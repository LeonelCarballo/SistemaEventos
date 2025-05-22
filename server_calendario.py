import socket
import json
import os
from datetime import datetime

ARCHIVO_DATOS = "usuarios_calendarios.json"

def cargar_datos():
    if os.path.exists(ARCHIVO_DATOS):
        with open(ARCHIVO_DATOS, "r", encoding="utf-8") as f:
            return json.load(f)
    return {}

def guardar_datos():
    try:
        with open(ARCHIVO_DATOS, "w", encoding="utf-8") as f:
            json.dump(usuarios, f, indent=2, ensure_ascii=False)
    except Exception:
        pass  # Silenciar errores al guardar

def parse_fecha_hora_unica(fecha_hora_str):
    try:
        return datetime.fromisoformat(fecha_hora_str)
    except Exception:
        return None

def procesar_mensaje(data):
    global usuarios
    try:
        print("RAW data:", repr(data), flush=True)
        req     = json.loads(data)
        accion  = req.get("accion", "").strip()
        usuario = req.get("usuario", "").strip().lower()
        id_ext  = req.get("idExterno")

        if not usuario:
            return json.dumps({"exito": False, "error": "Falta el campo 'usuario'"})

        # Inicializar estructuras si el usuario es nuevo
        if usuario not in usuarios:
            usuarios[usuario] = {
                "calendarios": {},
                "notificaciones": []
            }
        usuarios[usuario].setdefault("calendarios", {})
        usuarios[usuario].setdefault("notificaciones", [])

        # ------------------------------------------
        #            Flujo de calendario
        # ------------------------------------------
        if accion == "obtenerEventos":
            todos = []
            for cal in usuarios[usuario]["calendarios"].values():
                todos.extend(cal.get("eventos", []))
            return json.dumps(todos)

        elif accion == "agregarEvento":
            evento = req.get("evento")
            if not evento:
                return json.dumps({"exito": False, "error": "Falta evento"})
            if not id_ext:
                return json.dumps({"exito": False, "error": "Falta idExterno"})

            cal = usuarios[usuario]["calendarios"].setdefault(id_ext, {"eventos": []})
            nueva_dt = parse_fecha_hora_unica(evento.get("fechaHora"))
            if not nueva_dt:
                return json.dumps({"exito": False, "error": "Formato de fechaHora inválido"})

            # Buscar si ya existe un evento con el mismo idExterno (actualizar)
            evento_existente = None
            for existente in cal["eventos"]:
                if existente.get("idExterno") == evento.get("idExterno"):
                    evento_existente = existente
                    break

            if evento_existente:
                evento_existente.update(evento)
                guardar_datos()
                return json.dumps({"exito": True, "mensaje": "Evento actualizado"})
            else:
                # Verificar conflicto
                for ev in cal["eventos"]:
                    if parse_fecha_hora_unica(ev.get("fechaHora")) == nueva_dt:
                        return json.dumps({
                            "exito": False,
                            "error": "Conflicto de horario: ya existe un evento en esa fecha/hora"
                        })

                cal["eventos"].append(evento)
                guardar_datos()
                return json.dumps({"exito": True, "mensaje": "Evento creado"})

        elif accion == "validarHorario":
            fecha_hora = req.get("fechaHora")
            if not fecha_hora:
                return json.dumps({"disponible": False, "error": "Falta fechaHora"})
            nueva_dt = parse_fecha_hora_unica(fecha_hora)
            if not nueva_dt:
                return json.dumps({"disponible": False, "error": "Formato de fechaHora inválido"})
            for cal in usuarios[usuario]["calendarios"].values():
                for ev in cal.get("eventos", []):
                    if parse_fecha_hora_unica(ev.get("fechaHora")) == nueva_dt:
                        return json.dumps({"disponible": False, "error": "Conflicto de horario"})
            return json.dumps({"disponible": True})

        elif accion == "eliminarEvento":
            if not id_ext:
                return json.dumps({"exito": False, "error": "Falta idExterno"})

            eliminado = False
            for calendario in usuarios[usuario]["calendarios"].values():
                eventos = calendario.get("eventos", [])
                nuevos_eventos = [e for e in eventos if e.get("idExterno") != id_ext]

                if len(eventos) != len(nuevos_eventos):
                    calendario["eventos"] = nuevos_eventos
                    eliminado = True
                    break

            if eliminado:
                guardar_datos()
                return json.dumps({"exito": True, "mensaje": "Evento eliminado"})
            else:
                return json.dumps({"exito": False, "error": "Evento no encontrado"})

        # ------------------------------------------
        #          Flujo de invitaciones
        # ------------------------------------------
        elif accion == "enviarInvitaciones":
            id_evento = req.get("idEvento")
            lista     = req.get("contactos", [])
            if not id_evento or not isinstance(lista, list):
                return json.dumps({
                    "exito": False,
                    "error": "Faltan idEvento o lista de contactos"
                })
            for inv in lista:
                target = inv.strip().lower()
                if not target or target == usuario:
                    continue
                if target not in usuarios:
                    usuarios[target] = {
                        "calendarios": {},
                        "notificaciones": []
                    }
                usuarios[target]["notificaciones"].append({
                    "idEvento": id_evento,
                    "from": usuario
                })
            guardar_datos()
            return json.dumps({"exito": True})

        elif accion == "obtenerNotificaciones":
            return json.dumps(usuarios[usuario]["notificaciones"])

        elif accion == "eliminarNotificacion":
            id_evento = req.get("idEvento")
            if not id_evento:
                return json.dumps({"exito": False, "error": "Falta idEvento"})

            notificaciones = usuarios[usuario].get("notificaciones", [])
            nuevas_notificaciones = [n for n in notificaciones if n.get("idEvento") != id_evento]

            if len(nuevas_notificaciones) == len(notificaciones):
                # No se encontró la notificación para eliminar
                return json.dumps({"exito": False, "error": "Notificación no encontrada"})

            usuarios[usuario]["notificaciones"] = nuevas_notificaciones
            guardar_datos()
            return json.dumps({"exito": True, "mensaje": "Notificación eliminada"})

        else:
            return json.dumps({"exito": False, "error": "Acción no válida"})

    except json.JSONDecodeError:
        return json.dumps({"exito": False, "error": "JSON inválido"})
    except Exception as e:
        return json.dumps({"exito": False, "error": f"Error interno: {str(e)}"})

# ------------------------------------------
#        Inicio del servidor
# ------------------------------------------
if __name__ == "__main__":
    usuarios = cargar_datos()
    HOST, PORT = "localhost", 5010

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen()
        print(f"🟢 Servidor Calendario escuchando en puerto {PORT}", flush=True)

        while True:
            conn, addr = s.accept()
            with conn:
                data = conn.recv(4096).decode("utf-8")
                if not data:
                    continue
                respuesta = procesar_mensaje(data)
                conn.sendall(respuesta.encode("utf-8"))

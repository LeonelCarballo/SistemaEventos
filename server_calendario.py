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
        recibido = json.loads(data)
        accion = recibido.get("accion")
        usuario = recibido.get("usuario")
        id_externo = recibido.get("idExterno")

        if not usuario:
            return json.dumps({"exito": False, "error": "Falta el campo 'usuario'"})

        # Crear usuario si no existe
        if usuario not in usuarios:
            usuarios[usuario] = {"calendarios": {}}
            guardar_datos()

        if "calendarios" not in usuarios[usuario]:
            usuarios[usuario]["calendarios"] = {}

        calendarios_usuario = usuarios[usuario]["calendarios"]

        if accion == "obtenerEventos":
            todos_los_eventos = []
            for calendario in calendarios_usuario.values():
                todos_los_eventos.extend(calendario.get("eventos", []))
            return json.dumps(todos_los_eventos)

        elif accion == "agregarEvento":
            evento = recibido.get("evento")
            if not evento:
                return json.dumps({"exito": False, "error": "Falta evento"})

            if not id_externo:
                return json.dumps({"exito": False, "error": "Falta idExterno"})

            if id_externo not in calendarios_usuario:
                calendarios_usuario[id_externo] = {"eventos": []}

            calendario = calendarios_usuario[id_externo]

            nueva_dt = parse_fecha_hora_unica(evento.get("fechaHora"))
            if not nueva_dt:
                return json.dumps({"exito": False, "error": "Formato de fechaHora inválido"})

            for existente in calendario["eventos"]:
                existente_dt = parse_fecha_hora_unica(existente.get("fechaHora"))
                if existente_dt == nueva_dt:
                    return json.dumps({
                        "exito": False,
                        "error": "Conflicto de horario: ya existe un evento en esa fecha/hora"
                    })

            calendario["eventos"].append(evento)
            guardar_datos()
            return json.dumps({"exito": True})

        elif accion == "validarHorario":
            fecha_hora = recibido.get("fechaHora")
            if not fecha_hora:
                return json.dumps({"disponible": False, "error": "Falta fechaHora"})

            nueva_dt = parse_fecha_hora_unica(fecha_hora)
            if not nueva_dt:
                return json.dumps({"disponible": False, "error": "Formato de fechaHora inválido"})

            for calendario in calendarios_usuario.values():
                for evento in calendario.get("eventos", []):
                    existente_dt = parse_fecha_hora_unica(evento.get("fechaHora"))
                    if existente_dt == nueva_dt:
                        return json.dumps({
                            "disponible": False,
                            "error": "Conflicto de horario"
                        })

            return json.dumps({"disponible": True})

        else:
            return json.dumps({"exito": False, "error": "Acción no válida"})

    except json.JSONDecodeError:
        return json.dumps({"exito": False, "error": "JSON inválido"})
    except Exception as e:
        return json.dumps({"exito": False, "error": f"Error interno: {str(e)}"})

# Inicializar estructura de usuarios
usuarios = cargar_datos()

HOST = "localhost"
PORT = 5010

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    print("🟢 Servidor Calendario MULTI-USUARIO escuchando en puerto", PORT)

    while True:
        conn, addr = s.accept()
        with conn:
            data = conn.recv(4096).decode("utf-8")
            if not data:
                continue
            respuesta = procesar_mensaje(data)
            conn.sendall(respuesta.encode("utf-8"))
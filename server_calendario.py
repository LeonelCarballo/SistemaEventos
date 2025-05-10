import socket
import json
import os
from datetime import datetime

ARCHIVO_DATOS = "usuarios_calendarios.json"

# Cargar datos desde archivo
def cargar_datos():
    if os.path.exists(ARCHIVO_DATOS):
        with open(ARCHIVO_DATOS, "r", encoding="utf-8") as f:
            return json.load(f)
    return {}  # Estructura: { "usuario": { "calendarios": { ... } } }

# Guardar datos en archivo
def guardar_datos():
    with open(ARCHIVO_DATOS, "w", encoding="utf-8") as f:
        json.dump(usuarios, f, indent=2, ensure_ascii=False)

# Convertir fecha y hora a datetime
def parse_fecha_hora(fecha, hora):
    try:
        return datetime.strptime(f"{fecha} {hora}", "%Y-%m-%d %H:%M")
    except ValueError:
        return None

# Procesar mensaje entrante del cliente
def procesar_mensaje(data):
    try:
        recibido = json.loads(data)
        accion = recibido.get("accion")
        usuario = recibido.get("usuario")
        id_externo = recibido.get("idExterno")

        if not usuario:
            return json.dumps({"exito": False, "error": "Falta el campo 'usuario'"})

        if usuario not in usuarios:
            return json.dumps({"exito": False, "error": f"Usuario '{usuario}' no encontrado"})

        calendarios_usuario = usuarios[usuario].get("calendarios", {})

        if accion == "obtenerEventos":
            calendario = calendarios_usuario.get(id_externo)
            if calendario:
                return json.dumps(calendario["eventos"])
            else:
                return json.dumps([])

        elif accion == "agregarEvento":
            evento = recibido.get("evento")
            if not evento:
                return json.dumps({"exito": False, "error": "Falta evento"})

            calendario = calendarios_usuario.get(id_externo)
            if not calendario:
                return json.dumps({"exito": False, "error": "Calendario no encontrado"})

            nueva_dt = parse_fecha_hora(evento.get("fecha"), evento.get("hora"))
            if not nueva_dt:
                return json.dumps({"exito": False, "error": "Formato de fecha u hora inválido"})

            for existente in calendario["eventos"]:
                existente_dt = parse_fecha_hora(existente.get("fecha"), existente.get("hora"))
                if existente_dt == nueva_dt:
                    return json.dumps({
                        "exito": False,
                        "error": "Conflicto de horario: ya existe un evento en esa fecha/hora"
                    })

            # ✅ Agregar evento si no hay conflicto
            calendario["eventos"].append(evento)
            guardar_datos()
            return json.dumps({"exito": True})

        elif accion == "validarHorario":
            fecha = recibido.get("fecha")
            hora = recibido.get("hora")

            calendario = calendarios_usuario.get(id_externo)
            if not calendario:
                return json.dumps({"disponible": False, "error": "Calendario no encontrado"})

            for evento in calendario["eventos"]:
                if evento.get("fecha") == fecha and evento.get("hora") == hora:
                    return json.dumps({
                        "disponible": False,
                        "error": "Conflicto de horario"
                    })

            return json.dumps({"disponible": True})

        else:
            return json.dumps({"exito": False, "error": "Acción no válida"})

    except json.JSONDecodeError:
        return json.dumps({"exito": False, "error": "JSON inválido"})

# Cargar datos al iniciar
usuarios = cargar_datos()

# Configuración del servidor
HOST = "localhost"
PORT = 5010

# Iniciar servidor
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    print("Servidor Calendario MULTI-USUARIO escuchando en puerto", PORT)

    while True:
        conn, addr = s.accept()
        with conn:
            print(f"Conectado con {addr}")
            data = conn.recv(4096).decode("utf-8")

            if not data:
                continue

            print("Recibido:", data)
            respuesta = procesar_mensaje(data)
            conn.sendall(respuesta.encode("utf-8"))

import socket
import json
import os
print(f"CARGANDO: {os.path.abspath(__file__)}", flush=True)

ARCHIVO_CONTACTOS = "usuarios_contactos.json"

# -------------------------------
# Utilidades para persistencia
# -------------------------------
def cargar_contactos():
    if os.path.exists(ARCHIVO_CONTACTOS):
        with open(ARCHIVO_CONTACTOS, "r", encoding="utf-8") as f:
            return json.load(f)
    return {}

def guardar_contactos():
    with open(ARCHIVO_CONTACTOS, "w", encoding="utf-8") as f:
        json.dump(usuarios, f, indent=2, ensure_ascii=False)

# -------------------------------
# Procesamiento de peticiones
# -------------------------------
def procesar_mensaje(data):
    print("    → entrando a procesar_mensaje", flush=True)
    print("    → repr(data):", repr(data), flush=True)
    try:
        recibido = json.loads(data)
        accion = recibido.get("accion", "").strip()
        print("    → repr(accion):", repr(accion), flush=True)

        usuario = recibido.get("usuario", "").strip().lower()
        print("    → usuario normalizado:", usuario, flush=True)

        if not accion:
            return error("Falta el campo 'accion'")
        if not usuario:
            return error("Falta el campo 'usuario'")

        # Asegurar estructura del usuario
        if usuario not in usuarios:
            usuarios[usuario] = {"contactos": [], "invitaciones": {}}

        accion_lc = accion.lower()
        if accion_lc == "obtenercontactos":
            return json.dumps(usuarios[usuario]["contactos"])
        elif accion_lc == "agregarcontacto":
            return agregar_contacto(usuario, recibido.get("contacto"))
        elif accion_lc == "buscarcontactoporcorreo":
            return buscar_contacto_por_correo(usuario, recibido.get("correo"))
        elif accion_lc == "enviarinvitaciones":
            # en Python original usaba key "contactos", no "invitados"
            return enviar_invitaciones(usuario, {
                "idEvento": recibido.get("idEvento"),
                "contactos": recibido.get("contactos") or recibido.get("invitados")
            })
        elif accion_lc == "agregaramigo":
            return agregar_amigo(usuario, recibido.get("amigo"))
        else:
            print(f"    → acción '{accion}' no reconocida", flush=True)
            return error("Acción no válida")

    except json.JSONDecodeError:
        return error("JSON inválido")
    except Exception as e:
        return error(f"Error inesperado: {str(e)}")

# -------------------------------
# Funciones por acción
# -------------------------------
def agregar_contacto(usuario, contacto):
    if not contacto or "usuario" not in contacto:
        return error("Falta el contacto o su 'usuario'")
    if any(c.get("usuario") == contacto["usuario"] for c in usuarios[usuario]["contactos"]):
        return error("El contacto ya está agregado")
    usuarios[usuario]["contactos"].append(contacto)
    guardar_contactos()
    print(f"{usuario} agregó manualmente a {contacto['usuario']}", flush=True)
    return exito()

def buscar_contacto_por_correo(usuario, correo):
    correo = (correo or "").strip().lower()
    for c in usuarios[usuario]["contactos"]:
        if c.get("correo", "").strip().lower() == correo:
            return json.dumps(c)
    return json.dumps({})

def enviar_invitaciones(usuario, recibido):
    id_evento = recibido.get("idEvento")
    lista_contactos = recibido.get("contactos")
    if not id_evento or not isinstance(lista_contactos, list):
        return error("Faltan datos de evento o lista de contactos")
    usuarios[usuario]["invitaciones"][id_evento] = lista_contactos
    guardar_contactos()
    print(f"{usuario} envió invitaciones para evento {id_evento}", flush=True)
    return exito()

def agregar_amigo(usuario, amigo):
    amigo = (amigo or "").strip().lower()
    if not amigo:
        return error("Falta el campo 'amigo'")
    if amigo == usuario:
        return error("No puedes agregarte a ti mismo como amigo")
    if amigo not in usuarios:
        usuarios[amigo] = {"contactos": [], "invitaciones": {}}
    contactos_usuario = usuarios[usuario]["contactos"]
    contactos_amigo = usuarios[amigo]["contactos"]
    if any(c.get("usuario") == amigo for c in contactos_usuario):
        return error("Ya son amigos")
    contacto_para_usuario = {"usuario": amigo, "nombre": amigo}
    contacto_para_amigo  = {"usuario": usuario, "nombre": usuario}
    contactos_usuario.append(contacto_para_usuario)
    contactos_amigo.append(contacto_para_amigo)
    guardar_contactos()
    print(f"{usuario} y {amigo} ahora son amigos.", flush=True)
    return exito()

# -------------------------------
# Respuestas estándar
# -------------------------------
def exito():
    return json.dumps({"exito": True})

def error(mensaje):
    return json.dumps({"exito": False, "error": mensaje})

# -------------------------------
# Inicio del servidor
# -------------------------------
usuarios = cargar_contactos()

HOST = "localhost"
PORT = 5012

if __name__ == "__main__":
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen()
        print("Servidor de Contactos escuchando en puerto", PORT, flush=True)

        while True:
            conn, addr = s.accept()
            print(f"DEBUG: Conectado con {addr}", flush=True)
            with conn:
                raw = conn.recv(4096)
                print("DEBUG: raw bytes:", raw, flush=True)
                if not raw:
                    print("DEBUG: no llegó data, salto al siguiente ciclo", flush=True)
                    continue

                data = raw.decode("utf-8")
                print("DEBUG: RAW data repr:", repr(data), flush=True)

                respuesta = procesar_mensaje(data)

                print("DEBUG: respuesta generada:", repr(respuesta), flush=True)
                conn.sendall(respuesta.encode("utf-8"))

from flask import Flask, request, jsonify
import requests

app = Flask(__name__)

# Variable global para almacenar ubicación
ultima_ubicacion = {
    'latitud': 0.0,
    'longitud': 0.0,
    'ciudad': 'Desconocida'
}

def obtener_ciudad(lat, lng):
    try:
        url = f"https://nominatim.openstreetmap.org/reverse?lat={lat}&lon={lng}&format=json"
        headers = {'User-Agent': 'TuApp/1.0'}  # Nominatim requiere User-Agent
        response = requests.get(url, headers=headers).json()
        return response.get('address', {}).get('city', 'Desconocida')
    except:
        return 'Desconocida'

@app.route('/guardar_ubicacion', methods=['GET'])
def guardar_ubicacion():
    global ultima_ubicacion
    
    lat = request.args.get('lat', '0.0')
    lng = request.args.get('lng', '0.0')
    
    ultima_ubicacion = {
        'latitud': float(lat),
        'longitud': float(lng),
        'ciudad': obtener_ciudad(lat, lng)
    }
    
    print(f"📌 Ubicación guardada: {ultima_ubicacion}")
    return jsonify(ultima_ubicacion)

@app.route('/obtener_ubicacion', methods=['GET'])
def obtener_ubicacion():
    return jsonify(ultima_ubicacion)

if __name__ == '__main__':
    app.run(port=5001, debug=True)
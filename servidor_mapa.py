from flask import Flask, request, jsonify
import requests

app = Flask(__name__)

# Variable global para almacenar ubicación
ultima_ubicacion = {
    'latitud': 0.0,
    'longitud': 0.0,
    'ciudad': 'Desconocida',
    'localidad': 'Desconocida'
}

def obtener_detalles_ubicacion(lat, lng):
    try:
        url = f"https://nominatim.openstreetmap.org/reverse?lat={lat}&lon={lng}&format=json"
        headers = {'User-Agent': 'TuApp/1.0'}  # Nominatim requiere User-Agent
        response = requests.get(url, headers=headers).json()
        address = response.get('address', {})
        
        # Obtener ciudad o pueblo
        ciudad = address.get('city', 'Desconocida')
        if ciudad == 'Desconocida':
            ciudad = address.get('town', 'Desconocida')
        if ciudad == 'Desconocida':
            ciudad = address.get('village', 'Desconocida')
        
        # Obtener localidad (municipio o equivalente)
        localidad = address.get('municipality', 'Desconocida')
        if localidad == 'Desconocida':
            localidad = address.get('county', 'Desconocida')
        if localidad == 'Desconocida':
            localidad = address.get('state_district', 'Desconocida')
        
        return ciudad, localidad
    except:
        return 'Desconocida', 'Desconocida'

@app.route('/guardar_ubicacion', methods=['GET'])
def guardar_ubicacion():
    global ultima_ubicacion
    
    lat = request.args.get('lat', '0.0')
    lng = request.args.get('lng', '0.0')
    
    ciudad, localidad = obtener_detalles_ubicacion(lat, lng)
    
    ultima_ubicacion = {
        'latitud': float(lat),
        'longitud': float(lng),
        'ciudad': ciudad,
        'localidad': localidad
    }
    
    print(f"📌 Ubicación guardada: {ultima_ubicacion}")
    return jsonify(ultima_ubicacion)

@app.route('/obtener_ubicacion', methods=['GET'])
def obtener_ubicacion():
    return jsonify(ultima_ubicacion)

if __name__ == '__main__':
    app.run(port=5001, debug=True)
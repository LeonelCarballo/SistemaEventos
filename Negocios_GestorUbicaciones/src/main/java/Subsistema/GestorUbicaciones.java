/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import DTOs.Infraestructura;
import ISubsistema.IGestorUbicaciones;
import exception.NegocioException;

/**
 *
 * @author jrasc
 */
public class GestorUbicaciones implements IGestorUbicaciones {

    @Override
    public Infraestructura validarUbicacion(Infraestructura ubicacion) throws NegocioException {
        validarDireccion(ubicacion);
        validarCoordenadas(ubicacion);
        validarZonaHoraria(ubicacion);
        return ubicacion;
    }

    // Verifica que la dirección no esté vacía y tenga formato aceptable
    public void validarDireccion(Infraestructura ubicacion) throws NegocioException {
        String direccion = ubicacion.getDireccion();
        if (direccion == null || direccion.isBlank()) {
            throw new NegocioException("La dirección no puede estar vacía.");
        }
        if (direccion.length() < 5 || direccion.length() > 150) {
            throw new NegocioException("La dirección debe tener entre 5 y 150 caracteres.");
        }
    }

    // Verifica que las coordenadas estén dentro de un rango válido
    public void validarCoordenadas(Infraestructura ubicacion) throws NegocioException {
        double lat = ubicacion.getLatitud();
        double lon = ubicacion.getLongitud();
        if (lat < -90 || lat > 90) {
            throw new NegocioException("La latitud debe estar entre -90 y 90.");
        }
        if (lon < -180 || lon > 180) {
            throw new NegocioException("La longitud debe estar entre -180 y 180.");
        }
    }

    // Verifica que la zona horaria tenga un formato válido (ej. "America/Mexico_City")
    public void validarZonaHoraria(Infraestructura ubicacion) throws NegocioException {
        String zona = ubicacion.getZonaHoraria();
        if (zona == null || zona.isBlank()) {
            throw new NegocioException("La zona horaria no puede estar vacía.");
        }
        // Validación simple: que tenga formato continente/ciudad
        if (!zona.matches("^[A-Za-z_]+/[A-Za-z_]+$")) {
            throw new NegocioException("La zona horaria no tiene un formato válido.");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.negocios_gestorubicaciones;

import DTOs.Infraestructura;
import Subsistema.GestorUbicaciones;
import exception.NegocioException;

/**
 *
 * @author leoca
 */
public class Negocios_GestorUbicaciones {

    public static void main(String[] args) {
        GestorUbicaciones validador = new GestorUbicaciones();

        Infraestructura ubicacion = new Infraestructura();
        ubicacion.setDireccion("Av. Insurgentes Sur 123");
        ubicacion.setLatitud(19.4326);
        ubicacion.setLongitud(-99.1332);
        ubicacion.setZonaHoraria("America/Mexico_City");

        try {
            validador.validarUbicacion(ubicacion);
            System.out.println("Ubicacion validada");
        } catch (NegocioException e) {
            System.err.println("Ubicacion no valida: " + e.getMessage());
        }
    }
}


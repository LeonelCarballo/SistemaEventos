/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.negocios_organizadoreventos;

import DTOs.EventoDTO;
import Subsistema.DatosEvento;
import exception.NegocioException;
import java.time.LocalDateTime;

/**
 *
 * @author leoca
 */
public class Negocios_OrganizadorEventos {

    public static void main(String[] args) {
        DatosEvento validador = new DatosEvento();

        try {
            EventoDTO evento = new EventoDTO(
                    "Fiesta de Graduacion",
                    "Celebracion",
                    "Graduacion",
                    LocalDateTime.now().plusDays(3),
                    "Sonora"
            );

            validador.validarRegistroEvento(evento);
            System.out.println("Evento validado");
        } catch (NegocioException e) {
            System.err.println("Evento no validado: " + e.getMessage());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.negocios_administradorcontactos;

import DTOs.ContactoDTO;
import Subsistema.GestorContactos;
import exception.NegocioException;

/**
 *
 * @author leoca
 */
public class Negocios_AdministradorContactos {

    public static void main(String[] args) {
        GestorContactos validador = new GestorContactos();

        ContactoDTO contacto = new ContactoDTO("Juan Pablo", "jrascon@gmail.com", "6635358275");

        try {
            validador.validarContacto(contacto);
            System.out.println("Contacto valido");
        } catch (NegocioException e) {
            System.err.println("Contacto no valido: " + e.getMessage());
        }
    }
}

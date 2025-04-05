/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import DTOs.ContactoDTO;
import ISubsistema.IGestorContactos;
import exception.NegocioException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author jrasc
 */
public class GestorContactos implements IGestorContactos {

    private final List<ContactoDTO> contactos = List.of(
    new ContactoDTO("Ana Martínez", "ana.martinez@gmail.com", "6445551234"),
    new ContactoDTO("Luis Ramírez", "luis.ramirez@hotmail.com", "6445555678"),
    new ContactoDTO("Carla Torres", "carla.torres@yahoo.com", "6445559012")
    );
    
    @Override
    public ContactoDTO validarContacto(ContactoDTO contacto) throws NegocioException {
        validarNombre(contacto);
        validarCorreo(contacto);
        validarTelefono(contacto);
        return contacto;
    }

    public void validarNombre(ContactoDTO contacto) throws NegocioException {
        String nombre = contacto.getNombre();
        if (nombre == null || nombre.isBlank()) {
            throw new NegocioException("El nombre del contacto no puede estar vacío.");
        }
        if (nombre.length() > 60) {
            throw new NegocioException("El nombre es demasiado largo.");
        }
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s\\-]+")) {
            throw new NegocioException("El nombre contiene caracteres inválidos.");
        }
    }

    public void validarCorreo(ContactoDTO contacto) throws NegocioException {
        String correo = contacto.getCorreoElectronico();
        if (correo == null || correo.isBlank()) {
            throw new NegocioException("El correo electrónico no puede estar vacío.");
        }
        String patronCorreo = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (!Pattern.matches(patronCorreo, correo)) {
            throw new NegocioException("El formato del correo electrónico no es válido.");
        }
    }

    public void validarTelefono(ContactoDTO contacto) throws NegocioException {
        String telefono = contacto.getTelefono();
        if (telefono == null || telefono.isBlank()) {
            throw new NegocioException("El número telefónico no puede estar vacío.");
        }
        if (!telefono.matches("^\\d{10}$")) {
            throw new NegocioException("El número telefónico debe contener exactamente 10 dígitos.");
        }
    }

    @Override
    public List<ContactoDTO> ObtenerContactos() {
        return contactos;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import ISubsistema.IGestorContactos;
import exception.NegocioException;
import java.util.ArrayList;
import java.util.List;
import linkup.dtosnegocios.ContactoDTO;
import linkup.dtoinfraestructura.ContactoInfraestructuraDTO;
import linkup.objetosnegocio.Contactos;
import linkup.objetosnegocio.UsuarioON;

public class GestorContactos implements IGestorContactos {

    @Override
    public ContactoDTO validarContacto(ContactoDTO contacto) throws NegocioException {
        validarNombre(contacto);
        validarUsuario(contacto);
        return contacto;
    }

    private void validarNombre(ContactoDTO contacto) throws NegocioException {
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

    private void validarUsuario(ContactoDTO contacto) throws NegocioException {
        String usuario = contacto.getUsuario();
        if (usuario == null || usuario.isBlank()) {
            throw new NegocioException("El usuario no puede estar vacío.");
        }
        if (!usuario.matches("[\\w.-]{3,30}")) {
            throw new NegocioException("El usuario contiene caracteres inválidos o es muy corto.");
        }
    }

    @Override
    public List<ContactoDTO> ObtenerContactos(String usuario) {
        List<ContactoInfraestructuraDTO> contactosInfra = Contactos.getInstancia().obtenerContactos(usuario);
        List<ContactoDTO> contactosNegocio = new ArrayList<>();
        for (ContactoInfraestructuraDTO infra : contactosInfra) {
            contactosNegocio.add(new ContactoDTO(infra.getNombre(), infra.getUsuario()));
        }
        return contactosNegocio;
    }

    @Override
    public boolean agregarContacto(String usuario, ContactoDTO contacto) {
        return Contactos.getInstancia().agregarContacto(usuario, contacto.getUsuario());
    }

    @Override
    public boolean enviarInvitaciones(String usuario, String idEvento, List<ContactoDTO> contactos) {
        List<ContactoInfraestructuraDTO> contactosInfra = new ArrayList<>();
        for (ContactoDTO contacto : contactos) {
            contactosInfra.add(new ContactoInfraestructuraDTO(contacto.getNombre(), contacto.getUsuario()));
        }
        return Contactos.getInstancia().enviarInvitaciones(usuario, idEvento, contactosInfra);
    }
    
    public boolean validarExistenciaUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }

        if (!username.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }

        try {
            UsuarioON usuarioON = UsuarioON.getInstance();
            return usuarioON.existeUsername(username);
        } catch (IllegalStateException e) {
            return false;
        }
    }
}


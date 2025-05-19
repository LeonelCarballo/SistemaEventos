/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio;

import java.util.List;
import linkup.dtoinfraestructura.ContactoInfraestructuraDTO;
import linkup.infraestructura.ContactosAPI;

public class Contactos {

    private static Contactos instancia;
    private final ContactosAPI contactosAPI;

    private Contactos() {
        this.contactosAPI = new ContactosAPI();
    }

    public static Contactos getInstancia() {
        if (instancia == null) {
            instancia = new Contactos();
        }
        return instancia;
    }

    public List<ContactoInfraestructuraDTO> obtenerContactos(String usuario) {
        return contactosAPI.obtenerContactos(usuario);
    }

    public boolean agregarContacto(String usuario, String amigo) {
        return contactosAPI.agregarAmigo(usuario, amigo);
    }

    public boolean enviarInvitaciones(String usuario, String idEvento, List<ContactoInfraestructuraDTO> contactos) {
        return contactosAPI.enviarInvitaciones(usuario, idEvento, contactos);
    }
}


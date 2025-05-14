/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.infraestructura.interfaces;

import java.util.List;
import linkup.dtoinfraestructura.ContactoInfraestructuraDTO;

/**
 *
 * @author Dana Chavez
 */
public interface IContactosAPI {
    
    public abstract boolean enviarInvitaciones(String usuario, String idEvento, List<ContactoInfraestructuraDTO> contactos);
    
    public abstract List<ContactoInfraestructuraDTO> obtenerContactos(String usuario);
}

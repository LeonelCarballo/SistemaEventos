/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistema;

import linkup.dtosnegocios.ContactoDTO;
import exception.NegocioException;
import java.util.List;

public interface IGestorContactos {
    public abstract ContactoDTO validarContacto(ContactoDTO contacto) throws NegocioException;
    public abstract List<ContactoDTO> ObtenerContactos(String usuario);
    public abstract boolean agregarContacto(String usuario, ContactoDTO contacto);
    public abstract boolean enviarInvitaciones(String usuario, String idEvento, List<ContactoDTO> contactos);
    public abstract boolean validarExistenciaUsername(String username) throws NegocioException;
}

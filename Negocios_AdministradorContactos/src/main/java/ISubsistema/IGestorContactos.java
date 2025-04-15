/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistema;

import linkup.dtosnegocios.ContactoDTO;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author jrasc
 */
public interface IGestorContactos {
    public ContactoDTO validarContacto(ContactoDTO contacto) throws NegocioException;
    
    public List<ContactoDTO> ObtenerContactos();
}

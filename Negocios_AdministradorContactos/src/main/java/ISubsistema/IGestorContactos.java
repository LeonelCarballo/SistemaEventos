/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistema;

import DTOs.ContactoDTO;
import exception.NegocioException;

/**
 *
 * @author jrasc
 */
public interface IGestorContactos {
    public ContactoDTO validarContacto(ContactoDTO contacto) throws NegocioException;
}

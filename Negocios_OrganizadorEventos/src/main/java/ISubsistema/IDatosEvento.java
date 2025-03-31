/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistema;

import DTOs.EventoDTO;
import exception.NegocioException;

/**
 *
 * @author jrasc
 */
public interface IDatosEvento {
    public EventoDTO validarRegistroEvento(EventoDTO evento) throws NegocioException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistema;

import DTOs.ContactoDTO;
import DTOs.EventoCompletoDTO;
import DTOs.EventoDTO;
import DTOs.Infraestructura;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author jrasc
 */
public interface IGuardarEvento {

    public EventoCompletoDTO construirEventoCompleto(EventoDTO eventoParcial, Infraestructura ubicacion, List<ContactoDTO> invitados) throws NegocioException;

    public void persistirEventoDTO(EventoCompletoDTO evento) throws NegocioException;
}

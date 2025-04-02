/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import DTOs.ContactoDTO;
import DTOs.EventoCompletoDTO;
import DTOs.EventoDTO;
import DTOs.Infraestructura;
import ISubsistema.IGuardarEvento;
import exception.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jrasc
 */
public class GuardarEvento implements IGuardarEvento {

    private List<EventoCompletoDTO> eventosGuardados = new ArrayList<>();

    @Override
    public EventoCompletoDTO construirEventoCompleto(EventoDTO eventoParcial, Infraestructura ubicacion, List<ContactoDTO> invitados) throws NegocioException {
        if (eventoParcial == null) {
            throw new NegocioException("El evento base no puede ser null.");
        }
        if (ubicacion == null) {
            throw new NegocioException("La ubicación no puede ser null.");
        }
        if (invitados == null || invitados.isEmpty()) {
            throw new NegocioException("Debe haber al menos un invitado.");
        }

        return new EventoCompletoDTO(
                eventoParcial.getNombreEvento(),
                eventoParcial.getEtiqueta(),
                eventoParcial.getDescripcion(),
                eventoParcial.getFechaHora(),
                ubicacion.getDireccion(),
                invitados
        );
    }

    @Override
    public void persistirEventoDTO(EventoCompletoDTO evento) throws NegocioException {
        if (evento == null) {
            throw new NegocioException("El evento no puede ser null");
        }
        if(evento.getNombreEvento() == null){
            throw new NegocioException("El evento no puede ser null");
        }
        if (evento.getEtiqueta() == null || evento.getEtiqueta().trim().isEmpty()) {
        throw new NegocioException("La etiqueta del evento es obligatoria.");
        }
        if (evento.getDescripcion() == null || evento.getDescripcion().trim().isEmpty()) {
            throw new NegocioException("La descripción del evento es obligatoria.");
        }
        if (evento.getUbicacion() == null || evento.getUbicacion().trim().isEmpty()) {
            throw new NegocioException("La ubicación del evento es obligatoria.");
        }
        if (evento.getInvitados() == null || evento.getInvitados().isEmpty()) {
            throw new NegocioException("Debe haber al menos un invitado.");
        }
        

        eventosGuardados.add(evento);
        System.out.println("Evento guardado" + evento.getNombreEvento());
    }

    public List<EventoCompletoDTO> getEventosGuardados() {
        return eventosGuardados;
    }
}

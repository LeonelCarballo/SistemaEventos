/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negocios_administrarinvitaciones.implementacion;

import com.mycompany.negocios_administrarinvitaciones.interfaz.IAdministrarInvitaciones;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.dtoinfraestructura.InvitacionInfraestructuraDTO;
import linkup.infraestructura.Integracion;
import linkup.infraestructura.interfaces.IIntegracion;
import linkup.objetosnegocio.Evento;
import linkup.objetosnegocio.cu.admInvitacion.Invitacion;

/**
 *
 * @author santi
 */
public class AdministrarInvitaciones implements IAdministrarInvitaciones {
    
    private final IIntegracion integracion;

    public AdministrarInvitaciones() {
        this.integracion = new Integracion();
    }

    @Override
    public List<Invitacion> obtenerInvitaciones(String username) {
    List<InvitacionInfraestructuraDTO> dtoList = integracion.obtenerNotificaciones(username);

    if (dtoList == null) {
        // Retorna lista vacía en lugar de null
        return Collections.emptyList();
    }

    return dtoList.stream()
        .map(this::desdeDTO)
        .collect(Collectors.toList());
}

    
    public Invitacion desdeDTO(InvitacionInfraestructuraDTO dto) {
    String idCalendario = "1"; // fijo

    // obtener lista DTOs
    List<EventoInfraestructuraDTO> eventosDTO = integracion.obtenerEventosDelCalendario(idCalendario, dto.getFrom());

    // convertir a Evento
    List<Evento> eventos = eventosDTO.stream()
            .map(Evento::desdeDTO)
            .collect(Collectors.toList());

    Evento evento = eventos.stream()
            .filter(e -> e.getIdExterno().equals(dto.getIdEvento()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Evento no encontrado"));

    Invitacion invitacion = new Invitacion( dto.getFrom(), evento);
  


    return invitacion;
}

    @Override
    public void AceptarInvitacion(String username, Evento evento) {
        EventoInfraestructuraDTO dto = evento.convertirADTO();
        dto.setUsername(username);
        integracion.agregarEventoACalendario("1", dto);
        integracion.eliminarNotificacion(username, username);
    }

    @Override
    public void RechazarInvitacion(String username, String IdEvento) {
        integracion.eliminarNotificacion(username, IdEvento);
    }


}

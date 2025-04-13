/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.mappers;

import DTOs.EventoDTO;
import linkup.objetosnegocio.Evento;

/**
 * Clase utilitaria para mapear entre objetos Evento y EventoDTO.
 */
public class EventoMapper {

    private EventoMapper() {
    }

    public static EventoDTO toDTO(Evento evento) {
        if (evento == null) return null;

        EventoDTO dto = new EventoDTO();
        dto.setNombreEvento(evento.getNombreEvento());
        dto.setEtiqueta(evento.getEtiqueta());
        dto.setDescripcion(evento.getDescripcion());
        dto.setFechaHora(evento.getFechaHora());
        dto.setDescripcion(evento.getDireccion());

        return dto;
    }

    public static Evento toEntidad(EventoDTO dto) {
        if (dto == null) return null;

        Evento evento = new Evento();
        evento.setNombreEvento(dto.getNombreEvento());
        evento.setEtiqueta(dto.getEtiqueta());
        evento.setDescripcion(dto.getDescripcion());
        evento.setFechaHora(dto.getFechaHora());
        evento.setDescripcion(dto.getDireccion());

        return evento;
    }
}

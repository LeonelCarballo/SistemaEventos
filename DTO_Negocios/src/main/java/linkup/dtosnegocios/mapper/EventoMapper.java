/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtosnegocios.mapper;

import linkup.dtosnegocios.EventoDTO;
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
        dto.setIdExterno(evento.getIdExterno());
        dto.setNombreEvento(evento.getNombreEvento());
        dto.setEtiqueta(evento.getEtiqueta());
        dto.setDescripcion(evento.getDescripcion());
        dto.setFechaHora(evento.getFechaHora());
        dto.setFechaFin(evento.getFechaFin());
        dto.setDireccion(evento.getDireccion());
        dto.setLatitud(evento.getLatitud());
        dto.setLongitud(evento.getLongitud());
        dto.setRecordatorioActivo(evento.isRecordatorioActivo());
        dto.setFechaRecordatorio(evento.getFechaRecordatorio());
        dto.setBannerPath(evento.getBannerPath());
        
        return dto;
    }

    public static Evento toEntidad(EventoDTO dto) {
        return new Evento(
            dto.getIdExterno(),
            dto.getNombreEvento(),
            dto.getEtiqueta(),
            dto.getDescripcion(),
            dto.getFechaHora(),
            dto.getFechaFin(),
            dto.getDireccion(),
            dto.getLatitud(),
            dto.getLongitud(),
            dto.isRecordatorioActivo(),
            dto.getFechaRecordatorio(),
            dto.getBannerPath()
        );
    }
}

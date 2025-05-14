package linkup.dtosnegocios.mapper;

import linkup.dtosnegocios.EventoDTO;
import linkup.objetosnegocio.Evento;
import linkup.objetosnegocio.ServicioEventos;

public final class EventoMapper {
    private EventoMapper() {}
    
    public static EventoDTO toDTO(ServicioEventos servicioEvento) {
        if (servicioEvento == null) return null;

        Evento evento = servicioEvento.getEvento();
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

    public static ServicioEventos toServicioEvento(EventoDTO dto) {
        if(dto.getIdExterno() == null || dto.getIdExterno().isEmpty()) {
            String idExterno = dto.getIdExterno() != null ? 
                          dto.getIdExterno() : 
                          generarNuevoId();
        }
        
        Evento evento = new Evento(
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
        return new ServicioEventos(evento);
    }

    public static Evento toEvento(EventoDTO dto) {
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
    
    public static String generarNuevoId() {
        return java.util.UUID.randomUUID().toString(); 
    }
}
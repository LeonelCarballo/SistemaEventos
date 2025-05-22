package linkup.dtosnegocios.mapper;

import linkup.dtosnegocios.EventoDTO;
import linkup.objetosnegocio.Evento;
import linkup.objetosnegocio.ServicioEventos;
import linkup.objetosnegocio.UsuarioON;

public final class EventoMapper {

    private EventoMapper() {
    }

    public static Evento toEvento(EventoDTO dto) {
        return new Evento(
                dto.getIdExterno(),
                dto.getUsername(),
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

    public static EventoDTO toDTO(Evento evento) {
        if (evento == null) {
            return null;
        }

        EventoDTO dto = new EventoDTO();
        dto.setIdExterno(evento.getIdExterno());
        dto.setUsername(evento.getUsername());
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

    public static String generarNuevoId() {
        return java.util.UUID.randomUUID().toString();
    }
}

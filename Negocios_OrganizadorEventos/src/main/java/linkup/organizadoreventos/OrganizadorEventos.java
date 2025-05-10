package linkup.organizadoreventos;

import java.time.LocalDateTime;
import linkup.dtosnegocios.mapper.EventoMapper;
import linkup.objetosnegocio.Evento;

import java.util.ArrayList;
import java.util.List;
import linkup.dtosnegocios.EventoDTO;
import linkup.exception.NegocioException;
import linkup.objetosnegocio.ServicioEventos;
import linkup.organizadoreventos.interfaces.IOrganizadorEventos;

public class OrganizadorEventos implements IOrganizadorEventos {

    private final List<ServicioEventos> eventos;

    public OrganizadorEventos() {
        this.eventos = new ArrayList<>();
    }

    @Override
    public void agregarEvento(EventoDTO dto, String idCalendario) {

        if (dto != null) {
            ServicioEventos nuevo = EventoMapper.toEntidad(dto);
            nuevo.agregarEvento(idCalendario, nuevo);
        }
    }

    @Override
    public EventoDTO consultarEventoPorId(String idExterno) {
        for (ServicioEventos e : eventos) {
            if (e.getIdExterno().equals(idExterno)) {
                return EventoMapper.toDTO(e);
            }
        }
        return null;
    }

    @Override
    public List<EventoDTO> consultarEventos() {
        List<EventoDTO> lista = new ArrayList<>();
        for (ServicioEventos e : eventos) {
            lista.add(EventoMapper.toDTO(e));
        }
        return lista;
    }

    public EventoDTO validarDetalllesEvento(EventoDTO dto) {
        if (dto == null) {
            throw new NegocioException("El evento no puede ser nulo.");
        }
        if (dto.getNombreEvento() == null || dto.getNombreEvento().trim().isEmpty()) {
            throw new NegocioException("El nombre del evento es obligatorio.");
        }
        if (dto.getDescripcion() == null || dto.getDescripcion().trim().isEmpty()) {
            throw new NegocioException("La descripción del evento es obligatoria.");
        }
        if (dto.getEtiqueta() == null) {
            throw new NegocioException("Debe seleccionar una etiqueta para el evento.");
        }

        return dto;
    }

    public EventoDTO validarFechaHoraEvento(EventoDTO dto) {
        if (dto == null) {
            throw new NegocioException("El evento no puede ser nulo.");
        }
        if (dto.getFechaHora() == null) {
            throw new NegocioException("Debe seleccionar una fecha y hora para el evento.");
        }
        if (dto.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new NegocioException("La fecha y hora del evento deben ser posteriores a la fecha actual.");
        }

        return dto;
    }
}

package linkup.organizadoreventos;

import java.time.LocalDateTime;
import linkup.dtosnegocios.mapper.EventoMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import linkup.dtosnegocios.EventoDTO;
import linkup.exception.NegocioException;
import linkup.objetosnegocio.Evento;
import linkup.objetosnegocio.ServicioEventos;
import linkup.objetosnegocio.UsuarioON;
import linkup.organizadoreventos.interfaces.IOrganizadorEventos;

public class OrganizadorEventos implements IOrganizadorEventos {

    private final List<EventoDTO> eventos;

    private final String idCalendario;

    public OrganizadorEventos(String idCalendario) {
        this.eventos = new ArrayList<>();
        this.idCalendario = Objects.requireNonNull(idCalendario, "ID de calendario no puede ser nulo");
    }

    public void agregarEvento(EventoDTO dto) throws NegocioException {
        EventoDTO eventoValidado = validarEventoCompleto(dto);
        Evento nuevoEvento = EventoMapper.toEvento(eventoValidado);
        nuevoEvento.publicarEnCalendario(idCalendario);
    }

    @Override
    public EventoDTO consultarEventoPorId(String idExterno) {
        return eventos.stream()
                .filter(e -> e.getIdExterno().equals(idExterno))
                .findFirst()
                .orElse(null);

    }

    @Override
   public void eliminarEvento(EventoDTO dto) throws NegocioException {
    EventoDTO eventoValidado = validarEventoCompleto(dto);
    Evento evento = EventoMapper.toEvento(eventoValidado);
    evento.eliminarEvento(idCalendario); 
}

    @Override
    public List<EventoDTO> consultarEventos() {
        String usernameActual = UsuarioON.getInstance().getUsername();

        List<Evento> eventosInfra = Evento.obtenerEventosDelCalendario(idCalendario);

        return eventosInfra.stream()
                .filter(evento -> usernameActual.equals(evento.getUsername()))
                .map(EventoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventoDTO validarDetallesEvento(EventoDTO dto) throws NegocioException {
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

    @Override
    public EventoDTO validarFechaHoraEvento(EventoDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("El evento no puede ser nulo.");
        }
        if (dto.getFechaHora() == null) {
            throw new NegocioException("Debe seleccionar una fecha y hora para el evento.");
        }
        if (dto.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new NegocioException("La fecha y hora del evento deben ser posteriores a la fecha actual.");
        }
        if (dto.getFechaFin() != null && dto.getFechaFin().isBefore(dto.getFechaHora())) {
            throw new NegocioException("La fecha de fin no puede ser anterior a la de inicio.");
        }
        return dto;

    }

    @Override
    public EventoDTO validarEventoCompleto(EventoDTO dto) throws NegocioException {
        return validarDetallesEvento(validarFechaHoraEvento(dto));
    }

}

package linkup.objetosnegocio;



import java.util.List;
import java.util.stream.Collectors;
import linkup.infraestructura.calendario.InfraestructuraCalendario;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.infraestructura.interfaces.IInfraestructuraCalendario;

public class ServicioEventos {
    private static ServicioEventos instancia;
    private final IInfraestructuraCalendario infraestructura;

    private ServicioEventos() {
        this.infraestructura = new InfraestructuraCalendario(); // aquí podrías inyectar una implementación real
    }

    public static ServicioEventos getInstancia() {
        if (instancia == null) {
            instancia = new ServicioEventos();
        }
        return instancia;
    }

    public List<Evento> obtenerEventos(String idCalendarioExterno) {
        List<EventoInfraestructuraDTO> eventosInfra = infraestructura.obtenerEventosDelCalendario(idCalendarioExterno);
        return eventosInfra.stream()
                .map(this::convertirADominio)
                .collect(Collectors.toList());
    }

    public void agregarEvento(String idCalendarioExterno, Evento evento) {
        EventoInfraestructuraDTO dto = convertirADTO(evento);
        infraestructura.agregarEventoACalendario(idCalendarioExterno, dto);
    }

    private Evento convertirADominio(EventoInfraestructuraDTO dto) {
        return new Evento(
                dto.idExterno,
                dto.nombreEvento,
                Etiqueta.valueOf(dto.etiqueta), // Convierte String a Enum
                dto.descripcion,
                dto.fechaHora,
                dto.fechaFin,
                dto.direccion,
                dto.latitud,
                dto.longitud,
                dto.recordatorioActivo,
                dto.fechaRecordatorio
        );
    }

    private EventoInfraestructuraDTO convertirADTO(Evento evento) {
        EventoInfraestructuraDTO dto = new EventoInfraestructuraDTO();
        dto.idExterno = evento.getIdExterno();
        dto.nombreEvento = evento.getNombreEvento();
        dto.descripcion = evento.getDescripcion();
        dto.etiqueta = evento.getEtiqueta().name(); 
        dto.fechaHora = evento.getFechaHora();
        dto.fechaFin = evento.getFechaFin();
        dto.direccion = evento.getDireccion();
        dto.latitud = evento.getLatitud();
        dto.longitud = evento.getLongitud();
        dto.recordatorioActivo = evento.isRecordatorioActivo();
        dto.fechaRecordatorio = evento.getFechaRecordatorio();
        return dto;
    }
}

package linkup.objetosnegocio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.infraestructura.Integracion;
import linkup.infraestructura.interfaces.IIntegracion;

public final class ServicioEventos {
    private static ServicioEventos instancia;
    private final IIntegracion integracion;
    private final Evento evento; 

    private ServicioEventos() {
        this.integracion = new Integracion();
        this.evento = null;  
    }

    public ServicioEventos(Evento evento) {
        this.integracion = new Integracion();
        this.evento = Objects.requireNonNull(evento, "Evento no puede ser nulo");
    }

    public static ServicioEventos getInstancia() {
        if (instancia == null) {
            instancia = new ServicioEventos();
        }
        return instancia;
    }

    public void publicarEnCalendario(String idCalendarioExterno) {
        if (evento == null) {
            throw new IllegalStateException("Se requiere un evento válido para esta operación");
        }
        EventoInfraestructuraDTO dto = convertirADTO();
        integracion.agregarEventoACalendario(idCalendarioExterno, dto);
    }

    public boolean puedeCancelarse() {
        return evento != null && evento.puedeCancelarse();
    }

    public static List<Evento> obtenerEventosDelCalendario(String idCalendarioExterno) {
        List<EventoInfraestructuraDTO> eventosInfra = getInstancia().integracion
            .obtenerEventosDelCalendario(idCalendarioExterno);
        
        return eventosInfra.stream()
                .map(getInstancia()::convertirADominio)
                .collect(Collectors.toList());
    }

    private Evento convertirADominio(EventoInfraestructuraDTO dto) {
        return new Evento(
            dto.idExterno,
            dto.username,
            dto.nombreEvento,
            Etiqueta.valueOf(dto.etiqueta),
            dto.descripcion,
            dto.fechaHora,
            dto.fechaFin,
            dto.direccion,
            dto.latitud,
            dto.longitud,
            dto.recordatorioActivo,
            dto.fechaRecordatorio,
            dto.bannerPath
        );
    }

    private EventoInfraestructuraDTO convertirADTO() {
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
        dto.bannerPath = evento.getBannerPath();
        return dto;
    }
   
    public String getIdExterno() {
        return evento != null ? evento.getIdExterno() : null;
    }

    public String getNombreEvento() {
        return evento != null ? evento.getNombreEvento() : null;
    }

    public Evento getEvento() {
        return evento;
    }
    
    
   
}


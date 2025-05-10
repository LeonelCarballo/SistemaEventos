package linkup.objetosnegocio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.infraestructura.Integracion;
import linkup.infraestructura.interfaces.IIntegracion;

public class ServicioEventos {
    private static ServicioEventos instancia;
    private final IIntegracion integracion;
    
    private final String idExterno;
    private final String nombreEvento;
    private final Etiqueta etiqueta;
    private final String descripcion;
    private final LocalDateTime fechaHora;
    private final LocalDateTime fechaFin;
    private final String direccion;
    private final Double latitud;
    private final Double longitud;
    private final boolean recordatorioActivo;
    private final LocalDateTime fechaRecordatorio;
    private final String bannerPath;

    public ServicioEventos(String idExterno, String nombreEvento, Etiqueta etiqueta, String descripcion, LocalDateTime fechaHora, LocalDateTime fechaFin, String direccion, Double latitud, Double longitud, boolean recordatorioActivo, LocalDateTime fechaRecordatorio, String bannerPath) {
        this.integracion = new Integracion();
        this.idExterno = idExterno;
        this.nombreEvento = nombreEvento;
        this.etiqueta = etiqueta;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.fechaFin = fechaFin;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.recordatorioActivo = recordatorioActivo;
        this.fechaRecordatorio = fechaRecordatorio;
        this.bannerPath = bannerPath;
    }

    private ServicioEventos() {
        this.integracion = new Integracion();
        this.idExterno = null;
        this.nombreEvento = null;
        this.etiqueta = null;
        this.descripcion = null;
        this.fechaHora = null;
        this.fechaFin = null;
        this.direccion = null;
        this.latitud = null;
        this.longitud = null;
        this.recordatorioActivo = false;
        this.fechaRecordatorio = null;
        this.bannerPath = null;
    }

    public static ServicioEventos getInstancia() {
        if (instancia == null) {
            instancia = new ServicioEventos();
        }
        return instancia;
    }

    public List<Evento> obtenerEventos(String idCalendarioExterno) {
        List<EventoInfraestructuraDTO> eventosInfra = integracion.obtenerEventosDelCalendario(idCalendarioExterno);
        return eventosInfra.stream()
                .map(this::convertirADominio)
                .collect(Collectors.toList());
    }

    public void agregarEvento(String idCalendarioExterno, ServicioEventos evento) {
        EventoInfraestructuraDTO dto = convertirADTO(evento);
        integracion.agregarEventoACalendario(idCalendarioExterno, dto);
    }

    private Evento convertirADominio(EventoInfraestructuraDTO dto) {
        return new Evento(
                dto.idExterno,
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

    private EventoInfraestructuraDTO convertirADTO(ServicioEventos evento) {
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
        return idExterno;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public String getDireccion() {
        return direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public boolean isRecordatorioActivo() {
        return recordatorioActivo;
    }

    public LocalDateTime getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public String getBannerPath() {
        return bannerPath;
    }

}


package linkup.objetosnegocio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.infraestructura.Integracion;
import linkup.infraestructura.interfaces.IIntegracion;

public final class Evento {

    private final String idExterno;
    private final String username;
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

    private final IIntegracion integracion = new Integracion();

    public Evento(String idExterno, String username,
            String nombreEvento,
            Etiqueta etiqueta,
            String descripcion,
            LocalDateTime fechaHora,
            LocalDateTime fechaFin,
            String direccion,
            Double latitud,
            Double longitud,
            boolean recordatorioActivo,
            LocalDateTime fechaRecordatorio,
            String bannerPath) {

        this.idExterno = Objects.requireNonNull(idExterno, "ID externo no puede ser nulo");
        this.username = Objects.requireNonNull(username, "Username no puede ser nulo");
        this.nombreEvento = Objects.requireNonNull(nombreEvento, "Nombre no puede ser nulo");
        this.etiqueta = Objects.requireNonNull(etiqueta, "Etiqueta no puede ser nula");
        this.descripcion = Objects.requireNonNull(descripcion, "Descripción no puede ser nula");
        this.fechaHora = Objects.requireNonNull(fechaHora, "Fecha/Hora no puede ser nula");
        this.fechaFin = fechaFin;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.recordatorioActivo = recordatorioActivo;
        this.fechaRecordatorio = fechaRecordatorio;
        this.bannerPath = bannerPath;

        validarFechas();
    }

    private void validarFechas() {
        if (fechaFin != null && fechaFin.isBefore(fechaHora)) {
            throw new IllegalArgumentException("Fecha fin no puede ser anterior a fecha inicio");
        }
        if (fechaRecordatorio != null && fechaRecordatorio.isAfter(fechaHora)) {
            throw new IllegalArgumentException("Recordatorio no puede ser después del evento");
        }
    }

    // Métodos de infraestructura
    public void publicarEnCalendario(String idCalendarioExterno) {
        EventoInfraestructuraDTO dto = this.convertirADTO();
        integracion.agregarEventoACalendario(idCalendarioExterno, dto);
    }

    public static List<Evento> obtenerEventosDelCalendario(String idCalendarioExterno) {
        IIntegracion integracion = new Integracion();
        List<EventoInfraestructuraDTO> eventosInfra = integracion
                .obtenerEventosDelCalendario(idCalendarioExterno, UsuarioON.getInstance().getUsername());

        return eventosInfra.stream()
                .map(Evento::desdeDTO)
                .collect(Collectors.toList());
    }

    public void eliminarEvento(String idCalendarioExterno) {
    EventoInfraestructuraDTO dto = this.convertirADTO();

    integracion.eliminarEvento(idCalendarioExterno, dto);
}

    public static Evento desdeDTO(EventoInfraestructuraDTO dto) {
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
        dto.idExterno = this.getIdExterno();
        dto.username = this.getUsername();
        dto.nombreEvento = this.getNombreEvento();
        dto.descripcion = this.getDescripcion();
        dto.etiqueta = this.getEtiqueta().name();
        dto.fechaHora = this.getFechaHora();
        dto.fechaFin = this.getFechaFin();
        dto.direccion = this.getDireccion();
        dto.latitud = this.getLatitud();
        dto.longitud = this.getLongitud();
        dto.recordatorioActivo = this.isRecordatorioActivo();
        dto.fechaRecordatorio = this.getFechaRecordatorio();
        dto.bannerPath = this.getBannerPath();
        return dto;
    }

    // Getters - expone solo datos necesarios
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

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Evento)) {
            return false;
        }
        Evento evento = (Evento) o;
        return idExterno.equals(evento.idExterno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExterno);
    }

    @Override
    public String toString() {
        return String.format("Evento[id=%s, nombre=%s, inicio=%s, fin=%s]",
                idExterno, nombreEvento, fechaHora, fechaFin);
    }
}

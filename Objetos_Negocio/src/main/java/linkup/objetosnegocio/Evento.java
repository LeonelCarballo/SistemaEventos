package linkup.objetosnegocio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Evento {

    private static final int MAX_LONGITUD_NOMBRE = 100;
    private static final int MAX_LONGITUD_DESCRIPCION = 500;
    private static final int MIN_DURACION_MINUTOS = 5;
    private static final int MAX_ANTICIPACION_ANIOS = 5;

    private String idExterno;
    private String nombreEvento;
    private Etiqueta etiqueta;
    private String descripcion;
    private LocalDateTime fechaHora;
    private LocalDateTime fechaFin;

    // Ubicación directa (sin objeto Ubicacion)
    private String direccion;    // Ej: "Centro Histórico, CDMX"
    private Double latitud;
    private Double longitud;

    private boolean recordatorioActivo;
    private LocalDateTime fechaRecordatorio;

    public Evento() {
        this.recordatorioActivo = false;
    }

    public Evento(String nombreEvento, Etiqueta etiqueta, String descripcion,
                  LocalDateTime fechaHora, LocalDateTime fechaFin,
                  String direccion, Double latitud, Double longitud) {
        this();
        setNombreEvento(nombreEvento);
        setEtiqueta(etiqueta);
        setDescripcion(descripcion);
        setFechaHora(fechaHora);
        setFechaFin(fechaFin);
        setDireccion(direccion);
        setLatitud(latitud);
        setLongitud(longitud);
        validarEventoCompleto();
    }

    // Getters y setters básicos

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        if (nombreEvento == null || nombreEvento.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento no puede estar vacío");
        }
        if (nombreEvento.length() > MAX_LONGITUD_NOMBRE) {
            throw new IllegalArgumentException("El nombre del evento no puede exceder los " + MAX_LONGITUD_NOMBRE + " caracteres");
        }
        this.nombreEvento = nombreEvento.trim();
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        if (etiqueta == null) {
            throw new IllegalArgumentException("La etiqueta del evento es requerida");
        }
        this.etiqueta = etiqueta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && descripcion.length() > MAX_LONGITUD_DESCRIPCION) {
            throw new IllegalArgumentException("La descripción no puede exceder los " + MAX_LONGITUD_DESCRIPCION + " caracteres");
        }
        this.descripcion = descripcion != null ? descripcion.trim() : null;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora del evento son requeridas");
        }
        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha del evento no puede ser en el pasado");
        }
        if (fechaHora.isAfter(LocalDateTime.now().plusYears(MAX_ANTICIPACION_ANIOS))) {
            throw new IllegalArgumentException("No se pueden programar eventos con más de " + MAX_ANTICIPACION_ANIOS + " años de anticipación");
        }
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        if (fechaFin != null && fechaFin.isBefore(this.fechaHora)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la de inicio");
        }
        if (fechaFin != null &&
                java.time.Duration.between(this.fechaHora, fechaFin).toMinutes() < MIN_DURACION_MINUTOS) {
            throw new IllegalArgumentException("La duración mínima del evento debe ser de " + MIN_DURACION_MINUTOS + " minutos");
        }
        this.fechaFin = fechaFin;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion != null ? direccion.trim() : null;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public boolean isRecordatorioActivo() {
        return recordatorioActivo;
    }

    public void setRecordatorioActivo(boolean recordatorioActivo) {
        this.recordatorioActivo = recordatorioActivo;
    }

    public LocalDateTime getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public void setFechaRecordatorio(LocalDateTime fechaRecordatorio) {
        if (fechaRecordatorio != null && fechaRecordatorio.isAfter(this.fechaHora)) {
            throw new IllegalArgumentException("El recordatorio no puede ser después del evento");
        }
        this.fechaRecordatorio = fechaRecordatorio;
    }

    private void validarEventoCompleto() {
        if (this.fechaFin == null) {
            throw new IllegalStateException("La fecha de fin es requerida");
        }
        if (this.recordatorioActivo && this.fechaRecordatorio == null) {
            throw new IllegalStateException("Se requiere fecha de recordatorio cuando está activo");
        }
    }

    // Métodos extra
    public boolean esEventoPasado() {
        return LocalDateTime.now().isAfter(fechaFin != null ? fechaFin : fechaHora);
    }

    public boolean esEventoHoy() {
        LocalDateTime ahora = LocalDateTime.now();
        return fechaHora.toLocalDate().equals(ahora.toLocalDate()) ||
               (fechaFin != null && fechaFin.toLocalDate().equals(ahora.toLocalDate()));
    }

    public boolean puedeCancelarse() {
        return !fechaHora.isBefore(LocalDateTime.now().plusHours(2));
    }

    public long duracionEnMinutos() {
        return fechaFin != null ?
               java.time.Duration.between(fechaHora, fechaFin).toMinutes() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento evento)) return false;
        return Objects.equals(nombreEvento, evento.nombreEvento) &&
               Objects.equals(fechaHora, evento.fechaHora) &&
               Objects.equals(direccion, evento.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEvento, fechaHora, direccion);
    }

    @Override
    public String toString() {
        return "Evento{" +
               "nombre='" + nombreEvento + '\'' +
               ", inicio=" + fechaHora +
               ", fin=" + fechaFin +
               ", direccion='" + direccion + '\'' +
               '}';
    }
}

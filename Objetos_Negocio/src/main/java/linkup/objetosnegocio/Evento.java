package linkup.objetosnegocio;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Evento {
    
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

    public Evento(String idExterno,
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

    public boolean esEventoPasado() {
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.isAfter(fechaFin != null ? fechaFin : fechaHora);
    }

    public boolean esEventoHoy() {
        LocalDateTime hoy = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime manana = hoy.plusDays(1);
        return (fechaHora.isEqual(hoy) || fechaHora.isAfter(hoy)) && (fechaHora.isBefore(manana)) ||
               (fechaFin != null && fechaFin.isAfter(hoy) && fechaFin.isBefore(manana));
    }

    public boolean puedeCancelarse() {
        return !fechaHora.isBefore(LocalDateTime.now().plusHours(2));
    }

    public long duracionEnMinutos() {
        return fechaFin != null ? java.time.Duration.between(fechaHora, fechaFin).toMinutes() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento)) return false;
        Evento evento = (Evento) o;
        return idExterno.equals(evento.idExterno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExterno);
    }

    @Override
    public String toString() {
        return String.format(
            "Evento[id=%s, nombre=%s, inicio=%s, fin=%s]", 
            idExterno, 
            nombreEvento, 
            fechaHora, 
            fechaFin
        );
    }
}
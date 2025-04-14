
package linkup.objetosnegocio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Evento {
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
                  LocalDateTime fechaRecordatorio) {

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
    }

    // Getters

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

    // Lógica de negocio

    public boolean esEventoPasado() {
        return LocalDateTime.now().isAfter(fechaFin != null ? fechaFin : fechaHora);
    }

    public boolean esEventoHoy() {
        LocalDateTime hoy = LocalDateTime.now();
        return fechaHora.toLocalDate().equals(hoy.toLocalDate()) ||
               (fechaFin != null && fechaFin.toLocalDate().equals(hoy.toLocalDate()));
    }

    public boolean puedeCancelarse() {
        return !fechaHora.isBefore(LocalDateTime.now().plusHours(2));
    }

    public long duracionEnMinutos() {
        return fechaFin != null
                ? java.time.Duration.between(fechaHora, fechaFin).toMinutes()
                : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento evento)) return false;
        return Objects.equals(idExterno, evento.idExterno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExterno);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id='" + idExterno + '\'' +
                ", nombre='" + nombreEvento + '\'' +
                ", inicio=" + fechaHora +
                ", fin=" + fechaFin +
                '}';
    }
}

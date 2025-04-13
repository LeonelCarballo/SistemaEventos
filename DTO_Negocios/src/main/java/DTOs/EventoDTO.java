package DTOs;

import java.time.LocalDateTime;
import linkup.objetosnegocio.Etiqueta;

public class EventoDTO {

    private String nombreEvento;
    private Etiqueta etiqueta;
    private String descripcion;
    private LocalDateTime fechaHora;
    private LocalDateTime fechaFin;

    private String direccion;
    private Double latitud;
    private Double longitud;

    public EventoDTO() {
    }

    public EventoDTO(String nombreEvento, Etiqueta etiqueta, String descripcion,
                     LocalDateTime fechaHora, LocalDateTime fechaFin,
                     String direccion, Double latitud, Double longitud) {
        this.nombreEvento = nombreEvento;
        this.etiqueta = etiqueta;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.fechaFin = fechaFin;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Getters y setters

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
}

package linkup.dtosnegocios;

import linkup.objetosnegocio.Etiqueta;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import linkup.dtosnegocios.ContactoDTO;

public final class EventoDTO {
    private String idExterno;
    private String nombreEvento;
    private Etiqueta etiqueta;
    private String descripcion;
    private LocalDateTime fechaHora;
    private LocalDateTime fechaFin;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private boolean recordatorioActivo;
    private LocalDateTime fechaRecordatorio;
    private List<ContactoDTO> invitados;
    private String bannerPath;

    public EventoDTO() {}

    public EventoDTO(String idExterno, String nombreEvento, Etiqueta etiqueta, 
                   LocalDateTime fechaHora) {
        this.idExterno = Objects.requireNonNull(idExterno);
        this.nombreEvento = Objects.requireNonNull(nombreEvento);
        this.etiqueta = Objects.requireNonNull(etiqueta);
        this.fechaHora = Objects.requireNonNull(fechaHora);
    }

    public String getIdExterno() {
        return idExterno;
    }

    public EventoDTO setIdExterno(String idExterno) {
        this.idExterno = idExterno;
        return this;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public EventoDTO setNombreEvento(String nombreEvento) {
        this.nombreEvento = Objects.requireNonNull(nombreEvento);
        return this;
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
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public List<ContactoDTO> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<ContactoDTO> invitados) {
        this.invitados = invitados;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public boolean esEventoFuturo() {
        return fechaHora != null && fechaHora.isAfter(LocalDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventoDTO)) return false;
        EventoDTO eventoDTO = (EventoDTO) o;
        return Objects.equals(idExterno, eventoDTO.idExterno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExterno);
    }
}
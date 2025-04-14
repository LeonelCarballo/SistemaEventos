/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtosnegocios;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author jrasc
 */
public class EventoCompletoDTO {

    private String nombreEvento;
    private String etiqueta;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private List<ContactoDTO> invitados;

    public EventoCompletoDTO(String nombreEvento, String etiqueta, String descripcion, LocalDateTime fechaHora, String ubicacion, List<ContactoDTO> invitados) {
        this.nombreEvento = nombreEvento;
        this.etiqueta = etiqueta;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.invitados = invitados;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<ContactoDTO> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<ContactoDTO> invitados) {
        this.invitados = invitados;
    }
    
    
}

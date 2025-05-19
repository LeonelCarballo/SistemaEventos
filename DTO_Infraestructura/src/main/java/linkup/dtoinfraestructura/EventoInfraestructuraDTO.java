/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtoinfraestructura;

import java.time.LocalDateTime;

/**
 *
 * @author Dana Chavez
 */
public class EventoInfraestructuraDTO {
    public String idExterno;
    public String username;
    public String nombreEvento;
    public String descripcion;
    public String etiqueta; 
    public LocalDateTime fechaHora;
    public LocalDateTime fechaFin;
    public String direccion;
    public Double latitud;
    public Double longitud;
    public boolean recordatorioActivo;
    public LocalDateTime fechaRecordatorio;
    public String bannerPath;

    public EventoInfraestructuraDTO() {
    }

    public String getIdExterno() {
        return idExterno;
    }

    public String getUsername() {
        return username;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEtiqueta() {
        return etiqueta;
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

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public void setRecordatorioActivo(boolean recordatorioActivo) {
        this.recordatorioActivo = recordatorioActivo;
    }

    public void setFechaRecordatorio(LocalDateTime fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }
    
    
}

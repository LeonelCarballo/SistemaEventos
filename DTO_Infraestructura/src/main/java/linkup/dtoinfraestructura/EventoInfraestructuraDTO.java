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
}

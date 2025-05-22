/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtosnegocios.cu.admgrupo;

import java.time.LocalDateTime;

/**
 *
 * @author gael_
 */
public class NuevoMensajeDTO {
    private String contenido;
    private LocalDateTime fechaHora;
    private String autor;

    public NuevoMensajeDTO(String contenido, LocalDateTime fechaHora, String autor) {
        this.contenido = contenido;
        this.fechaHora = fechaHora;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
    
    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}

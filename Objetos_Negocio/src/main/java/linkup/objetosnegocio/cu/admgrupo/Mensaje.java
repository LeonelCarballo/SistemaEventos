/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio.cu.admgrupo;

import java.time.LocalDateTime;

/**
 *
 * @author gael_
 */
public class Mensaje {
    private Grupo grupo;
    private String contenido;
    private LocalDateTime fechaEnvio;
    private String autor;

    

    public Mensaje(String contenido, LocalDateTime fechaEnvio, String autor) {
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }


    public Grupo getGrupo() {
        return grupo;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

   
    
    public String getMensaje(){
        return autor + " : " + contenido + "  -  " +fechaEnvio;
    }
}

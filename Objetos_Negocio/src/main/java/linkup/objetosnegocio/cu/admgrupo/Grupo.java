/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio.cu.admgrupo;

import java.time.LocalDateTime;
import java.util.List;
import linkup.objetosnegocio.UsuarioON;

/**
 *
 * @author gael_
 */
public class Grupo {
    private String nombre;
    private LocalDateTime fechaCreaciom;
    private String creador;
    private List<UsuarioON> miembros;
    private List<Mensaje> mensajes;

    public Grupo(String nombre, LocalDateTime fechaCreaciom, String creador, List<UsuarioON> miembros, List<Mensaje> mensajes) {
        this.nombre = nombre;
        this.fechaCreaciom = fechaCreaciom;
        this.creador = creador;
        this.miembros = miembros;
        this.mensajes = mensajes;
    }
    

    public void agregarMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaCreaciom() {
        return fechaCreaciom;
    }

    public List<UsuarioON> getMiembros() {
        return miembros;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }
       
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCreaciom(LocalDateTime fechaCreaciom) {
        this.fechaCreaciom = fechaCreaciom;
    }

    public void setMiembros(List<UsuarioON> miembros) {
        this.miembros = miembros;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    
}

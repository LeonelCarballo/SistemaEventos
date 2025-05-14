/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio.cu.admgrupo;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author gael_
 */
public class Grupo {
    private String nombre;
    private LocalDateTime fechaCreaciom;
    private List<UsuarioAG> miembros;
    private List<Mensaje> mensajes;

    public Grupo(String nombre, LocalDateTime fechaCreaciom, List<UsuarioAG> miembros, List<Mensaje> mensajes) {
        this.nombre = nombre;
        this.fechaCreaciom = fechaCreaciom;
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

    public List<UsuarioAG> getMiembros() {
        return miembros;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCreaciom(LocalDateTime fechaCreaciom) {
        this.fechaCreaciom = fechaCreaciom;
    }

    public void setMiembros(List<UsuarioAG> miembros) {
        this.miembros = miembros;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    
}

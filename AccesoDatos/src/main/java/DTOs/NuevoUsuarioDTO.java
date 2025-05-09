/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author gael_
 */

//clase que va en capa Negocio

public class NuevoUsuarioDTO {
    private String username;
    private String contrasenia;
    private String nombre;
    private String apellido;

    public NuevoUsuarioDTO(String username, String contrasenia, String nombre, String apellido) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    

    
}

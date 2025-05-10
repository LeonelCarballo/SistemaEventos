/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtosnegocios;

/**
 *
 * @author gael_
 */
public class UsuarioDTO {
    private Long id;
    private String username;
    private String contrasenia;
    private String nombre;
    private String apellido;
    //talvez se ocupen mas

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id) {
        this.id = id;
    }
    
    //talvez se ocupen otros constructores

    public UsuarioDTO(Long id, String username, String contrasenia, String nombre, String apellido) {
        this.id = id;
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public UsuarioDTO(String username, String contrasenia) {
        this.username = username;
        this.contrasenia = contrasenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

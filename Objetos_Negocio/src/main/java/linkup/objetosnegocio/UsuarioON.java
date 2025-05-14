/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio;

import java.util.Objects;
import linkup.entidades.Usuario;

/**
 *
 * @author gael_
 */
public class UsuarioON {

    private final String username;
    private final String contrasenia;
    private final String nombre;
    private final String apellido;

    public UsuarioON(String username, String contrasenia, String nombre, String apellido) {
        this.username = Objects.requireNonNull(username, "Debe ingresar un username");
        this.contrasenia = Objects.requireNonNull(contrasenia, "Debe ingresar una contraseña");
        this.nombre = Objects.requireNonNull(nombre, "Debe ingresar su nombre");
        this.apellido = Objects.requireNonNull(apellido, "Debe ingrear su apellido");
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioON other = (UsuarioON) obj;
        return Objects.equals(this.username, other.username);
    }

    @Override
    public String toString() {
        return "UsuarioON{" + "username=" + username + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    public static Usuario toEntidad(UsuarioON on) {
        Usuario entidad = new Usuario();
        entidad.setUsername(on.getUsername());
        entidad.setContrasenia(on.getContrasenia());
        entidad.setNombre(on.getNombre());
        entidad.setApellido(on.getApellido());
        return entidad;
    }
    
}

package linkup.objetosnegocio;

import java.util.Objects;
import linkup.entidades.Usuario;

public class UsuarioON {
    private static UsuarioON instance; 
    private Long id;
    private String username;
    private String contrasenia;
    private String nombre;
    private String apellido;

    public UsuarioON(Long id, String username, String contrasenia, String nombre, String apellido) {
        this.id = id;
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static UsuarioON getInstance(Long id, String username, String contrasenia, String nombre, String apellido) {
        if (instance == null) {
            instance = new UsuarioON(id, username, contrasenia, nombre, apellido);
        }
        return instance;
    }

    public UsuarioON(String username, String contrasenia, String nombre, String apellido) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static UsuarioON getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instance not initialized");
        }
        return instance;
    }

    public Long getId() {
        return id;
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
        return Objects.hash(username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UsuarioON other = (UsuarioON) obj;
        return Objects.equals(this.username, other.username);
    }

    @Override
    public String toString() {
        return "UsuarioON{" + "username=" + username + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

    public Usuario toEntidad() {
        Usuario entidad = new Usuario();
        entidad.setId(this.id);
        entidad.setUsername(this.username);
        entidad.setContrasenia(this.contrasenia);
        entidad.setNombre(this.nombre);
        entidad.setApellido(this.apellido);
        return entidad;
    }

    public void fromEntidad(Usuario entidad) {
        this.id = entidad.getId();
        this.username = entidad.getUsername();
        this.contrasenia = entidad.getContrasenia();
        this.nombre = entidad.getNombre();
        this.apellido = entidad.getApellido();
    }
}

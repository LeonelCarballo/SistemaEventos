package linkup.objetosnegocio;

import exception.NegocioException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import linkup.entidades.Usuario;
import linkup.interfaces.IUsuariosDAO;

public class UsuarioON {
    private static UsuarioON instance; 
    private Long id;
    private String username;
    private String contrasenia;
    private String nombre;
    private String apellido;
    
    public IUsuariosDAO usuariosDAO;

    public UsuarioON(IUsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    public UsuarioON() {
    }

    public UsuarioON(String username) {
        this.username = username;
    }
    
        
    public UsuarioON(Long id, String username, String contrasenia, String nombre, String apellido) {
        this.id = id;
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static UsuarioON getInstance(Long id, String username, String contrasenia, String nombre, String apellido, IUsuariosDAO usuariosDAO) {
        if (instance == null) {
            instance = new UsuarioON(id, username, contrasenia, nombre, apellido);
            instance.usuariosDAO = usuariosDAO; 
        }
        return instance;
    }

    public static void setInstance(UsuarioON usuario) {
        instance = usuario;
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
    
    public static void cerrarSesion() {
        instance = null;
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
    
    public static List<UsuarioON> toUsuarioONList(List<Usuario> usuarios) {
        List<UsuarioON> usuariosON = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioON usuarioON = new UsuarioON(
                usuario.getUsername(),
                usuario.getContrasenia(),
                usuario.getNombre(),
                usuario.getApellido()
            );
            usuariosON.add(usuarioON);
        }
        return usuariosON;
    }
    
    public boolean registrarUsuario(UsuarioON nuevoUsuario) {
        if (nuevoUsuario == null ||
            nuevoUsuario.getUsername() == null || nuevoUsuario.getUsername().trim().isEmpty() ||
            nuevoUsuario.getContrasenia() == null || nuevoUsuario.getContrasenia().trim().isEmpty() ||
            nuevoUsuario.getNombre() == null || nuevoUsuario.getNombre().trim().isEmpty() ||
            nuevoUsuario.getApellido() == null || nuevoUsuario.getApellido().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ningún campo puede estar vacío.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!nuevoUsuario.getUsername().matches("^[a-zA-Z0-9]+$") ||
            !nuevoUsuario.getContrasenia().matches("^[a-zA-Z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario y la contraseña deben ser alfanuméricos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!nuevoUsuario.getNombre().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") ||
            !nuevoUsuario.getApellido().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            JOptionPane.showMessageDialog(null, "El nombre y apellido solo deben contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (usuariosDAO.existeUsername(nuevoUsuario.getUsername())) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Usuario entidad = UsuarioON.getInstance(nuevoUsuario.getId(), nuevoUsuario.getUsername(), nuevoUsuario.getContrasenia(), nuevoUsuario.getNombre(), nuevoUsuario.getApellido(), usuariosDAO).toEntidad();

        return usuariosDAO.registrarUsuario(entidad);
    }
    
    public UsuarioON iniciarSesionUsuario(String username, String contrasenia) throws NegocioException {
        if (username == null || username.trim().isEmpty() ||
            contrasenia == null || contrasenia.trim().isEmpty()) {
            throw new NegocioException("El nombre de usuario y la contraseña no pueden estar vacíos.");
        }

        if (!username.matches("^[a-zA-Z0-9]+$") || !contrasenia.matches("^[a-zA-Z0-9]+$")) {
            throw new NegocioException("El nombre de usuario y la contraseña deben ser alfanuméricos.");
        }

        Usuario usuario = usuariosDAO.iniciarSesionUsuario(username, contrasenia);

        if (usuario == null) {
            return null;
        }

        UsuarioON usuarioON = new UsuarioON(
            usuario.getId(),
            usuario.getUsername(),
            usuario.getContrasenia(),
            usuario.getNombre(),
            usuario.getApellido()
        );

        return usuarioON;
    }
    
    public boolean existeUsername(String username) {
        return usuariosDAO.existeUsername(username);
    }
    
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuariosDAO.obtenerTodosLosUsuarios();
    }
    
    public void validarExistenciaUsername(String username) throws NegocioException {
        if (username == null || username.trim().isEmpty()) {
            throw new NegocioException("El nombre de usuario no puede estar vacío.");
        }

        if (!username.matches("^[a-zA-Z0-9]+$")) {
            throw new NegocioException("El nombre de usuario contiene caracteres inválidos.");
        }

        if (!usuariosDAO.existeUsername(username)) {
            throw new NegocioException("El nombre de usuario no existe.");
        }
    }

}

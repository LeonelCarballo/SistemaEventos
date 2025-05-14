package linkup.objetosnegocio.implementaciones;

import exception.NegocioException;
import java.util.List;
import javax.swing.JOptionPane;
import linkup.entidades.Usuario;
import linkup.interfaces.IUsuariosDAO;
import linkup.objetosnegocio.UsuarioON;
import linkup.objetosnegocio.interfaz.IUsuariosBO;

public class UsuariosBO implements IUsuariosBO {

    private IUsuariosDAO usuariosDAO;

    public UsuariosBO(IUsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    @Override
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

        Usuario entidad = UsuarioON.getInstance(nuevoUsuario.getId(), nuevoUsuario.getUsername(), nuevoUsuario.getContrasenia(), nuevoUsuario.getNombre(), nuevoUsuario.getApellido()).toEntidad();

        return usuariosDAO.registrarUsuario(entidad);
    }

    @Override
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

    @Override
    public boolean existeUsername(String username) {
        return usuariosDAO.existeUsername(username);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuariosDAO.obtenerTodosLosUsuarios();
    }
}

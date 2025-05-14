/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio.implementaciones;

import exception.NegocioException;
import java.util.List;
import javax.swing.JOptionPane;
import linkup.entidades.Usuario;
import linkup.interfaces.IUsuariosDAO;
import linkup.objetosnegocio.ServicioUsuario;
import linkup.objetosnegocio.UsuarioON;
import linkup.objetosnegocio.interfaz.IUsuariosBO;

/**
 *
 * @author gael_
 */
public class UsuariosBO implements IUsuariosBO {
    
    IUsuariosDAO usuariosDAO;

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
            JOptionPane.showMessageDialog(null, "El nombre de usuario y la contraseña deben ser alfanuméricos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (usuariosDAO.existeUsername(nuevoUsuario.getUsername())) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }

//            Usuario usuario = new Usuario();
//            usuario.setUsername(nuevoUsuario.getUsername());
//            usuario.setContrasenia(nuevoUsuario.getContrasenia());
//            usuario.setNombre(nuevoUsuario.getNombre());
//            usuario.setApellido(nuevoUsuario.getApellido());
//
//            return usuariosDAO.registrarUsuario(usuario);

              Usuario entidad = UsuarioON.toEntidad(nuevoUsuario);
                return usuariosDAO.registrarUsuario(entidad);  
    }
    
    @Override
    public ServicioUsuario iniciarSesionUsuario(String username, String contrasenia) throws NegocioException {
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

        return new ServicioUsuario(
//            usuario.getId(),
//            usuario.getUsername(),
//            usuario.getContrasenia(),
//            usuario.getNombre(),
//            usuario.getApellido()
        );
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


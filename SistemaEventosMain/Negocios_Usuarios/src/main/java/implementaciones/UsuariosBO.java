/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import exception.NegocioException;
import interfaz.IUsuariosBO;
import javax.swing.JOptionPane;
import linkup.dtosnegocios.NuevoUsuarioDTO;
import linkup.dtosnegocios.UsuarioDTO;
import linkup.entidades.Usuario;
import linkup.interfaces.IUsuariosDAO;

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
    public boolean registrarUsuario(NuevoUsuarioDTO nuevoUsuario) {
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
        return usuariosDAO.registrarUsuario(nuevoUsuario);
    }
    
    @Override
    public UsuarioDTO iniciarSesionUsuario(String username, String contrasenia) throws NegocioException{
         if (username == null || username.trim().isEmpty() ||
            contrasenia == null || contrasenia.trim().isEmpty()) {
            throw new NegocioException("El nombre de usuario y la contraseña no pueden estar vacíos.");
        }

        if (!username.matches("^[a-zA-Z0-9]+$") || !contrasenia.matches("^[a-zA-Z0-9]+$")) {
            throw new NegocioException("El nombre de usuario y la contraseña deben ser alfanuméricos.");
        }
        return usuariosDAO.iniciarSesionUsuario(username, contrasenia);
    }
}

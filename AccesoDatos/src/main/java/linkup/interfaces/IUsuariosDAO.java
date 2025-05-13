/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.interfaces;


import java.util.List;
import linkup.dtosnegocios.NuevoUsuarioDTO;
import linkup.dtosnegocios.UsuarioDTO;
import linkup.entidades.Usuario;

/**
 *
 * @author gael_
 */
public interface IUsuariosDAO {
    public abstract boolean registrarUsuario(NuevoUsuarioDTO nuevoUsuario);
    public abstract UsuarioDTO iniciarSesionUsuario(String username, String contrasenia);
    public abstract boolean existeUsername(String username);
    public abstract List<Usuario> obtenerTodosLosUsuarios();
}

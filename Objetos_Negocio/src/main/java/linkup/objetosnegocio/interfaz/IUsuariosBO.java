/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.objetosnegocio.interfaz;


import exception.NegocioException;
import java.util.List;
import linkup.entidades.Usuario;
import linkup.objetosnegocio.ServicioUsuario;

/**
 *
 * @author gael_
 */
public interface IUsuariosBO {
    public boolean registrarUsuario(Usuario nuevoUsuario);
    public ServicioUsuario iniciarSesionUsuario(String username, String contrasenia)  throws NegocioException;
    public boolean existeUsername(String username);
    public List<Usuario> obtenerTodosLosUsuarios();
    
}

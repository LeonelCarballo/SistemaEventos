/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;


import exception.NegocioException;
import linkup.dtosnegocios.NuevoUsuarioDTO;
import linkup.dtosnegocios.UsuarioDTO;
import linkup.entidades.Usuario;

/**
 *
 * @author gael_
 */
public interface IUsuariosBO {
    public Usuario registrarUsuario(NuevoUsuarioDTO nuevoUsuario) throws NegocioException;
    public UsuarioDTO iniciarSesionUsuario(String username, String contrasenia) throws NegocioException;
}

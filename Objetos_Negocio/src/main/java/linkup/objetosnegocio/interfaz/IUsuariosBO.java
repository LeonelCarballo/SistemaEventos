/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.objetosnegocio.interfaz;

import exception.NegocioException;
import linkup.dtosnegocios.NuevoUsuarioDTO;
import linkup.dtosnegocios.UsuarioDTO;

/**
 *
 * @author gael_
 */
public interface IUsuariosBO {
    public boolean registrarUsuario(NuevoUsuarioDTO nuevoUsuario);
    public UsuarioDTO iniciarSesionUsuario(String username, String contrasenia) throws NegocioException;
}

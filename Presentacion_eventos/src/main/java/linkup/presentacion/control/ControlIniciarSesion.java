/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import exception.NegocioException;
import linkup.dtosnegocios.UsuarioDTO;
import linkup.objetosnegocio.fabrica.FabricaObjetosNegocio;
import linkup.objetosnegocio.interfaz.IUsuariosBO;
import linkup.presentacion.IniciarSesion;


/**
 *
 * @author gael_
 */
public class ControlIniciarSesion {
    
    private IniciarSesion frmIniciarSesion;
    private final IUsuariosBO usuariosBO;
    private UsuarioDTO usuarioActual;

    public ControlIniciarSesion() {
        this.usuariosBO = FabricaObjetosNegocio.crearUsuariosBO();
    }

    public void iniciarCasoUso(){
        this.frmIniciarSesion = new IniciarSesion(this);
        this.frmIniciarSesion.setVisible(true);
    }
    
    public boolean iniciarSesion(String username, String contraseña) throws NegocioException {
        UsuarioDTO usuario = usuariosBO.iniciarSesionUsuario(username, contraseña);
        if (usuario != null) {
            usuarioActual = usuario;
            return true;
        }
        return false;
    }
    
    public UsuarioDTO getUsuarioActual() {
        return usuarioActual;
    }
}

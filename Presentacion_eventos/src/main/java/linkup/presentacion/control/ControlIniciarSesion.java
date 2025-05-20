/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import exception.NegocioException;
import linkup.objetosnegocio.UsuarioON;
import linkup.objetosnegocio.fabrica.FabricaObjetosNegocio;
import linkup.presentacion.IniciarSesion;

public class ControlIniciarSesion {
    
    private IniciarSesion frmIniciarSesion;
    private final UsuarioON usuariosON;
    private UsuarioON usuarioActual;
    private ControlCrearEvento controlEvento;

    public ControlIniciarSesion() {
        this.usuariosON = FabricaObjetosNegocio.crearUsuarioON();
    }

    public void iniciarCasoUso(ControlCrearEvento controlEvento){
        this.controlEvento = controlEvento;
        this.frmIniciarSesion = new IniciarSesion(this, controlEvento);
        this.frmIniciarSesion.setVisible(true);
    }
    
    public boolean iniciarSesion(String username, String contraseña) throws NegocioException {
        UsuarioON usuario = usuariosON.iniciarSesionUsuario(username, contraseña);
        if (usuario != null) {
            usuario.usuariosDAO = this.usuariosON.usuariosDAO;
            usuarioActual = usuario;
            UsuarioON.setInstance(usuario);
            return true;
        }
        
        return false;
    }
 
    public UsuarioON getUsuarioActual() {
        return usuarioActual;
    }
    
    public String getUsuarioActual(UsuarioON usuario){
        return usuario.getUsername();
    }
}

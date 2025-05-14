/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;


import javax.swing.JOptionPane;
import linkup.dtosnegocios.NuevoUsuarioDTO;
import linkup.dtosnegocios.UsuarioDTO;
import linkup.exception.NegocioException;
import linkup.objetosnegocio.UsuarioON;
import linkup.objetosnegocio.fabrica.FabricaObjetosNegocio;
import linkup.objetosnegocio.interfaz.IUsuariosBO;
import linkup.presentacion.IniciarSesion;
import linkup.presentacion.RegistrarUsuario;


/**
 *
 * @author gael_
 */
public class ControlRegistrarUsuario {
    private RegistrarUsuario frmRegistrarUsuario;
    private IniciarSesion frmIniciarSesion; 
    private final IUsuariosBO usuariosBO;
    ControlCrearEvento controlEvento;

    public ControlRegistrarUsuario(IniciarSesion frmIniciarSesion) {
        this.frmIniciarSesion = frmIniciarSesion;
        this.usuariosBO = FabricaObjetosNegocio.crearUsuariosBO();
    }

    public void iniciarCasoUso(ControlCrearEvento controlEvento) {
        this.frmRegistrarUsuario = new RegistrarUsuario(this,controlEvento);
        frmRegistrarUsuario.setVisible(true);
    }
    
    public boolean registrarUsuario(String username, String contrasenia, String nombre, String apellido){
        
        UsuarioON usuario = new UsuarioON(username, contrasenia, nombre, apellido);
        
        boolean registrado = usuariosBO.registrarUsuario(usuario);
        
        if (registrado) {
            
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");

        } else {
        throw new NegocioException("Error al registrar el usuario. Inténtalo de nuevo.");
    }

        return registrado;
    }

    
    
}

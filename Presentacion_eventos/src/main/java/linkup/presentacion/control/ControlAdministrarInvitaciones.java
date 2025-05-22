/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import com.mycompany.negocios_administrarinvitaciones.implementacion.AdministrarInvitaciones;
import com.mycompany.negocios_administrarinvitaciones.interfaz.IAdministrarInvitaciones;
import java.util.List;
import linkup.objetosnegocio.Evento;
import linkup.objetosnegocio.cu.admInvitacion.Invitacion;
import linkup.presentacion.cu.gestionarInvitacion.frmMostrarInvitacion;

/**
 *
 * @author santi
 */
public class ControlAdministrarInvitaciones {
    private static ControlAdministrarInvitaciones instancia;
    private ControlCrearEvento controlPadre;
    private static IAdministrarInvitaciones administrarInvitaciones = new AdministrarInvitaciones();
    
    private List<Invitacion> invitaciones;
    
    private frmMostrarInvitacion mostrarInvitacion;
    private final String NombreUsuario;

    public ControlAdministrarInvitaciones(String NombreUsuario, ControlCrearEvento controlCrearEvento) {
        this.NombreUsuario = NombreUsuario;
        this.controlPadre = controlCrearEvento;
    }

    public List<Invitacion> obtenerInvitacionesUsuario(){
        return administrarInvitaciones.obtenerInvitaciones(NombreUsuario);
        
    }
    
    public void mostrarInvitacionesEnviadas(){
        this.invitaciones = obtenerInvitacionesUsuario();
        mostrarInvitacion =  new frmMostrarInvitacion(this.invitaciones , this);
        mostrarInvitacion.setVisible(true);
    }
    
    public void aceptarInvitacion( Evento evento){
        administrarInvitaciones.AceptarInvitacion(NombreUsuario, evento);
    }
    
    public void rechazar(Evento evento){
        administrarInvitaciones.RechazarInvitacion(NombreUsuario, evento.getUsername());
    }
}

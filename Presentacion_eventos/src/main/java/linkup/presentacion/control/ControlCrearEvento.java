/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import linkup.presentacion.ConfirmacionEvento;
import linkup.presentacion.EnviarInvitaciones;
import linkup.presentacion.IngresarDetallesEvento;
import linkup.presentacion.SeleccionarFechaHora;
import linkup.presentacion.SeleccionarUbicacion;
import linkup.presentacion.VentanaPrincipalCrearEvento;

/**
 *
 * @author leoca
 */
public class ControlCrearEvento {
    
    public void iniciarFlujoCreacionEvento(){
        mostrarFormularioDetalles();
    }
    
    public void mostrarVentanaPrincipal(){
        VentanaPrincipalCrearEvento ventanaPrincipal = new VentanaPrincipalCrearEvento(this);
        ventanaPrincipal.mostrar();
    }
    
    public void mostrarFormularioDetalles(){
        IngresarDetallesEvento ingresarDetalles = new IngresarDetallesEvento(this);
        ingresarDetalles.mostrar();
    }
    
    public void mostrarSeleccionFechaHora(){
        SeleccionarFechaHora seleccionFechaHora = new SeleccionarFechaHora(this);
        seleccionFechaHora.mostrar();
    }
    
    public void mostrarSeleccionarUbicacion(){
        SeleccionarUbicacion seleccionUbicacion = new SeleccionarUbicacion(this);
        seleccionUbicacion.mostrar();
    }
    
    public void mostrarEnviarInvitaciones(){
        EnviarInvitaciones enviarInvitaciones = new EnviarInvitaciones(this);
        enviarInvitaciones.mostrar();
    }
    
    public void mostrarConfirmacionEvento(){
        ConfirmacionEvento confirmacionEvento = new ConfirmacionEvento(this);
        confirmacionEvento.mostrar();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.negocios_administrarinvitaciones.interfaz;

import java.util.List;
import linkup.objetosnegocio.Evento;
import linkup.objetosnegocio.cu.admInvitacion.Invitacion;

/**
 *
 * @author santi
 */
public interface IAdministrarInvitaciones {
    public abstract List<Invitacion> obtenerInvitaciones(String username);
    
    public abstract void AceptarInvitacion(String username, Evento evento);
    
    public abstract void RechazarInvitacion(String username, String IdEvento);
}

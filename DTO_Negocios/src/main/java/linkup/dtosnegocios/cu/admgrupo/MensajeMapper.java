/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtosnegocios.cu.admgrupo;

import linkup.objetosnegocio.cu.admgrupo.Mensaje;

/**
 *
 * @author gael_
 */
public class MensajeMapper {
    public MensajeMapper() {
    }
    
    public static Mensaje toEntidad(NuevoMensajeDTO nuevoMensaje){
        if (nuevoMensaje == null){
            return null;
        }
        
        return new Mensaje(
            nuevoMensaje.getContenido(),
            nuevoMensaje.getFechaHora()
        );
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio.cu.admInvitacion;

/**
 *
 * @author santi
 */
public class Invitacion {
    
    private final String EventoCodigo;
    private final String CreadorNombre;
    private final Estado estado;

    public Invitacion(String EventoCodigo, String CreadorNombre, Estado estado) {
        this.EventoCodigo = EventoCodigo;
        this.CreadorNombre = CreadorNombre;
        this.estado = estado;
    }

    public String getEventoCodigo() {
        return EventoCodigo;
    }

    public String getCreadorNombre() {
        return CreadorNombre;
    }

    public Estado getEstado() {
        return estado;
    }
    
    
    
}

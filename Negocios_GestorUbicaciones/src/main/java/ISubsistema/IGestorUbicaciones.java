/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ISubsistema;

import linkup.dtosnegocios.EventoDTO;
import linkup.infraestructura.mapa.Location;



/**
 *
 * @author jrasc
 */
public interface IGestorUbicaciones {

    public abstract void mostrarMapa();
    public abstract Location elegirUbicacion(String nombre);
    public abstract Location getUbicacionSeleccionada();
    public abstract EventoDTO validarUbicacionEvento(EventoDTO dto);
}

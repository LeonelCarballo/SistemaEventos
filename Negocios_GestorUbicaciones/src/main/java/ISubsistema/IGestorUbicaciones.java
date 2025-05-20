/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ISubsistema;

import java.util.Map;
import javax.swing.JPanel;
import linkup.dtosnegocios.EventoDTO;




/**
 *
 * @author jrasc
 */
public interface IGestorUbicaciones {

    public abstract void mostrarMapa(JPanel destino);
    public abstract EventoDTO elegirUbicacion(String nombre);
    public abstract Map<String, String> getUbicacionSeleccionada();
    public abstract EventoDTO validarUbicacionEvento(EventoDTO dto);
}

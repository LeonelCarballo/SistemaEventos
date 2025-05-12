/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura.mapa.interfaces;

import java.util.List;
import javax.swing.JPanel;
import linkup.infraestructura.mapa.Location;

/**
 *
 * @author Dana Chavez
 */
public interface IInfraestructuraMapa {
    
    public abstract void showMap(JPanel destino);
    
    public abstract List<Location> getAvailableLocations();
    
    public abstract Location selectLocation(String name);
}

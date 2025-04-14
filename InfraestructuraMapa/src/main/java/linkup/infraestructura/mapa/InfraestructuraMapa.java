/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package linkup.infraestructura.mapa;

import java.util.ArrayList;
import java.util.List;
import linkup.infraestructura.mapa.interfaces.IInfraestructuraMapa;

/**
 *
 * @author Dana Chavez
 */
public class InfraestructuraMapa implements IInfraestructuraMapa {
    
    private List<Location> mockLocations;

    public InfraestructuraMapa() {
        mockLocations = new ArrayList<>();
        mockLocations.add(new Location("Plaza Central", -34.6037, -58.3816));
        mockLocations.add(new Location("Parque del Sol", -34.6118, -58.4173));
        mockLocations.add(new Location("Estación Norte", -34.5944, -58.4000));
    }

    @Override
    public void showMap() {
        System.out.println("Mostrando mapa de prueba con ubicaciones disponibles...");
        for (Location loc : mockLocations) {
            System.out.println(" - " + loc);
        }
    }

    @Override
    public List<Location> getAvailableLocations() {
        return mockLocations;
    }

    @Override
    public Location selectLocation(String name) {
        for (Location loc : mockLocations) {
            if (loc.getName().equalsIgnoreCase(name)) {
                System.out.println("Ubicación seleccionada: " + loc);
                return loc;
            }
        }
        System.out.println("Ubicación no encontrada.");
        return null;
    }
}

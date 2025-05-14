/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura.conectores;

import linkup.infraestructura.interfaces.IConector;
import linkup.infraestructura.conectores.ConectorCalendario;
import linkup.infraestructura.conectores.ConectorMapa;

public class FabricaConectores {
    
    public static IConector crearConector(String tipo) {
        return switch (tipo) {
            case "calendario" -> new ConectorCalendario();
            case "mapa" -> new ConectorMapa();
            case "contactos" -> new ConectorContactos();
            default -> throw new IllegalArgumentException("Tipo de conector desconocido: " + tipo);
        };
    }
    
}

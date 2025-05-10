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
        switch (tipo) {
            case "calendario":
                return new ConectorCalendario();
            case "mapa":
                return new ConectorMapa(); 
            default:
                throw new IllegalArgumentException("Tipo de conector no válido");
        }
    }
}

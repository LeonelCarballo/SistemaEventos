/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura.conectores;

import linkup.infraestructura.interfaces.IConector;
import linkup.infraestructura.conectores.ConectorCalendario;
import linkup.infraestructura.conectores.ConectorMapa;

public class FabricaConectores {
    public static IConector crearConectorParaCalendario() {
        return new ConectorCalendario();
    }

    public static IConector crearConectorParaMapa() {
        return new ConectorMapa();
    }
}

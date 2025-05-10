/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura.control;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import linkup.infraestructura.conectores.FabricaConectores;
import linkup.infraestructura.interfaces.IConector;

public class ControlInfraestructura {

    public String agendarCalendario(String json) {
        JsonObject objeto = JsonParser.parseString(json).getAsJsonObject();
        String accion = objeto.get("accion").getAsString();

        IConector conector = FabricaConectores.crearConector("calendario");
        return conector.invocarServicioJson(json);
    }

}


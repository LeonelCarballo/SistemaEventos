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

    public String obtenerCalendario(String json) {
        IConector conector = FabricaConectores.crearConector("calendario");
        return conector.invocarServicioJson(json);
    }

    public String obtenerUbicacionDesdeServidor() {
        IConector conector = FabricaConectores.crearConector("mapa");
        return conector.invocarServicioJson(""); // No se envía JSON, solo se hace GET
    }

    public String obtenerContactos(String json) {
        IConector conector = FabricaConectores.crearConector("contactos");
        return conector.invocarServicioJson(json);
    }
    
    public String enviarContactos(String json) {
        IConector conector = FabricaConectores.crearConector("contactos");
        return conector.invocarServicioJson(json);
    }
}

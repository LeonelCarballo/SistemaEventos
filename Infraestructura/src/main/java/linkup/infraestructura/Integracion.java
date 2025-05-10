/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Collections;
import java.util.List;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.infraestructura.control.ControlInfraestructura;
import linkup.infraestructura.interfaces.IIntegracion;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public class Integracion implements IIntegracion {

private final Gson gson = new Gson();
    private final ControlInfraestructura control = new ControlInfraestructura();

    @Override
    public List<EventoInfraestructuraDTO> obtenerEventosDelCalendario(String idExterno) {
        Map<String, String> payload = new HashMap<>();
        payload.put("accion", "obtenerEventos");
        payload.put("idExterno", idExterno);

        String jsonPeticion = gson.toJson(payload);
        String respuestaJson = control.agendarCalendario(jsonPeticion); 

        java.lang.reflect.Type tipoLista = new TypeToken<List<EventoInfraestructuraDTO>>() {}.getType();
        List<EventoInfraestructuraDTO> eventos = gson.fromJson(respuestaJson, tipoLista);

        return eventos != null ? eventos : Collections.emptyList();
    }


    @Override
    public void agregarEventoACalendario(String idCalendario, EventoInfraestructuraDTO evento) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("accion", "agregarEvento");
        payload.put("idExterno", idCalendario);
        payload.put("evento", evento);

        String json = gson.toJson(payload);
        control.agendarCalendario(json); 
    }

    @Override
    public boolean validarHorario(String idCalendario, String fecha, String hora) {
        Map<String, String> payload = new HashMap<>();
        payload.put("accion", "validarHorario");
        payload.put("idExterno", idCalendario);
        payload.put("fecha", fecha);
        payload.put("hora", hora);

        String json = gson.toJson(payload);
        String respuesta = control.agendarCalendario(json);

        JsonObject respuestaJson = JsonParser.parseString(respuesta).getAsJsonObject();
        return respuestaJson.get("disponible").getAsBoolean();
    }

    private static class CalendarioPayload {
        String idExterno;
        EventoInfraestructuraDTO evento;

        CalendarioPayload(String idExterno, EventoInfraestructuraDTO evento) {
            this.idExterno = idExterno;
            this.evento = evento;
        }
    }
}

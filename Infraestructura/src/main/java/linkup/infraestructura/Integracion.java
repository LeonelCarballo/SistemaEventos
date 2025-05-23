/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Collections;
import java.util.List;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.infraestructura.control.ControlInfraestructura;
import linkup.infraestructura.interfaces.IIntegracion;
import com.google.gson.reflect.TypeToken;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import linkup.dtoinfraestructura.InvitacionInfraestructuraDTO;
import linkup.infraestructura.utils.LocalDateTimeAdapter;

public class Integracion implements IIntegracion {

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();
    private final ControlInfraestructura control = new ControlInfraestructura();

    @Override
    public List<EventoInfraestructuraDTO> obtenerEventosDelCalendario(String idExterno, String username) {
        Map<String, String> payload = new HashMap<>();
        payload.put("accion", "obtenerEventos");
        payload.put("idExterno", idExterno);
        payload.put("usuario", username);

        String jsonPeticion = gson.toJson(payload);
        String respuestaJson = control.agendarCalendario(jsonPeticion);

        System.out.println("Respuesta JSON: " + respuestaJson);

        try {
            JsonObject respuestaObj = JsonParser.parseString(respuestaJson).getAsJsonObject();
            if (respuestaObj.has("exito") && !respuestaObj.get("exito").getAsBoolean()) {
                System.out.println("Error desde el servidor: " + respuestaObj.get("error").getAsString());
                return Collections.emptyList();
            }
        } catch (Exception e) {
        }

        java.lang.reflect.Type tipoLista = new TypeToken<List<EventoInfraestructuraDTO>>() {
        }.getType();
        List<EventoInfraestructuraDTO> eventos = gson.fromJson(respuestaJson, tipoLista);

        return eventos != null ? eventos : Collections.emptyList();
    }

    @Override
    public void agregarEventoACalendario(String idCalendario, EventoInfraestructuraDTO evento) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("accion", "agregarEvento");
        payload.put("idExterno", idCalendario);
        payload.put("evento", evento);
        payload.put("usuario", evento.getUsername());

        System.out.println("Usuario en evento: " + evento.getUsername());
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

    public Map<String, String> obtenerUbicacionMapa() {
    String jsonRespuesta = control.obtenerUbicacionDesdeServidor();
    JsonObject objeto = JsonParser.parseString(jsonRespuesta).getAsJsonObject();

    Map<String, String> ubicacion = new HashMap<>();
    ubicacion.put("latitud", objeto.get("latitud").getAsString());
    ubicacion.put("longitud", objeto.get("longitud").getAsString());
    ubicacion.put("ciudad", objeto.get("ciudad").getAsString());
    ubicacion.put("localidad", objeto.get("localidad").getAsString());
        return ubicacion;
    }

    @Override
    public void eliminarEvento(String idCalendario, EventoInfraestructuraDTO eventoInfraestructuraDTO) {
        Map<String, Object> payload = new HashMap<>();

        payload.put("accion", "eliminarEvento");

        payload.put("idExterno", eventoInfraestructuraDTO.getIdExterno());
        payload.put("usuario", eventoInfraestructuraDTO.getUsername());    
        payload.put("idCalendario", idCalendario);                            

        String json = gson.toJson(payload);

        control.agendarCalendario(json); 
    }
    
    @Override
    public List<InvitacionInfraestructuraDTO> obtenerNotificaciones(String username) {
    Map<String, String> payload = new HashMap<>();
    payload.put("accion", "obtenerNotificaciones");
    payload.put("usuario", username);

    String jsonPeticion = gson.toJson(payload);
    String respuestaJson = control.agendarCalendario(jsonPeticion);

    System.out.println("Respuesta JSON: " + respuestaJson);

    try {
        JsonObject respuestaObj = JsonParser.parseString(respuestaJson).getAsJsonObject();
        if (respuestaObj.has("exito") && !respuestaObj.get("exito").getAsBoolean()) {
            System.out.println("Error desde el servidor: " + respuestaObj.get("error").getAsString());
            return Collections.emptyList();
        }
    } catch (Exception e) {
        
    }

    java.lang.reflect.Type tipoLista = new TypeToken<List<InvitacionInfraestructuraDTO>>() {}.getType();
    List<InvitacionInfraestructuraDTO> notificaciones = gson.fromJson(respuestaJson, tipoLista);

    return notificaciones != null ? notificaciones : Collections.emptyList();
}

    @Override
    public void eliminarNotificacion(String username, String idEvento) {
        Map<String, String> payload = new HashMap<>();
        payload.put("accion", "eliminarNotificacion");
        payload.put("usuario", username);
        payload.put("idEvento", idEvento);

        String json = gson.toJson(payload);
        String respuestaJson = control.agendarCalendario(json);
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

package linkup.infraestructura;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import linkup.dtoinfraestructura.ContactoInfraestructuraDTO;
import linkup.infraestructura.control.ControlInfraestructura;
import linkup.infraestructura.interfaces.IContactosAPI;

/**
 * API de contactos. Enviar invitaciones ahora lo delega al servidor de calendario.
 */
public class ContactosAPI implements IContactosAPI {
    
    private final Gson gson = new Gson();
    private final ControlInfraestructura control = new ControlInfraestructura();

    public ContactosAPI() {
    }

    @Override
    public boolean enviarInvitaciones(String usuario, String idEvento, List<ContactoInfraestructuraDTO> contactos) {
        // 1) Construir la lista de usernames
        List<String> invitados = contactos.stream()
                .map(ContactoInfraestructuraDTO::getUsuario)
                .collect(Collectors.toList());

        // 2) Payload completo, incluyendo idEvento
        Map<String, Object> payload = new HashMap<>();
        payload.put("accion",    "enviarInvitaciones");
        payload.put("usuario",   usuario);
        payload.put("idEvento",  idEvento);
        payload.put("contactos", invitados);
        String jsonPeticion = gson.toJson(payload);

        // 3) Imprimir el JSON para depurar
        System.out.println("JSON enviarInvitaciones -> " + jsonPeticion);

        // 4) Invocar AL SERVIDOR SOLO UNA VEZ
        String respuestaJson = control.obtenerCalendario(jsonPeticion);
        System.out.println("Respuesta cruda del servidor -> " + respuestaJson);

        // 5) Parsear la respuesta
        Map<String, Object> respuesta = gson.fromJson(respuestaJson, Map.class);
        return Boolean.TRUE.equals(respuesta.get("exito"));
    }


    @Override
    public List<ContactoInfraestructuraDTO> obtenerContactos(String usuario) {
        Map<String, String> payload = new HashMap<>();
        payload.put("accion", "obtenerContactos");
        payload.put("usuario", usuario);

        String jsonPeticion = gson.toJson(payload);
        String respuesta = control.obtenerContactos(jsonPeticion);
        System.out.println("Respuesta cruda del servidor: " + respuesta);

        java.lang.reflect.Type tipoLista = new TypeToken<List<ContactoInfraestructuraDTO>>() {}.getType();
        List<ContactoInfraestructuraDTO> contactos = gson.fromJson(respuesta, tipoLista);

        return contactos != null ? contactos : Collections.emptyList();
    }
    
    @Override
    public boolean agregarAmigo(String usuario, String amigo) {
        Map<String, String> payload = new HashMap<>();
        payload.put("accion", "agregarAmigo");
        payload.put("usuario", usuario);
        payload.put("amigo", amigo);

        String jsonPeticion = gson.toJson(payload);
        System.out.println(jsonPeticion);
        System.out.println("JSON que se envía al servidor de contactos: " + jsonPeticion);
        String respuestaJson = control.enviarContactos(jsonPeticion);


        Map<String, Object> respuesta = gson.fromJson(respuestaJson, Map.class);
        System.out.println("Respuesta agregarAmigo: " + respuestaJson);
        return Boolean.TRUE.equals(respuesta.get("exito"));
    }

}

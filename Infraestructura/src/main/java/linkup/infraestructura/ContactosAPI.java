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
        List<String> invitados = contactos.stream()
                .map(ContactoInfraestructuraDTO::getUsuario) 
                .collect(Collectors.toList());

        Map<String, Object> payload = new HashMap<>();
        payload.put("accion", "enviarInvitaciones");
        payload.put("usuario", usuario);
        payload.put("idEvento", idEvento);
        payload.put("invitados", invitados);

        String jsonPeticion = gson.toJson(payload);
        
        // Llamar al servidor de calendario (NO al de contactos)
        String respuestaJson = control.obtenerCalendario(jsonPeticion); // Este método debe enviar la petición al servidor simulado de calendario

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
        String respuestaJson = control.obtenerContactos(jsonPeticion);

        Map<String, Object> respuesta = gson.fromJson(respuestaJson, Map.class);
        System.out.println("se agrego al contacto uwu uwu");
        return Boolean.TRUE.equals(respuesta.get("exito"));
    }

}

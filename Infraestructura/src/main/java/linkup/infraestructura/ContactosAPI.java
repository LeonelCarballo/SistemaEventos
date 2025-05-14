/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import linkup.dtoinfraestructura.ContactoInfraestructuraDTO;
import linkup.infraestructura.control.ControlInfraestructura;
import linkup.infraestructura.interfaces.IContactosAPI;

/**
 *
 * @author Dana Chavez
 */
public class ContactosAPI implements IContactosAPI {
    
    private final Gson gson = new Gson();
    private final ControlInfraestructura control = new ControlInfraestructura();

    public ContactosAPI() {
    }

    @Override
    public boolean enviarInvitaciones(String usuario, String idEvento, List<ContactoInfraestructuraDTO> contactos) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("accion", "enviarInvitaciones");
        payload.put("usuario", usuario);
        payload.put("idEvento", idEvento);
        payload.put("contactos", contactos);

        String jsonPeticion = gson.toJson(payload);
        String respuestaJson = control.obtenerContactos(jsonPeticion);

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
    
}


package linkup.infraestructura.calendario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.infraestructura.interfaces.IInfraestructuraCalendario;




/**
 * Implementación ficticia para pruebas de lógica de negocio sin conexión real.
 */
public class InfraestructuraCalendario implements IInfraestructuraCalendario {

    private final Map<String, List<EventoInfraestructuraDTO>> calendarioEventos;

    public InfraestructuraCalendario() {
        this.calendarioEventos = new HashMap<>();
    }

    @Override
    public List<EventoInfraestructuraDTO> obtenerEventosDelCalendario(String idExterno) {
        return new ArrayList<>(calendarioEventos.getOrDefault(idExterno, new ArrayList<>()));
    }

    @Override
    public void agregarEventoACalendario(String idCalendario, EventoInfraestructuraDTO evento) {
        calendarioEventos
            .computeIfAbsent(idCalendario, k -> new ArrayList<>())
            .add(evento);
    }


}

package linkup.infraestructura.interfaces;

import java.util.List;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;

/**
 * Define los métodos que una infraestructura de calendario debe implementar.
 */
public interface IInfraestructuraCalendario {

    /**
     * Obtiene todos los eventos asociados a un calendario.
     * 
     * @param idExterno Identificador externo del calendario (ej. en Google)
     * @return Lista de eventos
     */
    public abstract List<EventoInfraestructuraDTO> obtenerEventosDelCalendario(String idExterno);

    /**
     * Agrega un evento a un calendario.
     *
     * @param idCalendario Id externo del calendario
     * @param evento Evento a agregar
     */
    public abstract void agregarEventoACalendario(String idCalendario, EventoInfraestructuraDTO evento);

}

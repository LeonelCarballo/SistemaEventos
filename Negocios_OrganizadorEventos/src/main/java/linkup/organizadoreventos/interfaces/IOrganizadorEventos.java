package linkup.organizadoreventos.interfaces;

import java.util.List;
import linkup.dtosnegocios.EventoDTO;
import linkup.exception.NegocioException;

/**
 * Interfaz que define las operaciones del subsistema de organización de
 * eventos.
 */
public interface IOrganizadorEventos {

    /**
     * Agrega un nuevo evento al sistema y al calendario especificado
     *
     * @param dto Datos del evento a agregar
     * @throws NegocioException Si el evento no es válido
     */
    void agregarEvento(EventoDTO dto) throws NegocioException;

    /**
     * Consulta un evento por su ID externo
     *
     * @param idExterno Identificador único del evento
     * @return EventoDTO o null si no se encuentra
     */
    EventoDTO consultarEventoPorId(String idExterno);

    /**
     * Obtiene todos los eventos del sistema
     *
     * @return Lista de eventos
     */
    List<EventoDTO> consultarEventos();

    /**
     * Valida los detalles básicos de un evento
     *
     * @param dto Evento a validar
     * @return Evento validado
     * @throws NegocioException Si hay errores de validación
     */
    EventoDTO validarDetallesEvento(EventoDTO dto) throws NegocioException;

    /**
     * Valida las fechas y horas de un evento
     *
     * @param dto Evento a validar
     * @return Evento validado
     * @throws NegocioException Si hay errores de validación
     */
    EventoDTO validarFechaHoraEvento(EventoDTO dto) throws NegocioException;

    /**
     * Valida completamente un evento (detalles + fechas)
     *
     * @param dto Evento a validar
     * @return Evento validado
     * @throws NegocioException Si hay errores de validación
     */
    EventoDTO validarEventoCompleto(EventoDTO dto) throws NegocioException;

    void eliminarEvento(EventoDTO dto) throws NegocioException;
}

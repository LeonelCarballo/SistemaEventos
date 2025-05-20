/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.infraestructura.interfaces;

import java.util.List;
import java.util.Map;
import linkup.dtoinfraestructura.EventoInfraestructuraDTO;

/**
 *
 * @author Dana Chavez
 */
public interface IIntegracion {
    /**
     * Obtiene todos los eventos asociados a un calendario.
     * 
     * @param idExterno Identificador externo del calendario (ej. en Google)
     * @return Lista de eventos
     */
    public abstract List<EventoInfraestructuraDTO> obtenerEventosDelCalendario(String idExterno, String username);

    /**
     * Agrega un evento a un calendario.
     *
     * @param idCalendario Id externo del calendario
     * @param evento Evento a agregar
     */
    public abstract void agregarEventoACalendario(String idCalendario, EventoInfraestructuraDTO evento);
    
    public abstract boolean validarHorario(String idCalendario, String fecha, String hora);
    
    public abstract void eliminarEvento(String idCalendario, EventoInfraestructuraDTO evento);
    public abstract Map<String, String> obtenerUbicacionMapa();

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.organizadoreventos.interfaces;

import DTOs.EventoDTO;
import java.time.LocalDateTime;
import java.util.List;
import linkup.objetosnegocio.Evento;

/**
 * Interfaz que define las operaciones del subsistema de organización de eventos.
 */
public interface IOrganizadorEventos {
    Evento crearEvento(EventoDTO dto) throws IllegalArgumentException;
    List<Evento> obtenerEventosFuturos();
    List<Evento> obtenerEventosDeHoy();
    List<Evento> buscarEventosPorNombre(String nombreFragmento);
    void programarRecordatorio(String idEvento, LocalDateTime fechaRecordatorio);
    Evento buscarEventoPorId(String idEvento);
    boolean tieneConflictosHorario(EventoDTO nuevoEvento);
    int contarEventos();
}

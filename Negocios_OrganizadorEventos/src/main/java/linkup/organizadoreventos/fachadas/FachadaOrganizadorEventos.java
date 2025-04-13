/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.organizadoreventos.fachadas;

import DTOs.EventoDTO;
import linkup.organizadoreventos.interfaces.IOrganizadorEventos;
import java.time.LocalDateTime;
import java.util.List;
import linkup.objetosnegocio.Evento;
import linkup.organizadoreventos.OrganizadorEventos;

/**
 * Fachada que simplifica el acceso al subsistema de organización de eventos.
 * Oculta la complejidad interna y proporciona una API limpia.
 */
public class FachadaOrganizadorEventos {
    
    private final IOrganizadorEventos organizador;
    
    public FachadaOrganizadorEventos() {
        this.organizador = new OrganizadorEventos();
    }
    
    // Métodos simplificados para el cliente externo
    
    public String crearNuevoEvento(EventoDTO datosEvento) {
        try {
            Evento evento = organizador.crearEvento(datosEvento);
            return "Evento creado: " + evento.getNombreEvento();
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
    
    public List<Evento> obtenerProximosEventos() {
        return organizador.obtenerEventosFuturos();
    }
    
    public boolean verificarDisponibilidad(EventoDTO eventoPropuesto) {
        return !organizador.tieneConflictosHorario(eventoPropuesto);
    }
    
    public void agregarRecordatorio(String idEvento, LocalDateTime fechaRecordatorio) {
        organizador.programarRecordatorio(idEvento, fechaRecordatorio);
    }
    
    public Evento buscarEvento(String idEvento) {
        return organizador.buscarEventoPorId(idEvento);
    }
}

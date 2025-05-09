/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.organizadoreventos.interfaces;

import java.util.List;
import linkup.dtosnegocios.EventoDTO;
import linkup.objetosnegocio.Evento;

/**
 * Interfaz que define las operaciones del subsistema de organización de eventos.
 */
public interface IOrganizadorEventos {
    
    public abstract void agregarEvento(EventoDTO evento);
    
    public abstract EventoDTO consultarEventoPorId(String idExterno);
    
    public abstract List<EventoDTO> consultarEventos();
    
    public abstract EventoDTO validarDetalllesEvento(EventoDTO dto);
    
    public abstract EventoDTO validarFechaHoraEvento(EventoDTO dto);
}

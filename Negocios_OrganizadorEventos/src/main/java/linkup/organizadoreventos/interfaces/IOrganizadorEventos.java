/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.organizadoreventos.interfaces;

import java.util.List;
import linkup.dtosnegocios.EventoDTO;

/**
 * Interfaz que define las operaciones del subsistema de organización de eventos.
 */
public interface IOrganizadorEventos {
    
    public abstract boolean agregarEvento(EventoDTO evento);
    
    public abstract EventoDTO consultarEventoPorId(String idExterno);
    
    public abstract List<EventoDTO> consultarEventos();
}


package linkup.organizadoreventos;

import linkup.dtosnegocios.mapper.EventoMapper;
import linkup.objetosnegocio.Evento;

import java.util.ArrayList;
import java.util.List;
import linkup.dtosnegocios.EventoDTO;
import linkup.organizadoreventos.interfaces.IOrganizadorEventos;

public class OrganizadorEventos implements IOrganizadorEventos {

    private final List<Evento> eventos;

    public OrganizadorEventos() {
        this.eventos = new ArrayList<>();
    }

    @Override
    public boolean agregarEvento(EventoDTO dto) {
        if (dto == null || dto.getIdExterno() == null){
            return false;
        }
        Evento nuevo = EventoMapper.toEntidad(dto);
        return eventos.add(nuevo);
    }

    @Override
    public EventoDTO consultarEventoPorId(String idExterno) {
        for (Evento e : eventos) {
            if (e.getIdExterno().equals(idExterno)) {
                return EventoMapper.toDTO(e);
            }
        }
        return null;
    }

    @Override
    public List<EventoDTO> consultarEventos() {
        List<EventoDTO> lista = new ArrayList<>();
        for (Evento e : eventos) {
            lista.add(EventoMapper.toDTO(e));
        }
        return lista;
    }
}

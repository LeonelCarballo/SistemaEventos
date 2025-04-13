
package linkup.organizadoreventos;

import DTOs.EventoDTO;
import linkup.organizadoreventos.interfaces.IOrganizadorEventos;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import linkup.objetosnegocio.Evento;
import linkup.objetosnegocio.Eventos;

/**
 * Subsistema principal para la organización de eventos.
 * Coordina la validación, creación y gestión de eventos.
 */
public class OrganizadorEventos implements IOrganizadorEventos {
    
    private final Eventos repositorioEventos;
    
    public OrganizadorEventos() {
        this.repositorioEventos = Eventos.getInstancia();
    }
    
    /**
     * Crea y almacena un nuevo evento a partir de un DTO.
     * 
     * @param dto Datos del evento a crear
     * @return Evento creado y validado
     * @throws IllegalArgumentException si los datos son inválidos
     */
    public Evento crearEvento(EventoDTO dto) throws IllegalArgumentException {
        validarDTO(dto);
        
        Evento evento = new Evento(
            dto.getNombreEvento(),
            dto.getEtiqueta(),
            dto.getDescripcion(),
            dto.getFechaHora(),
            dto.getFechaFin(),
            dto.getDireccion(),
            dto.getLatitud(),
            dto.getLongitud()
        );
        
        repositorioEventos.agregarEvento(evento);
        return evento;
    }
    
    /**
     * Valida que los datos del DTO cumplan con los requisitos.
     * 
     * @param dto Datos del evento a validar
     * @throws IllegalArgumentException si algún campo no cumple las reglas
     */
    private void validarDTO(EventoDTO dto) throws IllegalArgumentException {
        if (dto == null) {
            throw new IllegalArgumentException("Los datos del evento no pueden ser nulos");
        }
        
        // Validaciones básicas (las específicas se harán en el constructor de Evento)
        if (dto.getNombreEvento() == null || dto.getNombreEvento().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento es requerido");
        }
        
        if (dto.getFechaHora() == null) {
            throw new IllegalArgumentException("La fecha y hora de inicio son requeridas");
        }
        
        if (dto.getFechaFin() == null) {
            throw new IllegalArgumentException("La fecha de fin es requerida");
        }
    }
    
    /**
     * Obtiene todos los eventos futuros.
     * 
     * @return Lista de eventos pendientes
     */
    public List<Evento> obtenerEventosFuturos() {
        LocalDateTime ahora = LocalDateTime.now();
        return repositorioEventos.obtenerEventos().stream()
            .filter(e -> !e.esEventoPasado())
            .collect(Collectors.toList());
    }
    
    /**
     * Obtiene los eventos que ocurren hoy.
     * 
     * @return Lista de eventos para hoy
     */
    public List<Evento> obtenerEventosDeHoy() {
        return repositorioEventos.obtenerEventos().stream()
            .filter(Evento::esEventoHoy)
            .collect(Collectors.toList());
    }
    
    /**
     * Busca eventos por nombre (búsqueda parcial case-insensitive).
     * 
     * @param nombreFragmento Fragmento del nombre a buscar
     * @return Lista de eventos que coinciden
     */
    public List<Evento> buscarEventosPorNombre(String nombreFragmento) {
        if (nombreFragmento == null || nombreFragmento.trim().isEmpty()) {
            throw new IllegalArgumentException("El término de búsqueda no puede estar vacío");
        }
        
        String busqueda = nombreFragmento.toLowerCase();
        return repositorioEventos.obtenerEventos().stream()
            .filter(e -> e.getNombreEvento().toLowerCase().contains(busqueda))
            .collect(Collectors.toList());
    }
    
    /**
     * Programa un recordatorio para un evento existente.
     * 
     * @param idEvento ID del evento
     * @param fechaRecordatorio Fecha para el recordatorio
     * @throws IllegalArgumentException si el evento no existe o la fecha es inválida
     */
    public void programarRecordatorio(String idEvento, LocalDateTime fechaRecordatorio) {
        Evento evento = buscarEventoPorId(idEvento);
        
        if (fechaRecordatorio.isAfter(evento.getFechaHora())) {
            throw new IllegalArgumentException("El recordatorio no puede ser después del evento");
        }
        
        evento.setRecordatorioActivo(true);
        evento.setFechaRecordatorio(fechaRecordatorio);
    }
    
    /**
     * Busca un evento por su ID.
     * 
     * @param idEvento ID del evento a buscar
     * @return Evento encontrado
     * @throws IllegalArgumentException si no se encuentra el evento
     */
    public Evento buscarEventoPorId(String idEvento) {
        return repositorioEventos.obtenerEventos().stream()
            .filter(e -> e.getIdExterno() != null && e.getIdExterno().equals(idEvento))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Evento no encontrado"));
    }
    
    /**
     * Verifica si hay conflictos de horario para un nuevo evento.
     * 
     * @param nuevoEvento Evento a verificar
     * @return true si hay conflicto, false si no
     */
    public boolean tieneConflictosHorario(EventoDTO nuevoEvento) {
        return repositorioEventos.obtenerEventos().stream()
            .anyMatch(existente -> existeSuperposicion(
                existente.getFechaHora(), existente.getFechaFin(),
                nuevoEvento.getFechaHora(), nuevoEvento.getFechaFin()
            ));
    }
    
    private boolean existeSuperposicion(LocalDateTime inicio1, LocalDateTime fin1,
                                      LocalDateTime inicio2, LocalDateTime fin2) {
        return inicio1.isBefore(fin2) && fin1.isAfter(inicio2);
    }
    
    /**
     * Obtiene la cantidad total de eventos registrados.
     * 
     * @return Número de eventos
     */
    public int contarEventos() {
        return repositorioEventos.obtenerEventos().size();
    }
}

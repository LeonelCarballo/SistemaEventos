
package linkup.objetosnegocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase singleton que actúa como almacén central de eventos creados por el usuario.
 * Encapsula una lista de objetos {@link Evento} y ofrece métodos para agregar y consultar eventos.
 */
public class Eventos {

    // Instancia única de la clase
    private static Eventos instancia;

    // Lista de eventos almacenados
    private final List<Evento> eventos;

    /**
     * Constructor privado para cumplir con el patrón singleton.
     */
    private Eventos() {
        this.eventos = new ArrayList<>();
    }

    /**
     * Obtiene la instancia única de la clase Eventos. Implementación thread-safe.
     * 
     * @return instancia única de Eventos
     */
    public static synchronized Eventos getInstancia() {
        if (instancia == null) {
            instancia = new Eventos();
        }
        return instancia;
    }

    /**
     * Agrega un nuevo evento a la lista.
     *
     * @param evento Evento a agregar
     * @throws IllegalArgumentException si el evento es null o ya existe uno igual
     */
    public synchronized void agregarEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("No se puede agregar un evento nulo.");
        }
        if (eventos.contains(evento)) {
            throw new IllegalArgumentException("Este evento ya ha sido agregado.");
        }
        eventos.add(evento);
    }

    /**
     * Retorna una copia inmutable de la lista de eventos registrados.
     * 
     * @return lista de eventos
     */
    public synchronized List<Evento> obtenerEventos() {
        return Collections.unmodifiableList(new ArrayList<>(eventos));
    }

    /**
     * Limpia todos los eventos del sistema. Útil para pruebas o reinicio de datos.
     */
    public synchronized void limpiarEventos() {
        eventos.clear();
    }

    /**
     * Verifica si existe algún evento en el sistema.
     * 
     * @return true si hay eventos, false si la lista está vacía
     */
    public synchronized boolean hayEventos() {
        return !eventos.isEmpty();
    }
}

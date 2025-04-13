package linkup.objetosnegocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa un calendario que agrupa eventos de un usuario o grupo.
 * Puede estar sincronizado con una API externa (como Google Calendar).
 */
public class Calendario {
    private String id; // Identificador interno
    private String idExterno; // ID de la API externa (opcional)
    private String nombre;
    private TipoCalendario tipo;
    private List<Evento> eventos;

    public Calendario() {
        this.eventos = new ArrayList<>();
    }

    public Calendario(String nombre, TipoCalendario tipo) {
        this();
        setNombre(nombre);
        setTipo(tipo);
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del calendario no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public TipoCalendario getTipo() {
        return tipo;
    }

    public void setTipo(TipoCalendario tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de calendario es requerido.");
        }
        this.tipo = tipo;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void agregarEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("El evento no puede ser nulo.");
        }
        this.eventos.add(evento);
    }

    public void eliminarEvento(Evento evento) {
        this.eventos.remove(evento);
    }

    // Métodos auxiliares

    public boolean contieneEvento(Evento evento) {
        return this.eventos.contains(evento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calendario)) return false;
        Calendario that = (Calendario) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "Calendario{" +
               "nombre='" + nombre + '\'' +
               ", tipo=" + tipo +
               ", eventos=" + eventos.size() +
               '}';
    }
}

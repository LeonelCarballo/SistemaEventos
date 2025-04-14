
package linkup.objetosnegocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calendario {
    private String id;
    private String idExterno;
    private String nombre;
    private TipoCalendario tipo;
    private List<String> idsEventos;

    private final ServicioEventos servicioEventos = ServicioEventos.getInstancia();


    public Calendario() {
        this.idsEventos = new ArrayList<>();
    }

    public Calendario(String nombre, TipoCalendario tipo) {
        this();
        setNombre(nombre);
        setTipo(tipo);
    }

    public void sincronizarConProveedorExterno() {
        if (tipo == TipoCalendario.COMPARTIDO && idExterno != null) {
            List<Evento> nuevosEventos = servicioEventos.obtenerEventos(idExterno);
            this.idsEventos.clear();
            for (Evento e : nuevosEventos) {
                this.idsEventos.add(e.getIdExterno());
            }
        }
    }


    public List<Evento> getEventos() {
        if (idExterno == null) {
            return new ArrayList<>();
        }
        return servicioEventos.obtenerEventos(idExterno);
    }


    public void agregarEvento(Evento evento) {
        if (evento == null || evento.getIdExterno() == null) {
            throw new IllegalArgumentException("Evento no válido.");
        }
        this.idsEventos.add(evento.getIdExterno());
        servicioEventos.agregarEvento(idExterno, evento);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calendario)) return false;
        Calendario that = (Calendario) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
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
                ", eventos=" + idsEventos.size() +
                '}';
    }
}

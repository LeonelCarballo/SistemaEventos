/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio.cu.admInvitacion;

import java.util.Objects;
import linkup.objetosnegocio.Evento;

/**
 *
 * @author santi
 */
public class Invitacion {


    private final String from;          // Quién envió la invitación
    private final Evento evento;        // El evento asociado a la invitación

    public Invitacion(String from, Evento evento) {
        this.from = Objects.requireNonNull(from, "Remitente no puede ser nulo");
        this.evento = Objects.requireNonNull(evento, "Evento no puede ser nulo");
    }

    public String getFrom() {
        return from;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return String.format("Invitacion[from=%s, evento=%s]", from, evento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invitacion)) return false;
        Invitacion that = (Invitacion) o;
        return from.equals(that.from) && evento.equals(that.evento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, evento);
    }
}

    



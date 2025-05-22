package linkup.objetosnegocio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import linkup.dtoinfraestructura.EventoInfraestructuraDTO;
import linkup.infraestructura.Integracion;
import linkup.infraestructura.interfaces.IIntegracion;

public final class ServicioEventos {

    private static ServicioEventos instancia;

    private ServicioEventos() {}

    public static ServicioEventos getInstancia() {
        if (instancia == null) {
            instancia = new ServicioEventos();
        }
        return instancia;
    }

    public boolean puedeCancelarse(Evento evento) {
        Objects.requireNonNull(evento);
        return !evento.getFechaHora().isBefore(LocalDateTime.now().plusHours(2));
    }

    public boolean esEventoPasado(Evento evento) {
        Objects.requireNonNull(evento);
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.isAfter(evento.getFechaFin() != null ? evento.getFechaFin() : evento.getFechaHora());
    }

    public boolean esEventoHoy(Evento evento) {
        Objects.requireNonNull(evento);
        LocalDateTime hoy = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime manana = hoy.plusDays(1);
        LocalDateTime inicio = evento.getFechaHora();
        LocalDateTime fin = evento.getFechaFin();

        return (inicio.isEqual(hoy) || inicio.isAfter(hoy)) && inicio.isBefore(manana)
                || (fin != null && fin.isAfter(hoy) && fin.isBefore(manana));
    }

    public long duracionEnMinutos(Evento evento) {
        Objects.requireNonNull(evento);
        return evento.getFechaFin() != null
                ? Duration.between(evento.getFechaHora(), evento.getFechaFin()).toMinutes()
                : 0;
    }
}


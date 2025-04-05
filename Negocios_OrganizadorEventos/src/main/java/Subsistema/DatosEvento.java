/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import DTOs.ContactoDTO;
import DTOs.EventoDTO;
import ISubsistema.IDatosEvento;
import exception.NegocioException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author jrasc
 */
public class DatosEvento implements IDatosEvento {

    public EventoDTO validarRegistroEvento(EventoDTO evento) throws NegocioException {
        validarNombreEvento(evento);
        validarEtiqueta(evento);
        validarDescripcion(evento);
        validarFechaHora(evento);
        validarUbicacion(evento);
        return evento;
    }


    public void validarNombreEvento(EventoDTO evento) throws NegocioException {
        String nombre = evento.getNombreEvento();
        if (nombre == null || nombre.isBlank()) {
            throw new NegocioException("El nombre del evento no puede estar vacío");
        }
        if (nombre.length() > 100) {
            throw new NegocioException("El nombre del evento es demasiado largo");
        }
    }

    public void validarEtiqueta(EventoDTO evento) throws NegocioException {
        String etiqueta = evento.getEtiqueta();
        if (etiqueta == null || etiqueta.isBlank()) {
            throw new NegocioException("La etiqueta no puede estar vacía");
        }
        if (!etiqueta.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s\\-]+")) {
            throw new NegocioException("La etiqueta contiene caracteres inválidos");
        }
    }

    public void validarDescripcion(EventoDTO evento) throws NegocioException {
        String descripcion = evento.getDescripcion();
        if (descripcion == null || descripcion.isBlank()) {
            throw new NegocioException("La descripción no puede estar vacía");
        }
        if (descripcion.length() > 500) {
            throw new NegocioException("La descripción es demasiado larga");
        }
    }

    public void validarFechaHora(EventoDTO evento) throws NegocioException {
        LocalDateTime fechaHora = evento.getFechaHora();
        if (fechaHora == null) {
            throw new NegocioException("Debes seleccionar fecha y hora");
        }
        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new NegocioException("La fecha del evento no puede ser en el pasado");
        }
    }

    public void validarUbicacion(EventoDTO evento) throws NegocioException {
        String ubicacion = evento.getUbicacion();
        if (ubicacion == null || ubicacion.isBlank()) {
            throw new NegocioException("La ubicación no puede estar vacía");
        }
    }
}

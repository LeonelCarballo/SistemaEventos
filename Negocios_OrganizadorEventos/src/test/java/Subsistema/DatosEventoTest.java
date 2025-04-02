/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Subsistema;

import DTOs.EventoDTO;
import exception.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author gael_
 */

@ExtendWith(MockitoExtension.class)
public class DatosEventoTest {
    
    
    @InjectMocks
    private DatosEvento datosEvento;

    private EventoDTO eventoMock;
    
    @BeforeEach
    public void setUp() {
        eventoMock = mock(EventoDTO.class);
    }

    //nombre incorrecto debe lanzar excepcion
    @Test
    void testvalidarNombreEvento() {
        when(eventoMock.getNombreEvento()).thenReturn("");

        NegocioException exception = assertThrows(NegocioException.class,
            () -> datosEvento.validarRegistroEvento(eventoMock));

        assertEquals("El nombre del evento no puede estar vacío", exception.getMessage());
    }


    //etiqueta vacia, lanza excepcion
    @Test
    void testValidarEtiqueta() {
        when(eventoMock.getNombreEvento()).thenReturn("Peso pluma reunion de fans");
        when(eventoMock.getEtiqueta()).thenReturn("");

        NegocioException exception = assertThrows(NegocioException.class,
            () -> datosEvento.validarRegistroEvento(eventoMock));

        assertEquals("La etiqueta no puede estar vacía", exception.getMessage());
    }

    //lanza excepcion porque la descripcion esta muy larfa
    @Test
    void testValidarDescripcion() {
        String descripcionLarga = "double p records. ".repeat(50);
        when(eventoMock.getNombreEvento()).thenReturn("Cumpleaños de Natanael Cano");
        when(eventoMock.getEtiqueta()).thenReturn("Fiesta");
        when(eventoMock.getDescripcion()).thenReturn(descripcionLarga);

        NegocioException exception = assertThrows(NegocioException.class,
            () -> datosEvento.validarRegistroEvento(eventoMock));

        assertEquals("La descripción es demasiado larga", exception.getMessage());
    }

    //la colaboracion no se hará nunca asi que salta excepcion
    @Test
    void testValidarFechaHora() {
        when(eventoMock.getNombreEvento()).thenReturn("Un Dior");
        when(eventoMock.getEtiqueta()).thenReturn("Lanzamiento");
        when(eventoMock.getDescripcion()).thenReturn("colaboracion peso pluma y fuerza regida");
        when(eventoMock.getFechaHora()).thenReturn(null);

        NegocioException exception = assertThrows(NegocioException.class,
            () -> datosEvento.validarRegistroEvento(eventoMock));

        assertEquals("Debes seleccionar fecha y hora", exception.getMessage());
    }

    //debe lanzar excepcion pq no hay ubicacion
    @Test
    void testValidarUbicacion() {
        when(eventoMock.getNombreEvento()).thenReturn("Los Angeles Winter 25");
        when(eventoMock.getEtiqueta()).thenReturn("Fiesta");
        when(eventoMock.getDescripcion()).thenReturn("Viaje a los angeles en invierno");
        when(eventoMock.getFechaHora()).thenReturn(LocalDateTime.now().plusDays(100));
        when(eventoMock.getUbicacion()).thenReturn("");

        NegocioException exception = assertThrows(NegocioException.class,
            () -> datosEvento.validarRegistroEvento(eventoMock));

        assertEquals("La ubicación no puede estar vacía", exception.getMessage());
    }
    
}

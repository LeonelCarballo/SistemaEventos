/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Subsistema;

import DTOs.ContactoDTO;
import DTOs.EventoCompletoDTO;
import DTOs.EventoDTO;
import DTOs.Infraestructura;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import exception.NegocioException;
import java.util.Collections;
import static org.mockito.Mockito.lenient;

/**
 *
 * @author gael_
 */

@ExtendWith(MockitoExtension.class)
public class GuardarEventoTest {
    
    @InjectMocks
    private GuardarEvento guardarEvento;

    @Mock
    private EventoDTO eventoParcialMock;

    @Mock
    private Infraestructura ubicacionMock;

    @Mock
    private ContactoDTO Jorge;

    @Mock
    private ContactoDTO Ian;
    

    private List<ContactoDTO> listaInvitados;
    
    @BeforeEach
    public void setUp() {
    lenient().when(eventoParcialMock.getNombreEvento()).thenReturn("Conferencia Tech");
    lenient().when(eventoParcialMock.getEtiqueta()).thenReturn("Tecnología");
    lenient().when(eventoParcialMock.getDescripcion()).thenReturn("Evento sobre innovación");
    lenient().when(eventoParcialMock.getFechaHora()).thenReturn(LocalDateTime.now().plusDays(1));

    lenient().when(ubicacionMock.getDireccion()).thenReturn("Av. Siempre Viva 123");
    listaInvitados = Arrays.asList(Jorge, Ian);
    }

    //datos correctos, se construye el evento
    @Test
    public void testConstruirEventoCompleto() throws NegocioException {

        EventoCompletoDTO resultado = guardarEvento.construirEventoCompleto(
                eventoParcialMock, 
                ubicacionMock, 
                listaInvitados
        );

        assertNotNull(resultado);
        assertEquals("Conferencia Tech", resultado.getNombreEvento());
        assertEquals("Tecnología", resultado.getEtiqueta());
        assertEquals("Evento sobre innovación", resultado.getDescripcion());
        assertEquals("Av. Siempre Viva 123", resultado.getUbicacion());
        assertEquals(2, resultado.getInvitados().size());
    }

    @Test
    void persistirEventoDTO_EventoValido_GuardaCorrectamente() throws NegocioException {

        EventoCompletoDTO eventoCompleto = new EventoCompletoDTO(
                "Conferencia Sech",
                "Tecnología",
                "Evento sobre conocimiento",
                LocalDateTime.now().plusDays(3),
                "Av. Reforma 222",
                listaInvitados
        );


        guardarEvento.persistirEventoDTO(eventoCompleto);


        assertEquals(1, guardarEvento.getEventosGuardados().size());
        assertEquals("Conferencia Sech", guardarEvento.getEventosGuardados().get(0).getNombreEvento());
    }
    
    //si le falta un dato salta excepcion
    @Test
    public void testPersistirEventoDTO() {
        EventoCompletoDTO eventoCompleto = new EventoCompletoDTO(
            null,
            null,
            null,
            LocalDateTime.now().plusDays(1),
            "Av. Siempre Viva 123",
            listaInvitados 
        );

        assertThrows(NegocioException.class, () -> {
            guardarEvento.persistirEventoDTO(eventoCompleto);
        });
    }   

 
    
}

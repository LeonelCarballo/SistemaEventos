/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Subsistema;

import DTOs.Infraestructura;
import ISubsistema.IGestorUbicaciones;
import exception.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author gael_
 */

@ExtendWith(MockitoExtension.class)
public class GestorUbicacionesTest {

    private IGestorUbicaciones gestor;
    
    @Mock
    private Infraestructura imock;
    

    
    @BeforeEach
    public void setUp() {
        imock = mock(Infraestructura.class);
        gestor = new GestorUbicaciones();
    }

    @Test
    public void testValidarUbicacionCorrecta() throws Exception {
        when(imock.getDireccion()).thenReturn("Av. Principal 123");
        when(imock.getLatitud()).thenReturn(19.4326);
        when(imock.getLongitud()).thenReturn(-99.1332);
        when(imock.getZonaHoraria()).thenReturn("America/Mexico_City");
        
        Infraestructura resultado = gestor.validarUbicacion(imock);
        
        verify(imock).getDireccion();
        verify(imock).getLatitud();
        verify(imock).getLongitud();
        verify(imock).getZonaHoraria();
        
        
    }
    
    @Test
    void testValidarUbicacionDireccionIncorrecta() {
        when(imock.getDireccion()).thenReturn(""); // Dirección vacía

        NegocioException exception = assertThrows(NegocioException.class, 
            () -> gestor.validarUbicacion(imock));

        assertEquals("La dirección no puede estar vacía.", exception.getMessage());
    }



    @Test
    public void testValidarZonaHorariaIncorrecta() throws Exception {
        when(imock.getDireccion()).thenReturn("Av. Principal 123");
        when(imock.getLatitud()).thenReturn(19.4326);
        when(imock.getLongitud()).thenReturn(-99.1332);
        when(imock.getZonaHoraria()).thenReturn("buenas tardes"); // Formato incorrecto

        NegocioException exception = assertThrows(NegocioException.class, 
            () -> gestor.validarUbicacion(imock));

        assertEquals("La zona horaria no tiene un formato válido.", exception.getMessage());
    }
    
}

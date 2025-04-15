/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Subsistema;

import linkup.dtosnegocios.ContactoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import exception.NegocioException;

/**
 *
 * @author gael_
 */

//@ExtendWith(MockitoExtension.class)
//public class GestorContactosTest {
//    
//    @InjectMocks
//    private GestorContactos gestorContactos;
//
//    private ContactoDTO contactoMock;
//    
//    @BeforeEach
//    public void setUp() {
//        contactoMock = mock(ContactoDTO.class);
//    }
//
//    //NO DEBE LANZAR EXEPCION
//    @Test
//    void validarContactoDatosCorrectosNoLanzaExcepcion() throws NegocioException {
//        when(contactoMock.getNombre()).thenReturn("Juan Pérez");
//        when(contactoMock.getCorreoElectronico()).thenReturn("juan@example.com");
//        when(contactoMock.getTelefono()).thenReturn("5512345678");
//
//        assertDoesNotThrow(() -> gestorContactos.validarContacto(contactoMock));
//        ContactoDTO resultado = gestorContactos.validarContacto(contactoMock);
//        assertSame(contactoMock, resultado);
//    }
//
//    //DEBE LANZAR EXEPCION
//    @Test
//    public void testValidarNombre() throws Exception {
//        when(contactoMock.getNombre()).thenReturn("");
//        NegocioException exception = assertThrows(NegocioException.class, () -> gestorContactos.validarContacto(contactoMock));
//
//        assertEquals("El nombre del contacto no puede estar vacío.", exception.getMessage());
//    }
//
//    //Lanza excepcion
//    @Test
//    public void testValidarNombreBienLargo() throws Exception {
//        String nombreLargo = "Taumatawhakatangihangakoauauotamateaturipukakapikimaungahoronukupokaiwhenuakitanatahu";
//        when(contactoMock.getNombre()).thenReturn(nombreLargo);
//
//        NegocioException exception = assertThrows(NegocioException.class,
//            () -> gestorContactos.validarContacto(contactoMock));
//
//        assertEquals("El nombre es demasiado largo.", exception.getMessage());
//    }
//
//    
//    @Test
//    void testvalidarTelefonoLanzaExcepcion() {
//        when(contactoMock.getNombre()).thenReturn("Nombre Válido");
//        when(contactoMock.getCorreoElectronico()).thenReturn("correo@valido.com");
//        when(contactoMock.getTelefono()).thenReturn("551234567A"); //una letra
//
//        NegocioException exception = assertThrows(NegocioException.class,
//            () -> gestorContactos.validarContacto(contactoMock));
//
//        assertEquals("El número telefónico debe contener exactamente 10 dígitos.", exception.getMessage());
//    }
//    
//}

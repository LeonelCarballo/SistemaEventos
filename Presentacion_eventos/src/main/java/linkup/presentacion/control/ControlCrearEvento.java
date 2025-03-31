/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion;

import DTOs.ContactoDTO;
import DTOs.EventoCompletoDTO;
import DTOs.EventoDTO;
import DTOs.Infraestructura;
import ISubsistema.IDatosEvento;
import ISubsistema.IGestorContactos;
import ISubsistema.IGestorUbicaciones;
import ISubsistema.IGuardarEvento;
import Subsistema.DatosEvento;
import Subsistema.GestorContactos;
import Subsistema.GestorUbicaciones;
import Subsistema.GuardarEvento;
import exception.NegocioException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author leoca
 */
public class ControlCrearEvento {

    private static ControlCrearEvento instancia;

    private static IDatosEvento validadorEvento = new DatosEvento();
    private static IGestorUbicaciones gestorUbicaciones = new GestorUbicaciones();
    private static IGestorContactos gestorContactos = new GestorContactos();
    private static IGuardarEvento guardarEventoDTO = new GuardarEvento();

    private EventoDTO eventoDTO;
    private Infraestructura ubicacionSeleccionada;
    private List<ContactoDTO> contactosSeleccionados;

    private VentanaPrincipalCrearEvento frmPrincipal;
    private IngresarDetallesEvento frmDetalles;
    private SeleccionarFechaHora frmFechaHora;
    private SeleccionarUbicacion frmUbicacion;
    private EnviarInvitaciones frmInvitaciones;
    private ConfirmacionEvento frmConfirmacion;

    private ControlCrearEvento() {
    }

    public static ControlCrearEvento getInstancia() {
        if (instancia == null) {
            instancia = new ControlCrearEvento();
        }
        return instancia;
    }

    public void iniciarFlujoCreacionEvento() {
        mostrarFormularioDetalles();
    }

    public void mostrarVentanaPrincipal() {
        if (frmPrincipal == null) {
            frmPrincipal = new VentanaPrincipalCrearEvento(this);
        }
        frmPrincipal.setVisible(true);
    }

    public void mostrarFormularioDetalles() {
        if (frmDetalles == null) {
            frmDetalles = new IngresarDetallesEvento(this);
        }
        frmDetalles.setVisible(true);
    }

    public void mostrarSeleccionFechaHora() {
        if (frmFechaHora == null) {
            frmFechaHora = new SeleccionarFechaHora(this);
        }
        frmFechaHora.setVisible(true);
    }

    public void mostrarSeleccionarUbicacion() {
        if (frmUbicacion == null) {
            frmUbicacion = new SeleccionarUbicacion(this);
        }
        frmUbicacion.setVisible(true);
    }

    public void mostrarEnviarInvitaciones() {
        if (frmInvitaciones == null) {
            frmInvitaciones = new EnviarInvitaciones(this);
        }
        frmInvitaciones.setVisible(true);
    }

    public void mostrarConfirmacionEvento() {
        if (frmConfirmacion == null) {
            frmConfirmacion = new ConfirmacionEvento(this);
        }
        frmConfirmacion.setVisible(true);
    }

    public EventoDTO intentarCrearEvento(EventoDTO evento) {
        try {
            this.eventoDTO = validadorEvento.validarRegistroEvento(evento);
            cerrarVentana(frmDetalles);
            mostrarSeleccionFechaHora();
            return eventoDTO;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    public Infraestructura intentarRegistrarUbicacion(Infraestructura ubicacion) {
        try {
            this.ubicacionSeleccionada = gestorUbicaciones.validarUbicacion(ubicacion);
            cerrarVentana(frmUbicacion);
            mostrarEnviarInvitaciones();
            return ubicacionSeleccionada;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    public List<ContactoDTO> intentarValidarContactos(List<ContactoDTO> contactos) {
        try {
            for (ContactoDTO c : contactos) {
                gestorContactos.validarContacto(c);
            }
            this.contactosSeleccionados = contactos;
            cerrarVentana(frmInvitaciones);
            mostrarConfirmacionEvento();
            return contactosSeleccionados;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    public void confirmarYGuardarEvento() {
        try {
            EventoCompletoDTO eventoCompleto = new EventoCompletoDTO(
                    eventoDTO.getNombreEvento(),
                    eventoDTO.getEtiqueta(),
                    eventoDTO.getDescripcion(),
                    eventoDTO.getFechaHora(),
                    ubicacionSeleccionada.getDireccion(),
                    contactosSeleccionados
            );
            guardarEventoDTO.persistirEventoDTO(eventoCompleto);
            JOptionPane.showMessageDialog(null, "Evento creado");
            cerrarVentana(frmConfirmacion);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al guardar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cerrarVentana(javax.swing.JFrame ventana) {
        if (ventana != null) {
            ventana.dispose();
        }
    }

    public EventoDTO getEventoDTO() {
        return eventoDTO;
    }

    public Infraestructura getUbicacionSeleccionada() {
        return ubicacionSeleccionada;
    }

    public List<ContactoDTO> getContactosSeleccionados() {
        return contactosSeleccionados;
    }
}

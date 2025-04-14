/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import linkup.dtosnegocios.ContactoDTO;
import linkup.dtosnegocios.EventoCompletoDTO;
import linkup.dtosnegocios.EventoDTO;
import linkup.dtosnegocios.Infraestructura;
import ISubsistema.IGestorContactos;
import ISubsistema.IGestorUbicaciones;
import Subsistema.GestorContactos;
import Subsistema.GestorUbicaciones;
import exception.NegocioException;
import java.util.List;
import javax.swing.JOptionPane;
import linkup.organizadoreventos.OrganizadorEventos;
import linkup.organizadoreventos.interfaces.IOrganizadorEventos;
import linkup.presentacion.ConfirmacionEvento;
import linkup.presentacion.EnviarInvitaciones;
import linkup.presentacion.IngresarDetallesEvento;
import linkup.presentacion.SeleccionarFechaHora;
import linkup.presentacion.SeleccionarUbicacion;
import linkup.presentacion.VentanaPrincipalCrearEvento;

/**
 *
 * @author leoca
 */
public class ControlCrearEvento {

    private static ControlCrearEvento instancia;

    private static IOrganizadorEventos validadorEvento = new OrganizadorEventos();
    private static IGestorUbicaciones gestorUbicaciones = new GestorUbicaciones();
    private static IGestorContactos gestorContactos = new GestorContactos();
    private static IOrganizadorEventos guardarEventoDTO = new OrganizadorEventos();

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

    public void mostrarSeleccionFechaHora(EventoDTO eventoDTO) {
        if (frmFechaHora == null) {
            frmFechaHora = new SeleccionarFechaHora(this , eventoDTO);
        }
        frmFechaHora.setVisible(true);
    }

    public void mostrarSeleccionarUbicacion(EventoDTO evento) {
        if (frmUbicacion == null) {
            frmUbicacion = new SeleccionarUbicacion(this, evento);
        }
        frmUbicacion.setVisible(true);
    }

    public void mostrarEnviarInvitaciones(EventoDTO eventoDTO) {
        if (frmInvitaciones == null) {
            frmInvitaciones = new EnviarInvitaciones(this, eventoDTO);
        }
        frmInvitaciones.setVisible(true);
    }

    public void mostrarConfirmacionEvento(EventoDTO eventoDTO) {
        if (frmConfirmacion == null) {
            frmConfirmacion = new ConfirmacionEvento(this, eventoDTO);
        }
        frmConfirmacion.setVisible(true);
    }

    public EventoDTO intentarCrearEvento(EventoDTO evento) {
        try {
            this.eventoDTO = validadorEvento.validarRegistroEvento(evento);
            cerrarVentana(frmDetalles);
            mostrarSeleccionFechaHora(evento);
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
            //mostrarEnviarInvitaciones();
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
            mostrarConfirmacionEvento(eventoDTO);
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
                    eventoDTO.getUbicacion(),
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
    
    public List<ContactoDTO> ObtenerContactos() {
        return gestorContactos.ObtenerContactos();
    }
}

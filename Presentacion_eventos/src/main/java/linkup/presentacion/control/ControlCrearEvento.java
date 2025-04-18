/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import linkup.dtosnegocios.ContactoDTO;
import linkup.dtosnegocios.EventoCompletoDTO;
import linkup.dtosnegocios.EventoDTO;
import linkup.infraestructura.mapa.InfraestructuraMapa;
import linkup.infraestructura.mapa.Location;
import ISubsistema.IGestorContactos;
import ISubsistema.IGestorUbicaciones;
import Subsistema.GestorContactos;
import Subsistema.GestorUbicaciones;
import exception.NegocioException;
import java.util.List;
import javax.swing.JOptionPane;
import linkup.objetosnegocio.Evento;
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

    private static InfraestructuraMapa mapService = new InfraestructuraMapa();
    private static IOrganizadorEventos validadorEvento = new OrganizadorEventos();
    private static IGestorUbicaciones gestorUbicaciones = new GestorUbicaciones(mapService);
    private static IGestorContactos gestorContactos = new GestorContactos();
    private static IOrganizadorEventos guardarEventoDTO = new OrganizadorEventos();

    private EventoDTO eventoDTO;
    private List<EventoDTO> eventos;
//    private final List<Evento> listaEventos;
    
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
        mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal() {

            frmPrincipal = new VentanaPrincipalCrearEvento(this, eventos);

        frmPrincipal.setVisible(true);
    }
    
    public void mostrarVentanaPrincipalAlCrear(List<EventoDTO> eventos) {
        this.eventos = eventos;

            frmPrincipal = new VentanaPrincipalCrearEvento(this, eventos);
        
        frmPrincipal.setVisible(true);
    }

    public void mostrarFormularioDetalles() {

            frmDetalles = new IngresarDetallesEvento(this, eventoDTO);

        frmDetalles.setVisible(true);
    }

    public void mostrarSeleccionFechaHora(EventoDTO eventoDTO) {

            frmFechaHora = new SeleccionarFechaHora(this , eventoDTO);

        frmFechaHora.setVisible(true);
    }

    public void mostrarSeleccionarUbicacion(EventoDTO evento) {
            frmUbicacion = new SeleccionarUbicacion(this, evento);

        frmUbicacion.setVisible(true);
    }

    public void mostrarEnviarInvitaciones(EventoDTO eventoDTO) {

            frmInvitaciones = new EnviarInvitaciones(this, eventoDTO);

        frmInvitaciones.setVisible(true);
    }

    public void mostrarConfirmacionEvento(EventoDTO eventoDTO) {

            frmConfirmacion = new ConfirmacionEvento(this, eventoDTO, validadorEvento);

        frmConfirmacion.setVisible(true);
    }

    public void intentarCrearEvento(EventoDTO evento) {
        validadorEvento.agregarEvento(evento);
        cerrarVentana(frmDetalles);
        mostrarSeleccionFechaHora(evento);
    }

//    public Infraestructura intentarRegistrarUbicacion(Infraestructura ubicacion) {
//        try {
//            this.ubicacionSeleccionada = gestorUbicaciones.(ubicacion);
//            cerrarVentana(frmUbicacion);
//            mostrarEnviarInvitaciones();
//            return ubicacionSeleccionada;
//        } catch (NegocioException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
//            return null;
//        }
//    }

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

//    public void confirmarYGuardarEvento() {
//        try {
//            EventoCompletoDTO eventoCompleto = new EventoCompletoDTO(
//                    eventoDTO.getNombreEvento(),
//                    eventoDTO.getEtiqueta(),
//                    eventoDTO.getDescripcion(),
//                    eventoDTO.getFechaHora(),
//                    eventoDTO.getDireccion(),
//                    contactosSeleccionados
//            );
//            guardarEventoDTO.agregarEvento(eventoCompleto);
//            JOptionPane.showMessageDialog(null, "Evento creado");
//            cerrarVentana(frmConfirmacion);
//        } catch (NegocioException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al guardar", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }

    public void cerrarVentana(javax.swing.JFrame ventana) {
        if (ventana != null) {
            ventana.dispose();
        }
    }

    public EventoDTO getEventoDTO() {
        return eventoDTO;
    }

//    public Infraestructura getUbicacionSeleccionada() {
//        return ubicacionSeleccionada;
//    }

    public List<ContactoDTO> getContactosSeleccionados() {
        return contactosSeleccionados;
    }
    
    public List<ContactoDTO> ObtenerContactos() {
        return gestorContactos.ObtenerContactos();
    }
}

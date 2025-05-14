/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import linkup.dtosnegocios.ContactoDTO;
import linkup.dtosnegocios.EventoCompletoDTO;
import linkup.dtosnegocios.EventoDTO;
import ISubsistema.IGestorContactos;
import ISubsistema.IGestorUbicaciones;
import Subsistema.GestorContactos;
import Subsistema.GestorUbicaciones;
import exception.NegocioException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import linkup.dtosnegocios.mapper.EventoMapper;
import linkup.objetosnegocio.Evento;
import linkup.organizadoreventos.OrganizadorEventos;
import linkup.organizadoreventos.interfaces.IOrganizadorEventos;
import linkup.presentacion.ConfirmacionEvento;
import linkup.presentacion.EnviarInvitaciones;
import linkup.presentacion.IngresarDetallesEvento;
import linkup.presentacion.IniciarSesion;
import linkup.presentacion.RegistrarUsuario;
import linkup.presentacion.SeleccionarFechaHora;
import linkup.presentacion.SeleccionarUbicacion;
import linkup.presentacion.VentanaPrincipalCrearEvento;

/**
 *
 * @author leoca
 */
public class ControlCrearEvento {

    private static ControlCrearEvento instancia;

    
    private static IOrganizadorEventos validadorEvento = new OrganizadorEventos("1");
    private static IGestorUbicaciones gestorUbicaciones = new GestorUbicaciones();
    private static IGestorContactos gestorContactos = new GestorContactos();
    private static IOrganizadorEventos guardarEventoDTO = new OrganizadorEventos("1");

    private EventoDTO eventoDTO;
    private List<EventoDTO> eventos;
    private static String idCalendario = "1";
//    private final List<Evento> listaEventos;

    private List<ContactoDTO> contactosSeleccionados;

    private VentanaPrincipalCrearEvento frmPrincipal;
    private IngresarDetallesEvento frmDetalles;
    private SeleccionarFechaHora frmFechaHora;
    private SeleccionarUbicacion frmUbicacion;
    private EnviarInvitaciones frmInvitaciones;
    private ConfirmacionEvento frmConfirmacion;
    
    private IniciarSesion frmIniciarSesion;
    private RegistrarUsuario frmRegistrarUsuario;  
    
    private ControlIniciarSesion controlIS = new ControlIniciarSesion();

    private ControlCrearEvento() {
    }

    public static ControlCrearEvento getInstancia() {
        if (instancia == null) {
            instancia = new ControlCrearEvento();
        }
        return instancia;
    }

    public void iniciarFlujoCreacionEvento() {
        mostrarInicioSesion();
    }

    public void mostrarVentanaPrincipal() {

        frmPrincipal = new VentanaPrincipalCrearEvento(this, eventos);

        frmPrincipal.setVisible(true);
    }
    
    public void mostrarInicioSesion() {
        IniciarSesion frmIniciarSesion = new IniciarSesion(controlIS);
        frmIniciarSesion.setVisible(true);
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

        frmFechaHora = new SeleccionarFechaHora(this, eventoDTO);

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

        EventoDTO validado = validadorEvento.validarEventoCompleto(evento);

        if(validado.getIdExterno() == null) {
            validado.setIdExterno(EventoMapper.generarNuevoId());
        }

        this.eventoDTO = validado;
        validadorEvento.agregarEvento(validado);

        cerrarVentana(frmDetalles);
        mostrarSeleccionFechaHora(validado);
    }

//    public Infraestructura RegistrarUbicacion(Infraestructura ubicacion) {
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

    public EventoDTO validarDetallesEventoDTO(EventoDTO evento) {
        return validadorEvento.validarDetallesEvento(evento);
    }

    public EventoDTO validarFechaHoraEventoDTO(EventoDTO evento) {
        return validadorEvento.validarFechaHoraEvento(evento);
    }

    public EventoDTO validarUbicacionEventoDTO(EventoDTO evento) {
        return gestorUbicaciones.validarUbicacionEvento(evento);
    }
    
    public void showMapa(JPanel destino){
        gestorUbicaciones.mostrarMapa(destino);
    }
    
    public Map<String, Double> obtenerUbicacion(){
        return gestorUbicaciones.getUbicacionSeleccionada();
    }
    
    
}

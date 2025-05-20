/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import ISubsistema.IGestorContactos;
import Subsistema.GestorContactos;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import linkup.dtosnegocios.ContactoDTO;
import linkup.objetosnegocio.UsuarioON;
import linkup.presentacion.enviarinvitaciones.ResumenParticipantes;
import linkup.presentacion.enviarinvitaciones.SeleccionarParticipantes;

public class ControlEnviarInvitaciones {

    private List<String> seleccionados;
    private SeleccionarParticipantes ventanaSeleccion;
    private ResumenParticipantes ventanaResumen;
    private ControlCrearEvento controlPadre;
    private IGestorContactos gestorContactos = new GestorContactos();
    private ControlIniciarSesion controlIniciarSesion;
    
    public ControlEnviarInvitaciones(ControlCrearEvento controlPadre, ControlIniciarSesion controlIniciarSesion) {
        this.controlPadre = controlPadre;
        this.controlIniciarSesion = controlIniciarSesion;
        seleccionados = new ArrayList<>();
        ventanaSeleccion = new SeleccionarParticipantes(this);
        ventanaResumen = new ResumenParticipantes(this);
    }

    public void iniciarFlujo() {
        ventanaSeleccion.setVisible(true);
    }

    public void agregarParticipante(String contacto) {
        if (!seleccionados.contains(contacto)) {
            seleccionados.add(contacto);
        }
    }

    public void quitarParticipante(String contacto) {
        seleccionados.remove(contacto);
    }

    public List<String> getSeleccionados() {
        return new ArrayList<>(seleccionados);
    }

    public void mostrarResumen() {
        ventanaSeleccion.setVisible(false);
        ventanaResumen.actualizarLista(seleccionados); 
        ventanaResumen.setVisible(true);
    }

    public void regresarASeleccion() {
        ventanaResumen.setVisible(false);
        ventanaSeleccion.setVisible(true);
    }
    
    public void confirmarSeleccion() {
        String username = UsuarioON.getInstance().getUsername();

        List<ContactoDTO> contactosDTO = seleccionados.stream()
            .map(nombre -> new ContactoDTO(nombre, username))
            .collect(Collectors.toList());

        controlPadre.intentarValidarContactos(contactosDTO);
    }
    
    public boolean estaSeleccionado(String contacto) {
        return seleccionados.contains(contacto);
    }
    
        public List<ContactoDTO> obtenerContactos() {
            String username = controlIniciarSesion.getUsuarioActual().getUsername();
            return gestorContactos.ObtenerContactos(username);
        }

}


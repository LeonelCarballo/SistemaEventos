/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion.control;

import ISubsistema.IAdministrarGrupo;
import Subsistema.AdministrarGrupo;
import exception.NegocioException;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import linkup.dtosnegocios.cu.admgrupo.GrupoDTO;
import linkup.dtosnegocios.cu.admgrupo.GrupoMapper;
import linkup.dtosnegocios.cu.admgrupo.MensajeMapper;
import linkup.dtosnegocios.cu.admgrupo.NuevoMensajeDTO;
import linkup.dtosnegocios.cu.admgrupo.UsuariosMock;
import linkup.objetosnegocio.cu.admgrupo.Grupo;
import linkup.objetosnegocio.cu.admgrupo.Mensaje;
import linkup.objetosnegocio.cu.admgrupo.UsuarioAG;
import linkup.presentacion.cu.admGrupo.frmCrearGrupo;
import linkup.presentacion.cu.admGrupo.frmGruposPrincipal;
import linkup.presentacion.cu.admGrupo.frmOpcionesGrupo;
import linkup.presentacion.cu.admGrupo.frmVerGrupo;

/**
 *
 * @author gael_
 */
public class ControlAdministrarGrupo {
    private static ControlAdministrarGrupo instancia;
    private static IAdministrarGrupo administradorGrupos = new AdministrarGrupo(); 
    
    private frmGruposPrincipal gruposPrincipal;
    private frmVerGrupo verGrupo;
    private frmOpcionesGrupo opcionesGrupo;
    private frmCrearGrupo crearGrupo;
     
    private List<Grupo> grupos;
    private List<UsuarioAG> usuariosDisponibles;
    
    public ControlAdministrarGrupo() {
        this.grupos = new ArrayList<>();
        this.usuariosDisponibles = new UsuariosMock().obtenerTodosLosUsuarios();
    }
    
    public void registrarGrupo(GrupoDTO grupoDTO) {
        Grupo grupo = GrupoMapper.toEntidad(grupoDTO, usuariosDisponibles);
        grupos.add(grupo);
        System.out.println("Grupo creado: " + grupo.getNombre());
    }
    
    public void registrarMensaje(Grupo grupo, NuevoMensajeDTO nuevoMensaje){
        Mensaje mensaje = MensajeMapper.toEntidad(nuevoMensaje);
        grupo.getMensajes().add(mensaje);
    }

    public List<Grupo> obtenerGrupos() {
        return grupos;
    }

    public List<UsuarioAG> getUsuariosDisponibles() {
        return usuariosDisponibles;
    }
    
    public Grupo obtenerGrupoPorNombre(String nombre) {
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equals(nombre)) {
                return grupo;
            }
        }
        return null;
    }
     
    public void eliminarUsuario(Grupo grupo, UsuarioAG usuario){
        administradorGrupos.eliminarUsuarioDeGrupo(grupo, usuario);
    } 
    
    public void eliminarGrupo(Grupo grupo) {
        administradorGrupos.eliminarGrupo(grupo, this.grupos);
    }

    public void cambiarNombreGrupo(Grupo grupo, String nuevoNombre) throws NegocioException {
         for (Grupo g : obtenerGrupos()) {
            if (!g.equals(grupo) && g.getNombre().equalsIgnoreCase(nuevoNombre)) {
                JOptionPane.showMessageDialog(null, "Ya existe un grupo con ese nombre.");
            return;
            }
        }
        administradorGrupos.cambiarNombreGrupo(grupo, nuevoNombre);
    }
    
    
    public static ControlAdministrarGrupo getInstancia(){
        if(instancia == null){
            instancia = new ControlAdministrarGrupo();
        }
        return instancia;
    }
    
    public void iniciarFlujoGrupos(){
        mostrarVentanaPrincipalGrupos();
    }
    
    public void mostrarVentanaPrincipalGrupos(){
        gruposPrincipal = new frmGruposPrincipal(this);
        gruposPrincipal.setVisible(true);
    }
    
    public void crearGrupo(){
        crearGrupo = new frmCrearGrupo(this);
        crearGrupo.setVisible(true);
    }
    
    public void accederGrupo(Grupo grupo) {
        frmVerGrupo verGrupo = new frmVerGrupo(this, grupo);
        verGrupo.setVisible(true);
    }

    
    public void verOpcionesGrupo(Grupo grupo){
        opcionesGrupo = new frmOpcionesGrupo(this, grupo);
        opcionesGrupo.setVisible(true); 
    }
    
}

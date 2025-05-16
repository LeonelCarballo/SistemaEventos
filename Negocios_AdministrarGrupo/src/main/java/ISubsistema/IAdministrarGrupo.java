/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistema;

import exception.NegocioException;
import java.util.List;
import linkup.objetosnegocio.UsuarioON;
import linkup.objetosnegocio.cu.admgrupo.Grupo;
import linkup.objetosnegocio.cu.admgrupo.UsuarioAG;

/**
 *
 * @author gael_
 */
public interface IAdministrarGrupo {
    public abstract void eliminarUsuarioDeGrupo(Grupo grupo, UsuarioON usuario );
    public abstract void eliminarGrupo(Grupo grupo, List<Grupo> grupos);
    public abstract void cambiarNombreGrupo(Grupo grupo, String nuevoNombre) throws NegocioException;
}

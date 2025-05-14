/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import ISubsistema.IAdministrarGrupo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import linkup.exception.NegocioException;
import linkup.objetosnegocio.cu.admgrupo.Grupo;
import linkup.objetosnegocio.cu.admgrupo.UsuarioAG;

/**
 *
 * @author gael_
 */
public class AdministrarGrupo implements IAdministrarGrupo {
    
    @Override
    public void eliminarUsuarioDeGrupo(Grupo grupo, UsuarioAG usuario ){
        grupo.getMiembros().remove(usuario);
    }

    @Override
    public void eliminarGrupo(Grupo grupo, List<Grupo> grupos) {
        grupos.remove(grupo);
    }
    
    @Override
    public void cambiarNombreGrupo(Grupo grupo, String nuevoNombre) throws NegocioException {
        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            throw new NegocioException("El nombre no puede estar vacío.");
        }

        nuevoNombre = nuevoNombre.trim();
        
        Pattern pattern = Pattern.compile("^.{0,30}$");
        Matcher matcher = pattern.matcher(nuevoNombre);

        if (!matcher.matches()) {
            throw new NegocioException("El nombre no puede tener más de 30 caracteres.");
        }

        grupo.setNombre(nuevoNombre);
    }
}

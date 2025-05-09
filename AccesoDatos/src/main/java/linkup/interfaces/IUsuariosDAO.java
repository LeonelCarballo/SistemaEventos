/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linkup.interfaces;

import DTOs.NuevoUsuarioDTO;
import linkup.entidades.Usuario;

/**
 *
 * @author gael_
 */
public interface IUsuariosDAO {
    public abstract Usuario registrarUsuario(NuevoUsuarioDTO nuevoUsuario);
}

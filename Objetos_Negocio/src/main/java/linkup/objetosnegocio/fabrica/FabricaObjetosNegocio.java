/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.objetosnegocio.fabrica;

import linkup.implementaciones.UsuariosDAO;
import linkup.interfaces.IUsuariosDAO;
import linkup.objetosnegocio.UsuarioON;

/**
 *
 * @author gael_
 */
public class FabricaObjetosNegocio {
    public static UsuarioON crearUsuarioON() {
        return new UsuarioON(new UsuariosDAO());
    }
}

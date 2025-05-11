/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import implementaciones.UsuariosBO;
import interfaz.IUsuariosBO;
import linkup.implementaciones.UsuariosDAO;
import linkup.interfaces.IUsuariosDAO;

/**
 *
 * @author gael_
 */
public class FabricaObjetosNegocio {
    
    public static IUsuariosBO crearUsuariosBO(){
        IUsuariosDAO usuariosDAO = new UsuariosDAO();
        return new UsuariosBO(usuariosDAO);
    }
}

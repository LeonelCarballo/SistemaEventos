/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtosnegocios.cu.admgrupo;

import java.util.List;
import linkup.objetosnegocio.cu.admgrupo.UsuarioAG;

/**
 *
 * @author gael_
 */
public class UsuariosMock {
    private List<UsuarioAG> usuariosMock;

    public UsuariosMock() {
        // Simulación de usuarios hardcodeados
        usuariosMock = List.of(
            new UsuarioAG("Ana", "ana@email.com", "123"),
            new UsuarioAG("Luis", "luis@email.com", "abc"),
            new UsuarioAG("Karla", "karla@email.com", "pass"),
            new UsuarioAG("Pablo", "pablo@email.com", "clave")
        );
    }
        
    public List<UsuarioAG> obtenerTodosLosUsuarios() {
        return usuariosMock;
    }

    public void mostrarUsuarios() {
        System.out.println("Usuarios registrados:");
        for (UsuarioAG u : usuariosMock) {
            System.out.println("- " + u.getNombre() + " (" + u.getEmail() + ")");
        }
    }

    public UsuarioAG buscarPorEmail(String email) {
        for (UsuarioAG u : usuariosMock) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }    
}

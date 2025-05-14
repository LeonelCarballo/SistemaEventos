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
            new UsuarioAG("Pablo", "pablo@email.com", "clave"),
            new UsuarioAG("Sofía", "sofia@email.com", "qwerty"),
            new UsuarioAG("Diego", "diego@email.com", "asd123"),
            new UsuarioAG("Fernanda", "fer@email.com", "pass123"),
            new UsuarioAG("Andrés", "andres@email.com", "andres1"),
            new UsuarioAG("Valeria", "valeria@email.com", "val123"),
            new UsuarioAG("Carlos", "carlos@email.com", "clave123"),
            new UsuarioAG("Mariana", "mariana@email.com", "mari456"),
            new UsuarioAG("Javier", "javier@email.com", "jav789")
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

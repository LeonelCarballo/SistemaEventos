/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.implementaciones;

import DTOs.NuevoUsuarioDTO;
import javax.persistence.EntityManager;
import linkup.entidades.Usuario;
import linkup.interfaces.IUsuariosDAO;

/**
 *
 * @author gael_
 */
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public Usuario registrarUsuario(NuevoUsuarioDTO nuevoUsuario) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        entityManager.getTransaction().begin();
        Usuario usuario = new Usuario();
        usuario.setUsername(nuevoUsuario.getUsername());
        usuario.setContrasenia(nuevoUsuario.getContrasenia());
        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setApellido(nuevoUsuario.getApellido());
        
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        
        return usuario;
    }
    
}

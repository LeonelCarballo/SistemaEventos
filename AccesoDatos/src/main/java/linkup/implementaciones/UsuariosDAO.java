/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.implementaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import linkup.dtosnegocios.NuevoUsuarioDTO;
import linkup.dtosnegocios.UsuarioDTO;
import linkup.entidades.Usuario;
import linkup.interfaces.IUsuariosDAO;

/**
 *
 * @author gael_
 */
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public boolean registrarUsuario(NuevoUsuarioDTO nuevoUsuario) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Usuario usuario = new Usuario();
            usuario.setUsername(nuevoUsuario.getUsername());
            usuario.setContrasenia(nuevoUsuario.getContrasenia());
            usuario.setNombre(nuevoUsuario.getNombre());
            usuario.setApellido(nuevoUsuario.getApellido());

            entityManager.persist(usuario);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public UsuarioDTO iniciarSesionUsuario(String username, String contrasenia) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        UsuarioDTO usuarioDTO = null;

        try {
            entityManager.getTransaction().begin();

            TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.username = :username AND u.contrasenia = :contrasenia", 
                Usuario.class
            );
            query.setParameter("username", username);
            query.setParameter("contrasenia", contrasenia);

            Usuario usuario = query.getSingleResult();

            if (usuario != null) {
                usuarioDTO = new UsuarioDTO(
                    usuario.getId(),
                    usuario.getUsername(),
                    usuario.getContrasenia(),
                    usuario.getNombre(),
                    usuario.getApellido()
                );
            }

            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            entityManager.getTransaction().rollback();
            // Usuario no encontrado
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return usuarioDTO;
        }
    
        @Override
        public boolean existeUsername(String username) {
            EntityManager em = ManejadorConexiones.getEntityManager();
            try {
                Long count = em.createQuery(
                    "SELECT COUNT(u) FROM Usuario u WHERE u.username = :username", Long.class)
                    .setParameter("username", username)
                    .getSingleResult();
                return count > 0;
            } finally {
                em.close();
            }
        }
        
        @Override
        public List<Usuario> obtenerTodosLosUsuarios() {
            EntityManager em = ManejadorConexiones.getEntityManager();
            try {
                return em.createQuery("SELECT u FROM Usuario u", Usuario.class)
                         .getResultList();
            } finally {
                em.close();
            }
        }

}

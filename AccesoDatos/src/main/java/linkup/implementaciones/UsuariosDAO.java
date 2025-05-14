/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.implementaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import linkup.entidades.Usuario;
import linkup.interfaces.IUsuariosDAO;

/**
 *
 * @author gael_
 */
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

            try {
                entityManager.getTransaction().begin();
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
    public Usuario iniciarSesionUsuario(String username, String contrasenia) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.username = :username AND u.contrasenia = :contrasenia",
                Usuario.class
            );
            query.setParameter("username", username);
            query.setParameter("contrasenia", contrasenia);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
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

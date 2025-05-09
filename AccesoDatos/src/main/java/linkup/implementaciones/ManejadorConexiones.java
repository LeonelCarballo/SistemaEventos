/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gael_
 */
public class ManejadorConexiones {
    public static EntityManager getEntityManager() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.252522_AccesoDatos_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ISubsistema;

import DTOs.Infraestructura;
import exception.NegocioException;

/**
 *
 * @author jrasc
 */
public interface IGestorUbicaciones {

    public Infraestructura validarUbicacion(Infraestructura ubicacion) throws NegocioException;
}

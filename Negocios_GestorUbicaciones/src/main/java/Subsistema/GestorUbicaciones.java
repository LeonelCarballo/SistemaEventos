/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import ISubsistema.IGestorUbicaciones;

import java.util.List;
import linkup.dtosnegocios.EventoDTO;
import linkup.exception.NegocioException;
import linkup.infraestructura.mapa.InfraestructuraMapa;
import linkup.infraestructura.mapa.Location;

/**
 *
 * @author jrasc
 */
public class GestorUbicaciones implements IGestorUbicaciones {

    private InfraestructuraMapa mapService;
    private Location ubicacionSeleccionada;

    public GestorUbicaciones(InfraestructuraMapa mapService) {
        this.mapService = mapService;
    }

    @Override
    public void mostrarMapa() {
        mapService.showMap();
    }

    @Override
    public Location elegirUbicacion(String nombre) {
        ubicacionSeleccionada = mapService.selectLocation(nombre);
        return ubicacionSeleccionada;
    }

    @Override
    public Location getUbicacionSeleccionada() {
        return ubicacionSeleccionada;
    }

    @Override
    public EventoDTO validarUbicacionEvento(EventoDTO dto){
        if (dto == null) {
            throw new NegocioException("El evento no puede ser nulo.");
        }
        if (dto.getDireccion() == null || dto.getDireccion().trim().isEmpty()) {
            throw new NegocioException("La dirección del evento es obligatoria.");
        }
        return dto;
    }
}

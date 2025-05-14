/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import ISubsistema.IGestorUbicaciones;
import java.io.File;

import java.util.List;
import java.util.Map;
//import javafx.application.Platform;
//import javafx.embed.swing.JFXPanel;
//import javafx.scene.Scene;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
import javax.swing.JPanel;
import linkup.dtosnegocios.EventoDTO;
import linkup.exception.NegocioException;
import linkup.infraestructura.Integracion;
import linkup.infraestructura.interfaces.IIntegracion;


/**
 *
 * @author jrasc
 */
public class GestorUbicaciones implements IGestorUbicaciones {

    
    
    private final IIntegracion integracion;
    public GestorUbicaciones() {
        this.integracion = new Integracion();
    }

    public void mostrarMapa(JPanel destino) {
//        JFXPanel jfxPanel = new JFXPanel();
//        destino.setLayout(new java.awt.BorderLayout()); 
//        destino.add(jfxPanel);
//
//        Platform.runLater(() -> {
//            WebView webView = new WebView();
//            WebEngine engine = webView.getEngine();
//
//            File file = new File("mapa.html");
//            engine.load(file.toURI().toString());
//
//            jfxPanel.setScene(new Scene(webView));
//        });
    }

    @Override
    public EventoDTO elegirUbicacion(String nombre) {
        return null;        
    }

    @Override
    public Map<String, Double> getUbicacionSeleccionada() {
        
        Map<String, Double> coordenadas = integracion.obtenerUbicacionMapa();
        return coordenadas;
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

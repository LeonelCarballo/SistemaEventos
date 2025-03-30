/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import linkup.control.ControlCrearEvento;
import linkup.crearevento.VentanaPrincipalCrearEvento;

/**
 *
 * @author leoca
 */
public class Main {

    public static void main(String[] args) {
        ControlCrearEvento controlador = new ControlCrearEvento();
        VentanaPrincipalCrearEvento ventanaPrincipalCrearEvento = new VentanaPrincipalCrearEvento(controlador);
        ventanaPrincipalCrearEvento.mostrar();
    }
    
}

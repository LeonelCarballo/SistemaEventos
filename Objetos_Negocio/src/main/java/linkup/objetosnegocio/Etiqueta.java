/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package linkup.objetosnegocio;

/**
 *
 * @author Dana Chavez
 */
public enum Etiqueta {
    CUMPLEAÑOS, BODA, REUNION;

    public String getTexto() {
        String nombre = this.name().toLowerCase();
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }
}

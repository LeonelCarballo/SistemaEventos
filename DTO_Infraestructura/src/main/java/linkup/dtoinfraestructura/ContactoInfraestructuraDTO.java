/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtoinfraestructura;

/**
 *
 * @author Dana Chavez
 */
public class ContactoInfraestructuraDTO {
    public String nombre;
    public String usuario;

    public ContactoInfraestructuraDTO() {
    }

    public ContactoInfraestructuraDTO(String nombre, String usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
      
}

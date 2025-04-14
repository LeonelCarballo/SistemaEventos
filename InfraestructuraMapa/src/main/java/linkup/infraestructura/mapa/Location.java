/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura.mapa;

/**
 *
 * @author Dana Chavez
 */
public class Location {
    private double latitude;
    private double longitude;
    private String name;

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + latitude + ", " + longitude + ")";
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura.conectores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import linkup.infraestructura.interfaces.IConector;

public class ConectorMapa implements IConector {

    private static final String HOST = "http://localhost:5000/obtener_ubicacion";

    @Override
    public String invocarServicioJson(String jsonIgnorado) {
        try {
            URL url = new URL(HOST);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                String inputLine;
                StringBuilder respuesta = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    respuesta.append(inputLine);
                }

                return respuesta.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}

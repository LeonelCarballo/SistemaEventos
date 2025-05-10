/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.infraestructura.conectores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import linkup.infraestructura.interfaces.IConector;


public class ConectorMapa implements IConector {

    private static final String HOST = "localhost";
    private static final int PORT = 5011; 

    @Override
    public String invocarServicioJson(String json) {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(json);

            StringBuilder respuesta = new StringBuilder();
            String linea;
            while ((linea = in.readLine()) != null) {
                respuesta.append(linea);
            }

            return respuesta.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return "{}"; 
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package linkup.infraestructura.mapa;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JPanel;
import linkup.infraestructura.mapa.interfaces.IInfraestructuraMapa;

/**
 *
 * @author Dana Chavez
 */
public class InfraestructuraMapa implements IInfraestructuraMapa {

    public InfraestructuraMapa() {
    }

    @Override
    public void showMap(JPanel destino) {
        JFXPanel jfxPanel = new JFXPanel();           
        destino.add(jfxPanel);

        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();

            File file = new File("mapa.html");
            engine.load(file.toURI().toString());

            jfxPanel.setScene(new Scene(webView));
        });
    }

    @Override
    public List<Location> getAvailableLocations() {
        return null;
    }

    @Override
    public Location selectLocation(String name) {
        
        return null;
    }
}

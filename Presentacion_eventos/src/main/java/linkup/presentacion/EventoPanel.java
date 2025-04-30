/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import linkup.dtosnegocios.EventoDTO;

/**
 *
 * @author leoca
 */
public class EventoPanel extends JPanel {
    private EventoDTO evento;

    public EventoPanel(EventoDTO evento) {
        this.evento = evento;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        setPreferredSize(new Dimension(400, 180));

        JPanel imagenPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(220, 222, 226));
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(Color.GRAY);
                g.fillPolygon(new int[]{getWidth() / 2 - 20, getWidth() / 2, getWidth() / 2 + 20},
                              new int[]{20, 0, 20}, 3);
                g.fillRect(getWidth() / 2 - 60, 40, 40, 40);
                g.fillOval(getWidth() / 2 + 20, 40, 40, 40);
            }
        };
        imagenPanel.setPreferredSize(new Dimension(400, 80));
        add(imagenPanel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblNombre = new JLabel(evento.getNombreEvento());
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel lblDireccion = new JLabel(evento.getDireccion());
        lblDireccion.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblDireccion.setForeground(Color.DARK_GRAY);

        // Conversión de etiqueta enum a string
        String etiquetaString = switch (evento.getEtiqueta()) {
            case CUMPLEAÑOS -> "Cumpleaños";
            case BODA -> "Boda";
            case REUNION -> "Reunión";
        };

        JLabel lblEtiqueta = new JLabel(etiquetaString);
        lblEtiqueta.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblEtiqueta.setForeground(new Color(128, 0, 64));

        // Formatear LocalDateTime
        LocalDateTime fechaHora = evento.getFechaHora();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHoraFormateada = fechaHora.format(formatter);

        JLabel lblFechaHora = new JLabel(fechaHoraFormateada);
        lblFechaHora.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblFechaHora.setForeground(Color.GRAY);

        infoPanel.add(lblNombre);
        infoPanel.add(lblDireccion);
        infoPanel.add(lblEtiqueta);
        infoPanel.add(lblFechaHora);

        add(infoPanel, BorderLayout.CENTER);
    }
}


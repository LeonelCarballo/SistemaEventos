/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
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
        setPreferredSize(new Dimension(400, 220)); 

        JPanel imagenPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                boolean bannerCargado = false;

                String bannerPath = evento.getBannerPath();

                if (bannerPath != null && !bannerPath.isBlank()) {
                    File file = new File(bannerPath);

                    if (file.exists()) {
                        try {
                            BufferedImage img = ImageIO.read(file);
                            if (img != null) {
                                int panelWidth = getWidth();
                                int panelHeight = getHeight();

                                double imgAspect = (double) img.getWidth() / img.getHeight();
                                double panelAspect = (double) panelWidth / panelHeight;

                                int drawWidth, drawHeight;
                                if (imgAspect > panelAspect) {
                                    drawWidth = panelWidth;
                                    drawHeight = (int) (panelWidth / imgAspect);
                                } else {
                                    drawHeight = panelHeight;
                                    drawWidth = (int) (panelHeight * imgAspect);
                                }

                                int x = (panelWidth - drawWidth) / 2;
                                int y = (panelHeight - drawHeight) / 2;

                                Image scaledImg = img.getScaledInstance(drawWidth, drawHeight, Image.SCALE_SMOOTH);
                                g.drawImage(scaledImg, x, y, this);
                                bannerCargado = true;
                            }
                        } catch (IOException e) {
                            System.err.println("Error cargando imagen: " + e.getMessage());
                        }
                    }
                }

                if (!bannerCargado) {
                    g.setColor(new Color(220, 222, 226));
                    g.fillRect(0, 0, getWidth(), getHeight());

                    g.setColor(Color.DARK_GRAY);
                    g.setFont(new Font("SansSerif", Font.ITALIC, 14));
                    FontMetrics fm = g.getFontMetrics();
                    String mensaje = "Sin banner disponible";
                    int x = (getWidth() - fm.stringWidth(mensaje)) / 2;
                    int y = (getHeight() + fm.getAscent()) / 2 - 5;
                    g.drawString(mensaje, x, y);
                }
            }
        };
        imagenPanel.setPreferredSize(new Dimension(400, 120)); 
        add(imagenPanel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblNombre = new JLabel(evento.getNombreEvento());
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel lblDireccion = new JLabel(evento.getDireccion());
        lblDireccion.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblDireccion.setForeground(Color.DARK_GRAY);

        String etiquetaString = switch (evento.getEtiqueta()) {
            case CUMPLEAÑOS -> "Cumpleaños";
            case BODA -> "Boda";
            case REUNION -> "Reunión";
        };

        JLabel lblEtiqueta = new JLabel(etiquetaString);
        lblEtiqueta.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblEtiqueta.setForeground(new Color(128, 0, 64));

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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion.enviarinvitaciones;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import linkup.dtosnegocios.ContactoDTO;
import linkup.presentacion.control.ControlEnviarInvitaciones;

/**
 *
 * @author Dana Chavez
 */
public class SeleccionarParticipantes extends javax.swing.JFrame {

    private List<String> contactos;
    private List<String> seleccionados;
    private List<PanelContacto> panelesContactos;
    
    
    private List<ContactoDTO> contactosDTO;
    
    private ControlEnviarInvitaciones control;

    public SeleccionarParticipantes(ControlEnviarInvitaciones control) {
        this.control = control;
        initComponents();
        setLocationRelativeTo(null);
          
        jScrollPaneContactos.setOpaque(false);
        jScrollPaneContactos.getViewport().setOpaque(false);
        jPanelContactos.setOpaque(false);

        panelesContactos = new ArrayList<>();

        this.contactos = new ArrayList<>();
        this.contactosDTO = control.obtenerContactos(); 

        for (ContactoDTO contacto : contactosDTO) {
            this.contactos.add(contacto.getNombre());
        }

        jPanelContactos.setLayout(new BoxLayout(jPanelContactos, BoxLayout.Y_AXIS));
        agregarContactosAlPanel(contactos);
    }
    
    public void actualizarCheckBoxes() {
        for (PanelContacto panel : panelesContactos) {
            String nombre = panel.getNombreContacto();
            boolean seleccionado = control.estaSeleccionado(nombre);
            panel.setSeleccionado(seleccionado); 
        }
    }

    public void mostrar() {
        actualizarCheckBoxes();
        setVisible(true);
    }

    public void cerrar() {
        setVisible(false);
        dispose();
    }
    
    private void agregarContactosAlPanel(List<String> contactos) {
        jPanelContactos.removeAll(); 
        panelesContactos.clear(); 

        for (String contacto : contactos) {
            PanelContacto panel = new PanelContacto(contacto, false);

            panel.agregarItemListener(e -> {
                JCheckBox check = (JCheckBox) e.getSource();
                if (check.isSelected()) {
                    control.agregarParticipante(contacto);
                } else {
                    control.quitarParticipante(contacto);
                }
            });

            jPanelContactos.add(panel);
            panelesContactos.add(panel); 
        }

        jPanelContactos.revalidate();
        jPanelContactos.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPaneContactos = new javax.swing.JScrollPane();
        jPanelContactos = new javax.swing.JPanel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 100, 750));

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoncancelar.png"))); // NOI18N
        jButtonCancelar.setContentAreaFilled(false);
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 610, -1, -1));

        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonregresar.png"))); // NOI18N
        jButtonRegresar.setContentAreaFilled(false);
        getContentPane().add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 610, 40, -1));

        jButtonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonsiguiente.png"))); // NOI18N
        jButtonSiguiente.setContentAreaFilled(false);
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 610, 40, -1));

        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmenu.png"))); // NOI18N
        jButtonMenu.setBorder(null);
        jButtonMenu.setContentAreaFilled(false);
        jButtonMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoncalendario.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonchat.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmiseventos.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 60, -1));

        jScrollPaneContactos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelContactos.setOpaque(false);
        jScrollPaneContactos.setViewportView(jPanelContactos);

        getContentPane().add(jScrollPaneContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 260, 330));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seleccionarparticipantes.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 1160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        cerrar();
        control.mostrarResumen();
    }//GEN-LAST:event_jButtonSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContactos;
    private javax.swing.JScrollPane jScrollPaneContactos;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import linkup.dtosnegocios.EventoDTO;
import linkup.exception.NegocioException;
import linkup.objetosnegocio.Etiqueta;
import linkup.organizadoreventos.interfaces.IOrganizadorEventos;
import linkup.presentacion.control.ControlCrearEvento;

/**
 *
 * @author Dana Chavez
 */
public class IngresarDetallesEvento extends javax.swing.JFrame {

    private ControlCrearEvento controlador;
    private EventoDTO eventoDTO;

    /**
     * Creates new form VentanaPrincipalCrearEvento
     */
    public IngresarDetallesEvento(ControlCrearEvento controlador, EventoDTO eventoDTO) {
        this.controlador = controlador;
        this.eventoDTO = new EventoDTO();
        initComponents();
        setLocationRelativeTo(null);
    }

    public IngresarDetallesEvento() {
        initComponents();
    }

    public void mostrar() {
        setVisible(true);
    }

    public void cerrar() {
        setVisible(false);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonInicio1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanelRosaClaro = new javax.swing.JPanel();
        jLabelNombreEvento = new javax.swing.JLabel();
        jTextFieldNombreEvento = new javax.swing.JTextField();
        jLabelEtiqueta = new javax.swing.JLabel();
        jComboBoxEtiqueta = new javax.swing.JComboBox<>();
        jLabelBanner = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jLabelDescripcion = new javax.swing.JLabel();
        jButtonSeleccionarBanner = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelLogo1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButtonMisAmigos = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();
        jPanelBlanco = new javax.swing.JPanel();

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(168, 91, 102));
        jLabel7.setText("Banner");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelar.setBackground(new java.awt.Color(246, 227, 230));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoncancelar.png"))); // NOI18N
        jButtonCancelar.setBorder(null);
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 610, -1, -1));

        jButtonSiguiente.setBackground(new java.awt.Color(246, 227, 230));
        jButtonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonsiguiente.png"))); // NOI18N
        jButtonSiguiente.setBorder(null);
        jButtonSiguiente.setContentAreaFilled(false);
        jButtonSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 610, -1, -1));

        jButtonInicio1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonInicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoninicio.png"))); // NOI18N
        jButtonInicio1.setBorder(null);
        jButtonInicio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicio1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 200, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lblcreandoevento.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 210, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoncalendario.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));

        jPanelRosaClaro.setBackground(new java.awt.Color(246, 227, 230));
        jPanelRosaClaro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombreEvento.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelNombreEvento.setForeground(new java.awt.Color(168, 91, 102));
        jLabelNombreEvento.setText("Nombre del evento");
        jPanelRosaClaro.add(jLabelNombreEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTextFieldNombreEvento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 63, 75)));
        jPanelRosaClaro.add(jTextFieldNombreEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 270, 40));

        jLabelEtiqueta.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelEtiqueta.setForeground(new java.awt.Color(168, 91, 102));
        jLabelEtiqueta.setText("Etiqueta");
        jPanelRosaClaro.add(jLabelEtiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jComboBoxEtiqueta.setBackground(new java.awt.Color(246, 227, 230));
        jComboBoxEtiqueta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cumpleaños", "Boda", "Reunion" }));
        jComboBoxEtiqueta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 63, 75)));
        jComboBoxEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEtiquetaActionPerformed(evt);
            }
        });
        jPanelRosaClaro.add(jComboBoxEtiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 270, 40));

        jLabelBanner.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelBanner.setForeground(new java.awt.Color(168, 91, 102));
        jLabelBanner.setText("Banner");
        jPanelRosaClaro.add(jLabelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jTextFieldDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 63, 75)));
        jPanelRosaClaro.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 270, 40));

        jLabelDescripcion.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelDescripcion.setForeground(new java.awt.Color(168, 91, 102));
        jLabelDescripcion.setText("Descripcion");
        jPanelRosaClaro.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jButtonSeleccionarBanner.setText("Seleccionar banner");
        jButtonSeleccionarBanner.setBorder(null);
        jButtonSeleccionarBanner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSeleccionarBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarBannerActionPerformed(evt);
            }
        });
        jPanelRosaClaro.add(jButtonSeleccionarBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 270, 30));

        getContentPane().add(jPanelRosaClaro, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 310, 400));

        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmenu.png"))); // NOI18N
        jButtonMenu.setBorder(null);
        jButtonMenu.setContentAreaFilled(false);
        jButtonMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonchat.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, -1));

        jLabelLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LINK UP.png"))); // NOI18N
        getContentPane().add(jLabelLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 250, 50));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmiseventos.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 60, -1));

        jButtonMisAmigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmisamigos.png"))); // NOI18N
        jButtonMisAmigos.setBorder(null);
        jButtonMisAmigos.setContentAreaFilled(false);
        jButtonMisAmigos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMisAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMisAmigosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMisAmigos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 60, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoevento.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 1200, -1));

        jPanelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanelBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEtiquetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEtiquetaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        controlador.mostrarVentanaPrincipal();
        cerrar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        Etiqueta etiqueta = Etiqueta.CUMPLEAÑOS;

        String seleccion = (String) jComboBoxEtiqueta.getSelectedItem();
        if ("Cumpleaños".equals(seleccion)) {
            etiqueta = Etiqueta.CUMPLEAÑOS;
        } else if ("Boda".equals(seleccion)) {
            etiqueta = Etiqueta.BODA;
        } else if ("Reunion".equals(seleccion)) {
            etiqueta = Etiqueta.REUNION;
        }

        eventoDTO.setNombreEvento(jTextFieldNombreEvento.getText());
        eventoDTO.setDescripcion(jTextFieldDescripcion.getText());
        eventoDTO.setEtiqueta(etiqueta);

        try {
            eventoDTO = controlador.validarDetallesEventoDTO(eventoDTO);
            controlador.mostrarSeleccionFechaHora(eventoDTO);
            cerrar();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonSeleccionarBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarBannerActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen de banner");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg", "gif"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            eventoDTO.setBannerPath(selectedFile.getAbsolutePath());
            JOptionPane.showMessageDialog(this, "Banner cargado correctamente.");
        }
    }//GEN-LAST:event_jButtonSeleccionarBannerActionPerformed

    private void jButtonInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInicio1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cerrar();
        controlador.mostrarVentanaPrincipal();       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonMisAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMisAmigosActionPerformed
        controlador.mostrarAgregarContactos();
    }//GEN-LAST:event_jButtonMisAmigosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresarDetallesEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarDetallesEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarDetallesEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarDetallesEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarDetallesEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonInicio1;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonMisAmigos;
    private javax.swing.JButton jButtonSeleccionarBanner;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JComboBox<String> jComboBoxEtiqueta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBanner;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelEtiqueta;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo1;
    private javax.swing.JLabel jLabelNombreEvento;
    private javax.swing.JPanel jPanelBlanco;
    private javax.swing.JPanel jPanelRosaClaro;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombreEvento;
    // End of variables declaration//GEN-END:variables
}

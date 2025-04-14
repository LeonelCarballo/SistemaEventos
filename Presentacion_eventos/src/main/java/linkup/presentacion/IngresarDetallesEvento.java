/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion;

import linkup.dtosnegocios.EventoDTO;
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
    public IngresarDetallesEvento(ControlCrearEvento controlador) {
        this.controlador = controlador;
        this.eventoDTO = new EventoDTO();
        initComponents();
        setLocationRelativeTo(null);
    }

    public IngresarDetallesEvento() {
        initComponents();
    }
    
    public void mostrar(){
        setVisible(true);
    }
    
    public void cerrar(){
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
        jPanelBlanco = new javax.swing.JPanel();
        jPanelRosa = new javax.swing.JPanel();
        JButtonMenu = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        JButtonInicio = new javax.swing.JButton();
        JButtonExplorar = new javax.swing.JButton();
        jLabelCreandoEvento = new javax.swing.JLabel();
        jPanelRosaClaro = new javax.swing.JPanel();
        jLabelNombreEvento = new javax.swing.JLabel();
        jTextFieldNombreEvento = new javax.swing.JTextField();
        jLabelEtiqueta = new javax.swing.JLabel();
        jComboBoxEtiqueta = new javax.swing.JComboBox<>();
        jLabelBanner = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jLabelDescripcion = new javax.swing.JLabel();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelColorSeparador = new javax.swing.JPanel();
        jLabelNuevoEvento = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(168, 91, 102));
        jLabel7.setText("Banner");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelRosa.setBackground(new java.awt.Color(253, 166, 179));
        jPanelRosa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JButtonMenu.setBackground(new java.awt.Color(253, 166, 179));
        JButtonMenu.setForeground(new java.awt.Color(255, 255, 255));
        JButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonmenu.png"))); // NOI18N
        jPanelRosa.add(JButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanelBlanco.add(jPanelRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 560));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linklogo.png"))); // NOI18N
        jPanelBlanco.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 210, 50));

        JButtonInicio.setBackground(new java.awt.Color(255, 255, 255));
        JButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupinicio.png"))); // NOI18N
        JButtonInicio.setBorder(null);
        JButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonInicioActionPerformed(evt);
            }
        });
        jPanelBlanco.add(JButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 110, 50));

        JButtonExplorar.setBackground(new java.awt.Color(255, 255, 255));
        JButtonExplorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupexplorar.png"))); // NOI18N
        jPanelBlanco.add(JButtonExplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        jLabelCreandoEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupcreandoevento.png"))); // NOI18N
        jPanelBlanco.add(jLabelCreandoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jPanelRosaClaro.setBackground(new java.awt.Color(246, 227, 230));
        jPanelRosaClaro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombreEvento.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelNombreEvento.setForeground(new java.awt.Color(168, 91, 102));
        jLabelNombreEvento.setText("Nombre del evento");
        jPanelRosaClaro.add(jLabelNombreEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTextFieldNombreEvento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 63, 75)));
        jPanelRosaClaro.add(jTextFieldNombreEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 40));

        jLabelEtiqueta.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelEtiqueta.setForeground(new java.awt.Color(168, 91, 102));
        jLabelEtiqueta.setText("Etiqueta");
        jPanelRosaClaro.add(jLabelEtiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jComboBoxEtiqueta.setBackground(new java.awt.Color(246, 227, 230));
        jComboBoxEtiqueta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEtiqueta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 63, 75)));
        jComboBoxEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEtiquetaActionPerformed(evt);
            }
        });
        jPanelRosaClaro.add(jComboBoxEtiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 260, 40));

        jLabelBanner.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelBanner.setForeground(new java.awt.Color(168, 91, 102));
        jLabelBanner.setText("Banner");
        jPanelRosaClaro.add(jLabelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jTextFieldDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 63, 75)));
        jPanelRosaClaro.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 260, 40));

        jLabelDescripcion.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelDescripcion.setForeground(new java.awt.Color(168, 91, 102));
        jLabelDescripcion.setText("Descripcion");
        jPanelRosaClaro.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jButtonSiguiente.setBackground(new java.awt.Color(246, 227, 230));
        jButtonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonsiguiente.png"))); // NOI18N
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        jPanelRosaClaro.add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(246, 227, 230));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotoncancelar.png"))); // NOI18N
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelRosaClaro.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jPanelBlanco.add(jPanelRosaClaro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 300, 400));

        jPanelColorSeparador.setBackground(new java.awt.Color(195, 123, 133));
        jPanelBlanco.add(jPanelColorSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 300, 10));

        jLabelNuevoEvento.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNuevoEvento.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabelNuevoEvento.setForeground(new java.awt.Color(168, 91, 102));
        jLabelNuevoEvento.setText("Nuevo evento");
        jPanelBlanco.add(jLabelNuevoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        getContentPane().add(jPanelBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 864, 558));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JButtonInicioActionPerformed

    private void jComboBoxEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEtiquetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEtiquetaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        controlador.mostrarVentanaPrincipal();
        cerrar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        eventoDTO.setNombreEvento(jTextFieldNombreEvento.getText());
        eventoDTO.setDescripcion(jTextFieldDescripcion.getText());
        eventoDTO.setEtiqueta(jComboBoxEtiqueta.getActionCommand());
        controlador.mostrarSeleccionFechaHora(eventoDTO);
        cerrar();
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

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
    private javax.swing.JButton JButtonExplorar;
    private javax.swing.JButton JButtonInicio;
    private javax.swing.JButton JButtonMenu;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JComboBox<String> jComboBoxEtiqueta;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBanner;
    private javax.swing.JLabel jLabelCreandoEvento;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelEtiqueta;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombreEvento;
    private javax.swing.JLabel jLabelNuevoEvento;
    private javax.swing.JPanel jPanelBlanco;
    private javax.swing.JPanel jPanelColorSeparador;
    private javax.swing.JPanel jPanelRosa;
    private javax.swing.JPanel jPanelRosaClaro;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombreEvento;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion;

import linkup.presentacion.control.ControlCrearEvento;

/**
 *
 * @author Dana Chavez
 */
public class ConfirmacionEvento extends javax.swing.JFrame {

    private ControlCrearEvento controlador;
    /**
     * Creates new form VentanaPrincipalCrearEvento
     */
    
    
    public ConfirmacionEvento(ControlCrearEvento controlador) {
        this.controlador = controlador;
        initComponents();
        setLocationRelativeTo(null);
    }

    public ConfirmacionEvento() {
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
        menuButton = new javax.swing.JButton();
        JLabelLogo = new javax.swing.JLabel();
        jButtonInicio = new javax.swing.JButton();
        jButtonExplorar = new javax.swing.JButton();
        jLabelCrearEvento = new javax.swing.JLabel();
        jPanelRosaClaro = new javax.swing.JPanel();
        jLabelDetallesEvento = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jPanelDetalles = new javax.swing.JPanel();
        jButtonCrear = new javax.swing.JButton();
        jPanelColorSeparador = new javax.swing.JPanel();
        jLabelConfirmacionEvento = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(168, 91, 102));
        jLabel7.setText("Banner");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelRosa.setBackground(new java.awt.Color(253, 166, 179));
        jPanelRosa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuButton.setBackground(new java.awt.Color(253, 166, 179));
        menuButton.setForeground(new java.awt.Color(255, 255, 255));
        menuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonmenu.png"))); // NOI18N
        jPanelRosa.add(menuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanelBlanco.add(jPanelRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 560));

        JLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linklogo.png"))); // NOI18N
        jPanelBlanco.add(JLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 210, 50));

        jButtonInicio.setBackground(new java.awt.Color(255, 255, 255));
        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupinicio.png"))); // NOI18N
        jButtonInicio.setBorder(null);
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        jPanelBlanco.add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 110, 50));

        jButtonExplorar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExplorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupexplorar.png"))); // NOI18N
        jPanelBlanco.add(jButtonExplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        jLabelCrearEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupcreandoevento.png"))); // NOI18N
        jPanelBlanco.add(jLabelCrearEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jPanelRosaClaro.setBackground(new java.awt.Color(246, 227, 230));
        jPanelRosaClaro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDetallesEvento.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelDetallesEvento.setForeground(new java.awt.Color(168, 91, 102));
        jLabelDetallesEvento.setText("Detalles del evento");
        jPanelRosaClaro.add(jLabelDetallesEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(246, 227, 230));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotoncancelar.png"))); // NOI18N
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelRosaClaro.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jButtonAnterior.setBackground(new java.awt.Color(246, 227, 230));
        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonregresar.png"))); // NOI18N
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        jPanelRosaClaro.add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, -1));

        jPanelDetalles.setBackground(new java.awt.Color(152, 79, 89));
        jPanelDetalles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelRosaClaro.add(jPanelDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 300));

        jButtonCrear.setBackground(new java.awt.Color(246, 227, 230));
        jButtonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupcrear.png"))); // NOI18N
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        jPanelRosaClaro.add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        jPanelBlanco.add(jPanelRosaClaro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 300, 400));

        jPanelColorSeparador.setBackground(new java.awt.Color(195, 123, 133));
        jPanelBlanco.add(jPanelColorSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 300, 10));

        jLabelConfirmacionEvento.setBackground(new java.awt.Color(255, 255, 255));
        jLabelConfirmacionEvento.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabelConfirmacionEvento.setForeground(new java.awt.Color(168, 91, 102));
        jLabelConfirmacionEvento.setText("Confirmacion del evento");
        jPanelBlanco.add(jLabelConfirmacionEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        getContentPane().add(jPanelBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 864, 558));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        controlador.mostrarVentanaPrincipal();
        cerrar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        controlador.mostrarEnviarInvitaciones();
        cerrar();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        controlador.mostrarVentanaPrincipal();
        cerrar();
    }//GEN-LAST:event_jButtonCrearActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmacionEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmacionEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelLogo;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonExplorar;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelConfirmacionEvento;
    private javax.swing.JLabel jLabelCrearEvento;
    private javax.swing.JLabel jLabelDetallesEvento;
    private javax.swing.JPanel jPanelBlanco;
    private javax.swing.JPanel jPanelColorSeparador;
    private javax.swing.JPanel jPanelDetalles;
    private javax.swing.JPanel jPanelRosa;
    private javax.swing.JPanel jPanelRosaClaro;
    private javax.swing.JButton menuButton;
    // End of variables declaration//GEN-END:variables
}

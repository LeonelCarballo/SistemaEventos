/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion;

import DTOs.ContactoDTO;
import DTOs.EventoDTO;
import java.util.List;
import javax.swing.JCheckBox;
import linkup.presentacion.control.ControlCrearEvento;

/**
 *
 * @author Dana Chavez
 */
public class EnviarInvitaciones extends javax.swing.JFrame {

    private ControlCrearEvento controlador;
    private List<JCheckBox> checkboxes;
    private EventoDTO eventoDTO;
    public List<ContactoDTO> seleccionados;
    /**
     * Creates new form VentanaPrincipalCrearEvento
     */
    
    
    public EnviarInvitaciones(ControlCrearEvento controlador, EventoDTO eventoDTO) {
        this.controlador = controlador;
        this.eventoDTO = eventoDTO;
        mostrarContactos();
        initComponents();
        setLocationRelativeTo(null);
    }
    
     public void mostrarContactos(){
        for (ContactoDTO ContactoDTO : controlador.ObtenerContactos()) {
                JCheckBox checkBox = new JCheckBox(ContactoDTO.getNombre());
                checkboxes.add(checkBox);
                contactosPanel.add(checkBox);
        }
    }
     
     private void generarListaSeleccionados() {

        for (int i = 0; i < checkboxes.size(); i++) {
        JCheckBox checkBox = checkboxes.get(i);
        if (checkBox.isSelected()) {
            seleccionados.add(controlador.ObtenerContactos().get(i));
        }
    }   
    }

    public EnviarInvitaciones() {
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
        jPanel2 = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        JLabelLogo = new javax.swing.JLabel();
        jButtonInicio = new javax.swing.JButton();
        jButtonExplorar = new javax.swing.JButton();
        jLabelCreaandoEvento = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelInvitacionesYDetalles = new javax.swing.JLabel();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        contactosPanel = new javax.swing.JPanel();
        jButtonCopiarEnlace = new javax.swing.JButton();
        jLabelGenerarAlbum = new javax.swing.JLabel();
        jLabelEnviarNotificaciones = new javax.swing.JLabel();
        jCheckBoxEnviarNotificaciones = new javax.swing.JCheckBox();
        jCheckBoxGenerarAlbum = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(168, 91, 102));
        jLabel7.setText("Banner");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(253, 166, 179));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMenu.setBackground(new java.awt.Color(253, 166, 179));
        jButtonMenu.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonmenu.png"))); // NOI18N
        jPanel2.add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanelBlanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 560));

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

        jLabelCreaandoEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupcreandoevento.png"))); // NOI18N
        jPanelBlanco.add(jLabelCreaandoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jPanel3.setBackground(new java.awt.Color(246, 227, 230));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelInvitacionesYDetalles.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelInvitacionesYDetalles.setForeground(new java.awt.Color(168, 91, 102));
        jLabelInvitacionesYDetalles.setText("Invitaciones y detalles");
        jPanel3.add(jLabelInvitacionesYDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButtonSiguiente.setBackground(new java.awt.Color(246, 227, 230));
        jButtonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonsiguiente.png"))); // NOI18N
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(246, 227, 230));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotoncancelar.png"))); // NOI18N
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jButtonAnterior.setBackground(new java.awt.Color(246, 227, 230));
        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonregresar.png"))); // NOI18N
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        jPanel5.setBackground(new java.awt.Color(152, 79, 89));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(241, 212, 217));
        jTextField1.setForeground(new java.awt.Color(168, 91, 102));
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 30));

        contactosPanel.setLayout(new javax.swing.BoxLayout(contactosPanel, javax.swing.BoxLayout.Y_AXIS));
        jPanel5.add(contactosPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, 130));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 190));

        jButtonCopiarEnlace.setBackground(new java.awt.Color(246, 227, 230));
        jButtonCopiarEnlace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonenlace.png"))); // NOI18N
        jPanel3.add(jButtonCopiarEnlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 210, 50));

        jLabelGenerarAlbum.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelGenerarAlbum.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenerarAlbum.setText("Generar un album de recuerdos");
        jPanel3.add(jLabelGenerarAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabelEnviarNotificaciones.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelEnviarNotificaciones.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEnviarNotificaciones.setText("Enviar notificaciones del evento");
        jPanel3.add(jLabelEnviarNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));
        jPanel3.add(jCheckBoxEnviarNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        jCheckBoxGenerarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGenerarAlbumActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBoxGenerarAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        jPanelBlanco.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 300, 400));

        jPanel4.setBackground(new java.awt.Color(195, 123, 133));
        jPanelBlanco.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 300, 10));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(168, 91, 102));
        jLabel2.setText("Nuevo evento");
        jPanelBlanco.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        getContentPane().add(jPanelBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 864, 558));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jCheckBoxGenerarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGenerarAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxGenerarAlbumActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        controlador.mostrarVentanaPrincipal();
        cerrar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        controlador.mostrarSeleccionarUbicacion(eventoDTO);
        cerrar();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        generarListaSeleccionados();
        controlador.intentarValidarContactos(seleccionados);
        
        controlador.mostrarConfirmacionEvento(eventoDTO);
        cerrar();
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(EnviarInvitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnviarInvitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnviarInvitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnviarInvitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnviarInvitaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelLogo;
    private javax.swing.JPanel contactosPanel;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCopiarEnlace;
    private javax.swing.JButton jButtonExplorar;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JCheckBox jCheckBoxEnviarNotificaciones;
    private javax.swing.JCheckBox jCheckBoxGenerarAlbum;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCreaandoEvento;
    private javax.swing.JLabel jLabelEnviarNotificaciones;
    private javax.swing.JLabel jLabelGenerarAlbum;
    private javax.swing.JLabel jLabelInvitacionesYDetalles;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelBlanco;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

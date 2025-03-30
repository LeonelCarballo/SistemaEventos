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
public class VentanaPrincipalCrearEvento extends javax.swing.JFrame {

    private ControlCrearEvento controlador;
    /**
     * Creates new form VentanaPrincipalCrearEvento
     */
    public VentanaPrincipalCrearEvento(ControlCrearEvento controlador) {
        this.controlador = controlador;
        initComponents();
        setLocationRelativeTo(null);
    }

    public VentanaPrincipalCrearEvento() {
        initComponents();
        setLocationRelativeTo(null);
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

        jPanelFondoBlanco = new javax.swing.JPanel();
        jPanelColorRosa = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        eventosScrollPane = new javax.swing.JScrollPane();
        jLabelLogo = new javax.swing.JLabel();
        jButtonInicio = new javax.swing.JButton();
        jButtonExplorar = new javax.swing.JButton();
        jButtonCrearEvento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFondoBlanco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondoBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelColorRosa.setBackground(new java.awt.Color(253, 166, 179));
        jPanelColorRosa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMenu.setBackground(new java.awt.Color(253, 166, 179));
        jButtonMenu.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonmenu.png"))); // NOI18N
        jPanelColorRosa.add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanelFondoBlanco.add(jPanelColorRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 560));
        jPanelFondoBlanco.add(eventosScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 350, 420));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linklogo.png"))); // NOI18N
        jPanelFondoBlanco.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 210, 50));

        jButtonInicio.setBackground(new java.awt.Color(255, 255, 255));
        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupinicio.png"))); // NOI18N
        jButtonInicio.setBorder(null);
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        jPanelFondoBlanco.add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 110, 50));

        jButtonExplorar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExplorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupexplorar.png"))); // NOI18N
        jPanelFondoBlanco.add(jButtonExplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        jButtonCrearEvento.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCrearEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotoncrear.png"))); // NOI18N
        jButtonCrearEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearEventoActionPerformed(evt);
            }
        });
        jPanelFondoBlanco.add(jButtonCrearEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, 40));

        getContentPane().add(jPanelFondoBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 864, 558));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonCrearEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearEventoActionPerformed
        controlador.iniciarFlujoCreacionEvento();
        cerrar();
    }//GEN-LAST:event_jButtonCrearEventoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipalCrearEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalCrearEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalCrearEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalCrearEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalCrearEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane eventosScrollPane;
    private javax.swing.JButton jButtonCrearEvento;
    private javax.swing.JButton jButtonExplorar;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanelColorRosa;
    private javax.swing.JPanel jPanelFondoBlanco;
    // End of variables declaration//GEN-END:variables
}

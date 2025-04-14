/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion;

import linkup.dtosnegocios.EventoDTO;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import linkup.presentacion.control.ControlCrearEvento;



/**
 *
 * @author Dana Chavez
 */
public class SeleccionarFechaHora extends javax.swing.JFrame {
    
    private ControlCrearEvento controlador;
    private EventoDTO eventoDTO;
    /**
     * Creates new form VentanaPrincipalCrearEvento
     */
    public SeleccionarFechaHora(ControlCrearEvento controlador, EventoDTO eventoDTO) {
        this.controlador = controlador;
        this.eventoDTO = eventoDTO;
        initComponents();
        setLocationRelativeTo(null);
    }

    public SeleccionarFechaHora() {
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
        jPanelFondo = new javax.swing.JPanel();
        jPanelColorRosa = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jButtonInicio = new javax.swing.JButton();
        jButtonExplorar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelColorFondo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        HoraCB = new javax.swing.JComboBox<>();
        MinutoCB = new javax.swing.JComboBox<>();
        jPanelColor = new javax.swing.JPanel();
        jLabelTituloNuevoEvento = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(168, 91, 102));
        jLabel7.setText("Banner");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelColorRosa.setBackground(new java.awt.Color(253, 166, 179));
        jPanelColorRosa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMenu.setBackground(new java.awt.Color(253, 166, 179));
        jButtonMenu.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonmenu.png"))); // NOI18N
        jPanelColorRosa.add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanelFondo.add(jPanelColorRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 560));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linklogo.png"))); // NOI18N
        jPanelFondo.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 210, 50));

        jButtonInicio.setBackground(new java.awt.Color(255, 255, 255));
        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupinicio.png"))); // NOI18N
        jButtonInicio.setBorder(null);
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 110, 50));

        jButtonExplorar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExplorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupexplorar.png"))); // NOI18N
        jPanelFondo.add(jButtonExplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupcreandoevento.png"))); // NOI18N
        jPanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jPanelColorFondo.setBackground(new java.awt.Color(246, 227, 230));
        jPanelColorFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(168, 91, 102));
        jLabel3.setText("Minutos");
        jPanelColorFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jButtonSiguiente.setBackground(new java.awt.Color(246, 227, 230));
        jButtonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonsiguiente.png"))); // NOI18N
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        jPanelColorFondo.add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(246, 227, 230));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotoncancelar.png"))); // NOI18N
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelColorFondo.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jButtonAnterior.setBackground(new java.awt.Color(246, 227, 230));
        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonregresar.png"))); // NOI18N
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        jPanelColorFondo.add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(168, 91, 102));
        jLabel4.setText("Seleccionar fecha y hora");
        jPanelColorFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(168, 91, 102));
        jLabel5.setText("Fecha");
        jPanelColorFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(168, 91, 102));
        jLabel6.setText("Horas");
        jPanelColorFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        jPanelColorFondo.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        HoraCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jPanelColorFondo.add(HoraCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        MinutoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        jPanelColorFondo.add(MinutoCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jPanelFondo.add(jPanelColorFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 300, 400));

        jPanelColor.setBackground(new java.awt.Color(195, 123, 133));
        jPanelFondo.add(jPanelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 300, 10));

        jLabelTituloNuevoEvento.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTituloNuevoEvento.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabelTituloNuevoEvento.setForeground(new java.awt.Color(168, 91, 102));
        jLabelTituloNuevoEvento.setText("Nuevo evento");
        jPanelFondo.add(jLabelTituloNuevoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        getContentPane().add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 864, 558));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        controlador.mostrarVentanaPrincipal();
        cerrar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        
            String hora = (String) this.HoraCB.getSelectedItem();
String minuto = (String) this.MinutoCB.getSelectedItem();

        // Obtienes la fecha desde el JDateChooser
        Date fecha = jDateChooser1.getDate();
        Instant instant = fecha.toInstant();
        ZoneId zoneId = ZoneId.systemDefault(); 
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        LocalTime localTime = LocalTime.of(Integer.parseInt(hora), Integer.parseInt(minuto));
        LocalDateTime fechaHora = LocalDateTime.of(localDate, localTime);
        eventoDTO.setFechaHora(fechaHora);
        controlador.mostrarSeleccionarUbicacion(eventoDTO);
        cerrar();
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        controlador.mostrarFormularioDetalles();
        cerrar();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarFechaHora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarFechaHora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarFechaHora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarFechaHora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new SeleccionarFechaHora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> HoraCB;
    private javax.swing.JComboBox<String> MinutoCB;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExplorar;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonSiguiente;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTituloNuevoEvento;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JPanel jPanelColorFondo;
    private javax.swing.JPanel jPanelColorRosa;
    private javax.swing.JPanel jPanelFondo;
    // End of variables declaration//GEN-END:variables
}

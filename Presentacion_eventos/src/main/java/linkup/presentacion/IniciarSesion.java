/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion;

import exception.NegocioException;
import javax.swing.JOptionPane;
import linkup.presentacion.control.ControlIniciarSesion;
import linkup.presentacion.control.ControlRegistrarUsuario;
import linkup.presentacion.control.ControlCrearEvento;

/**
 *
 * @author gael_
 */
public class IniciarSesion extends javax.swing.JFrame {

    
    ControlIniciarSesion controlIniciarSesion;
    ControlCrearEvento controlEvento;
    ControlRegistrarUsuario controlRegistrar;
    
    /**
     * Creates new form IniciarSesion
     */
    

    public IniciarSesion(ControlIniciarSesion controlIniciarSesion, ControlCrearEvento controlEvento) {
        this.controlIniciarSesion = controlIniciarSesion;
        this.controlEvento = controlEvento;
        this.controlRegistrar = controlRegistrar;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void iniciarSesion() {
    try {
        String username = txtUsername.getText().trim();
        String contrasenia = txtConstraseña.getText().trim();

        if (username.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean autenticado = controlIniciarSesion.iniciarSesion(username, contrasenia);

        if (autenticado) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
            controlEvento.mostrarVentanaPrincipalPrincipio(controlIniciarSesion);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NegocioException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de negocio", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado. Inténtalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace(); // Para depuración
    }
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBlanco = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtConstraseña = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        jLabelRegistrar = new javax.swing.JLabel();
        jLabelLogo1 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1151, 744));

        panelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        panelBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsuario.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(168, 91, 102));
        labelUsuario.setText("Usuario:");
        panelBlanco.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 90, 30));

        labelContraseña.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        labelContraseña.setForeground(new java.awt.Color(168, 91, 102));
        labelContraseña.setText("Contraseña:");
        panelBlanco.add(labelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 110, 30));

        txtUsername.setBackground(new java.awt.Color(247, 165, 165));
        txtUsername.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        panelBlanco.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 220, 40));

        txtConstraseña.setBackground(new java.awt.Color(247, 165, 165));
        txtConstraseña.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtConstraseña.setForeground(new java.awt.Color(255, 255, 255));
        panelBlanco.add(txtConstraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 220, 40));

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotoniniciarsesion.png"))); // NOI18N
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        panelBlanco.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 220, -1));

        btnRegistrarse.setForeground(new java.awt.Color(168, 91, 102));
        btnRegistrarse.setText("Registrate");
        btnRegistrarse.setBorder(null);
        btnRegistrarse.setContentAreaFilled(false);
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        panelBlanco.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 100, 40));

        jLabelRegistrar.setForeground(new java.awt.Color(204, 127, 138));
        jLabelRegistrar.setText("No tienes una cuenta? ");
        panelBlanco.add(jLabelRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, -1, -1));

        jLabelLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LINK UP.png"))); // NOI18N
        panelBlanco.add(jLabelLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 250, 50));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondosimple.png"))); // NOI18N
        panelBlanco.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, 0, 1160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        ControlRegistrarUsuario control = new ControlRegistrarUsuario(this);
        controlEvento.mostrarRegistrar(controlEvento);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo1;
    private javax.swing.JLabel jLabelRegistrar;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelBlanco;
    private javax.swing.JTextField txtConstraseña;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

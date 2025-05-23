 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion.cu.gestionarInvitacion;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import linkup.presentacion.cu.admgrupo.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import linkup.dtosnegocios.cu.admgrupo.GrupoDTO;
import linkup.objetosnegocio.UsuarioON;
import linkup.objetosnegocio.cu.admInvitacion.Invitacion;
import linkup.objetosnegocio.cu.admgrupo.Grupo;
import linkup.objetosnegocio.fabrica.FabricaObjetosNegocio;
import linkup.presentacion.control.ControlAdministrarGrupo;
import linkup.presentacion.control.ControlAdministrarInvitaciones;
import linkup.presentacion.control.ControlCrearEvento;


/**
 *
 * @author gael_
 */
public class frmMostrarInvitacion extends javax.swing.JFrame {

   private List<Invitacion> invitaciones;
    private ControlAdministrarInvitaciones administrarInvitaciones;
    /**
     * Creates new form frmCrearGrupo
     */
    public frmMostrarInvitacion(List<Invitacion> invitaciones, ControlAdministrarInvitaciones administrarInvitaciones) {
       this.invitaciones = invitaciones;
       this.administrarInvitaciones = administrarInvitaciones;
        initComponents();
        
        setTitle("Invitaciones");
        cargarInvitaciones(invitaciones);
        
    }
    
  public void cargarInvitaciones(List<Invitacion> listaInvitaciones) {
    jPanelListaInvitaciones.removeAll(); // limpiar el panel donde van los paneles

    jPanelListaInvitaciones.setLayout(new BoxLayout(jPanelListaInvitaciones, BoxLayout.Y_AXIS)); // layout vertical
    jPanelListaInvitaciones.setBackground(Color.PINK);

    if (listaInvitaciones == null || listaInvitaciones.isEmpty()) {
        // Si no hay invitaciones, mostrar un label indicando que no hay
        JLabel labelNoHay = new JLabel("No hay invitaciones disponibles");
        labelNoHay.setForeground(Color.DARK_GRAY);
        labelNoHay.setFont(new Font("Arial", Font.ITALIC, 16));
        labelNoHay.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelListaInvitaciones.add(Box.createVerticalGlue()); // para centrar verticalmente
        jPanelListaInvitaciones.add(labelNoHay);
        jPanelListaInvitaciones.add(Box.createVerticalGlue());
    } else {
        // Si hay invitaciones, agregarlas con fondo gris
        for (Invitacion invitacion : listaInvitaciones) {
            panelInvitacion panel = new panelInvitacion(invitacion, administrarInvitaciones);
            panel.setBackground(Color.LIGHT_GRAY); // fondo gris claro
            panel.setOpaque(true); // muy importante para que se pinte el fondo
            panel.setAlignmentX(Component.LEFT_ALIGNMENT); // para que se alinee bien en BoxLayout
            jPanelListaInvitaciones.add(panel);
            jPanelListaInvitaciones.add(Box.createRigidArea(new Dimension(0, 5))); // separador vertical entre paneles
        }
    }

    jPanelListaInvitaciones.revalidate();
    jPanelListaInvitaciones.repaint();
}




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBlanco = new javax.swing.JPanel();
        PanelRosa = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        btnGrupos = new javax.swing.JButton();
        btnEventos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        PanelLogo = new javax.swing.JLabel();
        jPanelListaInvitaciones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1160, 750));

        PanelBlanco.setBackground(new java.awt.Color(255, 255, 255));

        PanelRosa.setBackground(new java.awt.Color(253, 166, 179));
        PanelRosa.setMinimumSize(new java.awt.Dimension(56, 57));
        PanelRosa.setLayout(null);

        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmenu.png"))); // NOI18N
        jButtonMenu.setContentAreaFilled(false);
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        PanelRosa.add(jButtonMenu);
        jButtonMenu.setBounds(10, 20, 46, 47);

        btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoncalendario.png"))); // NOI18N
        btnCalendario.setContentAreaFilled(false);
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });
        PanelRosa.add(btnCalendario);
        btnCalendario.setBounds(10, 100, 46, 47);

        btnGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonchat.png"))); // NOI18N
        btnGrupos.setContentAreaFilled(false);
        btnGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGruposActionPerformed(evt);
            }
        });
        PanelRosa.add(btnGrupos);
        btnGrupos.setBounds(10, 160, 46, 47);

        btnEventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmiseventos.png"))); // NOI18N
        btnEventos.setContentAreaFilled(false);
        btnEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventosActionPerformed(evt);
            }
        });
        PanelRosa.add(btnEventos);
        btnEventos.setBounds(10, 220, 46, 47);

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(168, 91, 102));
        jLabel5.setText("Invitaciones");

        PanelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LINK UP.png"))); // NOI18N

        javax.swing.GroupLayout PanelBlancoLayout = new javax.swing.GroupLayout(PanelBlanco);
        PanelBlanco.setLayout(PanelBlancoLayout);
        PanelBlancoLayout.setHorizontalGroup(
            PanelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBlancoLayout.createSequentialGroup()
                .addComponent(PanelRosa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBlancoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelLogo))
                    .addGroup(PanelBlancoLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBlancoLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jPanelListaInvitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        PanelBlancoLayout.setVerticalGroup(
            PanelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRosa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(PanelBlancoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(PanelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanelListaInvitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalendarioActionPerformed

    private void btnGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGruposActionPerformed
       
    }//GEN-LAST:event_btnGruposActionPerformed

    private void btnEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventosActionPerformed
        ControlCrearEvento.getInstancia().mostrarVentanaPrincipal();
        this.dispose();
    }//GEN-LAST:event_btnEventosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBlanco;
    private javax.swing.JLabel PanelLogo;
    private javax.swing.JPanel PanelRosa;
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnEventos;
    private javax.swing.JButton btnGrupos;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelListaInvitaciones;
    // End of variables declaration//GEN-END:variables
}

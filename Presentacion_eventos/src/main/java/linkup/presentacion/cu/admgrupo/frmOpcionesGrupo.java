/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion.cu.admGrupo;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import linkup.exception.NegocioException;
import linkup.objetosnegocio.UsuarioON;
import linkup.objetosnegocio.cu.admgrupo.Grupo;
import linkup.objetosnegocio.cu.admgrupo.UsuarioAG;
import linkup.presentacion.control.ControlAdministrarGrupo;
import linkup.presentacion.control.ControlCrearEvento;


/**
 *
 * @author gael_
 */
public class frmOpcionesGrupo extends javax.swing.JFrame {
 
    public ControlAdministrarGrupo controlador;
    private Grupo grupo;
    /**
     * Creates new form frmOpcionesGrupo
     */
    public frmOpcionesGrupo(ControlAdministrarGrupo controlador, Grupo grupo) {
        this.controlador = controlador;
        this.grupo = grupo;
        initComponents();
        setTitle("Opciones grupo");
        labelNombreGrupo.setText(grupo.getNombre());
        setLocationRelativeTo(null);
        llenarTablaUsuarios(mostrarUsuariosGrupo());

    }
    
        private List<UsuarioON> mostrarUsuariosGrupo() {
            List<UsuarioON> usuarios = grupo.getMiembros(); 
            llenarTablaUsuarios(usuarios);
            return usuarios;
        }
        
        private void llenarTablaUsuarios(List<UsuarioON> usuarios) {
            
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaUsuarios.getModel();
            modeloTabla.setRowCount(0);
            
            for(UsuarioON u : usuarios){
                Object[] fila = {
                    u.getNombre()
                };
                modeloTabla.addRow(fila);
            }
            
            JTableHeader header = tablaUsuarios.getTableHeader();
            Font fuenteEncabezadoGrande = new Font(header.getFont().getName(), Font.BOLD, 16); 
            header.setFont(fuenteEncabezadoGrande);
            header.setBackground(new Color(102, 0, 102));
            header.setForeground(Color.WHITE);
            tablaUsuarios.setRowHeight(20);
            
        }
        
        private void eliminarUsuarioSeleccionado() {
            int filaSeleccionada = tablaUsuarios.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un usuario para eliminar.");
                return;
            }

            String nombreUsuario = (String) tablaUsuarios.getValueAt(filaSeleccionada, 0);

            UsuarioON usuarioAEliminar = null;
            for (UsuarioON u : grupo.getMiembros()) {
                if (u.getNombre().equals(nombreUsuario)) {
                    usuarioAEliminar = u;
                    break;
                }
            }

            if (usuarioAEliminar != null) {
                int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "Eliminar un usuario del grupo es una acción permanente.\n¿Estás seguro de que deseas continuar?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    controlador.eliminarUsuario(grupo, usuarioAEliminar);
                    JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.");

                    if (grupo.getMiembros().isEmpty()) {
                        controlador.eliminarGrupo(grupo);
                        JOptionPane.showMessageDialog(this, "Como ya no hay usuarios, el grupo ha sido eliminado.");
                        this.dispose(); 
                        controlador.mostrarVentanaPrincipalGrupos();
                    } else {
                        llenarTablaUsuarios(grupo.getMiembros()); 
                    }
                }
              } else {
                JOptionPane.showMessageDialog(this, "No se pudo encontrar el usuario.");
            }
        }

        
        public void eliminarGrupo(){
            int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "Eliminar el grupo es una acción permanente.\n¿Estás seguro de que deseas continuar?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                controlador.eliminarGrupo(grupo);
                JOptionPane.showMessageDialog(this, "Grupo eliminado exitosamente.");
                this.dispose(); 
            }
        } 
    
        public void cambiarNombre() throws exception.NegocioException{
            String nuevoNombre = JOptionPane.showInputDialog(
            this,
            "Ingresa el nuevo nombre del grupo:",
            grupo.getNombre()
            );
            
            try {
                controlador.cambiarNombreGrupo(grupo, nuevoNombre);
                JOptionPane.showMessageDialog(this, "Nombre del grupo actualizado exitosamente.");
                labelNombreGrupo.setText(grupo.getNombre()); 
            } catch (NegocioException e) {
                JOptionPane.showMessageDialog(this, "Error al cambiar el nombre del grupo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        PanelRosa = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        btnGrupos = new javax.swing.JButton();
        btnEventos = new javax.swing.JButton();
        PanelLogo = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JButton();
        PanelPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BotonCambiarNombre = new javax.swing.JButton();
        labelNombreGrupo = new javax.swing.JLabel();
        BotonEliminarGrupo = new javax.swing.JButton();
        BotonEliminarUsuario = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1160, 750));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        PanelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LINK UP.png"))); // NOI18N

        BotonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonregresar.png"))); // NOI18N
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });

        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BotonCambiarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonEditarNombre.png"))); // NOI18N
        BotonCambiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCambiarNombreActionPerformed(evt);
            }
        });

        labelNombreGrupo.setFont(new java.awt.Font("Futura Book", 0, 24)); // NOI18N
        labelNombreGrupo.setText("nombreGrupo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(labelNombreGrupo)
                .addGap(100, 100, 100)
                .addComponent(BotonCambiarNombre)
                .addContainerGap(338, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(BotonCambiarNombre))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(labelNombreGrupo)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        BotonEliminarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonEliminarGrupo.png"))); // NOI18N
        BotonEliminarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarGrupoActionPerformed(evt);
            }
        });

        BotonEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonEliminarUsuario.png"))); // NOI18N
        BotonEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarUsuarioActionPerformed(evt);
            }
        });

        tablaUsuarios.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tablaUsuarios.setForeground(new java.awt.Color(148, 63, 75));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Usuarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(BotonEliminarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonEliminarGrupo)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonEliminarGrupo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonEliminarUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PanelRosa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(BotonRegresar)
                        .addGap(28, 28, 28)
                        .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(PanelLogo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRosa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelLogo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonRegresar))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarUsuarioActionPerformed
        eliminarUsuarioSeleccionado();
    }//GEN-LAST:event_BotonEliminarUsuarioActionPerformed

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        this.dispose();
        controlador.accederGrupo(grupo);
    }//GEN-LAST:event_BotonRegresarActionPerformed

    private void BotonEliminarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarGrupoActionPerformed
        eliminarGrupo();
        this.dispose();
        controlador.mostrarVentanaPrincipalGrupos();
    }//GEN-LAST:event_BotonEliminarGrupoActionPerformed

    private void BotonCambiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCambiarNombreActionPerformed
        try {
            cambiarNombre();
        } catch (exception.NegocioException ex) {
            Logger.getLogger(frmOpcionesGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonCambiarNombreActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalendarioActionPerformed

    private void btnGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGruposActionPerformed
        ControlAdministrarGrupo.getInstancia().iniciarFlujoGrupos();
        this.dispose();
    }//GEN-LAST:event_btnGruposActionPerformed

    private void btnEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventosActionPerformed
        ControlCrearEvento.getInstancia().mostrarVentanaPrincipal();
        this.dispose();
    }//GEN-LAST:event_btnEventosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCambiarNombre;
    private javax.swing.JButton BotonEliminarGrupo;
    private javax.swing.JButton BotonEliminarUsuario;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JLabel PanelLogo;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelRosa;
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnEventos;
    private javax.swing.JButton btnGrupos;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelNombreGrupo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linkup.presentacion.cu.admGrupo;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import linkup.dtosnegocios.cu.admgrupo.GrupoDTO;
import linkup.objetosnegocio.UsuarioON;
import linkup.objetosnegocio.cu.admgrupo.Grupo;
import linkup.objetosnegocio.fabrica.FabricaObjetosNegocio;
import linkup.presentacion.control.ControlAdministrarGrupo;
import linkup.presentacion.control.ControlCrearEvento;


/**
 *
 * @author gael_
 */
public class frmCrearGrupo extends javax.swing.JFrame {

    public ControlAdministrarGrupo controlador;
    
    /**
     * Creates new form frmCrearGrupo
     */
    public frmCrearGrupo(ControlAdministrarGrupo controlador) {
        this.controlador = controlador;
        initComponents();
        this.TablaUsuarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        setTitle("Crear Grupo");
        setLocationRelativeTo(null);
        LlenarTablaMiembrosAInvitar();
    }
    
   public void LlenarTablaMiembrosAInvitar(){

       
       List<UsuarioON> usuariosDisponibles = UsuarioON.toUsuarioONList(FabricaObjetosNegocio.crearUsuarioON().obtenerTodosLosUsuarios());


        DefaultTableModel modeloTabla = (DefaultTableModel) this.TablaUsuarios.getModel();
        modeloTabla.setRowCount(0);

        TablaUsuarios.setRowHeight(30);

        String usuarioActual = UsuarioON.getInstance().getNombre();
        for (UsuarioON usuario : usuariosDisponibles) {
             if (!usuario.getNombre().equalsIgnoreCase(usuarioActual)) {
                modeloTabla.addRow(new Object[]{usuario.getNombre()});
            }
        }
    }
    
    public List<UsuarioON> seleccionarMiembros(){
            int[] filasSeleccionadas = TablaUsuarios.getSelectedRows();
            if (filasSeleccionadas.length == 0) {
                
                return null;
            }
       
            List<UsuarioON> miembrosSeleccionados = new ArrayList<>();
            DefaultTableModel modelo = (DefaultTableModel) TablaUsuarios.getModel();
            
            String usuarioActual = UsuarioON.getInstance().getNombre();
            List<UsuarioON> todosLosUsuarios = UsuarioON.toUsuarioONList(FabricaObjetosNegocio.crearUsuarioON().obtenerTodosLosUsuarios());
            
            for (int fila : filasSeleccionadas) {
                String nombreSeleccionado = (String) modelo.getValueAt(fila, 0);

                if (nombreSeleccionado.equalsIgnoreCase(usuarioActual)) {
                    continue;
                }

                for (UsuarioON usuario : todosLosUsuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(nombreSeleccionado)) {
                        miembrosSeleccionados.add(usuario);
                        break; // Para evitar agregar duplicados si hay varios con mismo nombre
                    }
                }
            }

            return miembrosSeleccionados;
    }
    
    public void crearGrupo(){
        String nombreGrupo = this.txtNombreGrupo.getText();
        
        if (nombreGrupo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del grupo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        List<Grupo> gruposExistentes = controlador.obtenerGrupos();
        for (Grupo grupo : gruposExistentes) {
            if (grupo.getNombre().equalsIgnoreCase(nombreGrupo)) {
                JOptionPane.showMessageDialog(this, "Ya existe un grupo con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        List<UsuarioON> miembrosSeleccionados = seleccionarMiembros();
        
        if (miembrosSeleccionados == null || miembrosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar al menos un miembro para el grupo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String usuarioActual = UsuarioON.getInstance().getNombre();
        List<String> nombresMiembros = new ArrayList<>();
        nombresMiembros.add(usuarioActual);
        for (UsuarioON u : miembrosSeleccionados) {
            nombresMiembros.add(u.getNombre());
        }
        
        String creador = UsuarioON.getInstance().getUsername();
        
        
        GrupoDTO nuevoGrupoDTO = new GrupoDTO(nombreGrupo, nombresMiembros, creador);
        nuevoGrupoDTO.setMensajes(null);
        controlador.registrarGrupo(nuevoGrupoDTO);

        JOptionPane.showMessageDialog(this, "Grupo creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

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
        jButtonMisAmigos2 = new javax.swing.JButton();
        PanelLogo = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JButton();
        PanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreGrupo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        BotonCrearGrupo = new javax.swing.JButton();

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

        jButtonMisAmigos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmisamigos.png"))); // NOI18N
        jButtonMisAmigos2.setBorder(null);
        jButtonMisAmigos2.setContentAreaFilled(false);
        jButtonMisAmigos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMisAmigos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMisAmigos2ActionPerformed(evt);
            }
        });
        PanelRosa.add(jButtonMisAmigos2);
        jButtonMisAmigos2.setBounds(10, 280, 40, 40);

        PanelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LINK UP.png"))); // NOI18N

        BotonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonregresar.png"))); // NOI18N
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });

        PanelPrincipal.setBackground(new java.awt.Color(253, 166, 179));
        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del grupo:");

        txtNombreGrupo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreGrupo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 63, 75)));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Agregar miembros:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(148, 63, 75)));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        TablaUsuarios.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TablaUsuarios.setForeground(new java.awt.Color(148, 63, 75));
        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        TablaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(TablaUsuarios);

        BotonCrearGrupo.setBackground(new java.awt.Color(253, 166, 179));
        BotonCrearGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linkupbotonsiguiente.png"))); // NOI18N
        BotonCrearGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombreGrupo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(BotonCrearGrupo)
                        .addGap(23, 23, 23))))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonCrearGrupo)
                        .addGap(20, 20, 20))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout PanelBlancoLayout = new javax.swing.GroupLayout(PanelBlanco);
        PanelBlanco.setLayout(PanelBlancoLayout);
        PanelBlancoLayout.setHorizontalGroup(
            PanelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBlancoLayout.createSequentialGroup()
                .addComponent(PanelRosa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBlancoLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(BotonRegresar)
                        .addGap(24, 24, 24)
                        .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBlancoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PanelLogo)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        PanelBlancoLayout.setVerticalGroup(
            PanelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRosa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(PanelBlancoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(PanelLogo)
                .addGap(41, 41, 41)
                .addGroup(PanelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void BotonCrearGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearGrupoActionPerformed
        crearGrupo();
        this.dispose();
        controlador.mostrarVentanaPrincipalGrupos();
    }//GEN-LAST:event_BotonCrearGrupoActionPerformed

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        this.dispose();
        controlador.mostrarVentanaPrincipalGrupos();
    }//GEN-LAST:event_BotonRegresarActionPerformed

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

    private void jButtonMisAmigos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMisAmigos2ActionPerformed
        ControlCrearEvento.getInstancia().mostrarAgregarContactos();
        this.dispose();
    }//GEN-LAST:event_jButtonMisAmigos2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCrearGrupo;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JPanel PanelBlanco;
    private javax.swing.JLabel PanelLogo;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelRosa;
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnEventos;
    private javax.swing.JButton btnGrupos;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonMisAmigos;
    private javax.swing.JButton jButtonMisAmigos1;
    private javax.swing.JButton jButtonMisAmigos2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombreGrupo;
    // End of variables declaration//GEN-END:variables
}

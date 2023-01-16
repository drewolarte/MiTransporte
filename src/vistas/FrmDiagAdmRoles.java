package vistas;

import clases.Rol;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.RolDB;

public class FrmDiagAdmRoles extends javax.swing.JDialog {

    FondoPanelAdmRoles fondo = new FondoPanelAdmRoles();

    DefaultTableModel modeloTablaRoles;
    DefaultTableModel modeloTablaPermisos;
    RolDB objRolDB = new RolDB();

    public FrmDiagAdmRoles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setContentPane(fondo);
        initComponents();
        this.configurarTablaRoles();
        this.refrescarTablaRoles();
    }

    private void configurarTablaRoles() {
        String cabecera[] = {"ID", "Rol"};
        String datos[][] = {};
        this.modeloTablaRoles = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblListaRoles.setModel(this.modeloTablaRoles);
    }

    private void refrescarTablaRoles() {

        this.modeloTablaRoles.setNumRows(0);

        String filaDeTabla[] = new String[2];

        for (Object obj : objRolDB.listarTodos()) {
            Rol objRol = (Rol) obj;
            filaDeTabla[0] = Integer.toString(objRol.getId());
            filaDeTabla[1] = objRol.getRol();

            this.modeloTablaRoles.addRow(filaDeTabla);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanelAdmRoles();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaRoles = new javax.swing.JTable();
        btnInsertarRoles = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnActualizarRoles = new javax.swing.JButton();
        btnEliminarRoles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Roles");

        tblListaRoles.setBackground(new java.awt.Color(0, 0, 0));
        tblListaRoles.setForeground(new java.awt.Color(255, 255, 255));
        tblListaRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblListaRoles);

        btnInsertarRoles.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        btnInsertarRoles.setText("Insertar");
        btnInsertarRoles.setBorderPainted(false);
        btnInsertarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarRolesActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorderPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnActualizarRoles.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        btnActualizarRoles.setText("Actualizar");
        btnActualizarRoles.setBorderPainted(false);
        btnActualizarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRolesActionPerformed(evt);
            }
        });

        btnEliminarRoles.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        btnEliminarRoles.setText("Eliminar");
        btnEliminarRoles.setBorderPainted(false);
        btnEliminarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsertarRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(189, 189, 189))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarRolesActionPerformed
        FrmDiagInsertarRol objFrmDiagInsRol = new FrmDiagInsertarRol(null, true);
        objFrmDiagInsRol.setLocationRelativeTo(null);
        objFrmDiagInsRol.setVisible(true);

        this.refrescarTablaRoles();
    }//GEN-LAST:event_btnInsertarRolesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActualizarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRolesActionPerformed
        int fila = this.tblListaRoles.getSelectedRow();
        if (fila >= 0) {
            int rolId = Integer.parseInt(this.tblListaRoles.getValueAt(fila, 0).toString());
            FrmDiagActualizarRol objFrmDiagActRol = new FrmDiagActualizarRol(null, true, rolId);
            objFrmDiagActRol.setLocationRelativeTo(null);
            objFrmDiagActRol.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un rol para modificarlo.");
        }

        this.refrescarTablaRoles();
    }//GEN-LAST:event_btnActualizarRolesActionPerformed

    private void btnEliminarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRolesActionPerformed
        int fila = this.tblListaRoles.getSelectedRow();
        if (fila >= 0) {
            Rol objRol = new Rol();
            int rolId = Integer.parseInt(this.tblListaRoles.getValueAt(fila, 0).toString());
            objRol.setId(rolId);

            if (objRolDB.eliminar(objRol)) {
                JOptionPane.showMessageDialog(this, "El rol fue eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el rol.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un rol para eliminarlo.");
        }

        this.refrescarTablaRoles();
    }//GEN-LAST:event_btnEliminarRolesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarRoles;
    private javax.swing.JButton btnEliminarRoles;
    private javax.swing.JButton btnInsertarRoles;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaRoles;
    // End of variables declaration//GEN-END:variables
}

class FondoPanelAdmRoles extends JPanel {

    private Image imagen;

    @Override
    public void paint(Graphics g) {

        imagen = new ImageIcon(getClass().getResource("/imagenes/MiTransporteItems.jpg")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);

    }
}

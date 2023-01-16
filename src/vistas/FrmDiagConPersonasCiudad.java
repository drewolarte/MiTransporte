package vistas;

import clases.Persona;
import clases.Rol;
import javax.swing.table.DefaultTableModel;
import modelo.PersonaDB;
import modelo.RolDB;

public class FrmDiagConPersonasCiudad extends javax.swing.JDialog {

    FondoPanelAcEnv fondo = new FondoPanelAcEnv();

    DefaultTableModel modeloTabla;
    PersonaDB objPerDB = new PersonaDB();
    Persona objPersona = new Persona();

    public FrmDiagConPersonasCiudad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setContentPane(fondo);
        initComponents();
        this.configurarTabla();
        this.refrescarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"ID", "Documento", "Nombres", "Apellidos", "Dirección", "Ciudad", "Teléfono", "Email", "Rol"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblListaPersona.setModel(this.modeloTabla);
    }

    private void refrescarTabla() {

        this.modeloTabla.setNumRows(0);

        String filaDeTabla[] = new String[9];

        for (Object obj : objPerDB.listarTodos()) {

            Persona objPer = (Persona) obj;
            if (objPersona.getCiudad().equalsIgnoreCase(objPer.getCiudad())) {
                filaDeTabla[0] = Integer.toString(objPer.getId());
                filaDeTabla[1] = objPer.getDocumento();
                filaDeTabla[2] = objPer.getNombre();
                filaDeTabla[3] = objPer.getApellido();
                filaDeTabla[4] = objPer.getDireccion();
                filaDeTabla[5] = objPer.getCiudad();
                filaDeTabla[6] = objPer.getTelefono();
                filaDeTabla[7] = objPer.getEmail();
                filaDeTabla[8] = obtenerNombreRol(objPer);

                this.modeloTabla.addRow(filaDeTabla);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanelAcEnv();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaPersona = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbCiudad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar Usuarios");

        tblListaPersona.setBackground(new java.awt.Color(0, 0, 0));
        tblListaPersona.setForeground(new java.awt.Color(255, 255, 255));
        tblListaPersona.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListaPersona);

        btnSalir.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorderPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Escoja la ciudad");

        cmbCiudad.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cmbCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chiquinquirá (Boyacá)", "Duitama (Boyacá)", "Paipa (Boyacá)", "Sogamoso (Boyacá)", "Tunja (Boyacá)", "Bogotá (Cundinamarca)", "Chía (Cundinamarca)", "Facatativá (Cundinamarca)", "Fusagasugá (Cundinamarca)", "Girardot (Cundinamarca)", "Soacha (Cundinamarca)", "Zipaquirá (Cundinamarca)", "Chaparral (Tolima)", "Espinal (Tolima)", "Honda (Tolima)", "Ibagué (Tolima)", "Melgar (Tolima)", "Rovira (Tolima)", "Saldaña (Tolima)" }));
        cmbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel2)
                .addGap(72, 72, 72)
                .addComponent(cmbCiudad, 0, 243, Short.MAX_VALUE)
                .addGap(118, 118, 118))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
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

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cmbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCiudadActionPerformed

        objPersona.setCiudad(cmbCiudad.getSelectedItem().toString());
        this.refrescarTabla();
    }//GEN-LAST:event_cmbCiudadActionPerformed

    public String obtenerNombreRol(Persona objPer) {
        RolDB objRolDB = new RolDB();
        Rol objRol = new Rol();

        objRol = (Rol) objRolDB.listarUno(objPer.getRolId());

        return objRol.getRol();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaPersona;
    // End of variables declaration//GEN-END:variables
}

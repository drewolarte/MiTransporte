package vistas;

import clases.Persona;
import javax.swing.JOptionPane;
import modelo.PersonaDB;

public class FrmDiagConPersonasNumeroCiudad extends javax.swing.JDialog {

    FondoPanelAcEnv fondo = new FondoPanelAcEnv();

    PersonaDB objPerDB = new PersonaDB();
    Persona objPersona = new Persona();

    public FrmDiagConPersonasNumeroCiudad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setContentPane(fondo);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new FondoPanelAcEnv();
        btnSalir4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbCiudadNumeroPersonas = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        btnSalir4.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        btnSalir4.setText("Salir");
        btnSalir4.setBorderPainted(false);
        btnSalir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir4ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Escoja la ciudad");

        cmbCiudadNumeroPersonas.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cmbCiudadNumeroPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chiquinquirá (Boyacá)", "Duitama (Boyacá)", "Paipa (Boyacá)", "Sogamoso (Boyacá)", "Tunja (Boyacá)", "Bogotá (Cundinamarca)", "Chía (Cundinamarca)", "Facatativá (Cundinamarca)", "Fusagasugá (Cundinamarca)", "Girardot (Cundinamarca)", "Soacha (Cundinamarca)", "Zipaquirá (Cundinamarca)", "Chaparral (Tolima)", "Espinal (Tolima)", "Honda (Tolima)", "Ibagué (Tolima)", "Melgar (Tolima)", "Rovira (Tolima)", "Saldaña (Tolima)" }));
        cmbCiudadNumeroPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCiudadNumeroPersonasActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Consultar Usuarios");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(cmbCiudadNumeroPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnSalir4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel11)
                .addGap(34, 34, 34)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cmbCiudadNumeroPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnSalir4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir4ActionPerformed

    private void cmbCiudadNumeroPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCiudadNumeroPersonasActionPerformed

        objPersona.setCiudad(cmbCiudadNumeroPersonas.getSelectedItem().toString());

        int contador = 0;

        for (Object obj : objPerDB.listarTodos()) {
            Persona objPer = (Persona) obj;
            if (objPersona.getCiudad().equalsIgnoreCase(objPer.getCiudad())) {
                contador++;
            }
        }

        JOptionPane.showMessageDialog(null, "El número de usuarios en " + objPersona.getCiudad() + " es: " + contador + ".");
    }//GEN-LAST:event_cmbCiudadNumeroPersonasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir4;
    private javax.swing.JComboBox<String> cmbCiudadNumeroPersonas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}

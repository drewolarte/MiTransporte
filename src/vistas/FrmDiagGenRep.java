package vistas;

import clases.Envio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EnvioDB;

public class FrmDiagGenRep extends javax.swing.JDialog {

    FondoPanelAdmEnv fondo = new FondoPanelAdmEnv();

    DefaultTableModel modeloTabla;
    EnvioDB objEnvDB = new EnvioDB();
    Envio objEnvio = new Envio();
    ArrayList<Object> listaReporteEnvio = new ArrayList<>();

    public FrmDiagGenRep(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setContentPane(fondo);
        initComponents();
        this.configurarTabla();
        this.refrescarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"ID", "Descripción", "Dirección", "Ciudad destino", "Ciudad origen", "Fecha Envío", "Costo", "Observaciones"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblRepEnvios.setModel(this.modeloTabla);
    }

    private void refrescarTabla() {

        this.modeloTabla.setNumRows(0);

        String filaDeTabla[] = new String[8];

        for (Object obj : listaReporteEnvio) {
            Envio objEnv = (Envio) obj;
            filaDeTabla[0] = Integer.toString(objEnv.getId());
            filaDeTabla[1] = objEnv.getDescripcion();
            filaDeTabla[2] = objEnv.getDireccion();
            filaDeTabla[3] = objEnv.getCiudadDestino();
            filaDeTabla[4] = objEnv.getCiudadOrigen();
            filaDeTabla[5] = objEnv.getFechaEnvio();
            filaDeTabla[6] = Double.toString(objEnv.getCosto());
            filaDeTabla[7] = objEnv.getObservaciones();

            this.modeloTabla.addRow(filaDeTabla);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanelAdmEnv();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRepEnvios = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dateFechaInicio = new com.toedter.calendar.JDateChooser();
        dateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbCiudadOrigen = new javax.swing.JComboBox<>();
        lblTotalEnvios = new javax.swing.JLabel();
        lblTotalCostos = new javax.swing.JLabel();
        lblTotalPersonas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Seleccione el periodo de tiempo a consultar:");

        tblRepEnvios.setBackground(new java.awt.Color(0, 0, 0));
        tblRepEnvios.setForeground(new java.awt.Color(255, 255, 255));
        tblRepEnvios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRepEnvios);

        btnConsultar.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setBorderPainted(false);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reporte Envíos");

        dateFechaInicio.setDateFormatString("yyyy/MM/dd");
        dateFechaInicio.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        dateFechaFin.setDateFormatString("yyyy/MM/dd");
        dateFechaFin.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha final:");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha inicial:");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Seleccione la ciudad de origen :");

        cmbCiudadOrigen.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cmbCiudadOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chiquinquirá (Boyacá)", "Duitama (Boyacá)", "Paipa (Boyacá)", "Sogamoso (Boyacá)", "Tunja (Boyacá)", "Bogotá (Cundinamarca)", "Chía (Cundinamarca)", "Facatativá (Cundinamarca)", "Fusagasugá (Cundinamarca)", "Girardot (Cundinamarca)", "Soacha (Cundinamarca)", "Zipaquirá (Cundinamarca)", "Chaparral (Tolima)", "Espinal (Tolima)", "Honda (Tolima)", "Ibagué (Tolima)", "Melgar (Tolima)", "Rovira (Tolima)", "Saldaña (Tolima)" }));

        lblTotalEnvios.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lblTotalEnvios.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalEnvios.setText("                                                                   ");

        lblTotalCostos.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lblTotalCostos.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalCostos.setText("                                                                   ");

        lblTotalPersonas.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lblTotalPersonas.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPersonas.setText("                                                                   ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(104, 104, 104))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(405, 405, 405))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalPersonas)
                            .addComponent(lblTotalCostos)
                            .addComponent(lblTotalEnvios)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(cmbCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTotalEnvios)
                .addGap(18, 18, 18)
                .addComponent(lblTotalCostos)
                .addGap(18, 18, 18)
                .addComponent(lblTotalPersonas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        HashSet<Integer> listaIdPersonas = new HashSet<>();
        listaReporteEnvio.clear();
        listaIdPersonas.clear();
        objEnvio.setCiudadOrigen(cmbCiudadOrigen.getSelectedItem().toString());
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = this.dateFechaInicio.getDate();
        Date fechaFin = this.dateFechaFin.getDate();
        int contadorEnvio = 0;
        double costoTotal = 0;

        if (fechaFin.before(fechaInicio)) {
            JOptionPane.showMessageDialog(null, "Por favor verifique que la fecha final sea más reciente o igual que la fecha inicial.");
            lblTotalCostos.setText("");
            lblTotalEnvios.setText("");
            lblTotalPersonas.setText("");

        } else {
            for (Object obj : objEnvDB.listarTodos()) {
                Envio objEnv = (Envio) obj;
                if (objEnv.getCiudadOrigen().equalsIgnoreCase(objEnvio.getCiudadOrigen())) {
                    try {
                        Date fechaEnvio = dFormat.parse(objEnv.getFechaEnvio());

                        if ((fechaEnvio.after(fechaInicio) || fechaEnvio.equals(fechaInicio)) && (fechaEnvio.before(fechaFin) || fechaEnvio.equals(fechaFin))) {
                            listaIdPersonas.add(objEnv.getPersonaId());
                            contadorEnvio++;
                            costoTotal += objEnv.getCosto();
                            listaReporteEnvio.add(objEnv);
                        }

                    } catch (ParseException ex) {
                        Logger.getLogger(FrmDiagGenRep.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            lblTotalCostos.setText("El costo total de los envíos despachados desde la ciudad de " + objEnvio.getCiudadOrigen() + " es: $" + costoTotal + ".");
            lblTotalEnvios.setText("El número total de envíos despachados desde la ciudad de " + objEnvio.getCiudadOrigen() + " es: " + contadorEnvio + ".");
            lblTotalPersonas.setText("El número total de personas que realizaron envíos desde la ciudad de " + objEnvio.getCiudadOrigen() + " es: " + listaIdPersonas.size() + ".");
        }

        this.refrescarTabla();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbCiudadOrigen;
    private com.toedter.calendar.JDateChooser dateFechaFin;
    private com.toedter.calendar.JDateChooser dateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalCostos;
    private javax.swing.JLabel lblTotalEnvios;
    private javax.swing.JLabel lblTotalPersonas;
    private javax.swing.JTable tblRepEnvios;
    // End of variables declaration//GEN-END:variables
}

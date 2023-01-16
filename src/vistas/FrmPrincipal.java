package vistas;

import clases.AsignarPermisos;
import clases.Persona;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrmPrincipal extends javax.swing.JFrame {

    FondoPanelPrincipal fondo = new FondoPanelPrincipal();

    public FrmPrincipal(Persona usuarioEnSesion) {
        this.setContentPane(fondo);
        initComponents();
        this.cargarPermisos(usuarioEnSesion);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new FondoPanelPrincipal();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        submenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        submenuConPersonas = new javax.swing.JMenu();
        submenuConPersonaDocumento = new javax.swing.JMenuItem();
        submenuConPersonaCiudad = new javax.swing.JMenuItem();
        submenuConPersonaNumero = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        submenuGesEnvUsu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        submenuGenRep = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        submenuAdmPersonas = new javax.swing.JMenuItem();
        submenuAdmEnvios = new javax.swing.JMenuItem();
        submenuAdmRoles = new javax.swing.JMenuItem();
        submenuAdmContrasenas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        submenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(getSize());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Mi Transporte");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 191, 0, 179);
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(185, 191, 0, 179);
        jPanel1.add(jSeparator1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 190, 179);
        jPanel1.add(jSeparator2, gridBagConstraints);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(136, 30));

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N

        submenuSalir.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuSalir.setText("Salir");
        submenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(submenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Usuarios");
        jMenu2.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N

        submenuConPersonas.setText("Consultar Usuarios");
        submenuConPersonas.setEnabled(false);
        submenuConPersonas.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N

        submenuConPersonaDocumento.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuConPersonaDocumento.setText("Por Documento");
        submenuConPersonaDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuConPersonaDocumentoActionPerformed(evt);
            }
        });
        submenuConPersonas.add(submenuConPersonaDocumento);

        submenuConPersonaCiudad.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuConPersonaCiudad.setText("Por Ciudad");
        submenuConPersonaCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuConPersonaCiudadActionPerformed(evt);
            }
        });
        submenuConPersonas.add(submenuConPersonaCiudad);

        submenuConPersonaNumero.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuConPersonaNumero.setText("Número de Usuarios por Ciudad");
        submenuConPersonaNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuConPersonaNumeroActionPerformed(evt);
            }
        });
        submenuConPersonas.add(submenuConPersonaNumero);

        jMenu2.add(submenuConPersonas);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Envíos");
        jMenu3.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N

        submenuGesEnvUsu.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuGesEnvUsu.setText("Gestionar Envíos de Usuarios");
        submenuGesEnvUsu.setEnabled(false);
        submenuGesEnvUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuGesEnvUsuActionPerformed(evt);
            }
        });
        jMenu3.add(submenuGesEnvUsu);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Reportes");
        jMenu6.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N

        submenuGenRep.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuGenRep.setText("Generar Reportes");
        submenuGenRep.setEnabled(false);
        submenuGenRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuGenRepActionPerformed(evt);
            }
        });
        jMenu6.add(submenuGenRep);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Configuración");
        jMenu5.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N

        submenuAdmPersonas.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuAdmPersonas.setText("Administrar Usuarios");
        submenuAdmPersonas.setEnabled(false);
        submenuAdmPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmPersonasActionPerformed(evt);
            }
        });
        jMenu5.add(submenuAdmPersonas);

        submenuAdmEnvios.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuAdmEnvios.setText("Administrar Envíos");
        submenuAdmEnvios.setEnabled(false);
        submenuAdmEnvios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmEnviosActionPerformed(evt);
            }
        });
        jMenu5.add(submenuAdmEnvios);

        submenuAdmRoles.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuAdmRoles.setText("Administrar Roles");
        submenuAdmRoles.setEnabled(false);
        submenuAdmRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmRolesActionPerformed(evt);
            }
        });
        jMenu5.add(submenuAdmRoles);

        submenuAdmContrasenas.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuAdmContrasenas.setText("Administrar Contraseñas");
        submenuAdmContrasenas.setEnabled(false);
        submenuAdmContrasenas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmContrasenasActionPerformed(evt);
            }
        });
        jMenu5.add(submenuAdmContrasenas);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Acerca de");
        jMenu4.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N

        submenuAcercaDe.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        submenuAcercaDe.setText("Autores");
        submenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAcercaDeActionPerformed(evt);
            }
        });
        jMenu4.add(submenuAcercaDe);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_submenuSalirActionPerformed

    private void submenuAdmEnviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmEnviosActionPerformed
        FrmDiagAdmEnvio objFrmAdmEnvio = new FrmDiagAdmEnvio(this, true);
        objFrmAdmEnvio.setLocationRelativeTo(null);
        objFrmAdmEnvio.setVisible(true);
    }//GEN-LAST:event_submenuAdmEnviosActionPerformed

    private void submenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAcercaDeActionPerformed
        FrmDiagAcercaDe objFrmAcercaDe = new FrmDiagAcercaDe(this, true);
        objFrmAcercaDe.setLocationRelativeTo(null);
        objFrmAcercaDe.setVisible(true);
    }//GEN-LAST:event_submenuAcercaDeActionPerformed

    private void submenuAdmRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmRolesActionPerformed
        FrmDiagAdmRoles objFrmAdmRol = new FrmDiagAdmRoles(this, true);
        objFrmAdmRol.setLocationRelativeTo(null);
        objFrmAdmRol.setVisible(true);
    }//GEN-LAST:event_submenuAdmRolesActionPerformed

    private void submenuAdmPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmPersonasActionPerformed
        FrmDiagAdmPersonas objFrmAdmPer = new FrmDiagAdmPersonas(this, true);
        objFrmAdmPer.setLocationRelativeTo(null);
        objFrmAdmPer.setVisible(true);
    }//GEN-LAST:event_submenuAdmPersonasActionPerformed

    private void submenuConPersonaDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuConPersonaDocumentoActionPerformed
        FrmDiagConPersonasDocumento objFrmConPerDoc = new FrmDiagConPersonasDocumento(this, true);
        objFrmConPerDoc.setLocationRelativeTo(null);
        objFrmConPerDoc.setVisible(true);
    }//GEN-LAST:event_submenuConPersonaDocumentoActionPerformed

    private void submenuConPersonaCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuConPersonaCiudadActionPerformed
        FrmDiagConPersonasCiudad objFrmConPerCiu = new FrmDiagConPersonasCiudad(this, true);
        objFrmConPerCiu.setLocationRelativeTo(null);
        objFrmConPerCiu.setVisible(true);
    }//GEN-LAST:event_submenuConPersonaCiudadActionPerformed

    private void submenuConPersonaNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuConPersonaNumeroActionPerformed
        FrmDiagConPersonasNumeroCiudad objFrmConPerNumCiu = new FrmDiagConPersonasNumeroCiudad(this, true);
        objFrmConPerNumCiu.setLocationRelativeTo(null);
        objFrmConPerNumCiu.setVisible(true);
    }//GEN-LAST:event_submenuConPersonaNumeroActionPerformed

    private void submenuGenRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuGenRepActionPerformed
        FrmDiagGenRep objFrmGenRep = new FrmDiagGenRep(this, true);
        objFrmGenRep.setLocationRelativeTo(null);
        objFrmGenRep.setVisible(true);
    }//GEN-LAST:event_submenuGenRepActionPerformed

    private void submenuGesEnvUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuGesEnvUsuActionPerformed
        FrmDiagGesEnvUsu objFrmGesEnvUsu = new FrmDiagGesEnvUsu(this, true);
        objFrmGesEnvUsu.setLocationRelativeTo(null);
        objFrmGesEnvUsu.setVisible(true);
    }//GEN-LAST:event_submenuGesEnvUsuActionPerformed

    private void submenuAdmContrasenasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmContrasenasActionPerformed
        FrmDiagAdmContrasena objFrmAdmCont = new FrmDiagAdmContrasena(this, true);
        objFrmAdmCont.setLocationRelativeTo(null);
        objFrmAdmCont.setVisible(true);
    }//GEN-LAST:event_submenuAdmContrasenasActionPerformed

    private void cargarPermisos(Persona usuarioEnSesion) {

        if (usuarioEnSesion != null) {
            AsignarPermisos objAsigPer = new AsignarPermisos(this, this.obtenerListaDePermisosPorRol(usuarioEnSesion.getRolId()));
            if (!objAsigPer.asignarPermisos()) {
                JOptionPane.showMessageDialog(this, "El usuario no tiene permisos para usar este sistema.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El usuario no tiene permisos para usar este sistema.");
        }

        this.dispose();
    }

    private ArrayList<String> obtenerListaDePermisosPorRol(int idrol) {
        String permisos[][] = new String[6][7];

//Inicializar permisos en vacio
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                permisos[i][j] = "-";
            }
        }

//Permisos del administrador
        permisos[1][0] = "submenuConPersonas";
        permisos[1][1] = "submenuGesEnvUsu";
        permisos[1][2] = "submenuGenRep";
        permisos[1][3] = "submenuAdmPersonas";
        permisos[1][4] = "submenuAdmEnvios";
        permisos[1][5] = "submenuAdmRoles";
        permisos[1][6] = "submenuAdmContrasenas";

//Permisos del cajero
        permisos[2][0] = "submenuConPersonas";
        permisos[2][1] = "submenuGesEnvUsu";
        permisos[2][2] = "submenuGenRep";
        permisos[2][3] = "submenuAdmEnvios";

//Permisos del bodeguero
        permisos[3][0] = "submenuConPersonas";
        permisos[3][1] = "submenuGenRep";

//Permisos del conductor
        permisos[4][0] = "submenuConPersonas";
        permisos[4][1] = "submenuGenRep";

//Permisos del mensajero
        permisos[5][0] = "submenuConPersonas";
        permisos[5][1] = "submenuGenRep";

        ArrayList<String> listaDePermisos = new ArrayList<String>();

        for (int i = 0; i < 7; i++) {
            if (!permisos[idrol][i].equals("-")) {
                listaDePermisos.add(permisos[idrol][i]);
            }
        }

        return listaDePermisos;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem submenuAcercaDe;
    private javax.swing.JMenuItem submenuAdmContrasenas;
    private javax.swing.JMenuItem submenuAdmEnvios;
    private javax.swing.JMenuItem submenuAdmPersonas;
    private javax.swing.JMenuItem submenuAdmRoles;
    private javax.swing.JMenuItem submenuConPersonaCiudad;
    private javax.swing.JMenuItem submenuConPersonaDocumento;
    private javax.swing.JMenuItem submenuConPersonaNumero;
    private javax.swing.JMenu submenuConPersonas;
    private javax.swing.JMenuItem submenuGenRep;
    private javax.swing.JMenuItem submenuGesEnvUsu;
    private javax.swing.JMenuItem submenuSalir;
    // End of variables declaration//GEN-END:variables
}

class FondoPanelPrincipal extends JPanel {

    private Image imagen;

    @Override
    public void paint(Graphics g) {

        imagen = new ImageIcon(getClass().getResource("/imagenes/MiTransportePrincipal.jpg")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);

    }
}

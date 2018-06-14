/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Bienvenidos
 */
public class Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        String[] cuenta = home.getInfoUsuario().split(";");
        String pass = "";
        int lenghtPass = cuenta[1].length() / 2;
        this.nombreUsu.setText(cuenta[0]);
        for (int i = 0; i < lenghtPass; i++) {
            pass += "*";
        }
        this.contraseñaUsu.setText(pass);
        try {
            setIconImage(new ImageIcon(getClass().getResource("../iconos/logoMATHRedimensionado.png")).getImage());
        } catch (Exception ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreUsu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnCambiaSueldos = new javax.swing.JButton();
        btnPermisos = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        contraseñaUsu = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/business_user.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Modo Administrador");

        jLabel3.setText("Administrador:");

        nombreUsu.setEditable(false);
        nombreUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuActionPerformed(evt);
            }
        });

        jLabel4.setText("Contraseña:");

        btnCambiaSueldos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eur@2x.png"))); // NOI18N
        btnCambiaSueldos.setText("Modificar sueldo");
        btnCambiaSueldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiaSueldosActionPerformed(evt);
            }
        });

        btnPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/employee.png"))); // NOI18N
        btnPermisos.setText("Dar permisos de administrador");
        btnPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisosActionPerformed(evt);
            }
        });

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N

        contraseñaUsu.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreUsu)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contraseñaUsu)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(478, 478, 478)
                            .addComponent(btnAtras)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnPermisos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCambiaSueldos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contraseñaUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPermisos)
                    .addComponent(btnCambiaSueldos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiaSueldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiaSueldosActionPerformed
        if (this.buscarUsuario(this.nombreUsu.getText())) {
            vista.ModificarSueldoEmpleados modifSueldo = new vista.ModificarSueldoEmpleados();
            modifSueldo.setLocation(1000, 0);
            modifSueldo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "La cuenta que esta utilizando no es valida.");
        }
    }//GEN-LAST:event_btnCambiaSueldosActionPerformed

    private void btnPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisosActionPerformed
        if (this.buscarUsuario(this.nombreUsu.getText()) != false) {
            vista.DarPermisosAdmin nuevoAdmin = new vista.DarPermisosAdmin();
            nuevoAdmin.setLocation(1000, 0);
            nuevoAdmin.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "La cuenta que esta utilizando no es valida.");
        }
    }//GEN-LAST:event_btnPermisosActionPerformed

    private void nombreUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuActionPerformed

    }//GEN-LAST:event_nombreUsuActionPerformed

    private boolean buscarUsuario(String usuario) {
        File usuariosReales = new File("empleados.csv");
        boolean loginCorrecto = false;
        String linea;
        String[] arrayAnalizado;
        try {
            Scanner sc = new Scanner(usuariosReales);
            while (sc.hasNext()) {
                linea = sc.nextLine();
                arrayAnalizado = linea.split(";");
                if (arrayAnalizado[1].equalsIgnoreCase(usuario)) {
                    if (arrayAnalizado[0].equalsIgnoreCase("Administrador")) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usted no es un administrador. no puede realizar la accion");
                        return false;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCambiaSueldos;
    private javax.swing.JButton btnPermisos;
    private javax.swing.JPasswordField contraseñaUsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombreUsu;
    // End of variables declaration//GEN-END:variables
}

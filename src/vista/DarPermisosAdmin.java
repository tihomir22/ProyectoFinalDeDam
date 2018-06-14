/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Excepciones.empleadoExistente;
import Excepciones.empleadoNoExistente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empleado;
import modelo.EmpleadoAdmin;
import modelo.EmpleadoNormal;

/**
 *
 * @author Bienvenidos
 */
public class DarPermisosAdmin extends javax.swing.JFrame {
    
    private DefaultTableModel dtm;

    /**
     * Creates new form DarPermisosAdmin
     */
    public DarPermisosAdmin() {
        initComponents();
        dtm = new DefaultTableModel();
        this.tablaEmpleados.setModel(dtm);
        dtm.addColumn("Número Empleado");
        dtm.addColumn("Nombre");
        dtm.addColumn("Sueldo");
        dtm.addColumn("DNI");
        llenarTabla();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtAntigüedad = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/business_user.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Dar permisos de administrador");

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero empleado", "Nombre", "Sueldo", "Antigüedad"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        jLabel3.setText("Insertar antigüedad del empleado:");

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAntigüedad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAntigüedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAtras)
                    .addComponent(btnAgregar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Empleado e;
        EmpleadoAdmin ea;
        int row = this.tablaEmpleados.getSelectedRow();
        String nume = this.tablaEmpleados.getValueAt(row, 0).toString().trim();
        int nuevaAnt = Integer.parseInt(this.txtAntigüedad.getText());
        e = controlador.GestionFicheros.getListaTienda().get(0).buscarEmpleado(Integer.parseInt(nume));
        if (e != null) {
            if (this.txtAntigüedad.getText().length() > 0) {
                if (e instanceof EmpleadoNormal) {
                    int ale = (int) (Math.random() * 1000);
                    String dni = e.getDni();
                    String nombre = e.getNombre();
                    double sueldo = e.getSueldo();
                    String cuenta = e.getUsuario();
                    String pass = e.getContrasena();
                    ea = new EmpleadoAdmin(ale, nuevaAnt, dni, nombre, sueldo, cuenta, pass);
                    JOptionPane.showMessageDialog(this, "La antigüedad ha cabiado exitosamente");
                    DefaultTableModel model = (DefaultTableModel) this.tablaEmpleados.getModel();
                    try {
                        controlador.GestionFicheros.eliminarEmpleado(e);
                        controlador.GestionFicheros.listaTienda.get(0).eliminarEmpleado(e);
                        controlador.GestionFicheros.altaEmpleado(ea);
                        controlador.GestionFicheros.listaTienda.get(0).añadirEmpleado(ea);
                        controlador.GestionFicheros.generarUsuariosVerdaderos();
                    } catch (IOException ex) {
                        Logger.getLogger(ModificarNombreEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (empleadoNoExistente | empleadoExistente ex) {
                        Logger.getLogger(DarPermisosAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No puedes dar permisos de administrador a un administrador");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Debes eligir la antigüedad del nuevo administrador");
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DarPermisosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DarPermisosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DarPermisosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DarPermisosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DarPermisosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtAntigüedad;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        ArrayList<Empleado> empleados = controlador.GestionFicheros.getListaTienda().get(0).getListaEmpleados();
        borrarTable();
        for (int i = 0; i < empleados.size(); i++) {
            Empleado emp = empleados.get(i);
            Object[] datos = {emp.getNumEmpleado(), emp.getNombre(), emp.getSueldo(), emp.getDni()};
            dtm.addRow(datos);
            this.tablaEmpleados.setModel(dtm);
        }
    }
    
    private void borrarTable() {
        while (0 < dtm.getRowCount()) {
            dtm.removeRow(0);
        }
    }
    
}

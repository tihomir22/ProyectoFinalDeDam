/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Excepciones.clienteNoExistente;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

/**
 *
 * @author Bienvenidos
 */
public class EliminarCliente extends javax.swing.JFrame {

    /**
     * Creates new form EliminarCliente
     */
    private DefaultTableModel dtm;

    public EliminarCliente() {
        initComponents();
        dtm = new DefaultTableModel();
        this.TablaClientes.setModel(dtm);
        this.
        dtm.addColumn("DNI");
        dtm.addColumn("Nombre");
        dtm.addColumn("Direccion");
        dtm.addColumn("Telefono");
        llenarTabla();
        
        try{
        setIconImage(new ImageIcon(getClass().getResource("../iconos/logoMATHRedimensionado.png")).getImage());
        }catch (Exception ex){
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

        txtTabla = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Direccion", "Telefono"
            }
        ));
        txtTabla.setViewportView(TablaClientes);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Eliminación de cliente");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/substract.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Cliente c;
        //obtener la fila seleccionada
        int row = this.TablaClientes.getSelectedRow();
        //los valores de la fila seleccionada
        String dni = this.TablaClientes.getValueAt(row, 0).toString();
        c = controlador.GestionFicheros.getListaTienda().get(0).buscarCliente(dni);
        try {
            controlador.GestionFicheros.getListaTienda().get(0).eliminarCliente(c);
            controlador.GestionFicheros.bajaCliente(c);
            JOptionPane.showMessageDialog(rootPane, "El cliente fue eliminado exitosamente");
            DefaultTableModel model = (DefaultTableModel)this.TablaClientes.getModel();
            model.removeRow(row);
        } catch (clienteNoExistente ex) {
            Logger.getLogger(EliminarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        super.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane txtTabla;
    // End of variables declaration//GEN-END:variables
private void llenarTabla() {
        ArrayList<Cliente> clientes = controlador.GestionFicheros.getListaTienda().get(0).getListaClientes();
        borrarTable();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cli = clientes.get(i);
            Object[] datos = {cli.getDni(), cli.getNombre(), cli.getDireccion(), cli.getTelefono()};
            dtm.addRow(datos);
            this.TablaClientes.setModel(dtm);
        }
    }

    private void borrarTable() {
        while (0 < dtm.getRowCount()) {
            dtm.removeRow(0);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Factura;
import modelo.Producto;
import modelo.Servicio;

/**
 *
 * @author sportak
 */
public class ListadoFacturas extends javax.swing.JFrame {

    /**
     * Creates new form ListadoClientes
     */
    private DefaultTableModel dtm;
    public Factura activa;

    public ListadoFacturas() {
        initComponents();
        cargarComboClientes();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        darDeAltaFactura = new javax.swing.JButton();
        verLineaBtn = new javax.swing.JButton();
        eliminarLineaBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Facturas del cliente:");

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaFacturas);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Elija un cliente:");

        darDeAltaFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        darDeAltaFactura.setAlignmentY(0.0F);
        darDeAltaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darDeAltaFacturaActionPerformed(evt);
            }
        });

        verLineaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/view (1).png"))); // NOI18N
        verLineaBtn.setAlignmentY(0.0F);
        verLineaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verLineaBtnActionPerformed(evt);
            }
        });

        eliminarLineaBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/substract.png"))); // NOI18N
        eliminarLineaBtn1.setAlignmentY(0.0F);
        eliminarLineaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarLineaBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(verLineaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(darDeAltaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eliminarLineaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 32, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(darDeAltaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminarLineaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verLineaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(522, 522, 522))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxClienteActionPerformed

        if (this.comboBoxCliente.getSelectedItem() != null) {
            //System.out.println(this.comboBoxCliente.getSelectedItem());
            dtm = new DefaultTableModel();
            this.tablaFacturas.setModel(dtm);
            dtm.addColumn("ID Factura");
            dtm.addColumn("Metodo de Pago");
            dtm.addColumn("Fecha");
            dtm.addColumn("Importe");

            String[] datos = this.comboBoxCliente.getSelectedItem().toString().split(":");
            Cliente c = controlador.GestionFicheros.listaTienda.get(0).buscarCliente(datos[0].trim());

            if (c != null) {
                llenarTablaFactura(c);
            } else {
                System.out.println("No fue encontrado el cliente!");
            }
        }

    }//GEN-LAST:event_comboBoxClienteActionPerformed

    private void darDeAltaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darDeAltaFacturaActionPerformed
        generarFactura gf = new generarFactura();
        gf.setLocation(1075, 0);
        gf.setVisible(true);
    }//GEN-LAST:event_darDeAltaFacturaActionPerformed

    private void verLineaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verLineaBtnActionPerformed
        int row = this.tablaFacturas.getSelectedRow();
        String codigo = this.tablaFacturas.getValueAt(row, 0).toString();
        activa = controlador.GestionFicheros.buscarFactura(codigo);
        if (this.activa != null) {
            File file = new File("tienda/facturas/PDF/" + activa.getId() + "ConIMG.pdf");
            if (file.toString().endsWith(".pdf")) {
                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
                } catch (IOException ex) {
                    Logger.getLogger(ListadoFacturas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ListadoFacturas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes eligir una factura antes de visualizarla");
        }
    }//GEN-LAST:event_verLineaBtnActionPerformed

    private void eliminarLineaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarLineaBtn1ActionPerformed
        int row = this.tablaFacturas.getSelectedRow();
        if (row != -1) {
            if (JOptionPane.showConfirmDialog(rootPane, "Seguro que deseas eliminar la factura? Se eliminará de la lista,el pdf y el csv!") == 0) {
                Factura f;
                String codigo = this.tablaFacturas.getValueAt(row, 0).toString();
                this.dtm.removeRow(row);
                f = controlador.GestionFicheros.buscarFactura(codigo);

                if (f != null) {
                    System.out.println(f.toString());
                    controlador.GestionFicheros.borrarFactura(f);
                } else {
                    System.out.println("No fue encontrado!");
                }
                int i = 0;
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes eligir una factura a la que eliminar!");
        }

    }//GEN-LAST:event_eliminarLineaBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(ListadoFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxCliente;
    private javax.swing.JButton darDeAltaFactura;
    private javax.swing.JButton eliminarLineaBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JButton verLineaBtn;
    // End of variables declaration//GEN-END:variables
private void cargarComboClientes() {
        this.comboBoxCliente.removeAllItems();
        ArrayList<Cliente> listaClientes = controlador.GestionFicheros.getListaTienda().get(0).getListaClientes();
        for (int i = 0; i < listaClientes.size(); i++) {
            this.comboBoxCliente.addItem(listaClientes.get(i).getDni() + " : " + listaClientes.get(i).getNombre());
        }
    }

    private void llenarTablaFactura(Cliente c) {
        ArrayList<Factura> listaFacturas = c.getFacturas();
        borrarTablaFacturas();
        for (int i = 0; i < listaFacturas.size(); i++) {

            Factura factura = listaFacturas.get(i);
            Object[] datos = {factura.getId(), factura.getMp(), factura.getFecha(), factura.getImporte()};
            dtm.addRow(datos);
            this.tablaFacturas.setModel(dtm);

        }
    }

    private void borrarTablaFacturas() {
        while (0 < dtm.getRowCount()) {
            dtm.removeRow(0);
        }
    }
}
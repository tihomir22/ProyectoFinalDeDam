/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Excepciones.clienteExistente;
import Excepciones.empleadoExistente;
import Excepciones.lineaFacturaExistente;
import Excepciones.productoExistente;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Tienda;

/**
 *
 * @author link
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    private boolean loginExitoso = false;
    private boolean accesoAdmin = false;
    private boolean modoInvitado = false;
    private static String infoUsuario;

    public static String getInfoUsuario() {
        return infoUsuario;
    }

    public static void setInfoUsuario(String infoUsuario) {
        home.infoUsuario = infoUsuario;
    }

    public home() {
        initComponents();
        this.estadoVisual.setBackground(Color.red);
        this.invitado.setVisible(false);
        this.invitado.setForeground(Color.white);
        this.informeEstado.setForeground(Color.white);
        this.jLabel3.setForeground(Color.white);
        this.jLabel4.setForeground(Color.white);
        this.txtAdministrador.setForeground(Color.white);
        this.txtAdministrador.setVisible(false);
        this.cuadroAdmin.setVisible(false);
        Tienda t = new Tienda("MATH", " Avinguda de les Corts Valencianes, s/n, 46800 Xàtiva, València", "454354", "64656454", "http://ieslluissimarro.org/");
        controlador.GestionFicheros.listaTienda.add(t);
        try {
            controlador.GestionFicheros.generacionDeEstructurasBasicas();
            controlador.GestionFicheros.cargarCliente();
            controlador.GestionFicheros.cargarProductos();
            controlador.GestionFicheros.cargarFacturas();
            controlador.GestionFicheros.redistribuirFacturas();
            controlador.GestionFicheros.cargarEmpleados();
            //System.out.println(controlador.GestionFicheros.listaFacturas.get(0).toString());
        } catch (IOException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (clienteExistente ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (productoExistente ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (lineaFacturaExistente ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (empleadoExistente ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }

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

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        invitado = new javax.swing.JLabel();
        cuadroAdmin = new javax.swing.JPanel();
        txtAdministrador = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        desconexion = new javax.swing.JButton();
        jTextPane2 = new javax.swing.JPasswordField();
        estadoVisual = new javax.swing.JPanel();
        informeEstado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        menuCrearCliente = new javax.swing.JMenuItem();
        menuEliminarCliente = new javax.swing.JMenuItem();
        menuModificarCliente = new javax.swing.JMenu();
        menuModificarClienteNombre = new javax.swing.JMenuItem();
        menuModificarClienteTelefono = new javax.swing.JMenuItem();
        menuModificarClienteDireccion = new javax.swing.JMenuItem();
        menuEmpleados = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        menuFacturas = new javax.swing.JMenu();
        generarFacturaVar = new javax.swing.JMenuItem();
        eliminarFacturaVar = new javax.swing.JMenuItem();
        menuServicios = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));

        jLabel6.setText("NetBeans IDE 8.2");

        jLabel7.setText("Build 201609300101");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addComponent(jLabel7))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/logoMATH.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 10, 380, 280);

        invitado.setText("Modo Invitado");
        jPanel2.add(invitado);
        invitado.setBounds(350, 10, 100, 15);

        cuadroAdmin.setBackground(new java.awt.Color(255, 51, 255));
        cuadroAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cuadroAdmin.setEnabled(false);

        javax.swing.GroupLayout cuadroAdminLayout = new javax.swing.GroupLayout(cuadroAdmin);
        cuadroAdmin.setLayout(cuadroAdminLayout);
        cuadroAdminLayout.setHorizontalGroup(
            cuadroAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        cuadroAdminLayout.setVerticalGroup(
            cuadroAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel2.add(cuadroAdmin);
        cuadroAdmin.setBounds(440, 30, 20, 20);

        txtAdministrador.setText("MODO ADMINISTRADOR");
        jPanel2.add(txtAdministrador);
        txtAdministrador.setBounds(300, 30, 140, 15);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel3.setText("Login:");

        jScrollPane2.setViewportView(jTextPane1);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel4.setText("Password:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        desconexion.setText("Desconectarse");
        desconexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desconexionActionPerformed(evt);
            }
        });

        estadoVisual.setBackground(new java.awt.Color(255, 0, 51));
        estadoVisual.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        estadoVisual.setEnabled(false);

        javax.swing.GroupLayout estadoVisualLayout = new javax.swing.GroupLayout(estadoVisual);
        estadoVisual.setLayout(estadoVisualLayout);
        estadoVisualLayout.setHorizontalGroup(
            estadoVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        estadoVisualLayout.setVerticalGroup(
            estadoVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(desconexion, javax.swing.GroupLayout.PREFERRED_SIZE, 128, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(estadoVisual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(informeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(9, 9, 9)
                        .addComponent(jTextPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(desconexion)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(estadoVisual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuClientes.setText("Clientes");

        menuCrearCliente.setText("Crear Cliente");
        menuCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuCrearCliente);

        menuEliminarCliente.setText("Eliminar Cliente");
        menuEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuEliminarCliente);

        menuModificarCliente.setText("Modificar Cliente");

        menuModificarClienteNombre.setText("Nombre");
        menuModificarClienteNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarClienteNombreActionPerformed(evt);
            }
        });
        menuModificarCliente.add(menuModificarClienteNombre);

        menuModificarClienteTelefono.setText("Telefono");
        menuModificarClienteTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarClienteTelefonoActionPerformed(evt);
            }
        });
        menuModificarCliente.add(menuModificarClienteTelefono);

        menuModificarClienteDireccion.setText("Direccion");
        menuModificarClienteDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarClienteDireccionActionPerformed(evt);
            }
        });
        menuModificarCliente.add(menuModificarClienteDireccion);

        menuClientes.add(menuModificarCliente);

        jMenuBar1.add(menuClientes);

        menuEmpleados.setText("Empleados");

        jMenuItem6.setText("Crear Empleado");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuEmpleados.add(jMenuItem6);

        jMenuItem7.setText("Eliminar Empleado");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuEmpleados.add(jMenuItem7);

        jMenu2.setText("Modificar Empleado");

        jMenuItem8.setText("Nombre");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        menuEmpleados.add(jMenu2);

        jMenuItem10.setForeground(new java.awt.Color(255, 0, 51));
        jMenuItem10.setText("Modo Administrador");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menuEmpleados.add(jMenuItem10);

        jMenuBar1.add(menuEmpleados);

        menuFacturas.setText("Facturas");

        generarFacturaVar.setText("Generar Factura");
        generarFacturaVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarFacturaVarActionPerformed(evt);
            }
        });
        menuFacturas.add(generarFacturaVar);

        eliminarFacturaVar.setText("Listado Facturas");
        eliminarFacturaVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarFacturaVarActionPerformed(evt);
            }
        });
        menuFacturas.add(eliminarFacturaVar);

        jMenuBar1.add(menuFacturas);

        menuServicios.setText("Productos");

        jMenuItem11.setText("Piezas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        menuServicios.add(jMenuItem11);

        jMenuItem12.setText("Ordenadores");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        menuServicios.add(jMenuItem12);

        jMenuItem13.setText("Servicios");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        menuServicios.add(jMenuItem13);

        jMenuBar1.add(menuServicios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        if (this.buscarUsuario(this.jTextPane1.getText(), this.jTextPane2.getText())) {
            System.out.println("LOGIN CORRECTO");
            this.infoUsuario = this.jTextPane1.getText() + ";" + Arrays.toString(this.jTextPane2.getPassword()) + ";";
            this.loginExitoso = true;
            this.jTextPane1.setText("");
            this.jTextPane2.setText("");
            actualizar();
        } else {
            System.out.println("CREDENCIALES INCORRECTAS");
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void desconexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desconexionActionPerformed
        this.loginExitoso = false;
        this.accesoAdmin = false;
        this.modoInvitado = false;
        actualizar();
    }//GEN-LAST:event_desconexionActionPerformed

    private void menuCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearClienteActionPerformed
        if (this.loginExitoso) {
            vista.CrearCliente crearCliente = new vista.CrearCliente();
            crearCliente.setLocation(475, 0);
            crearCliente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_menuCrearClienteActionPerformed

    private void menuEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarClienteActionPerformed
        if (this.loginExitoso) {
            vista.EliminarCliente eliminarCliente = new vista.EliminarCliente();
            eliminarCliente.setLocation(475, 0);
            eliminarCliente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_menuEliminarClienteActionPerformed

    private void menuModificarClienteNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarClienteNombreActionPerformed
        if (this.loginExitoso) {
            vista.ModificarClienteNombre modifClienteNombre = new vista.ModificarClienteNombre();
            modifClienteNombre.setLocation(475, 0);
            modifClienteNombre.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_menuModificarClienteNombreActionPerformed

    private void menuModificarClienteTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarClienteTelefonoActionPerformed
        if (this.loginExitoso) {
            vista.ModificarClienteTelefono modifClienteTelefono = new vista.ModificarClienteTelefono();
            modifClienteTelefono.setLocation(475, 0);
            modifClienteTelefono.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_menuModificarClienteTelefonoActionPerformed

    private void menuModificarClienteDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarClienteDireccionActionPerformed
        if (this.loginExitoso) {
            vista.ModificarClienteDireccion modifClienteDireccion = new vista.ModificarClienteDireccion();
            modifClienteDireccion.setLocation(475, 0);
            modifClienteDireccion.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_menuModificarClienteDireccionActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (this.loginExitoso) {
            vista.CrearEmpleado crearEmpleado = new vista.CrearEmpleado();
            crearEmpleado.setLocation(475, 0);
            crearEmpleado.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (this.loginExitoso) {
            vista.EliminarEmpleado eliminarEmpleado = new vista.EliminarEmpleado();
            eliminarEmpleado.setLocation(475, 0);
            eliminarEmpleado.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (this.loginExitoso) {
            vista.ModificarNombreEmpleado modifNomEmpleado = new vista.ModificarNombreEmpleado();
            modifNomEmpleado.setLocation(475, 0);
            modifNomEmpleado.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void generarFacturaVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarFacturaVarActionPerformed
        if (this.loginExitoso) {
            generarFactura gf = new generarFactura();
            gf.setLocation(475, 0);
            gf.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_generarFacturaVarActionPerformed

    private void eliminarFacturaVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarFacturaVarActionPerformed
        if (this.loginExitoso) {
            ListadoFacturas lf = new ListadoFacturas();
            lf.setLocation(475, 0);
            lf.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_eliminarFacturaVarActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (this.loginExitoso) {
            if (this.accesoAdmin) {
                vista.Administrador admin = new Administrador();
                admin.setLocation(475, 0);
                admin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "DEBES SER ADMINISTRADOR PARA ACCEDER AL MODO ADMINISTRADOR");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if (this.loginExitoso) {
            CrearPiezas cp = new CrearPiezas();
            cp.setLocation(475, 0);
            cp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if (this.loginExitoso) {
            CrearOrdenador co = new CrearOrdenador();
            co.setLocation(475, 0);
            co.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if (this.loginExitoso) {
            CrearServicio cs = new CrearServicio();
            cs.setLocation(475, 0);
            cs.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "DEBES LOGEARTE ANTES DE PONER USAR LAS FUNCIONALIDADES");
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private boolean buscarUsuario(String usuario, String pass) {
        File ficheroAbuscar = new File("invitados.txt");
        File usuariosReales = new File("empleados.csv");
        boolean loginCorrecto = false;
        String linea;
        String[] arrayAnalizado;
        try {
            Scanner sc = new Scanner(ficheroAbuscar);
            while (sc.hasNext()) {
                linea = sc.nextLine();
                arrayAnalizado = linea.split(";");
                //System.out.println("COMPARANDO "+usuario+" CON "+usuario.length()+" CARACTERES VS "+arrayAnalizado[0]+" DE "+arrayAnalizado[0].length()+" CARACTERES");
                if (arrayAnalizado[0].equalsIgnoreCase(usuario) && arrayAnalizado[1].equalsIgnoreCase(pass)) {
                    //System.out.println("HAY COINCIDENCIA");
                    modoInvitado = true;
                    this.invitado.setVisible(true);
                    loginCorrecto = true;
                    return true;
                }
            }
            sc.close();
            if (loginCorrecto == false) {
                Scanner sc2 = new Scanner(usuariosReales);
                while (sc2.hasNext()) {
                    linea = sc2.nextLine();
                    arrayAnalizado = linea.split(";");
                    if (arrayAnalizado[0].equalsIgnoreCase("Administrador")) {
                        this.accesoAdmin = true;
                    }
                    if (arrayAnalizado[1].equalsIgnoreCase(usuario) && arrayAnalizado[2].equalsIgnoreCase(pass)) {
                        loginCorrecto = true;
                        return true;
                    }
                }
                sc2.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    private void actualizar() {
        if (this.loginExitoso == true) {
            this.estadoVisual.setBackground(Color.green);
            this.informeEstado.setText("Conexion garantizada!");
        } else {
            this.informeEstado.setText("");
            this.estadoVisual.setBackground(Color.red);
        }

        if (this.accesoAdmin == true) {
            this.cuadroAdmin.setVisible(true);
            this.txtAdministrador.setVisible(true);
        } else {
            this.cuadroAdmin.setVisible(false);
            this.txtAdministrador.setVisible(false);
        }

        if (this.modoInvitado == true) {
            this.invitado.setVisible(true);
        } else {
            this.invitado.setVisible(false);
        }

    }

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new home().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel cuadroAdmin;
    private javax.swing.JButton desconexion;
    private javax.swing.JMenuItem eliminarFacturaVar;
    private javax.swing.JPanel estadoVisual;
    private javax.swing.JMenuItem generarFacturaVar;
    private javax.swing.JLabel informeEstado;
    private javax.swing.JLabel invitado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPasswordField jTextPane2;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenuItem menuCrearCliente;
    private javax.swing.JMenuItem menuEliminarCliente;
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenu menuFacturas;
    private javax.swing.JMenu menuModificarCliente;
    private javax.swing.JMenuItem menuModificarClienteDireccion;
    private javax.swing.JMenuItem menuModificarClienteNombre;
    private javax.swing.JMenuItem menuModificarClienteTelefono;
    private javax.swing.JMenu menuServicios;
    private javax.swing.JLabel txtAdministrador;
    // End of variables declaration//GEN-END:variables
}

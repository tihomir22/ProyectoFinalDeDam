/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.clienteExistente;
import Excepciones.clienteNoExistente;
import Excepciones.empleadoExistente;
import Excepciones.empleadoNoExistente;
import Excepciones.productoExistente;
import Excepciones.productoNoExistente;
import java.util.ArrayList;

/**
 *
 * @author sportak
 */
public class Tienda {

    private String nombre;
    private String direccion;
    private String CIF;
    private String telefono;
    private String web;
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Producto> listaProductos = new ArrayList<>();

    public Tienda(String nombre, String direccion, String CIF, String telefono, String web) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.CIF = CIF;
        this.telefono = telefono;
        this.web = web;
    }

    public Tienda() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void imprimirClientes() {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            System.out.println(this.listaClientes.get(i).toString());
        }
    }

    public void imprimirEmpleados() {
        for (int i = 0; i < this.listaEmpleados.size(); i++) {
            System.out.println(this.listaEmpleados.get(i).toString());
        }
    }

    public void imprimirProductos() {
        for (int i = 0; i < this.listaProductos.size(); i++) {
            System.out.println(this.listaProductos.get(i).toString());
        }
    }

    public Cliente buscarCliente(String dni) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getDni().equalsIgnoreCase(dni)) {
                return this.listaClientes.get(i);
            }
        }
        return null;
    }

    public void añadirCliente(Cliente c) throws clienteExistente {
        if (buscarCliente(c.getDni()) == null) {
            this.listaClientes.add(c);
        } else {
            throw new clienteExistente(c);
        }
    }

    public void eliminarCliente(Cliente c) throws clienteNoExistente {
        if (buscarCliente(c.getDni()) != null) {
            this.listaClientes.remove(c);
        } else {
            throw new clienteNoExistente(c);
        }
    }

    public Empleado buscarEmpleado(int numEmple) {
        for (int i = 0; i < this.listaEmpleados.size(); i++) {
            if (this.listaEmpleados.get(i).getNumEmpleado() == numEmple) {
                return this.listaEmpleados.get(i);
            }
        }
        return null;
    }

    public void añadirEmpleado(Empleado e) throws empleadoExistente {
        if (this.buscarEmpleado(e.getNumEmpleado()) == null) {
            this.listaEmpleados.add(e);
        } else {
            throw new empleadoExistente(e);
        }
    }

    public void eliminarEmpleado(Empleado e) throws empleadoNoExistente {
        if (this.buscarEmpleado(e.getNumEmpleado()) != null) {
            this.listaEmpleados.remove(e);
        } else {
            throw new empleadoNoExistente(e);
        }
    }

    public Producto buscarProducto(String codigo) {
        for (int i = 0; i < this.listaProductos.size(); i++) {
            if (this.listaProductos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                return this.listaProductos.get(i);
            }
        }
        return null;
    }

    public void añadirProducto(Producto p) throws productoExistente {
        if (this.buscarProducto(p.getCodigo()) == null) {
            this.listaProductos.add(p);
        } else {
            throw new productoExistente(p);
        }
    }

    public void eliminarProducto(Producto p) throws productoNoExistente {
        if (this.buscarProducto(p.getCodigo()) != null) {
            this.listaProductos.remove(p);
        } else {
            throw new productoNoExistente(p);
        }
    }

    @Override
    public String toString() {
        return this.CIF + "\t" + this.nombre + "\t" + this.direccion + "\t" + this.telefono + "\t" + this.web;
    }
    /*
    public static void main(String[] args) {
        Tienda t = new Tienda("APPSimarret", "DR LUIS ISMARR", "454354", "64656454", "www.google.es");
        Cliente c = new Cliente("pepe", "la calle de pepe", "x5514136r","603680594");
        Factura f = new Factura(4343, c, Calendar.getInstance(), 5000, MetodoPago.EFECTIVO);
        Ordenador p = new Ordenador(2, "MSI GL62MVR 7RFX-1271XES Intel Core i5-7300HQ/8GB/1TB/GTX 1060/15.6\"", "534534", 899.0);
        Ordenador p2 = new Ordenador(3, "Nox Hummer MC USB 3.0 Zero Edition Blanca", "34665234", 49.99);
        LineaFactura lf = new LineaFactura(2, p, 3);
        LineaFactura lf2 = new LineaFactura(3, p2, 5);
        try {
            f.añadirLineaAFactura(lf);
            f.añadirLineaAFactura(lf2);
        } catch (lineaFacturaExistente ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t.generarDocumentoFactura(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

}

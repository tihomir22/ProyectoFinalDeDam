/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.lineaFacturaExistente;
import Excepciones.lineaFacturaNoExistente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author link
 */
public class Factura {

    private int id;
    private Cliente cliente;
    private String fecha;
    private double importe;
    private MetodoPago mp;
    private ArrayList<LineaFactura> listaLineas = new ArrayList<>();

    public Factura(Cliente cliente, String fecha, double importe, MetodoPago mp) {
        this.id = (int) Math.round(Math.random() * 1000);
        this.cliente = cliente;
        this.fecha = fecha;
        this.importe = importe;
        this.mp = mp;
    }

    public Factura(int id, Cliente cliente, String fecha, double importe, MetodoPago mp) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.importe = importe;
        this.mp = mp;
    }

    /*METODOS*/
    public LineaFactura buscarLineaDeFactura(int codLinea) {
        for (int i = 0; i < this.listaLineas.size(); i++) {
            if (this.listaLineas.get(i).getCodigoLinea() == codLinea) {
                return this.listaLineas.get(i);
            }
        }
        return null;
    }

    public void añadirLineaAFactura(LineaFactura lf) throws lineaFacturaExistente {
        if (this.buscarLineaDeFactura(lf.getCodigoLinea()) == null) {
            this.listaLineas.add(lf);
        } else {
            throw new lineaFacturaExistente(lf);
        }
    }

    public void añadirLineaAFacturaExpress(LineaFactura lf) {
        this.listaLineas.add(lf);
    }

    public void eliminarLineaDeFactura(LineaFactura lf) throws lineaFacturaNoExistente {
        if (this.buscarLineaDeFactura(lf.getCodigoLinea()) != null) {
            this.listaLineas.remove(lf);
        } else {
            throw new lineaFacturaNoExistente(lf);
        }

    }

    @Override
    public String toString() {
        return this.cliente.toString() + "\t" + this.id + "\t" + this.fecha + "\t" + this.mp + "\t" + this.importe;
    }

    public String formatear() {
        String cabecera = this.id + ";" + this.cliente.getDni() + ";" + this.fecha + ";" + this.importe + ";" + this.mp + ";" + "Lineas" + ";";
        //idDelaFactura;idCliente;DateFactura;importeFinal;MetodoPago;EmpiezaLinea;idCodilinea;idProducto;cantidad;coste; >> aparecera en los ficheros
        for (int i = 0; i < this.listaLineas.size(); i++) {
            cabecera += this.listaLineas.get(i).formatear();
        }
        System.out.println(cabecera);
        return cabecera;
    }

    /*METODOS*/
    public Cliente getC() {
        return cliente;
    }

    public void setC(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public ArrayList<LineaFactura> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(ArrayList<LineaFactura> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public MetodoPago getMp() {
        return mp;
    }

    public void setMp(MetodoPago mp) {
        this.mp = mp;
    }

}

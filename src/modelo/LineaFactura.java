/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author link
 */
public class LineaFactura {

    private int codigoLinea;
    private Producto producto;
    private int cantidad;
    private Double coste;

    public LineaFactura(int codigoLinea, Producto producto, int cantidad) {
        this.codigoLinea = codigoLinea;
        this.producto = producto;
        this.cantidad = cantidad;
        this.coste = producto.getPrecio() * cantidad;
    }

    public LineaFactura(int codigoLinea, Producto producto, int cantidad, Double coste) {
        this.codigoLinea = codigoLinea;
        this.producto = producto;
        this.cantidad = cantidad;
        this.coste = coste;
    }

    /*METODOS*/
    public String formatear() {
        return this.codigoLinea + ";" + this.producto.getCodigo() + ";" + this.cantidad + ";" + this.coste + ";";
    }

    /*METODOS*/
    public int getCodigoLinea() {
        return codigoLinea;
    }

    public void setCodigoLinea(int codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return this.producto.toString() + "\t" + this.codigoLinea + "\t" + this.coste + "\t" + this.cantidad;
    }

}

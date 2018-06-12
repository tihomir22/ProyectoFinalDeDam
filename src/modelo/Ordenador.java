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
public class Ordenador extends Producto {

    private int cantidad;

    public Ordenador(int cantidad, String nombre, String codigo, Double precio) {
        super(nombre, codigo, precio);
        this.cantidad = cantidad;
    }

    /*METODOS*/
 /*METODOS*/
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + this.cantidad;
    }

     @Override
    public String formatear(){
        return "Ordenador;"+this.getCodigo()+";"+this.getNombre()+";"+this.getPrecio()+";"+this.cantidad+";";
    }
}

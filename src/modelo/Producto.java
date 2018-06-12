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
public abstract class Producto {

    protected String nombre;
    protected String codigo;
    protected Double precio;

    public Producto(String nombre, String codigo, Double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
    }

    /*METODOS*/
    public abstract String formatear();

    /*METODOS*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\t" + this.codigo +" "+ "\t" + this.nombre + "\t" + this.precio + "\t";
    }
}

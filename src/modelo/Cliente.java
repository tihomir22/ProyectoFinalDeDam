/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author link
 */
public class Cliente {

    private String nombre;
    private String direccion;
    private String dni;
    private String telefono;
    private ArrayList<Factura> facturas = new ArrayList<>();

    public Cliente(String nombre, String direccion, String dni, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;

    }

    /*METODOS*/
    public String formatear() {
        return this.getDni() + ";" + this.nombre + ";" + this.direccion + ";" + this.telefono + ";";
    }

    /*METODOS*/
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return this.dni + "\t" + this.nombre + "\t" + this.direccion;
    }

}

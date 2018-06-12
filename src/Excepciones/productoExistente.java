/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import modelo.Producto;

/**
 *
 * @author sportak
 */
public class productoExistente extends Exception {

    Producto p;

    public productoExistente(Producto p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "El producto con codigo " + this.p.getCodigo() + " ya existe y no se puede añadir";
    }

}

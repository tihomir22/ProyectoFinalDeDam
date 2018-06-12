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
public class productoNoExistente extends Exception {

   Producto p;

    public productoNoExistente(Producto p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "El producto con codigo "+this.p.getCodigo()+" no existe por lo que no se puede eliminar!";
    }
   
   
}

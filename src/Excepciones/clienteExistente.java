/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import modelo.Cliente;

/**
 *
 * @author sportak
 */
public class clienteExistente extends Exception {
    Cliente c;

    public clienteExistente(Cliente c) {
        this.c = c;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "El cliente con DNI "+this.c.getDni()+" ya existe! No se puede añadir!";
    }
    
    
    
}

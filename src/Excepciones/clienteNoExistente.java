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
public class clienteNoExistente extends Exception {

   Cliente c;

    public clienteNoExistente(Cliente c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "El cliente con dni "+this.c.getDni()+" no existe !";
    }
    
    
    
   
}

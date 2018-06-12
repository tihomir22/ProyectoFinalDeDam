/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import modelo.Empleado;

/**
 *
 * @author sportak
 */
public class empleadoNoExistente extends Exception {

    Empleado e;

    public empleadoNoExistente(Empleado e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "El empleado no existe, por lo que no se puede dar de baja!";
    }
    
    
}

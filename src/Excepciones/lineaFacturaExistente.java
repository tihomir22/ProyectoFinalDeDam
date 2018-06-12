/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import modelo.LineaFactura;

/**
 *
 * @author mati
 */
public class lineaFacturaExistente extends Exception {

    LineaFactura lf;

    public lineaFacturaExistente(LineaFactura lf) {
        this.lf = lf;
    }

    @Override
    public String toString() {
        return "La linea de factura " + "\t" + lf.toString() + "\t" + "ya fue añadida!";
    }

}

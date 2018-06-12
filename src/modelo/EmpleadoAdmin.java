/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sportak
 */
public class EmpleadoAdmin extends Empleado {

    private int antiguedad;

    public EmpleadoAdmin(int numEmpleado, String dni, String nombre, Double sueldo, String usuario, String contrasena) {
        super(numEmpleado, dni, nombre, sueldo, usuario, contrasena);
    }
    
    /*METODOS*/

    @Override
    public String formatear() {
        return "Administrador;"+this.getNumEmpleado()+";"+this.getNombre()+";"+this.getDni()+";"+this.getSueldo()+";"+this.getUsuario()+";"+this.getContrasena()+";";
    }
    
    
    
    @Override
    public String toString() {
        return super.toString() + "\t" + this.antiguedad;
    }
    
    /*METODOS*/

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}

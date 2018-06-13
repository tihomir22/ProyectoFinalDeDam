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

    public EmpleadoAdmin(int numEmpleado, int anguedad, String dni, String nombre, Double sueldo, String usuario, String contrasena) {
        super(numEmpleado, dni, nombre, sueldo, usuario, contrasena);
        this.antiguedad = anguedad;
    }

    /*METODOS*/
    @Override
    public String formatear() {
        return "Administrador" + ";" + this.getNumEmpleado() + ";" + this.getNombre() + ";" + this.getDni() + ";" + this.getSueldo() + ";" + this.getUsuario() + ";" + this.getContrasena() + ";" + this.getAntiguedad() + ";";
    }

    @Override
    public String formatoUsuario() {
        return "Administrador" + ";" + this.getUsuario() + ";" + this.getContrasena() + ";";
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

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Kraze
 */
public class OtrosEmpleados extends Empleado{
    private String descripcion; //Breve descripcion de su puesto de trabajo

    public OtrosEmpleados(String descripcion, String dni, String nombre, String apellidos, boolean parcial, short horaEntrada, short horaSalida) {
        super(dni, nombre, apellidos, parcial, horaEntrada, horaSalida);
        this.descripcion = descripcion;
    }
    
    
}

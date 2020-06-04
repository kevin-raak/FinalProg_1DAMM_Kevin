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
public class Caja extends Empleado{
    private byte numCaja; //El número de la caja en la que el empleado trabaja

    public Caja(byte numCaja, String dni, String nombre, String apellidos, boolean parcial, short horaEntrada, short horaSalida, int salario) {
        super(dni, nombre, apellidos, parcial, horaEntrada, horaSalida, salario, numCaja);
        this.numCaja = numCaja;
    }
    
    
}

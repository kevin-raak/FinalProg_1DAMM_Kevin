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
public class Panaderia extends Empleado{

    /**
     * Crea un Empleado que trabaja en la seccion de panadería.
     * @param dni DNI del empleado. String.
     * @param nombre Nombre del empleado. String.
     * @param apellidos Apellido(s) del empleado. String.
     * @param parcial TRUE si tiene contrato de jornada parcial, FALSE si es completa.
     * @param horaEntrada La hora de entrada del empleado (FORMATO MILITAR, ejs.:0900, 1245, 2315, 0000). INT.
     * @param horaSalida La hora de salida del empleado (FORMATO MILITAR, ejs.:0900, 1245, 2315, 0000). INT.
     * @param salario Salario mensual del empleado. NO SE PERMITEN DECIMALES.
     */
    public Panaderia(String dni, String nombre, String apellidos, boolean parcial, short horaEntrada, short horaSalida, int salario) {
        super(dni, nombre, apellidos, parcial, horaEntrada, horaSalida, salario);
    }
    
}

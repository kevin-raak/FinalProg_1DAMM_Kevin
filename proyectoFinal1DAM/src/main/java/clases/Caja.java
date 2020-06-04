/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 * Tipo de empleado que trabaja en la caja (cajero/a)
 * @author Kraze
 */
public class Caja extends Empleado{
    private byte numCaja; //El número de la caja en la que el empleado trabaja

    /**
     * Crea un Empleado de tipo cajero/a.
     * @param numCaja Número de caja en la que trabaja. INT.
     * @param dni DNI del empleado. String.
     * @param nombre Nombre del empleado. String.
     * @param apellidos Apellido(s) del empleado. String.
     * @param parcial TRUE si tiene contrato de jornada parcial, FALSE si es completa.
     * @param horaEntrada La hora de entrada del empleado (FORMATO MILITAR, ejs.:0900, 1245, 2315, 0000). INT.
     * @param horaSalida La hora de salida del empleado (FORMATO MILITAR, ejs.:0900, 1245, 2315, 0000). INT.
     * @param salario Salario mensual del empleado. NO SE PERMITEN DECIMALES.
     */
    public Caja(byte numCaja, String dni, String nombre, String apellidos, boolean parcial, short horaEntrada, short horaSalida, int salario) {
        super(dni, nombre, apellidos, parcial, horaEntrada, horaSalida, salario, numCaja);
        this.numCaja = numCaja;
    }

    /**
     * Getter del número de caja del empleado.
     * @return Número de caja en INT.
     */
    public byte getNumCaja() {
        return numCaja;
    }

    /**
     * Setter del número de caja del empleado.
     * @param numCaja El número de caja en INT.
     */
    public void setNumCaja(byte numCaja) {
        this.numCaja = numCaja;
    }
    
    
}

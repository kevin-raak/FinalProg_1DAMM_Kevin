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
public abstract class Empleado {
    private String dni; //DNI o NIE del empleado.
    private String nombre; //Nombre del empleado.
    private String apellidos; //Apellido(s) del empleado.
    private boolean parcial; //TRUE si trabaja jornada parcial, FALSE si es jornada completa.
    private short horaEntrada; //La hora a la que entra (formato 24H, ejemplos: 0900, 0830, 2245).
    private short horaSalida; //La hora a la que sale (formato 24H, ejemplos: 0900, 0830, 2245).
}

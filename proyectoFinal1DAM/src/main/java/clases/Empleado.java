/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Empleado(String dni, String nombre, String apellidos, boolean parcial, short horaEntrada, short horaSalida) {
        try {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.parcial = parcial;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "REPLACE INTO empleado(dni, nombre, apellidos, parcial, horaEntrada, horaSalida) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,dni);
            statement.setString(2,nombre);
            statement.setString(3,apellidos);
            statement.setBoolean(4,parcial);
            statement.setShort(5,horaEntrada);
            statement.setShort(6,horaSalida);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isParcial() {
        return parcial;
    }

    public void setParcial(boolean parcial) {
        this.parcial = parcial;
    }

    public short getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(short horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public short getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(short horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    
}

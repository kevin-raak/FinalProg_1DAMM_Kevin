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
 * En la clase Empleado se determinan todos los datos de cada empleado del supermercado. Es una clase abstracta, los empleados se construyen 
 * mediante las subclases ya que el tipo de empleado lo denominan las subclases.
 * @author Kraze
 */
public abstract class Empleado {
    private String dni; //DNI o NIE del empleado.
    private String nombre; //Nombre del empleado.
    private String apellidos; //Apellido(s) del empleado.
    private boolean parcial; //TRUE si trabaja jornada parcial, FALSE si es jornada completa.
    private short horaEntrada; //La hora a la que entra (formato 24H, ejemplos: 0900, 0830, 2245).
    private short horaSalida; //La hora a la que sale (formato 24H, ejemplos: 0900, 0830, 2245).
    private int salario;//El salario mensual del empleado.

    /**
     * Los constructores de Empleado toman todas las variable escritas e las inserta en su correspondiente
     * tabla en la base de datos MYSQL.
     * @param dni DNI o NIE del empleado.
     * @param nombre Nombre del empleado.
     * @param apellidos Apellido(s) del empleado.
     * @param parcial Si su jornada es parcial (TRUE) o completa (FALSE).
     * @param horaEntrada Su hora de entrada (FORMATO MILITAR, ejs.: 2315, 0900).
     * @param horaSalida Su hora de salida (FORMATO MILITAR, ejs.: 2315, 0900).
     * @param salario Su salario mensual (NO SE ADMITEN DECIMALES).
     * @param numCaja El número de la caja donde trabaja.
     */
    public Empleado(String dni, String nombre, String apellidos, boolean parcial, short horaEntrada, short horaSalida, int salario, byte numCaja) {
        try {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.parcial = parcial;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.salario = salario;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "REPLACE INTO empleado(dni, nombre, apellidos, parcial, horaEntrada, horaSalida, salario) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,dni);
            statement.setString(2,nombre);
            statement.setString(3,apellidos);
            statement.setBoolean(4,parcial);
            statement.setShort(5,horaEntrada);
            statement.setShort(6,horaSalida);
            statement.setInt(7,salario);
            statement.setInt(8,numCaja);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Los constructores de Empleado toman todas las variable escritas e las inserta en su correspondiente
     * tabla en la base de datos MYSQL.
     * @param dni DNI o NIE del empleado.
     * @param nombre Nombre del empleado.
     * @param apellidos Apellido(s) del empleado.
     * @param parcial Si su jornada es parcial (TRUE) o completa (FALSE).
     * @param horaEntrada Su hora de entrada (FORMATO MILITAR, ejs.: 2315, 0900).
     * @param horaSalida Su hora de salida (FORMATO MILITAR, ejs.: 2315, 0900).
     * @param salario Su salario mensual (NO SE ADMITEN DECIMALES). 
     */
    public Empleado(String dni, String nombre, String apellidos, boolean parcial, short horaEntrada, short horaSalida, int salario) {
        try {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.parcial = parcial;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.salario = salario;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "REPLACE INTO empleado(dni, nombre, apellidos, parcial, horaEntrada, horaSalida, salario) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,dni);
            statement.setString(2,nombre);
            statement.setString(3,apellidos);
            statement.setBoolean(4,parcial);
            statement.setShort(5,horaEntrada);
            statement.setShort(6,horaSalida);
            statement.setInt(7,salario);
            statement.setNull(8, java.sql.Types.INTEGER);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Getter del DNI del empleado.
     * @return Devuelve su DNI en un String.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Setter del DNI del empleado. Actualiza el registro en la base de datos.
     * @param dni Su DNI o NIE en un String.
     */
    public void setDni(String dni) {
        this.dni = dni;
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "UPDATE empleado SET dni = ? WHERE dni = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,dni);
            statement.setString(2,this.dni);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Getter del nombre del empleado.
     * @return Devuelve su nombre en un String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre del empleado. Actualiza el registro en la base de datos.
     * @param nombre Su nombre en un String.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "UPDATE empleado SET nombre = ? WHERE dni = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,nombre);
            statement.setString(2,this.dni);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter de los apellidos del empleado.
     * @return Devuelve sus apellidos en un String.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter de los apellidos del empleado. Actualiza el registro en la base de datos.
     * @param apellidos Sus apellidos en un String.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "UPDATE empleado SET apellidos = ? WHERE dni = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,apellidos);
            statement.setString(2,this.dni);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter del tipo de contrato del empleado.
     * @return Devuelve TRUE si es parcial, FALSE si es jornada completa.
     */
    public boolean isParcial() {
        return parcial;
    }

    /**
     * Setter del tipo de contrato del empleado. Actualiza el registro en la base de datos.
     * @param parcial TRUE si es jornada parcial, FALSE si es completa.
     */
    public void setParcial(boolean parcial) {
        this.parcial = parcial;
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "UPDATE empleado SET parcial = ? WHERE dni = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setBoolean(1,parcial);
            statement.setString(2,this.dni);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter de la hora de entrada del empleado.
     * @return Devuelve su hora de entrada en un INT.
     */
    public short getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Setter de la hora de entrada del empleado. Actualiza el registro en la base de datos.
     * @param horaEntrada La hora de entrada EN FORMATO MILITAR (ejs.: 0900, 2315, 0000) en un INT.
     */
    public void setHoraEntrada(short horaEntrada) {
        this.horaEntrada = horaEntrada;
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "UPDATE empleado SET horaEntrada = ? WHERE dni = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,horaEntrada);
            statement.setString(2,this.dni);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Getter de la hora de salida del empleado.
     * @return Devuelve su hora de salida en un INT.
     */
    public short getHoraSalida() {
        return horaSalida;
    }
    
    /**
     * Setter de la hora de salida del empleado. Actualiza el registro en la base de datos.
     * @param horaEntrada La hora de salida EN FORMATO MILITAR (ejs.: 0900, 2315, 0000) en un INT.
     */
    public void setHoraSalida(short horaSalida) {
        this.horaSalida = horaSalida;
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "UPDATE empleado SET horaSalida = ? WHERE dni = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,horaSalida);
            statement.setString(2,this.dni);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

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
 * En la clase Producto se determinan todos los datos de cada producto del supermercado.
 * @author Kraze
 */
public abstract class Producto {
    private int id; //ID del producto
    private String nombre; //Nombre del producto
    private String descripcion; //Breve descripción del producto (opcional)

    /**
     * Los constructores de Producto toman todas las variable escritas e las inserta en su correspondiente
     * tabla en la base de datos MYSQL.
     * @param id ID del producto, el numero debajo del código de barras, en un INT.
     * @param nombre Nombre del producto, lo que iría en la etiqueta del precio. String.
     * @param descripcion Breve descripción del producto. Máximo 150 caracteres.
     * @param fechaCaducidad Fecha de caducidad del producto (FORMATO aaaa-mm-dd, ej.: 2020-12-31).
     */
    public Producto(int id, String nombre, String descripcion, String fechaCaducidad) {
        try {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "REPLACE INTO producto(id, nombre, descripcion)VALUES(?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2,nombre);
            statement.setString(3,descripcion);
            statement.setBoolean(4,true);
            statement.setString(5,fechaCaducidad);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Los constructores de Producto toman todas las variable escritas e las inserta en su correspondiente
     * tabla en la base de datos MYSQL.
     * @param id
     * @param nombre
     * @param descripcion 
     */
    public Producto(int id, String nombre, String descripcion) {
        try {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "REPLACE INTO producto(id, nombre, descripcion)VALUES(?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2,nombre);
            statement.setString(3,descripcion);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter de la ID del producto.
     * @return La ID del producto en INT.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de la ID del producto.
     * @param id La ID del producto, INT.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del nombre del producto.
     * @return Nombre del producto en un String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre del producto.
     * @param nombre Nombre del producto en String.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la descripción del producto.
     * @return Descripción del producto en un String.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la descripción del producto.
     * @param descripcion Descripción del producto en String.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}

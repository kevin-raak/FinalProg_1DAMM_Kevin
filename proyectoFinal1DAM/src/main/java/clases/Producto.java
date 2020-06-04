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
public abstract class Producto {
    private int id; //ID del producto
    private String nombre; //Nombre del producto
    private String descripcion; //Breve descripción del producto (opcional)

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}

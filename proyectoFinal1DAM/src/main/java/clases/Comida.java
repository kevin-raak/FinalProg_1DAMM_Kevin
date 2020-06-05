/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kraze
 */
public class Comida extends Producto{
    private boolean caduca; //TRUE si tiene fecha de caducidad, FALSE si no
    private String fechaCaducidad; //Fecha de caducidad (FORMATO: yyyy-mm-dd)(EJ: 2020-12-31)

    /**
     * Crea un producto comestible.
     * @param caduca TRUE si tiene fecha de caducidad, FALSE si no.
     * @param fechaCaducidad Fecha de caducidad del producto. (FORMATO aaaa-mm-dd, ej.: 2020-12-31). String.
     * @param id ID del producto, un número.
     * @param nombre Nombre del producto, lo que iría en la etiqueta del precio. String
     * @param descripcion Breve descripción del producto. Máximo 150 caracteres.
     */
    public Comida(boolean caduca, String fechaCaducidad, int id, String nombre, String descripcion) {
        super(id, nombre, descripcion, fechaCaducidad);
        this.caduca = caduca;
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Getter de la variable caduca.
     * @return TRUE si tiene fecha de caducidad, FALSE si no.
     */
    public boolean isCaduca() {
        return caduca;
    }

    /**
     * Setter de la variable caduca. Actualiza el registro en la base de datos.
     * @param caduca TRUE si tiene fecha de caducidad, FALSE si no.
     */
    public void setCaduca(boolean caduca) {
        this.caduca = caduca;
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "UPDATE producto SET caduca = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setBoolean(1,caduca);
            statement.setInt(2,this.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter de la fecha de caducidad del producto.
     * @return la fecha de caducidad en un String.
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Setter de la fecha de caducidad.
     * @param fechaCaducidad Fecha de caducidad del producto. (FORMATO aaaa-mm-dd, ej.: 2020-12-31). String.
     */
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "UPDATE producto SET fechaCaducidad = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDate(1,Date.valueOf(fechaCaducidad));
            statement.setInt(2,this.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

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
 * En la clase Usuario se declaran el nombre de usuario y la contraseña de todos las personas que tendrán acceso al programa.
 * @author Kraze
 */
public class Usuario {
    private String usuario; //Nombre de ususario
    private String contrasena; //Contraseña

    /**
     * El constructor de Usuario se encarga de crear la clase y de guardar los respectivos datos en su tabla en la base de datos.
     * @param usuario Nombre de ususario
     * @param contrasena Contraseña
     */
    public Usuario(String usuario, String contrasena) {
        try {
        this.usuario = usuario;
        this.contrasena = contrasena;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            String sql = "REPLACE INTO usuario(usuario, contrasena)VALUES(?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,usuario);
            statement.setString(2,contrasena);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

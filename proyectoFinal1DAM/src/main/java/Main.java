import clases.*;
import interfaz.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kraze
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root", "root");
            con.createStatement().execute("CREATE TABLE IF NOT EXISTS usuario("
                    + "usuario VARCHAR(12) NOT NULL,"
                    + "contrasena VARCHAR(16) NOT NULL,"
                    + "PRIMARY KEY (`usuario`))");
            con.createStatement().execute("CREATE TABLE IF NOT EXISTS producto("
                    + "id INT NOT NULL,"
                    + "nombre VARCHAR(45) NOT NULL,"
                    + "descripcion VARCHAR(150) NULL,"
                    + "PRIMARY KEY (`id`))");
            con.createStatement().execute("CREATE TABLE IF NOT EXISTS empleado("
                    + "dni VARCHAR(11) NOT NULL,"
                    + "nombre VARCHAR(45) NOT NULL,"
                    + "apellidos VARCHAR(100) NOT NULL,"
                    + "parcial BOOLEAN,"
                    + "horaEntrada INT(4) NOT NULL,"
                    + "horaSalida INT(4) NOT NULL,"
                    + "salario INT(9) NOT NULL,"
                    + "PRIMARY KEY (`dni`))");
            Usuario admin = new Usuario("admin","admin");
            JFrameMain interfaz = new JFrameMain();
            interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            interfaz.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

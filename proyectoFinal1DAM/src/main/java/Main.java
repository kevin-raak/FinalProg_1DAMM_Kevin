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
                    + "descripcion VARCHAR(150),"
                    + "caduca BOOLEAN,"
                    + "fechaCaducidad DATE,"
                    + "PRIMARY KEY (`id`))");
            con.createStatement().execute("CREATE TABLE IF NOT EXISTS empleado("
                    + "dni VARCHAR(11) NOT NULL,"
                    + "nombre VARCHAR(45) NOT NULL,"
                    + "apellidos VARCHAR(100) NOT NULL,"
                    + "parcial BOOLEAN,"
                    + "horaEntrada INT(4) NOT NULL,"
                    + "horaSalida INT(4) NOT NULL,"
                    + "salario INT(9) NOT NULL,"
                    + "numCaja INT(2),"
                    + "PRIMARY KEY (`dni`))");
            Usuario admin = new Usuario("admin","admin");
            Empleado emp1 = new Caja((byte)(3), "487932Z", "Cajero", "Ejemplo Uno", false, (short)900, (short)1730, 1450);
            Empleado emp2 = new Carniceria("5235987Q", "Carnicero", "Ejemplo Dos", true, (short)1700, (short)2145, 650);
            Producto pro1 = new Comida(true, "2021-01-02", 645367244, "Producto Comestible Ejemplo", "Un producto ejemplar. Delicioso.");
            Producto pro2 = new OtrosProductos(14636944, "Producto No Comestible Ejemplo", "Un producto ejemplar. No sabe bien.");
            JFrameMain interfaz = new JFrameMain();
            interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            interfaz.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

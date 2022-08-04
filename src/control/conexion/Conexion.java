/*
    Document   : Inicio
    Created on : 22 jul. 2022, 20:19:49
    Author     : Miguel Londono, Nicolas Diaz, Daniel Paez
    Project: Proyecto Final de Modelos de Programacion I
 */
package control.conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion {

    // atributos de clase necesarios para crear la conexion
    private static Connection cn = null;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/minihanddb";
    private static String usuario = "root";
    private static String contrasena = "";

    private static Conexion instancia;

    private Conexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(url, usuario, contrasena);
            if(cn != null){
                System.out.println("Conexion establecida");
            }
        } catch (Exception e) {
            System.out.println("Error en la conexión");
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public static Connection getConexion() {
        if (cn == null) {
            new Conexion();
        }

        return cn;
    }

    /**
     * Metodo encargado de desconectar la conexion con la base de datos
     */
    public static void desconectar() {
        cn = null;
    }
}

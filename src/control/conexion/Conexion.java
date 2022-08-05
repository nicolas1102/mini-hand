/*
    Document   : Inicio
    Created on : 3 ago. 2022, 20:19:49
    Author     : Miguel Londono, Nicolas Diaz, Felipe Pacheco
    Project: Proyecto Final de Fundamentos de Bases de Datos
 */
package control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Londoño
 * @author Felipe Pacheco
 * @author Nicolas Diaz
 */
public class Conexion {

    // atributos de clase necesarios para crear la conexion con la base de datos
    private static Connection cn = null;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/minihanddb";
    private static String usuario = "root";
    private static String contrasena = "";

    // singleton
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

    // singleton
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

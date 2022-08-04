/*
    Document   : Inicio
    Created on : 22 jul. 2022, 20:19:49
    Author     : Miguel Londono, Nicolas Diaz, Daniel Paez
    Project: Proyecto Final de Modelos de Programacion I
 */
package control.dao;

import control.conexion.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.GradoVO;
import vista.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class GradoDAO {

    // SINGLETON - variable para control de instnacia de clase
    private static GradoDAO instancia;
    
    // atributos de clase necesarios para las operaciones
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    // SINGLETON - Control de solo una instancia de clase
    public static GradoDAO getInstancia(){
        if (instancia == null) {
            instancia = new GradoDAO();
        }
        return instancia;
    }
    
    /**
     * constructor para iniciar la conexion
     */
    private GradoDAO() {
        // iniciar conexion
        con = Conexion.getConexion();
    }
    
    
    public ArrayList<GradoVO> recuperarListaDeGradosDeBaseDeDatos() {
        // instanciacion del arraylist en el que se aljaran todos los registros de la base de datos. Se usa un arraylist porque se desconoce exactamente cuantos registros existen
        ArrayList<GradoVO> misGrados = new ArrayList<>();
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM grados";

        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            st = con.createStatement();
            // guarda lo que retorna la consultta
            rs = st.executeQuery(consulta);
            // mientras haya mas registros en la BD sigue ejecutando el bloque de codifo
            while (rs.next()) {
                // se instancia un ClienteVO nuevo
                GradoVO grado = new GradoVO();
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                grado.setCodigo_grado(Integer.parseInt(rs.getString("codigo_grado")));
                grado.setDescripcion_grado(rs.getString("descripcion_grado"));
                grado.setJornada_grado(rs.getString("jornada_grado"));
                
                // añade el nuevo  al arraylist
                misGrados.add(grado);
            }
            // cierra el stamenten porque ya se realizo la consulta
            st.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que "No se pudo realizar la consulta de la Base de Datos."
            VtnPrincipal.mostrarJOptionPane(1);
            // en caso en que  haya un error al cargar la base de datos cerrara el programa
            System.exit(0);
        }
        // retorna el arraylist con todos los  registros encontrados
        return misGrados;
    }

    /**
     * metodo encargado de insertar datos a la BD que llegan como parametros
     *
     * @param user
     * @param pass
     */
    public void insertarGrados(int codigo_grado, String descripcion_grado, String jornada_grado) {
        try {
            
            st = con.createStatement();
            // intruccion de insercion a la BD codigo
            String insercion = "INSERT INTO grados VALUES(" + codigo_grado + ",'" + descripcion_grado + "','" + jornada_grado + "')";

            // insercion por parte del statement (update)
            st.executeUpdate(insercion);
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }
    
    public void eliminarGrados (int codigo_grado){
        // Instruccion en sql
        String consulta = "DELETE FROM grados where codigo_silla=" + codigo_grado;
        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            st = con.createStatement();
            // Eliminar , agregar o modificar va con update
            st.executeUpdate(consulta);
            // cierra el stamenten porque ya se realizo la consulta
            st.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que
        }
    }

    /**
     * metodo encargado de cerrar conexion a la BD
     *
     * @throws SQLException
     */
    public void cerrarCnx() throws SQLException {
        rs.close();
        rs = null;
        st.close();
        st = null;
        con.close();
        con = null;
    }
}

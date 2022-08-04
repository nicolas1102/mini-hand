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
import modelo.MesVO;
import vista.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class MesDAO {

    // SINGLETON - variable para control de instnacia de clase
    private static MesDAO instancia;
    
    // atributos de clase necesarios para las operaciones
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    // SINGLETON - Control de solo una instancia de clase
    public static MesDAO getInstancia(){
        if (instancia == null) {
            instancia = new MesDAO();
        }
        return instancia;
    }
    
    /**
     * constructor para iniciar la conexion
     */
    private MesDAO() {
        // iniciar conexion
        con = Conexion.getConexion();
    }
    
    
    public ArrayList<MesVO> recuperarListaDeMesesDeBaseDeDatos() {
        // instanciacion del arraylist en el que se aljaran todos los registros de la base de datos. Se usa un arraylist porque se desconoce exactamente cuantos registros existen
        ArrayList<MesVO> misMeses = new ArrayList<>();
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM meses";

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
                MesVO mes = new MesVO();
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                mes.setCodigo_mes(Integer.parseInt(rs.getString("codigo_mes")));
                mes.setNombre_mes(rs.getString("nombre_mes"));
                mes.setAño_mes(Integer.parseInt(rs.getString("año_mes")));
                mes.setCodigo_pago(Integer.parseInt(rs.getString("codigo_pago")));
                
                // añade el nuevo  al arraylist
                misMeses.add(mes);
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
        return misMeses;
    }

    /**
     * metodo encargado de insertar datos a la BD que llegan como parametros
     *
     * @param user
     * @param pass
     */
    public void insertarMes(int codigo_mes, String nombre_mes, int año_mes, int codigo_pago) {
        try {
            
            st = con.createStatement();
            // intruccion de insercion a la BD codigo
            String insercion = "INSERT INTO meses VALUES(" + codigo_mes + ",'" + nombre_mes + "'," + año_mes + "," + codigo_pago + ")";

            // insercion por parte del statement (update)
            st.executeUpdate(insercion);
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }
    
    public void eliminarMes(int codigo_mes){
        // Instruccion en sql
        String consulta = "DELETE FROM meses where codigo_mes=" + codigo_mes;
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

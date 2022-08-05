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
import modelo.PagoVO;
import vista.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class PagoDAO {

    // SINGLETON - variable para control de instnacia de clase
    private static PagoDAO instancia;
    
    // atributos de clase necesarios para las operaciones
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    // SINGLETON - Control de solo una instancia de clase
    public static PagoDAO getInstancia(){
        if (instancia == null) {
            instancia = new PagoDAO();
        }
        return instancia;
    }
    
    /**
     * constructor para iniciar la conexion
     */
    private PagoDAO() {
        // iniciar conexion
        con = Conexion.getConexion();
    }
    
    
    public ArrayList<PagoVO> recuperarListaDePagosDeBaseDeDatos() {
        // instanciacion del arraylist en el que se aljaran todos los registros de la base de datos. Se usa un arraylist porque se desconoce exactamente cuantos registros existen
        ArrayList<PagoVO> misPagos = new ArrayList<>();
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM pagos";

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
                PagoVO pago = new PagoVO();
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                pago.setCodigo_pago(Integer.parseInt(rs.getString("codigo_pago")));
                pago.setEstado_pago(rs.getString("estado_pago"));
                pago.setCodigo_estudiante(Integer.parseInt(rs.getString("codigo_estudiante")));
                pago.setCodigo_mes(Integer.parseInt(rs.getString("codigo_mes")));
                pago.setCodigo_detalle(Integer.parseInt(rs.getString("codigo_detalle")));
                
                // añade el nuevo  al arraylist
                misPagos.add(pago);
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
        return misPagos;
    }

    /**
     * metodo encargado de insertar datos a la BD que llegan como parametros
     *
     * @param user
     * @param pass
     */
    public void insertarPago (int codigo_pago, String estado_pago, String estudiante_pago, String codigo_mes, int codigo_detalle) {
        try {
            
            st = con.createStatement();
            // intruccion de insercion a la BD codigo
            String insercion = "INSERT INTO pagos VALUES(" + codigo_pago + ",'" + estado_pago + "'," + estudiante_pago + "," + codigo_mes + "," + codigo_detalle + ")";

            // insercion por parte del statement (update)
            st.executeUpdate(insercion);
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }
    
    public void eliminarPago (int codigo_pago){
        // Instruccion en sql
        String consulta = "DELETE FROM pagos where codigo_pago=" + codigo_pago;
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

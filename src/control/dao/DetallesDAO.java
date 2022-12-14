package control.dao;

import control.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.DetalleVO;
import vista.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class DetallesDAO {

    // SINGLETON - variable para control de instnacia de clase
    private static DetallesDAO instancia;

    // atributos de clase necesarios para las operaciones
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    // SINGLETON - Control de solo una instancia de clase
    public static DetallesDAO getInstancia(){
        if (instancia == null) {
            instancia = new DetallesDAO();
        }
        return instancia;
    }

    /**
     * constructor para iniciar la conexion
     */
    private DetallesDAO() {
        // iniciar conexion
        con = Conexion.getConexion();
    }


    public ArrayList<DetalleVO> recuperarListaDeDetallesDeBaseDeDatos() {
        // instanciacion del arraylist en el que se aljaran todos los registros de la base de datos. Se usa un arraylist porque se desconoce exactamente cuantos registros existen
        ArrayList<DetalleVO> misDetalles = new ArrayList<>();
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM detalles";

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
                DetalleVO detalle = new DetalleVO();
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                detalle.setCodigo_detalle(Integer.parseInt(rs.getString("codigo_detalle")));
                detalle.setDescripcion_detalle(rs.getString("descripcion_detalle"));
                detalle.setValor_detalle(Integer.parseInt(rs.getString("valor_detalle")));

                // a??ade el nuevo  al arraylist
                misDetalles.add(detalle);
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
        return misDetalles;
    }

    /**
     * metodo encargado de insertar datos a la BD que llegan como parametros
     *
     * @param user
     * @param pass
     */
    public void insertarDetalle(int codigo_detalle, String descripcion_detalle, int valor_detalle, int codigo_pago) {
        try {

            st = con.createStatement();
            // intruccion de insercion a la BD codigo
            String insercion = "INSERT INTO detalles VALUES(" + codigo_detalle + ",'" + descripcion_detalle + "'," + valor_detalle + "," + codigo_pago + ")";

            // insercion por parte del statement (update)
            st.executeUpdate(insercion);
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }

    public void eliminarDetalle (int codigo_detalle){
        // Instruccion en sql
        String consulta = "DELETE FROM detalles where codigo_detalle=" + codigo_detalle;
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
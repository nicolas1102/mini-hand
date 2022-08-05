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
import modelo.ReciboVO;
import vista.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class RecibosDAO {

    // SINGLETON - variable para control de instnacia de clase
    private static RecibosDAO instancia;
    // atributos de clase necesarios para las operaciones
    private Connection con = null;

    // SINGLETON - Control de solo una instancia de clase
    public static RecibosDAO getInstancia() {
        if (instancia == null) {
            instancia = new RecibosDAO();
        }
        return instancia;
    }

    /**
     * constructor para iniciar la conexion
     */
    private RecibosDAO() {
        // iniciar conexion
        con = Conexion.getConexion();
    }

    public ArrayList<ReciboVO> recuperarDatosDePagosDeBaseDeDatos() {

        Statement stPagos = null;
        ResultSet rsPagos = null;

        ArrayList<ReciboVO> misRecibos = new ArrayList<>();
        
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM pagos";

        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            stPagos = con.createStatement();
            // guarda lo que retorna la consultta
            rsPagos = stPagos.executeQuery(consulta);
            // mientras haya mas registros en la BD sigue ejecutando el bloque de codifo
            while (rsPagos.next()) {
                ReciboVO recibo = new ReciboVO();
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                recibo.setCodigo_pago(Integer.parseInt(rsPagos.getString("codigo_pago")));
                recibo.setEstado_pago(rsPagos.getString("estado_pago"));

                recibo.setCodigo_estudiante(Integer.parseInt(rsPagos.getString("codigo_estudiante")));
                recuperarDatosDeEstudiantesDeBaseDeDatos(recibo);

                recibo.setCodigo_mes(Integer.parseInt(rsPagos.getString("codigo_mes")));
                recuperarDatosDeMesesDeBaseDeDatos(recibo);

                recibo.setCodigo_detalle(Integer.parseInt(rsPagos.getString("codigo_detalle")));
                recuperarDatosDeDetallesDeBaseDeDatos(recibo);

                misRecibos.add(recibo);
            }

            // cierra el stamenten porque ya se realizo la consulta
            stPagos.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que "No se pudo realizar la consulta de la Base de Datos."
            VtnPrincipal.mostrarJOptionPane(1);
            // en caso en que  haya un error al cargar la base de datos cerrara el programa
            System.exit(0);
        }
        return misRecibos;
    }

    public void recuperarDatosDeEstudiantesDeBaseDeDatos(ReciboVO reciboVO) {

        Statement stEstudiantes = null;
        ResultSet rsEstudiantes = null;
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM estudiantes where codigo_estudiante=" + reciboVO.getCodigo_estudiante();

        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            stEstudiantes = con.createStatement();
            // guarda lo que retorna la consultta
            rsEstudiantes = stEstudiantes.executeQuery(consulta);
            // mientras haya mas registros en la BD sigue ejecutando el bloque de codifo
            while (rsEstudiantes.next()) {
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                reciboVO.setCodigo_persona(Integer.parseInt(rsEstudiantes.getString("codigo_persona")));
                recuperarDatosDePersonasDeBaseDeDatos(reciboVO);
                reciboVO.setCodigo_grado(Integer.parseInt(rsEstudiantes.getString("codigo_grado")));
                recuperarDatosDeGradosDeBaseDeDatos(reciboVO);
            }
            // cierra el stamenten porque ya se realizo la consulta
            stEstudiantes.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que "No se pudo realizar la consulta de la Base de Datos."
            VtnPrincipal.mostrarJOptionPane(1);
            // en caso en que  haya un error al cargar la base de datos cerrara el programa
            System.exit(0);
        }
    }

    public void recuperarDatosDePersonasDeBaseDeDatos(ReciboVO reciboVO) {

        Statement stPersonas = null;
        ResultSet rsPersonas = null;
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM personas where codigo_persona=" + reciboVO.getCodigo_persona();

        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            stPersonas = con.createStatement();
            // guarda lo que retorna la consultta
            rsPersonas = stPersonas.executeQuery(consulta);
            // mientras haya mas registros en la BD sigue ejecutando el bloque de codifo
            while (rsPersonas.next()) {
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                reciboVO.setNombre_persona(rsPersonas.getString("nombre_persona"));
            }
            // cierra el stamenten porque ya se realizo la consulta
            stPersonas.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que "No se pudo realizar la consulta de la Base de Datos."
            VtnPrincipal.mostrarJOptionPane(1);
            // en caso en que  haya un error al cargar la base de datos cerrara el programa
            System.exit(0);
        }
    }

    public void recuperarDatosDeGradosDeBaseDeDatos(ReciboVO reciboVO) {

        Statement stGrados = null;
        ResultSet rsGrados = null;
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM grados where codigo_grado=" + reciboVO.getCodigo_grado();

        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            stGrados = con.createStatement();
            // guarda lo que retorna la consultta
            rsGrados = stGrados.executeQuery(consulta);
            // mientras haya mas registros en la BD sigue ejecutando el bloque de codifo
            while (rsGrados.next()) {
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                reciboVO.setDescripcion_grado(rsGrados.getString("descripcion_grado"));
            }
            // cierra el stamenten porque ya se realizo la consulta
            stGrados.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que "No se pudo realizar la consulta de la Base de Datos."
            VtnPrincipal.mostrarJOptionPane(1);
            // en caso en que  haya un error al cargar la base de datos cerrara el programa
            System.exit(0);
        }
    }

    public void recuperarDatosDeMesesDeBaseDeDatos(ReciboVO reciboVO) {

        Statement stMeses = null;
        ResultSet rsMeses = null;
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM meses where codigo_mes=" + reciboVO.getCodigo_mes();

        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            stMeses = con.createStatement();
            // guarda lo que retorna la consultta
            rsMeses = stMeses.executeQuery(consulta);
            // mientras haya mas registros en la BD sigue ejecutando el bloque de codifo
            while (rsMeses.next()) {
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                reciboVO.setAño_mes(Integer.parseInt(rsMeses.getString("año_mes")));
                reciboVO.setNombre_mes(rsMeses.getString("nombre_mes"));
            }
            // cierra el stamenten porque ya se realizo la consulta
            stMeses.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que "No se pudo realizar la consulta de la Base de Datos."
            VtnPrincipal.mostrarJOptionPane(1);
            // en caso en que  haya un error al cargar la base de datos cerrara el programa
            System.exit(0);
        }
    }

    public void recuperarDatosDeDetallesDeBaseDeDatos(ReciboVO reciboVO) {

        Statement stDetalles = null;
        ResultSet rsDetalles = null;
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM detalles where codigo_detalle=" + reciboVO.getCodigo_detalle();

        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            stDetalles = con.createStatement();
            // guarda lo que retorna la consultta
            rsDetalles = stDetalles.executeQuery(consulta);
            // mientras haya mas registros en la BD sigue ejecutando el bloque de codifo
            while (rsDetalles.next()) {
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                reciboVO.setDescripcion_detalle(rsDetalles.getString("descripcion_detalle"));
                reciboVO.setValor_detalle(Integer.parseInt(rsDetalles.getString("valor_detalle")));
            }
            // cierra el stamenten porque ya se realizo la consulta
            stDetalles.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que "No se pudo realizar la consulta de la Base de Datos."
            VtnPrincipal.mostrarJOptionPane(1);
            // en caso en que  haya un error al cargar la base de datos cerrara el programa
            System.exit(0);
        }
    }
    
    public boolean modificarRegistro(int codigo_pago, String estado_pago, int codigo_estudiante, int codigo_mes, int codigo_detalle) {
        Statement stModicficar = null;
        //Instruccion en sql para modificar cada uno de los campos de un registro con los objetos que llegaron
        String consulta1 = "update pagos set estado_pago ='" + estado_pago + "' where codigo_pago=" + codigo_pago;
        String consulta2 = "update pagos set codigo_estudiante ='" + codigo_estudiante + "' where codigo_pago=" + codigo_pago;
        String consulta3 = "update pagos set codigo_mes ='" + codigo_mes + "' where codigo_pago=" + codigo_pago;
        String consulta4 = "update pagos set codigo_detalle ='" + codigo_detalle + "' where codigo_pago=" + codigo_pago;
        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            stModicficar = con.createStatement();
            // enviamos la instruccion para que actualice "update" la base de datos con la instruccion que ingresamos arriba
            stModicficar.executeUpdate(consulta1);
            stModicficar.executeUpdate(consulta2);
            stModicficar.executeUpdate(consulta3);
            stModicficar.executeUpdate(consulta4);
            // cierra el stamenten porque ya se realizo la consulta
            stModicficar.close();
            // desconecta la DB
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            // ventana emergente en caso de errros que comunica que "No se pudo modificar el animal"
            VtnPrincipal.mostrarJOptionPane(9);
        }
        return false;
    }

    /**
     * metodo encargado de insertar datos a la BD que llegan como parametros
     *
     * @param user
     * @param pass
     */
    public void insertarRecibo(int codigo_pago, String estado_pago, String estudiante_pago, String codigo_mes, int codigo_detalle) {

        Statement stPagos = null;
        ResultSet rsPagos = null;
        try {

            stPagos = con.createStatement();
            // intruccion de insercion a la BD codigo
            String insercion = "INSERT INTO pagos VALUES(" + codigo_pago + ",'" + estado_pago + "'," + estudiante_pago + "," + codigo_mes + "," + codigo_detalle + ")";

            // insercion por parte del statement (update)
            stPagos.executeUpdate(insercion);
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }

    public void eliminarPago(int codigo_pago) {

        Statement stPagos = null;
        ResultSet rsPagos = null;
        // Instruccion en sql
        String consulta = "DELETE FROM pagos where codigo_pago=" + codigo_pago;
        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            stPagos = con.createStatement();
            // Eliminar , agregar o modificar va con update
            stPagos.executeUpdate(consulta);
            // cierra el stamenten porque ya se realizo la consulta
            stPagos.close();
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
    public void cerrarCnx(Statement st, ResultSet rs) throws SQLException {
        rs.close();
        rs = null;
        st.close();
        st = null;
        con.close();
        con = null;
    }
}

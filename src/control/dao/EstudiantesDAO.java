/*
    Document   : Inicio
    Created on : 22 jul. 2022, 20:19:49
    Author     : Miguel Londono, Nicolas Diaz, Daniel Paez
    Project: Proyecto Final de Modelos de Programacion I
 */
package control.dao;

import control.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.EstudianteVO;
import vista.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class EstudiantesDAO {

    // SINGLETON - variable para control de instnacia de clase
    private static EstudiantesDAO instancia;

    // atributos de clase necesarios para las operaciones
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    // SINGLETON - Control de solo una instancia de clase
    public static EstudiantesDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstudiantesDAO();
        }
        return instancia;
    }

    /**
     * constructor para iniciar la conexion
     */
    private EstudiantesDAO() {
        // iniciar conexion
        con = Conexion.getConexion();
    }

    public ArrayList<EstudianteVO> recuperarListaDeEstudiantesDeBaseDeDatos() {
        // instanciacion del arraylist en el que se aljaran todos los registros de la base de datos. Se usa un arraylist porque se desconoce exactamente cuantos registros existen
        ArrayList<EstudianteVO> misEstudiantes = new ArrayList<>();
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM estudiantes";

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
                EstudianteVO estudiante = new EstudianteVO();
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                estudiante.setCodigo_estudiante(Integer.parseInt(rs.getString("codigo_estudiante")));
                estudiante.setCodigo_persona(Integer.parseInt(rs.getString("codigo_persona")));
                estudiante.setCodigo_grado(Integer.parseInt(rs.getString("codigo_grado")));

                // añade el nuevo  al arraylist
                misEstudiantes.add(estudiante);
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
        return misEstudiantes;
    }

    /**
     * metodo encargado de insertar datos a la BD que llegan como parametros
     *
     * @param user
     * @param pass
     */
    public void insertarEstudiante(int codigo_estudiante, int codigo_persona, int codigo_grado) {
        try {

            st = con.createStatement();
            // intruccion de insercion a la BD codigo
            String insercion = "INSERT INTO estudiantes VALUES(" + codigo_estudiante + "," + codigo_persona + "," + codigo_grado + ")";

            // insercion por parte del statement (update)
            st.executeUpdate(insercion);
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }

    public void eliminarEstudiante(int codigo_estudiante) {
        // Instruccion en sql
        String consulta = "DELETE FROM estudiantes where codigo_estudiante=" + codigo_estudiante;
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

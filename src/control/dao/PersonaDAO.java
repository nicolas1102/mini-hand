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
import modelo.PersonaVO;
import vista.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class PersonaDAO {

    // SINGLETON - variable para control de instnacia de clase
    private static PersonaDAO instancia;
    
    // atributos de clase necesarios para las operaciones
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    // SINGLETON - Control de solo una instancia de clase
    public static PersonaDAO getInstancia(){
        if (instancia == null) {
            instancia = new PersonaDAO();
        }
        return instancia;
    }
    
    /**
     * constructor para iniciar la conexion
     */
    private PersonaDAO() {
        // iniciar conexion
        con = Conexion.getConexion();
    }
    
    
    public ArrayList<PersonaVO> recuperarListaDePersonasBaseDeDatos() {
        // instanciacion del arraylist en el que se aljaran todos los registros de la base de datos. Se usa un arraylist porque se desconoce exactamente cuantos registros existen
        ArrayList<PersonaVO> misPersonas = new ArrayList<>();
        // Instruccion en sql que pide todos los registros de la base de datos
        String consulta = "SELECT * FROM personas";

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
                PersonaVO persona = new PersonaVO();
                // pedimos datos del registro y se lo asignamos a cada variable de nuestro animal instanciado anteriomente
                persona.setCodigo_persona(Integer.parseInt(rs.getString("codigo_persona")));
                persona.setNombre_persona(rs.getString("nombre_persona"));
                persona.setEdad_persona(Integer.parseInt(rs.getString("edad_persona")));
                persona.setAño_vinculacion_persona(Integer.parseInt(rs.getString("año_vinculacion_persona")));
                
                // añade el nuevo  al arraylist
                misPersonas.add(persona);
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
        return misPersonas;
    }

    /**
     * metodo encargado de insertar datos a la BD que llegan como parametros
     *
     * @param user
     * @param pass
     */
    public void insertarPersona(int codigo_persona, String nombre_persona, int edad_persona, int año_vinculacion_persona) {
        try {
            
            st = con.createStatement();
            // intruccion de insercion a la BD codigo
            String insercion = "INSERT INTO personas VALUES(" + codigo_persona + ",'" + nombre_persona + "'," + edad_persona + "," + año_vinculacion_persona + ")";

            // insercion por parte del statement (update)
            st.executeUpdate(insercion);
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }
    
    public void eliminarPersona (int codigo_persona){
        // Instruccion en sql
        String consulta = "DELETE FROM personas where codigo_persona=" + codigo_persona;
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

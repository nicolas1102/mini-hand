/*
    Document   : Control
    Created on : 22 jul. 2022, 20:19:49
    Author     : Miguel Londono, Nicolas Diaz, Felipe Pacheco
    Project: Proyecto Final de Fundamentos de Bases de Datos
 */
package control.logica;

import control.conexion.Conexion;
import control.dao.DetalleDAO;
import control.dao.EstudianteDAO;
import control.dao.GradoDAO;
import control.dao.MesDAO;
import control.dao.PagoDAO;
import control.dao.PersonaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import modelo.DetalleVO;
import modelo.EstudianteVO;
import modelo.GradoVO;
import modelo.MesVO;
import modelo.PagoVO;
import modelo.PersonaVO;
import vista.VtnPrincipal;
import vista.VtnEstudiantes;

/**
 *
 *
 * @author Usuario
 */
public class Control implements ActionListener {

    // SINGLETON - variable para control de instnacia de clase
    private static Control instancia;

    //----------- ATRIBUTOS ---------------------
    private VtnPrincipal vtnPrincipal;
    private VtnEstudiantes vtnEstudiantes;
    private DetalleDAO misDetallesDAO;
    private EstudianteDAO misEstudiantesDAO;
    private GradoDAO misGradosDAO;
    private MesDAO misMesesDAO;
    private PagoDAO misPagosDAO;
    private PersonaDAO misPersonasDAO;
    private ArrayList<DetalleVO> listaDetalles;
    private ArrayList<EstudianteVO> listaEstudiantes;
    private ArrayList<GradoVO> listaGrados;
    private ArrayList<MesVO> listaMes;
    private ArrayList<PagoVO> listaPagos;
    private ArrayList<PersonaVO> listaPersonas;

    // SINGLETON - Control de solo una instancia de clase
    public static Control getInstancia() throws IOException {
        if (instancia == null) {
            instancia = new Control();
        }
        return instancia;
    }

    /**
     * Contructor
     *
     * @throws IOException
     */
    private Control() throws IOException {

        // SINGLETON - Ventana principal
        vtnPrincipal = VtnPrincipal.getInstancia();
        vtnEstudiantes = VtnEstudiantes.getInstancia();
    
        //instanciacion de arraylist donde se guardaran objetos de cada tipo de registro de la base de datos
        listaDetalles = new ArrayList<>();
        listaEstudiantes = new ArrayList<>();
        listaGrados = new ArrayList<>();
        listaMes = new ArrayList<>();
        listaPagos = new ArrayList<>();
        listaPersonas = new ArrayList<>();

        // configura la conexion con la base de datos
        Conexion.getConexion();
        // obtener registros de la base de datos e ingresarlos a arraylist de cada tipo
        obtenerRegistrosBaseDeDatos();
        // iniciar ventana
        iniciarVtnPrincipal();

    }

    // ------------------------------------- OBTENCION DE REGISTROS DE LAS TABLASE DE LA BASE DE DATOS -------------------------------
    /**
     * Recoge el arraylist con todos los animales registrados en la base de
     * datos anteriormente, luego de esto guarda un archivo aleatorio con toda
     * la informacion
     */
    public void obtenerRegistrosBaseDeDatos() {
        // creacion de una nueva instancia para su implementacion al recuperar una arraylist con todos los registros de la base de datos
        misDetallesDAO = DetalleDAO.getInstancia();
        misEstudiantesDAO = EstudianteDAO.getInstancia();
        misGradosDAO = GradoDAO.getInstancia();
        misMesesDAO = MesDAO.getInstancia();
        misPagosDAO = PagoDAO.getInstancia();
        misPersonasDAO = PersonaDAO.getInstancia();
        
        // extracion de datos
        listaDetalles = misDetallesDAO.recuperarListaDeDetallesDeBaseDeDatos();
        listaEstudiantes = misEstudiantesDAO.recuperarListaDeEstudiantesDeBaseDeDatos();
        listaGrados = misGradosDAO.recuperarListaDeGradosDeBaseDeDatos();
        listaMes = misMesesDAO.recuperarListaDeMesesDeBaseDeDatos();
        listaPagos = misPagosDAO.recuperarListaDePagosDeBaseDeDatos();
        listaPersonas = misPersonasDAO.recuperarListaDePersonasBaseDeDatos();

    }
    
    // -------------------------------------------------  INICIACION DE VENTANAS ----------------------------------------
    /**
     * Metodo encargado de iniciar la ventana principal, dandole una posicion y
     * un titulo
     */
    public void iniciarVtnPrincipal() throws IOException {
        //configuracion del titulo de la ventana
        vtnPrincipal.setTitle("MiniHand - Principal");
        // configuracion de la posicion de la ventana
        vtnPrincipal.setLocationRelativeTo(null);
        vtnPrincipal.setVisible(true);
        agregarActionListenerVtnLogin();
    }

    public void iniciarVtnMultiplex() throws IOException {
        //configuracion del titulo de la ventana
        vtnEstudiantes.setTitle("MiniHand - Estudiantes");
        // configuracion de la posicion de la ventana
        vtnEstudiantes.setLocationRelativeTo(null);
        vtnEstudiantes.setVisible(true);
        agregarActionListenerVtnEstudiantes();
    }

    // ----------------------------------------- AGREGACION DE ACTIONLISTENER DE CADA VENTANA -----------------------------
    public void agregarActionListenerVtnLogin() throws IOException {
        // se preparan los botones de la interfaz para que pueda escuchar instrucciones
        this.vtnPrincipal.btnSalir.addActionListener(this);
    }

    public void agregarActionListenerVtnEstudiantes() throws IOException {
        // se preparan los botones de la interfaz para que pueda escuchar instrucciones
        this.vtnEstudiantes.btnSalir.addActionListener(this);
    }

    // -----------------------------------------  CONFIGURACION DE BOTONES -----------------------------------------------
    /**
     * Metodo sobreescrito de la Clase ActionListener, donde con el parametro se
     * capturara el evento respectivo a cada jBtn para ejecutar las respectivas
     * acciones
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //  -------------------------------------- BOTONES VENTANA LOGIN ------------------------------------------------
//        if (e.getSource() == vtnLogin.btnEntrar) {
//
//            if ((!vtnLogin.checkEmpleado.isSelected())) {
//                try {
//                    miClientesDAO = ClientesDAO.getInstancia();
//
//                    // verificacion de credenciales
//                    ClienteVO clienteLogeado = miClientesDAO.consultarCliente(vtnLogin.textFUsername.getText(), vtnLogin.textFContrasena.getText());
//
//                    if (clienteLogeado.getNombre() != null) {
//
//                        // ---- CONSTRUCCION PEDIDO ----
//                        codigo_cliente = clienteLogeado.getCodigo();
//                        pedido.setCodigo_cliente(codigo_cliente);
//
//                        iniciarVtnMultiplex();
//                        vtnLogin.setVisible(false);
//
//                    } else {
//                        // reemplazar por joption pain emergente situada en metodo de la ventana login
//                        System.out.println("Usuario o contraseña incorrecto, vuelva a intentar");
//                    }
//
//                } catch (IOException ex) {
//                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else {
//                // logica de empleado (ventana)
//            }
//        }

       
        // ---------------------------------- BOTON SALIR DE TODAS LAS VENTANAS ----------------------------------------------
        if ((e.getSource() == vtnPrincipal.btnSalir) || (e.getSource() == vtnEstudiantes.btnSalir)) {
            vtnPrincipal.dispose();
            vtnEstudiantes.dispose();
        }
    }

}

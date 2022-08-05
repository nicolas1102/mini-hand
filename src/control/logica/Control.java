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
import control.dao.RecibosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleVO;
import modelo.EstudianteVO;
import modelo.GradoVO;
import modelo.MesVO;
import modelo.PagoVO;
import modelo.PersonaVO;
import modelo.ReciboVO;
import vista.VtnPrincipal;
import vista.VtnRecibos;

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
    private VtnRecibos vtnRecibos;
    private RecibosDAO miRecibosDAO;
    private ArrayList<ReciboVO> listaRecibos;

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
        vtnRecibos = VtnRecibos.getInstancia();

        // configura la conexion con la base de datos
        Conexion.getConexion();

        listaRecibos = new ArrayList<>();

        miRecibosDAO = RecibosDAO.getInstancia();
        //instanciacion de arraylist donde se guardaran objetos de cada tipo de registro de la base de datos
        listaRecibos = miRecibosDAO.recuperarDatosDePagosDeBaseDeDatos();

        // iniciar ventana principal
        iniciarVtnPrincipal();

    }

    public void insertarRecibosATabla() {
        DefaultTableModel modelo = (DefaultTableModel) vtnRecibos.tableEstudiantesRegistros.getModel();
        for (int i = 0; i < 4; i++){
            modelo.removeRow(0);
        }
        
        for (ReciboVO recibo : listaRecibos) {
            modelo.addRow(new Object[]{recibo.getCodigo_estudiante(), recibo.getNombre_persona(), recibo.getDescripcion_grado(), recibo.getCodigo_pago(), recibo.getDescripcion_detalle(), recibo.getAño_mes(), recibo.getNombre_mes(), recibo.getEstado_pago(), recibo.getValor_detalle()});
        }

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
        agregarActionListenerVtnPrincipal();
    }

    public void iniciarVtnRecibos() throws IOException {
        //configuracion del titulo de la ventana
        vtnRecibos.setTitle("MiniHand - Estudiantes");
        // configuracion de la posicion de la ventana
        vtnRecibos.setLocationRelativeTo(null);
        vtnRecibos.setVisible(true);
        agregarActionListenerVtnEstudiantes();
    }

    // ----------------------------------------- AGREGACION DE ACTIONLISTENER DE CADA VENTANA -----------------------------
    public void agregarActionListenerVtnPrincipal() throws IOException {
        // se preparan los botones de la interfaz para que pueda escuchar instrucciones
        this.vtnPrincipal.btnInciar.addActionListener(this);
        this.vtnPrincipal.btnSalir.addActionListener(this);
    }

    public void agregarActionListenerVtnEstudiantes() throws IOException {
        // se preparan los botones de la interfaz para que pueda escuchar instrucciones
        this.vtnRecibos.btnAgregarRecibo.addActionListener(this);
        this.vtnRecibos.btnActualizarRecibo.addActionListener(this);
        this.vtnRecibos.btnEliminarRecibo.addActionListener(this);
        this.vtnRecibos.btnSalir.addActionListener(this);
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

        //  -------------------------------------- BOTONES VENTANA PRINCIPAL ------------------------------------------------
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
        //  -------------------------------------- BOTONES VENTANA ESTUDIANTES ------------------------------------------------
        if (e.getSource() == vtnPrincipal.btnInciar) {
            try {
                iniciarVtnRecibos();
                vtnPrincipal.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }

            insertarRecibosATabla();

        }

        //  -------------------------------------- BOTONES VENTANA GRADOS ------------------------------------------------
        //  -------------------------------------- BOTONES VENTANA PAGOS ------------------------------------------------
        //  -------------------------------------- BOTONES VENTANA MES ------------------------------------------------
        //  -------------------------------------- BOTONES VENTANA DETALLE ------------------------------------------------
        // ---------------------------------- BOTON SALIR DE TODAS LAS VENTANAS ----------------------------------------------
        if ((e.getSource() == vtnPrincipal.btnSalir) || (e.getSource() == vtnRecibos.btnSalir)) {
            vtnPrincipal.dispose();
            vtnRecibos.dispose();
        }
    }

}

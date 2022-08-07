/*
    Document   : Control
    Created on : 22 jul. 2022, 20:19:49
    Author     : Miguel Londono, Nicolas Diaz, Felipe Pacheco
    Project: Proyecto Final de Fundamentos de Bases de Datos
 */
package control.logica;

import control.conexion.Conexion;
import control.dao.DetallesDAO;
import control.dao.EstudiantesDAO;
import control.dao.MesesDAO;
import control.dao.PagosDAO;
import control.dao.PersonasDAO;
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
import modelo.MesVO;
import modelo.PagoVO;
import modelo.PersonaVO;
import modelo.ReciboVO;
import vista.VtnActualizarRecibo;
import vista.VtnAgregarRecibo;
import vista.VtnPrincipal;
import vista.VtnRecibos;

/**
 *
 * @author Miguel Londoño
 * @author Felipe Pacheco
 * @author Nicolas Diaz
 */
public class Control implements ActionListener {

    // SINGLETON - variable para control de instnacia de clase
    private static Control instancia;

    //----------- ATRIBUTOS ---------------------
    private VtnPrincipal vtnPrincipal;
    private VtnRecibos vtnRecibos;
    private VtnAgregarRecibo vtnAgregarRecibo;
    private VtnActualizarRecibo vtnActualizarRecibo;
    private RecibosDAO miRecibosDAO;
    private DetallesDAO misDetallesDAO;
    private EstudiantesDAO misEstudiantesDAO;
    private MesesDAO misMesesDAO;
    private PagosDAO misPagosDAO;
    private PersonasDAO misPersonasDAO;
    private ArrayList<ReciboVO> listaRecibos;
    private ArrayList<DetalleVO> listaDetalles;
    private ArrayList<EstudianteVO> listaEstudiantes;
    private ArrayList<MesVO> listaMeses;
    private ArrayList<PagoVO> listaPagos;
    private ArrayList<PersonaVO> listaPersonas;
    private int cantRegistros = 0;

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
        vtnAgregarRecibo = VtnAgregarRecibo.getInstancia();
        vtnActualizarRecibo = vtnActualizarRecibo.getInstancia();

        // configura la conexion con la base de datos
        Conexion.getConexion();

        // arraylist donde se guarda los objetos
        listaRecibos = new ArrayList<>();
        listaDetalles = new ArrayList<>();
        listaEstudiantes = new ArrayList<>();
        listaMeses = new ArrayList<>();
        listaPagos = new ArrayList<>();
        listaPersonas = new ArrayList<>();

        obtenerRegistrosBaseDeDatos();

        // iniciar ventana principal
        iniciarVtnPrincipal();

    }

    public void obtenerRegistrosBaseDeDatos() {
        // objeto para operaciones con la base de datos
        miRecibosDAO = RecibosDAO.getInstancia();
        misDetallesDAO = DetallesDAO.getInstancia();
        misEstudiantesDAO = EstudiantesDAO.getInstancia();
        misMesesDAO = MesesDAO.getInstancia();
        misPagosDAO = PagosDAO.getInstancia();
        misPersonasDAO = misPersonasDAO.getInstancia();

        // recuperacion de registros
        listaRecibos = miRecibosDAO.recuperarDatosDePagosDeBaseDeDatos();
        listaDetalles = misDetallesDAO.recuperarListaDeDetallesDeBaseDeDatos();
        listaEstudiantes = misEstudiantesDAO.recuperarListaDeEstudiantesDeBaseDeDatos();
        listaMeses = misMesesDAO.recuperarListaDeMesesDeBaseDeDatos();
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
        agregarActionListenerVtnPrincipal();
    }

    public void iniciarVtnRecibos() throws IOException {
        //configuracion del titulo de la ventana
        vtnRecibos.setTitle("MiniHand - Recibos");
        // configuracion de la posicion de la ventana
        vtnRecibos.setLocationRelativeTo(null);
        vtnRecibos.setVisible(true);
        agregarActionListenerVtnEstudiantes();
    }

    public void iniciarVtnAgregarRecibo() throws IOException {
        //configuracion del titulo de la ventana
        vtnAgregarRecibo.setTitle("MiniHand - Agregar Recibo");
        // configuracion de la posicion de la ventana
        vtnAgregarRecibo.setLocationRelativeTo(null);
        vtnAgregarRecibo.setVisible(true);
        agregarActionListenerVtnAgregarRecibo();
    }

    public void iniciarVtnActualizarRecibo() throws IOException {
        //configuracion del titulo de la ventana
        vtnActualizarRecibo.setTitle("MiniHand - Actualizar Recibo");
        // configuracion de la posicion de la ventana
        vtnActualizarRecibo.setLocationRelativeTo(null);
        vtnActualizarRecibo.setVisible(true);
        agregarActionListenerVtnActualizarRecibo();
    }

    // ----------------------------------------- AGREGACION DE ACTIONLISTENER DE CADA VENTANA -----------------------------
    public void agregarActionListenerVtnPrincipal() throws IOException {
        // se preparan los botones de la interfaz para que pueda escuchar instrucciones
        this.vtnPrincipal.btnInciar.addActionListener(this);
        this.vtnPrincipal.btnSalir.addActionListener(this);
    }

    public void agregarActionListenerVtnEstudiantes() throws IOException {
        // se preparan los botones de la interfaz para que pueda escuchar instrucciones
        this.vtnRecibos.btnBuscarRecibos.addActionListener(this);
        this.vtnRecibos.btnAgregarRecibo.addActionListener(this);
        this.vtnRecibos.btnActualizarRecibo.addActionListener(this);
        this.vtnRecibos.btnEliminarRecibo.addActionListener(this);
        this.vtnRecibos.btnSalir.addActionListener(this);
    }

    public void agregarActionListenerVtnAgregarRecibo() throws IOException {
        // se preparan los botones de la interfaz para que pueda escuchar instrucciones
        this.vtnAgregarRecibo.btnAgregarRecibo.addActionListener(this);
    }

    public void agregarActionListenerVtnActualizarRecibo() throws IOException {
        // se preparan los botones de la interfaz para que pueda escuchar instrucciones
        this.vtnActualizarRecibo.btnActualizarRecibo.addActionListener(this);
    }

    // ----------------------------------------- FUNCIONALIDADES -------------------------------------
    public void insertarRecibosATabla(ArrayList<ReciboVO> auxListaRecibos) {
        // manejo de modelo de la tabla de resgistros
        DefaultTableModel modelo = (DefaultTableModel) vtnRecibos.tableEstudiantesRegistros.getModel();

        // recorrer lista de recibos 
        for (ReciboVO recibo : auxListaRecibos) {
            // agregar registro a tabla de registros
            modelo.addRow(new Object[]{recibo.getCodigo_estudiante(), recibo.getNombre_persona(), recibo.getDescripcion_grado(), recibo.getCodigo_pago(), recibo.getDescripcion_detalle(), recibo.getAño_mes(), recibo.getNombre_mes(), recibo.getEstado_pago(), recibo.getValor_detalle()});
            cantRegistros = cantRegistros + 1;
        }

    }

    public void actualizarTabla(ArrayList<ReciboVO> auxListaRecibos) {
        DefaultTableModel modelo = (DefaultTableModel) vtnRecibos.tableEstudiantesRegistros.getModel();

        // borra registros de tabla
        for (int i = 0; i < cantRegistros; i++) {
            modelo.removeRow(0);
        }
        cantRegistros = 0;

        // metodo usado para volver a registrar recibos
        insertarRecibosATabla(auxListaRecibos);
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
        if (e.getSource() == vtnPrincipal.btnInciar) {
            // remover filas inusadas de la tabla
            DefaultTableModel modelo = (DefaultTableModel) vtnRecibos.tableEstudiantesRegistros.getModel();
            for (int i = 0; i < 4; i++) {
                modelo.removeRow(0);
            }

            try {
                iniciarVtnRecibos();
                vtnPrincipal.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }

            // 
            insertarRecibosATabla(listaRecibos);

        }

        //  -------------------------------------- BOTONES VENTANA RECIBOS ------------------------------------------------
        if (e.getSource() == vtnRecibos.btnBuscarRecibos) {
            ArrayList<ReciboVO> auxListaRecibos = new ArrayList<>();

            for (ReciboVO recibo : listaRecibos) {
                if (vtnRecibos.txtFBuscarRecibos.getText().equals(String.valueOf(recibo.getCodigo_estudiante()))) {
                    auxListaRecibos.add(recibo);
                }
            }
            actualizarTabla(auxListaRecibos);
        }

        // -------------------------- VENTANA AGREGAR RECIBO ----------------------
        if (e.getSource() == vtnRecibos.btnAgregarRecibo) {
            try {
                iniciarVtnAgregarRecibo();

                for (EstudianteVO estudiante : listaEstudiantes) {
                    PersonaVO personaVO = listaPersonas.get(estudiante.getCodigo_persona() - 1);
                    vtnAgregarRecibo.cBoxEstudiante.addItem(String.valueOf(estudiante.getCodigo_estudiante()) + " - " + String.valueOf(personaVO.getNombre_persona()));
                }

                for (DetalleVO detalle : listaDetalles) {
                    vtnAgregarRecibo.cBoxDescripcion.addItem(String.valueOf(detalle.getCodigo_detalle()) + " - " + String.valueOf(detalle.getDescripcion_detalle()) + " - " + String.valueOf(detalle.getValor_detalle()));
                }

                for (MesVO mes : listaMeses) {
                    vtnAgregarRecibo.cBoxMes.addItem(String.valueOf(mes.getCodigo_mes()) + " - " + String.valueOf(mes.getNombre_mes()) + " - " + String.valueOf(mes.getAño_mes()));
                }

            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == vtnRecibos.btnActualizarRecibo) {
            try {
                iniciarVtnActualizarRecibo();
                for (ReciboVO recibo : listaRecibos) {
                    vtnActualizarRecibo.cBoxCodPago.addItem(String.valueOf(recibo.getCodigo_pago()));
                }
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == vtnAgregarRecibo.btnAgregarRecibo) {

            String codigo_estudiante = (String) vtnAgregarRecibo.cBoxEstudiante.getSelectedItem();
            String[] arrayCodigo_estudiante = codigo_estudiante.split("\\s+");

            String codigo_descripcion = (String) vtnAgregarRecibo.cBoxDescripcion.getSelectedItem();
            String[] arrayCodigo_descripcion = codigo_descripcion.split("\\s+");

            String codigo_mes = (String) vtnAgregarRecibo.cBoxMes.getSelectedItem();
            String[] arrayCodigo_mes = codigo_mes.split("\\s+");

            miRecibosDAO.insertarRecibo((String) vtnAgregarRecibo.cBoxEstado.getSelectedItem(), Integer.parseInt(arrayCodigo_estudiante[0]), Integer.parseInt(arrayCodigo_mes[0]), Integer.parseInt(arrayCodigo_descripcion[0]));
            vtnAgregarRecibo.setVisible(false);
            vtnAgregarRecibo.dispose();

            listaRecibos = miRecibosDAO.recuperarDatosDePagosDeBaseDeDatos();
            actualizarTabla(listaRecibos);

        }

        // -------------------------- VENTANA ACTUALIZAR RECIBO ----------------------
        if (e.getSource() == vtnActualizarRecibo.btnActualizarRecibo) {
            ReciboVO recibo = listaRecibos.get(Integer.parseInt((String) vtnActualizarRecibo.cBoxCodPago.getSelectedItem()));

            miRecibosDAO.modificarRegistro(recibo.getCodigo_pago(), String.valueOf(vtnActualizarRecibo.cBoxCodPago1.getSelectedItem()), recibo.getCodigo_estudiante(), recibo.getCodigo_mes(), recibo.getCodigo_detalle());
            listaRecibos = miRecibosDAO.recuperarDatosDePagosDeBaseDeDatos();

            actualizarTabla(listaRecibos);

            vtnActualizarRecibo.dispose();
        }

        // ---------------------------------- BOTON SALIR DE TODAS LAS VENTANAS ----------------------------------------------
        if ((e.getSource() == vtnPrincipal.btnSalir) || (e.getSource() == vtnRecibos.btnSalir)) {
            vtnPrincipal.dispose();
            vtnRecibos.dispose();
            System.exit(0);
        }
    }

}

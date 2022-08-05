/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Miguel D
 */
public class ReciboVO {
    
    // atributo emplados para cada animal que haga las veces de value object
    private int codigo_persona;
    private int codigo_estudiante;
    private int codigo_grado;
    private int codigo_pago;
    private int codigo_mes;
    private int codigo_detalle;
    private String nombre_persona;
    private String descripcion_grado;
    private String descripcion_detalle;
    private int año_mes;
    private String nombre_mes;
    private String estado_pago;
    private int valor_detalle;

    /**
     * Constructor 1 el cual permite crear objetos AnimalVO sin necesidad de
     * variables de entrada
     */
    public ReciboVO() {

    }

    /**
     * Constructor 2 el cual requiere un parametro para cada atributo que posee
     * la clase
     *
     */
    public ReciboVO(int codigo_persona, int codigo_estudiante, int codigo_grado, int codigo_pago, int codigo_mes, int codigo_detalle, String nombre_persona, String descripcion_grado, String descripcion_detalle, int año_mes, String nombre_mes, String estado_pago, int valor_detalle) {
        this.codigo_persona = codigo_persona;
        this.codigo_estudiante = codigo_estudiante;
        this.codigo_pago = codigo_pago;
        this.codigo_mes = codigo_mes;
        this.codigo_detalle = codigo_detalle;
        this.nombre_persona = nombre_persona;
        this.descripcion_grado = descripcion_grado;
        this.descripcion_detalle = descripcion_detalle;
        this.año_mes = año_mes;
        this.nombre_mes = nombre_mes;
        this.estado_pago = estado_pago;
        this.valor_detalle = valor_detalle;

    }

    public int getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(int codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public int getCodigo_estudiante() {
        return codigo_estudiante;
    }

    public void setCodigo_estudiante(int codigo_estudiante) {
        this.codigo_estudiante = codigo_estudiante;
    }

    public int getCodigo_grado() {
        return codigo_grado;
    }

    public void setCodigo_grado(int codigo_grado) {
        this.codigo_grado = codigo_grado;
    }

    public int getCodigo_pago() {
        return codigo_pago;
    }

    public void setCodigo_pago(int codigo_pago) {
        this.codigo_pago = codigo_pago;
    }

    public int getCodigo_mes() {
        return codigo_mes;
    }

    public void setCodigo_mes(int codigo_mes) {
        this.codigo_mes = codigo_mes;
    }

    public int getCodigo_detalle() {
        return codigo_detalle;
    }

    public void setCodigo_detalle(int codigo_detalle) {
        this.codigo_detalle = codigo_detalle;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getDescripcion_grado() {
        return descripcion_grado;
    }

    public void setDescripcion_grado(String descripcion_grado) {
        this.descripcion_grado = descripcion_grado;
    }

    public String getDescripcion_detalle() {
        return descripcion_detalle;
    }

    public void setDescripcion_detalle(String descripcion_detalle) {
        this.descripcion_detalle = descripcion_detalle;
    }

    public int getAño_mes() {
        return año_mes;
    }

    public void setAño_mes(int año_mes) {
        this.año_mes = año_mes;
    }

    public String getNombre_mes() {
        return nombre_mes;
    }

    public void setNombre_mes(String nombre_mes) {
        this.nombre_mes = nombre_mes;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }

    public int getValor_detalle() {
        return valor_detalle;
    }

    public void setValor_detalle(int valor_detalle) {
        this.valor_detalle = valor_detalle;
    }

}

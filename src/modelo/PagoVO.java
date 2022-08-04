/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Miguel D
 */
public class PagoVO {
    
    // atributo emplados para cada animal que haga las veces de value object
    private int codigo_pago;
    private String estado_pago;
    private int estudiante_pago;
    private int codigo_mes;
    private int codigo_detalle;

    /**
     * Constructor 1 el cual permite crear objetos AnimalVO sin necesidad de
     * variables de entrada
     */
    public PagoVO() {

    }

    /**
     * Constructor 2 el cual requiere un parametro para cada atributo que posee
     * la clase
     *
     */
    public PagoVO(int codigo_pago, String estado_pago, int estudiante_pago, int codigo_mes, int codigo_detalle) {
        this.codigo_pago = codigo_pago;
        this.estado_pago = estado_pago;
        this.estudiante_pago = estudiante_pago;
        this.codigo_mes = codigo_mes;
        this.codigo_detalle = codigo_detalle;

    }

    public int getCodigo_pago() {
        return codigo_pago;
    }

    public void setCodigo_pago(int codigo_pago) {
        this.codigo_pago = codigo_pago;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }

    public int getEstudiante_pago() {
        return estudiante_pago;
    }

    public void setEstudiante_pago(int estudiante_pago) {
        this.estudiante_pago = estudiante_pago;
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

}

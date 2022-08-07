/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Miguel D
 */
public class MesVO {

    // atributo emplados para cada animal que haga las veces de value object
    private int codigo_mes;
    private String nombre_mes;
    private int año_mes;
    private int codigo_pago;
    /**
     * Constructor 1 el cual permite crear objetos AnimalVO sin necesidad de
     * variables de entrada
     */
    public MesVO() {

    }

    /**
     * Constructor 2 el cual requiere un parametro para cada atributo que posee
     * la clase
     *
     */
    public MesVO(int codigo_mes, String nombre_mes, int año_mes, int codigo_pago) {
        this.codigo_mes = codigo_mes;
        this.nombre_mes = nombre_mes;
        this.año_mes = año_mes;
        this.codigo_pago = codigo_pago;

    }

    public int getCodigo_mes() {
        return codigo_mes;
    }

    public void setCodigo_mes(int codigo_mes) {
        this.codigo_mes = codigo_mes;
    }

    public String getNombre_mes() {
        return nombre_mes;
    }

    public void setNombre_mes(String nombre_mes) {
        this.nombre_mes = nombre_mes;
    }

    public int getAño_mes() {
        return año_mes;
    }

    public void setAño_mes(int año_mes) {
        this.año_mes = año_mes;
    }

    public int getCodigo_pago() {
        return codigo_pago;
    }

    public void setCodigo_pago(int codigo_pago) {
        this.codigo_pago = codigo_pago;
    }

}
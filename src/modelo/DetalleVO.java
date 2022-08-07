package modelo;

/**
 *
 * @author Miguel D
 */
public class DetalleVO {

    // atributo emplados para cada animal que haga las veces de value object
    private int codigo_detalle;
    private String descripcion_detalle;
    private int valor_detalle;
    private int codigo_pago;

    /**
     * Constructor 1 el cual permite crear objetos AnimalVO sin necesidad de
     * variables de entrada
     */
    public DetalleVO() {

    }

    /**
     * Constructor 2 el cual requiere un parametro para cada atributo que posee
     * la clase
     *
     */
    public DetalleVO(int codigo_detalle, String descripcion_detalle, int valor_detalle, int codigo_pago) {
        this.codigo_detalle = codigo_detalle;
        this.descripcion_detalle = descripcion_detalle;
        this.valor_detalle = valor_detalle;
        this.codigo_pago = codigo_pago;

    }

    public int getCodigo_detalle() {
        return codigo_detalle;
    }

    public void setCodigo_detalle(int codigo_detalle) {
        this.codigo_detalle = codigo_detalle;
    }

    public String getDescripcion_detalle() {
        return descripcion_detalle;
    }

    public void setDescripcion_detalle(String descripcion_detalle) {
        this.descripcion_detalle = descripcion_detalle;
    }

    public int getValor_detalle() {
        return valor_detalle;
    }

    public void setValor_detalle(int valor_detalle) {
        this.valor_detalle = valor_detalle;
    }

    public int getCodigo_pago() {
        return codigo_pago;
    }

    public void setCodigo_pago(int codigo_pago) {
        this.codigo_pago = codigo_pago;
    }

}
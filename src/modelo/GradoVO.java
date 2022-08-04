package modelo;

/**
 *
 * @author Miguel D
 */
public class GradoVO {

    // atributo emplados para cada animal que haga las veces de value object
    private int codigo_grado;
    private String descripcion_grado;
    private String jornada_grado;

    /**
     * Constructor 1 el cual permite crear objetos AnimalVO sin necesidad de
     * variables de entrada
     */
    public GradoVO() {

    }

    /**
     * Constructor 2 el cual requiere un parametro para cada atributo que posee
     * la clase
     *
     */
    public GradoVO(int codigo_grado, String descripcion_grado, String jornada_grado) {
        this.codigo_grado = codigo_grado;
        this.descripcion_grado = descripcion_grado;
        this.jornada_grado = jornada_grado;

    }

    public int getCodigo_grado() {
        return codigo_grado;
    }

    public void setCodigo_grado(int codigo_grado) {
        this.codigo_grado = codigo_grado;
    }

    public String getDescripcion_grado() {
        return descripcion_grado;
    }

    public void setDescripcion_grado(String descripcion_grado) {
        this.descripcion_grado = descripcion_grado;
    }

    public String getJornada_grado() {
        return jornada_grado;
    }

    public void setJornada_grado(String jornada_grado) {
        this.jornada_grado = jornada_grado;
    }

}

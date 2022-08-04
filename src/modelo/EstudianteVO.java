package modelo;

/**
 *
 * @author Miguel D
 */
public class EstudianteVO {
    
    // atributo emplados para cada animal que haga las veces de value object
    private int codigo_estudiante;
    private int codigo_persona;
    private int codigo_grado;

    /**
     * Constructor 1 el cual permite crear objetos AnimalVO sin necesidad de
     * variables de entrada
     */
    public EstudianteVO() {

    }

    /**
     * Constructor 2 el cual requiere un parametro para cada atributo que posee
     * la clase
     *
     */
    public EstudianteVO(int codigo_estudiante, int codigo_persona, int codigo_grado) {
        this.codigo_estudiante = codigo_estudiante;
        this.codigo_persona = codigo_persona;
        this.codigo_grado = codigo_grado;

    }

    public int getCodigo_estudiante() {
        return codigo_estudiante;
    }

    public void setCodigo_estudiante(int codigo_estudiante) {
        this.codigo_estudiante = codigo_estudiante;
    }

    public int getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(int codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public int getCodigo_grado() {
        return codigo_grado;
    }

    public void setCodigo_grado(int codigo_grado) {
        this.codigo_grado = codigo_grado;
    }

}

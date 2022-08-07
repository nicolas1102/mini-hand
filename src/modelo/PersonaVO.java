package modelo;

/**
 *
 * @author Miguel D
 */
public class PersonaVO {

    // atributo emplados para cada animal que haga las veces de value object
    private int codigo_persona;
    private String nombre_persona;
    private int edad_persona;
    private int año_vinculacion_persona;

    /**
     * Constructor 1 el cual permite crear objetos AnimalVO sin necesidad de
     * variables de entrada
     */
    public PersonaVO() {

    }

    /**
     * Constructor 2 el cual requiere un parametro para cada atributo que posee
     * la clase
     *
     */
    public PersonaVO(int codigo_persona, String nombre_persona, int edad_persona, int año_vinculacion_persona) {
        this.codigo_persona = codigo_persona;
        this.nombre_persona = nombre_persona;
        this.edad_persona = edad_persona;
        this.año_vinculacion_persona = año_vinculacion_persona;

    }

    public int getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(int codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public int getEdad_persona() {
        return edad_persona;
    }

    public void setEdad_persona(int edad_persona) {
        this.edad_persona = edad_persona;
    }

    public int getAño_vinculacion_persona() {
        return año_vinculacion_persona;
    }

    public void setAño_vinculacion_persona(int año_vinculacion_persona) {
        this.año_vinculacion_persona = año_vinculacion_persona;
    }

}
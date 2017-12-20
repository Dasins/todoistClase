
/**
 * Clase que modela un objeto tarea que indica el contenido de la tarea
 * y su estado (si esta completada o no)
 *
 * @author Dasins
 * @version 20/12/2017
 */
public class Tarea
{
    // La tarea
    private String tarea;
    // El estado de la tarea. 
    // True cuando esta completada 
    // False en cualquier otro caso
    private boolean estado;

    /**
     * Constructor for objects of class Tarea
     */
    public Tarea(String tarea){
        estado = false;
        this.tarea = tarea;
    }

    /**
     * @return Devuelve true si la tarea esta compeltada. Falso en cualquier otro caso
     */
    public String getTarea(){
        return tarea;
    }
    
    /**
     * @return Devuelve el contenido de la tarea
     */
    public boolean getEstado(){
        return estado;
    }
    
    /**
     * Marca como completada una tarea
     */
    public void setCompletada(){
        estado = true;
    }
    
    /**
     * Devuelve la tarea, inserta un [x] si esta completada o un [ ] si no.
     */
    public String devolverTarea(int numeroPosicion){
        String tareaADevolver = tarea;
        if (estado){
            tareaADevolver = numeroPosicion + ". [x] " + tarea;
        }
        else {
            tareaADevolver = numeroPosicion + ". [ ] " + tarea;
        }
        return tareaADevolver;
    }
}

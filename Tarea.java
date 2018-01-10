
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
    // La prioridad
    // La prioridad va de 1 a 5. 1 Menor prioridad - 5 Mayor prioridad
    private int prioridad;

    /**
     * Constructor de objetos de la clase Tarea
     */
    public Tarea(String tarea){
        estado = false;
        this.tarea = tarea;
        prioridad = 1;
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
     * Cambia la prioridad de la tarea.
     * Si los valores no son legales no hace nada.
     * 
     * @param prioridad El nuevo valor de la prioridad.
     */
    public void setPrioridad(int prioridad){
        if (prioridad >= 1 && prioridad <= 5) { 
            this.prioridad = prioridad;
        }
    }

    /**
     * Devuelve la tarea, inserta un [x] si esta completada o un [ ] si no.
     */
    public String devolverTarea(int numeroPosicion){
        String tareaADevolver = tarea;
        String textoPrioridad = "#Prioridad: " + prioridad + "# ";
        if (estado){
            tareaADevolver = numeroPosicion + ". [x] " + textoPrioridad  + tarea;
        }
        else {
            tareaADevolver = numeroPosicion + ". [ ] " + textoPrioridad + tarea;
        }
        return tareaADevolver;
    }
    
}

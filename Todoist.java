import java.util.*;
/**
 * Clase que modela un objeto que permite
 * almacenar las tareas pendientes que tenemos por hacer.
 */
public class Todoist {
    // Nuestras tres tareas.
    private String tarea0;
    private String tarea1;
    private String tarea2;
    private ArrayList listaTareas;
    
    /**
     * Constructor de la clase Todoist:
     * Crea un gestor con las tres tareas vacias.
     */
    public Todoist()
    {
        tarea0 = "";
        tarea1 = "";
        tarea2 = "";
        List<String>listaTareas = new ArrayList();
    }
    
    /**
     * Inserta la tarea especificada en la posición indicada.
     * @param nombreTarea 
     * @param posicion 
     */
    public void nuevaTarea(String nombreTarea, int posicion)
    {
        if (posicion >= 0){
           if (posicion == 0){
               tarea0 = nombreTarea;
           }
           else if (posicion == 1){
               tarea1 = nombreTarea;
           }
           else if (posicion >2){
               tarea2 = nombreTarea;
           }
        }
    }
    
    /**
     * Muestra por pantalla todas las tareas existentes
     */
    public void mostrarTareas()
    {
        String muestraTareas = "";
        if (tarea0 != null){
            muestraTareas = muestraTareas + tarea0 + "\n";
        }
        if (tarea1 != null){
            muestraTareas = muestraTareas + tarea1 + "\n";
        }
        if (tarea2 != null){
            muestraTareas = muestraTareas + tarea2 + "\n";
        }
        if (muestraTareas.length() > 0){
            System.out.println(muestraTareas);
        }
    }
    
}
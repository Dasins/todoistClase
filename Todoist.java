import java.util.ArrayList;
/**
 * Clase que modela un objeto que permite
 * almacenar las tareas pendientes que tenemos por hacer.
 */
public class Todoist {
    // Almacena nuestras tareas.
    private ArrayList<String> tareas;
    
    /**
     * Constructor de la clase Todoist:
     * Crea un gestor de tareas vacio.
     */
    public Todoist(){
        tareas = new ArrayList<String>();
    }
    
    /**
     * Inserta la tarea especificada en la posición indicada.
     * @param nombreTarea La tarea que tenemos que realizar.
     */
    public void nuevaTarea(String nombreTarea){
        tareas.add(nombreTarea);
    }
    
    /**
     * Muestra por pantalla todas las tareas existentes.
     */
    public void mostrarTareas(){
        System.out.println(tareas);
    }
    
    /**
     * @return Devuelve el numero de tareas pendientes.
     */
    public int getNumeroTareas(){
        return tareas.size();  
    }
    
    /**
     * Imprime por pantalla el numero de tareas pendientes.
     */
    public void mostrarNumeroDeTareasPendientes(){
        if (tareas.size() > 1){
            System.out.println("Tienes" + tareas.size() + "pendientes.");
        }
        else {
            System.out.println("Tiene" + tareas.size() + "pendiente.");
        }
    }
    
    /**
     * Imprime por pantalla el numero de tareas pendientes.
     */
    public void imprimirTareas(){
       System.out.println(tareas);
    }
    
    /**
     * Elimina la tarea en la posición indicada
     * @param posicion La posicion que ocupa la tarea que queremos borrar.
     * @return Devuelve true si la posicion contiene un valor y falso si no.
     */
    public boolean eliminarTarea(int posicion){
        boolean existeLaTarea = false;
        if (posicion >= 0 && posicion < tareas.size()){
            tareas.remove(posicion);
            existeLaTarea = true;
        }
        return existeLaTarea; 
    }
}
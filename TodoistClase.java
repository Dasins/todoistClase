import java.util.ArrayList;

/**
 * Clase que permite almacenar las tareas pendientes que tenemos por hacer.
 */
class TodoistClase 
{
    // Almacena nuestras tareas
    private ArrayList<Tarea> tareas; 

    /**
     * Constructor de la clase Todoist. 
     * Crea un gestor con las 3 tareas vacías.
     */
    public TodoistClase()
    {
        tareas = new ArrayList<Tarea>();
    }  
    
    /**
     * Inserta una nueva tarea
     */
    public void addTarea(String nombreTarea)
    {
        tareas.add(new Tarea(nombreTarea));
    }    

    /** 
     * Metodo que imprime todas las tareas existentes, una por linea.
     * El metodo imprime el numero de posicion de la tarea antes del
     * nombre de la tarea.
     */
    public void mostrarTareasNumeradas()
    {
        int numeroPosicion = 1;
        for (Tarea tarea : tareas){
            tarea.imprimirTarea(numeroPosicion);
            numeroPosicion = numeroPosicion + 1;
        }
    }
      
    /**
     * Marca como completada la tarea indicada como parametro. Por ejemplo,
     * si el parámetro es 0 marca como completada la primera tarea, si es 1 la
     * segunda, etc.
     */
    public void marcarComoCompletada(int indiceTarea)
    {
        tareas.get(indiceTarea).setCompletada();
    }
}

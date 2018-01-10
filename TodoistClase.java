import java.util.ArrayList;

/**
 * Clase que modela objetos que permiten almacenar tareas.
 */
class TodoistClase 
{
    // Almacena nuestras tareas
    private ArrayList<Tarea> tareas; 

    /**
     * Constructor de la clase Todoist. 
     * Crea un gestor con las 3 tareas vacías.
     */
    public TodoistClase(){
        tareas = new ArrayList<Tarea>();
    }  

    /**
     * Inserta una nueva tarea
     */
    public void addTarea(String nombreTarea){
        tareas.add(new Tarea(nombreTarea));
    }    

    /** 
     * Metodo que imprime todas las tareas existentes, una por linea.
     * El metodo imprime el numero de posicion de la tarea antes del
     * nombre de la tarea.
     */
    public void mostrarTareasNumeradas(){
        int numeroPosicion = 1;
        for (Tarea tarea : tareas){
            System.out.println(tarea.devolverTarea(numeroPosicion));
            numeroPosicion = numeroPosicion + 1;
        }
    }

    /**
     * Marca como completada la tarea indicada como parametro. Por ejemplo,
     * si el parámetro es 0 marca como completada la primera tarea, si es 1 la
     * segunda, etc.
     */
    public void marcarComoCompletada(int indiceTarea){
        tareas.get(indiceTarea).setCompletada();
    }
    
    /**
     * Cambia la prioridad de una tarea.
     * Se da por supuesto que los valores son legales.
     * 
     * @param indiceTarea La posición en el Array de la tarea. 0 para la primera.
     * @param prioridad El nuevo valor de prioridad
     */
    public void setPrioridad(int indiceTarea, int prioridad){
        tareas.get(indiceTarea).setPrioridad(prioridad);
    }
    
    /**
     * Imprime en la terminal de texto las tareas completadas, las incompletas, el porcentaje de cada una sobre el total
     * y las tareas totales.
     */
    public void printEstadisticas (){
        int tareasTotales = tareas.size();
        int tareasCompletadas = 0;
        for (Tarea tarea : tareas){
            if (tarea.getEstado()){
                tareasCompletadas++;
            }
        }
        System.out.println("Tareas totales: " + tareasTotales);
        System.out.println("Completadas: " + tareasCompletadas + " (" + (tareasCompletadas*100)/tareasTotales + "%)");
        System.out.println("Incompletas: " + (100 - (tareasCompletadas*100)/tareasTotales) + "%)");
    }
    
    /** 
     * Añade tareas random
     */
    public void test() {
        addTarea("Comerse al perro");
        addTarea("Pasear a la suegra");
        addTarea("Limpiar la basura");
        addTarea("Verter fluídos gaussianos");
        addTarea("Perseguir un dracoliche");
        addTarea("Bailar con un tigre");
        addTarea("Descifrar el necronomicón");
        addTarea("Invocar al maligno");
        addTarea("Ordenarse sacerdote");
        addTarea("Tener dulces pesadillas");
    }
}

import java.util.ArrayList;
import java.time.LocalDate;

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
        System.out.println("");
        for (Tarea tarea : tareas){
            System.out.println(numeroPosicion + " " + tarea.devolverTarea());
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
     * Si los valores no son legales no hace nada.
     * 
     * @param indiceTarea La posición en el Array de la tarea. 0 para la primera.
     * @param prioridad El nuevo valor de prioridad
     */
    public void setPrioridad(int indiceTarea, int prioridad){
        if (indiceTarea >= 0 && indiceTarea < tareas.size()){  
            tareas.get(indiceTarea).setPrioridad(prioridad);
        }
    }
    
    /**
     * Imprime en la terminal de texto las tareas completadas, las incompletas, el porcentaje de cada una sobre el total
     * y las tareas totales.
     */
    public void printEstadisticas(){
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
    public void test(){
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
        setFechaVencimiento(4, 18, 1, 2017);
        setFechaVencimiento(3, 18, 1, 2017);
        setFechaVencimiento(2, 18, 1, 2017);
        setFechaVencimiento(1, 19, 2, 2017);
    }
    
    /**
     * Imprime todos los datos de la tarea con mayor prioridad. Si hay varias, devuelve la última encontrada. 
     */
    public void printTareaPrioritaria(){
        if (tareas.size() > 0){
            Tarea tareaPrioritaria = tareas.get(0);
            for(Tarea tareaActual : tareas){
                if (tareaActual.getPrioridad() >= tareaPrioritaria.getPrioridad()){
                   tareaPrioritaria = tareaActual;
                }
            }
            //System.out.println(tareas.indexOf(tareaPrioritaria.getTarea()) +
            //                   " " + tareaPrioritaria.devolverTarea());
            System.out.println(tareaPrioritaria.devolverTarea());
        }
    }
   
    /**
    * Imprime todos los datos de la tarea con menor prioridad. 
    * Si hay empate,imprime por pantalla los datos de la última encontrada.
    * Si no hay tareas,no imprime nada.
    */
    public void printTareaMenosPrioritaria(){
        if (tareas.size() > 0){
            Tarea tareaMenosPrioritaria = tareas.get(0);
            for(Tarea tareaActual : tareas){
                if (tareaActual.getPrioridad() <= tareaMenosPrioritaria.getPrioridad()){
                   tareaMenosPrioritaria = tareaActual;
                }
            }
            System.out.println(tareas.indexOf(tareaMenosPrioritaria) + " " + tareaMenosPrioritaria.devolverTarea());
        }
    }
    
    /**
     * Anade una fecha limite a una tarea especifica
     * @param index El indice que ocupa la tarea.
     * @param dia El dia de la fecha limite
     * @param mes El mes de la fecha limite
     * @param ano El ano de la fecha limite
     */
    public void setFechaVencimiento(int index, int dia, int mes, int ano) {
        if (index < tareas.size()){
            tareas.get(index).setFechaLimite(dia,mes,ano);
        }
    }
    
    /**
    * Muestra la tarea con la fecha tope más inminente. Si hay empate,
    * muestra todas las empatadas. Si no hay ninguna con fecha tope no muestra nada
    */
    public void printTareaMasUrgente() {
        ArrayList<Tarea> tareasAImprimir = new ArrayList<>();
        LocalDate fechaInminente = LocalDate.now();
        for(Tarea tarea : tareas) {
            LocalDate tareaFechaActual = tarea.getFechaLimite();
            if (tareaFechaActual != null){
               if (tareaFechaActual.isBefore(fechaInminente) || tareaFechaActual.isEqual(fechaInminente)){
                  if (tareaFechaActual.isBefore(fechaInminente)){
                      fechaInminente = tareaFechaActual;
                      tareasAImprimir = new ArrayList<>();
                      tareasAImprimir.add(tarea);
                  }
                  else if (tareaFechaActual.isEqual(fechaInminente)){
                      tareasAImprimir.add(tarea);
                  }
               }
            }
        }
        
        for (Tarea tarea : tareasAImprimir){
            System.out.println(tarea.devolverTarea());
        }
    }
    
    /**
    * Muestra la tarea con la fecha tope menos urgente. Si hay empate,
    * muestra todas las empatadas. Si no hay ninguna con fecha tope no muestra nada
    */
   public void printTareaMenosUrgente() {
        ArrayList<Tarea> tareasAImprimir = new ArrayList<>();
        LocalDate fechaInminente = LocalDate.now();
        for(Tarea tarea : tareas) {
            LocalDate tareaFechaActual = tarea.getFechaLimite();
            if (tareaFechaActual != null){
               if (tareaFechaActual.isBefore(fechaInminente) || tareaFechaActual.isEqual(fechaInminente)) {
                   if (tareaFechaActual.isAfter(fechaInminente)){
                      fechaInminente = tareaFechaActual;
                      tareasAImprimir = new ArrayList<>();
                      tareasAImprimir.add(tarea);
                  }
                  else if (tareaFechaActual.isEqual(fechaInminente)){
                      tareasAImprimir.add(tarea);
                  }
               }
            }
        }
        
        for (Tarea tarea : tareasAImprimir){
            System.out.println(tarea.devolverTarea());
        }
   }
   
   
}



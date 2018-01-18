import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que modela un objeto tarea que indica el contenido de la tarea, su prioridad y 
 * su estado (si esta completada o no).
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
    // La fecha de vencimiento.
    private LocalDate fechaLimite;

    /**
     * Constructor de objetos de la clase Tarea
     */
    public Tarea(String tarea){
        estado = false;
        this.tarea = tarea;
        prioridad = 1;
        fechaLimite = null;
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
     * @return Devuelve la prioridad de la tarea
     */
    public int getPrioridad(){
        return prioridad;
    }
    
    /**
     * @return Devuelve la prioridad de la tarea
     */
    public LocalDate getFechaLimite(){
        return fechaLimite;
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
    public String devolverTarea(){
        String tareaADevolver = tarea;
        String texto =". #Prioridad: " + prioridad + "# ";
        if (estado){
            tareaADevolver =  "[x] " + texto  + tarea;
        }
        else {
            tareaADevolver = "[ ] " + texto + tarea;
        }
        if(fechaLimite != null) {
            tareaADevolver += " Fecha limite: " + formatearFechaSP(fechaLimite,"dd' de 'MMMM' de 'yyyy" );
        }
        return tareaADevolver;
    }
    
    /**
     * Anade una fecha de limite a la tarea
     * @param dia El dia de la fecha limite
     * @param mes El mes de la fecha limite
     * @param ano El ano de la fecha limite
     */
    public void setFechaLimite(int dia, int mes, int ano) {
        fechaLimite = LocalDate.of(ano,mes,dia);
    }
    
    /**
     * @return Devuelve una fecha con un determinado formato con el ISO de Espana.
     */
    public String formatearFechaSP(LocalDate fecha, String format) {
        String fechaFormateada = fechaLimite.format(DateTimeFormatter.ISO_DATE);
        fechaFormateada = fecha.format(DateTimeFormatter.ofPattern(format));
        return fechaFormateada;
    }
    
    
}

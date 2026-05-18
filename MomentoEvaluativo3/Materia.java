import java.util.LinkedList;
import java.util.Queue;

public class Materia {
    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int cuposOcupados;
    private int creditos;
    //Pre requisitos: lista enlazada
    private LinkedList<String> preRequisitos;
    //Estudiantes inscritos: lista enlazada
    private LinkedList<String> estudiantesInscritos;
    //Cola de espera
    private Queue<String> colaEspera;
    //Id del profesor asignado a esta materia
    private String idProfesor;

    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.cuposOcupados = 0;
        this.creditos = creditos;
        this.preRequisitos = new LinkedList<>();
        this.estudiantesInscritos = new LinkedList<>();
        this.colaEspera = new LinkedList<>();
        this.idProfesor = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuposMaximos() {
        return cuposMaximos;
    }

    public int getCuposOcupados() {
        return cuposOcupados;
    }

    public int getCreditos() {
        return creditos;
    }

    public LinkedList<String> getPreRequisitos() {
        return preRequisitos;
    }

    public LinkedList<String> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public Queue<String> getColaEspera() {
        return colaEspera;
    }

    public void agregarPreRequisitos(String codigoMateria){
        if(!preRequisitos.contains(codigoMateria)){
            preRequisitos.add(codigoMateria);
        }
    }

    public boolean hayCupo(){
        return cuposOcupados < cuposMaximos;
    }

    /*Inscribe un estudiante directamente (si ya se verificaron los pre requisitos antes) */
    public void inscribirEstudiante(String idEstudiante) throws CupoLlenoExpcetion{
        if(!hayCupo()){
            throw new CupoLlenoExpcetion("CupoLlenoException - La materia " + codigo + " no tiene cupos disponibels");
        }
        estudiantesInscritos.add(idEstudiante);
        cuposOcupados++;
    }

    /*Agrewga un estudiante a la cola de espera*/
    public void agregarAColaEspera(String idEstudiante){
        colaEspera.add(idEstudiante);
    }

    /*Cancelala inscripcion de un estudiante y asigna su cupo al primero en la cola
    retorna el ID del estudiante que tomo el cupo desde la cola, o null si no habia*/
    public String cancelarInscripcion(String idEstudiante){
        boolean removido = estudiantesInscritos.remove(idEstudiante);
        if(!removido) return null;
        cuposOcupados--;

        //Asigna el cupo al primero en la cola de espera
        if(!colaEspera.isEmpty()){
            String siguiente = colaEspera.poll();
            estudiantesInscritos.add(siguiente);
            cuposOcupados++;
            return siguiente;
        }
        return null;
    }

    public boolean estaInscrito(String idEstudiante){
        return estudiantesInscritos.contains(idEstudiante);
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " (Cupos: " + cuposOcupados + "/" + cuposMaximos + ")";
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    

    
}

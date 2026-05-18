import java.util.HashMap;

public class Gestormaterias {
    //HashMap para buscar materias rapido por codigo
    private HashMap<String, Materia> materias;
    private Gestorestudiantes gestorEstudiantes;
    //Referencia al gestor de profesores, para mostrar al docente al inscribir
    private Gestorprofesores gestorProfesores;

    public Gestormaterias(Gestorestudiantes gestorEstudiantes) {
        this.materias = new HashMap<>();
        this.gestorEstudiantes = gestorEstudiantes;
        this.gestorProfesores = null; //Se inyecta despues con el set
    }

    //Permite inyectar el gestor despues del constructor, lo que evita la dependencia circular en el constructor
    public void setGestorprofesores(Gestorprofesores gestorprofesores){
        this.gestorProfesores = gestorProfesores;
    }

    public void crearMateria(String codigo, String nombre, int cuposMaximos, int creditos){
        Materia m = new Materia(codigo, nombre, cuposMaximos, creditos);
        materias.put(codigo, m);
        System.out.println("Materia creada: " + m);
    }

    public Materia buscarMateria(String codigo){
        return materias.get(codigo);
    }

    public void agregarPreRequisito(String codigoMateria, String codigoPreReq){
        Materia m = materias.get(codigoMateria);
        if(m == null){
            System.out.println("Error: Materia " + codigoMateria + " no encontrada.");
            return;
        }
        m.agregarPreRequisitos(codigoPreReq);
        System.out.println("PreRequisito " + codigoPreReq + " agregado a " + codigoMateria);
    }

    public void mostrarPreRequisitos(String codigoMateria){
        Materia m = materias.get(codigoMateria);
        if(m == null){
            System.out.println("Materia no encontrada");
            return;
        }
        System.out.println("PreRequisitos de "+ codigoMateria + ":" );
        if(m.getPreRequisitos().isEmpty()){
            System.out.println(" (Sin PreRequisitos)");
        } else {
            for(String req : m.getPreRequisitos()){
                System.out.println(" -" + req);
            }
        }
    }

    // Ahora un metodo que inscriba un estuidante a una materia, ademas de verificar los prerequisitos y si hay cupos
    public void inscribirEstudiante(String idEstudiante, String codigoMateria)throws PreRequisitoNoAprobadoException, EstudianteNoEncontradoException{
        Estudiante estudiante = gestorEstudiantes.buscarPorId(idEstudiante);
        Materia materia = materias.get(codigoMateria);

        if(materia == null){
            System.out.println("Error: Materia " + codigoMateria + " no encontrada.");
            return;
        }

        //En esta parte verificamos los prerequisitos, mirando el historial del estudiante
        for(String req : materia.getPreRequisitos()){
            if(!estudiante.getHistorialMaterias().contains(req)){
                throw new PreRequisitoNoAprobadoException("PreRequisito excepcion - El estudiante no ha cursado: " + req);
            }
        }

        if(materia.estaInscrito(idEstudiante)){
            System.out.println("El estudiante ya se encuentra inscrito en " + codigoMateria);
            return;
        }

        try{
            materia.inscribirEstudiante(idEstudiante);
            System.out.println("Inscripcion existosa: " + idEstudiante + " en " + codigoMateria);
            //mostrar info del docente asignado
            if(gestorProfesores != null){
                Profesor prof = gestorProfesores.getProfesorDeMateria(codigoMateria);
                if(prof != null){
                    System.out.println("Materia: " + materia.getNombre());
                    System.out.println("Docente: " + prof.getNombre() + " | " + prof.getTelefono());
                } else{
                    System.out.println("Docente: (sin asignar)");
                }
            }
        } catch(CupoLlenoExpcetion e){
            System.out.println(e.getMessage());
            materia.agregarAColaEspera(idEstudiante);
            System.out.println("Materia llena " + idEstudiante + " agregado a cola de espera de " + codigoMateria);
        }
    }

    //Ahora debemos de poder cancelar la inscripcion de un estudiante en una materia, asi que retornaremos el id del siguiente en la cola (o null)
    public String cancelarInscripcion(String idEstuidante, String codigoMateria){
        Materia materia = materias.get(codigoMateria);
        if(materia == null){
            System.out.println("Materia no encontrada.");
            return null;
        }

        String siguiente = materia.cancelarInscripcion(idEstuidante);
        System.out.println("Caneclacion exitosa. Cupo liberado");

        if(siguiente != null){
            System.out.println("Asignado cupo a " + siguiente + " (primer estuidante en la cola)");

        }
        return siguiente;
    }

    public void mostrarColaEspera(String codigoMateria) throws ColaDeEsperaVaciaException{
        Materia m = materias.get(codigoMateria);
        if(m == null){
            System.out.println("Materia no encontrada");
            return;
        }

        System.out.println("--- COLA DE ESPERA ---");
        System.out.println("Materia: " + m.getCodigo() + " - " + m.getNombre());
        System.out.println("Cupos totales: " + m.getCuposMaximos());
        
        if(m.getColaEspera().isEmpty()){
            System.out.println("Cola de espera vacia.");
            return;
        }
        if(m.getColaEspera().isEmpty()){
            throw new ColaDeEsperaVaciaException("ColaDeEsperaException - Cola de espera vacia para esta materia");
        }
        int pos = 1;
        for(String id : m.getColaEspera()){
            System.out.println("Posicion" + pos + ": " + id);
        }
        System.out.println("Total en espera: " + m.getColaEspera().size());
    }

    public void listarMaterias(){
        if(materias.isEmpty()){
            System.out.println("No hay materias registradas");
            return;
        }
        System.out.println("=== MATERIAS ===");
        for(Materia m : materias.values()){
            System.out.println(" " + m);
        }
    }

    public HashMap<String, Materia> getMaterias() {
        return materias;
    }

    
}



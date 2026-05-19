import java.util.Stack;

/*Gestionamos las operaciones deshacer/rehacer usando dos pilas.
Las operaciones deshacible son:
- Inscribir estudiante en materias
- Cancelar inscripcion
- Registrar nota
- Eliminar estudiante*/
public class Gestordeshacerrehacer {
    private Stack<Operacion> pilaDeshacer;
    private Stack<Operacion> pilaRehacer;
    private Gestorestudiantes gestorEstudiantes;
    private Gestormaterias gestorMaterias;
    private Gestorhorarios gestorHorarios;

    public Gestordeshacerrehacer(Gestorestudiantes gestorEstudiantes, Gestormaterias gestorMaterias, Gestorhorarios gestorHorarios) {
        this.gestorEstudiantes = gestorEstudiantes;
        this.gestorMaterias = gestorMaterias;
        this.gestorHorarios = gestorHorarios;
        this.pilaDeshacer = new Stack<>();
        this.pilaRehacer = new Stack<>();
    }

    // Ahora registrar una operacion deshacible. Siempre que se hace una nueva
    // operacion, se limpia la pila de rehacer
    public void registrarOperacion(Operacion op) {
        pilaDeshacer.push(op);
        pilaRehacer.clear(); // nueva accion invalida el historial al rehacer
    }

    // Ahora un metodo para deshacer la ultima operacion
    public void deshacer() throws PilasDeshacerVaciaException {
        if (pilaDeshacer.isEmpty()) {
            throw new PilasDeshacerVaciaException("Pila deshacer expecion - No hay operaciones para deshacer");
        }

        Operacion op = pilaDeshacer.pop();
        aplicarDeshacer(op);
        pilaRehacer.push(op);
        System.out.println("Operacion deshecha: " + op.getDescripcion());
    }

    // Un metodo que permita rehacer la ultima operacion deshecha
    public void rehacer() throws PilasDeshacerVaciaException {
        if (pilaRehacer.isEmpty()) {
            throw new PilasDeshacerVaciaException("Pila deshacer exception - No hay operacion para rehacer");
        }

        Operacion op = pilaRehacer.pop();
        aplicarRehacer(op);
        pilaDeshacer.push(op);
        System.out.println("Operacion rehecha: " + op.getDescripcion());
    }

    private void aplicarDeshacer(Operacion op) {
        try {
            switch (op.getTipo()) {
                case "INSCRIPCION": {
                    // Deshacer inscripcion = cancelar la inscripcion
                    String[] datos = (String[]) op.getDatosEstado(); // [idEstudiante, codigoMateria]
                    Materia m = gestorMaterias.buscarMateria(datos[1]);
                    if (m != null) {
                        m.cancelarInscripcion(datos[0]);
                        System.out.println(datos[0] + " ya no esta inscrito en " + datos[1]);
                    }
                    break;
                }
                case "CANCELACION": {
                    // Deshacer cancelacion = volver a inscribir
                    String[] datos = (String[]) op.getDatosEstado();
                    Materia m = gestorMaterias.buscarMateria(datos[1]);
                    if (m != null && m.hayCupo()) {
                        m.inscribirEstudiante(datos[0]);
                        System.out.println(datos[0] + " vuelve a estar inscrito en " + datos[1]);
                    }
                    break;
                }
                case "NOTA": {
                    // Para simplificar, informamos que la nota fue removida conceptual. En el
                    // sistema real se guardaria la nota anterior
                    Object[] datos = (Object[]) op.getDatosEstado();
                    System.out.println("Nota removida del registro de " + datos[0]);
                    break;
                }
                case "ELIMINAR_ESTUDIANTE": {
                    // Deshacer eliminacion = volver a registrar al estudiante
                    Estudiante e = (Estudiante) op.getDatosEstado();
                    gestorEstudiantes.reRegistrarEstuidante(e);
                    System.out.println("Estudiante " + e.getId() + " restaurado");
                    break;
                }
                default:
                    System.out.println("Tipo de operacion desconocido: " + op.getTipo());
            }
        } catch (Exception e) {
            System.out.println("Error al deshacer: " + e.getMessage());
        }

    }

    private void aplicarRehacer(Operacion op){
        try{
            switch(op.getTipo()){
                case "INSCRIPCION":{
                    String[] datos = (String[]) op.getDatosEstado();
                    Materia m = gestorMaterias.buscarMateria(datos[1]);
                    if(m != null && m.hayCupo()){
                        m.inscribirEstudiante(datos[0]);
                        System.out.println(datos[0] + " inscrito en " + datos[1]);
                    }
                    break;
                }
                case "CANCELACION":{
                    String[] datos = (String[]) op.getDatosEstado();
                    Materia m = gestorMaterias.buscarMateria(datos[1]);
                    if(m != null){
                        m.cancelarInscripcion(datos[0]);
                        System.out.println("Cancelacion rehecha: " + datos[0] + " fuera de " + datos[1]);
                    }
                    break;
                }
                case "ELIMINAR_ESTUDIANTE":{
                    Estudiante e = (Estudiante) op.getDatosEstado();
                    try{
                        gestorEstudiantes.eliminarEstudiante(e.getId());
                        System.out.println("Estudiante " + e.getId() + " eliminado de nuevo");
                    } catch(EstudianteNoEncontradoException ex){
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                }
                default:
                    System.out.println("Rehacer: tipo no manejo " + op.getTipo());
            }
        } catch(Exception e){
            System.out.println("Error al rehacer: " + e.getMessage());
        }
    }
}

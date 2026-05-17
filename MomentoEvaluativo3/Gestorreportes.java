import java.util.Stack;

public class Gestorreportes {
    private Gestorestudiantes gestorEstudiantes;
    //Creamos una pila apra navegar entre los reportes vistos (un stack)
    private Stack<String> pilaReportes;
    
    public Gestorreportes(Gestorestudiantes gestorEstudiantes){
        this.gestorEstudiantes = gestorEstudiantes;
        this.pilaReportes = new Stack<>();
    }

    //Registramos una nota en el arrgelo double[10][20] del estudiante con el siguiente metodo
    public void registrarNota(String idEStudiante, int semestre, String codigoMateria, double nota) throws EstudianteNoEncontradoException{
        Estudiante e = gestorEstudiantes.buscarPorId(idEStudiante);
        boolean ok = e.registrarNota(semestre, codigoMateria, nota);
        if(ok){
            System.out.println("Nota registrada: " + codigoMateria + " = " + nota + " (Semestre " + semestre + ")");
        } else{
            System.out.println("Error: semestre fuera de rango o cupo de materia lleno");
        }
    }

    //Ahora necesitamos generar y mostrar un reporte academico completo del estudiante
    //Asi que gardamos el id en la pila de reportes vistos
    public void verReporteAcademico(String idEstudiante) throws EstudianteNoEncontradoException{
        Estudiante e = gestorEstudiantes.buscarPorId(idEstudiante);

        //Ahora guardamos en la pila de navegacion

        pilaReportes.push(idEstudiante);

        System.out.println("--- REPORTE ACADEMICO ---");
        System.out.println("Estudiante: " + e.getNombre() + " (ID: " + e.getId() + ")");
        System.out.println();

        double[][] notas = e.getNotas();
        String[][] nombres = e.getNombresMaterias();
        int[] conteo = e.getConteoMaterias();
        int totalMaterias = 0;
        int materiasReprobadas = 0;
        for(int i = 0; i < 10; i++){
            if(conteo[i] == 0) continue;
            System.out.println("Semestre " + (i + 1) + ":");
            for(int j = 0; j < conteo[i]; j++){
                System.out.printf(" %-10s: %.1f%n", nombres[i][j], notas[i][j]);
                totalMaterias++;
                if(notas[i][j] < 3.0) materiasReprobadas ++;
            }
            System.out.printf(" Promedio: %.2f%n", e.calcularPromedioPorSemestre(i + 1));
            System.out.println();
        }
        System.out.println("=== RESUMEN ===");
        System.out.printf("Promedio acumulado: %.2f%n", e.calcularPromedioAcumulado());
        System.out.println("Materias aprobadas: " + (totalMaterias - materiasReprobadas));
        System.out.println("Materias reprobadas: " + materiasReprobadas);
    }

    //Navega al reporte anterior, usando la pila
    public void reporteAnterior() throws PilasDeshacerVaciaException, EstudianteNoEncontradoException{
        if(pilaReportes.isEmpty()){
            throw new PilasDeshacerVaciaException("No hay reportes anteriores para mostrar");
        }
        //sacamos el actual y mostramos el anteriro si es que existe
        pilaReportes.pop();
        if(pilaReportes.isEmpty()){
            System.out.println("No hay mas reportes anteriores");
            return;
        }
        String anterior = pilaReportes.peek();
        System.out.println("Volviendo al reporte de: " + anterior);
        verReporteAcademico(anterior);
    }

    //Muestra un reporte sin volver a apilarlo
    private void verReporteAcademicoSinApilar(String idEstudiante) throws EstudianteNoEncontradoException{
        Estudiante e = gestorEstudiantes.buscarPorId(idEstudiante);
        System.out.println("--- REPORTE ACADEMICO ---");
        System.out.println("Estudiante: " + e.getNombre() + " (ID: " + e.getId() + ")");

        double[][] notas = e.getNotas();
        String[][] nombres = e.getNombresMaterias();
        int[] conteo = e.getConteoMaterias();

        for(int i = 0; i < 10; i++){
            if(conteo[i] == 0) continue;
            System.out.println("Semestre " + (i + 1) + ":");
            for(int j = 0; j < conteo[i]; j++){
                System.out.printf(" %-10s: %.1f%n", nombres[i][j], notas[i][j]);
            }
            System.out.printf(" Promedio: %.2f%n", e.calcularPromedioPorSemestre(i + 1));
        }
    }
}

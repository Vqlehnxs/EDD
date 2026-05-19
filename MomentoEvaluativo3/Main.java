import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static Gestorestudiantes gestorEstudiantes = new Gestorestudiantes();
    private static Gestormaterias gestorMaterias = new Gestormaterias(gestorEstudiantes);
    private static Gestorprofesores gestorProfesores = new Gestorprofesores(gestorMaterias);
    private static Gestorhorarios gestorHorarios = new Gestorhorarios();
    private static Gestorrutas gestorRutas = new Gestorrutas();
    private static Gestorreportes gestorReportes = new Gestorreportes(gestorEstudiantes);
    private static Gestordeshacerrehacer gestorDR = new Gestordeshacerrehacer(gestorEstudiantes, gestorMaterias, gestorHorarios);
    private static Gestorbatch gestorBatch = new Gestorbatch(gestorMaterias, gestorEstudiantes);

    public static void main(String[] args) {
        // Inyectar GestorProfesores en GestorMaterias para poder mostrar el docente al
        // inscribir
        gestorMaterias.setGestorprofesores(gestorProfesores);
        cargarDatosDemostracion();
        boolean corriendo = true;
        while (corriendo) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opcion: ");
            System.out.println();
            switch (opcion) {
                // Gestion de estudiantes
                case 1:
                    opcion1_RegistrarEstudiante();
                    break;
                case 2:
                    opcion2_BuscarEstudiante();
                    break;
                case 3:
                    gestorEstudiantes.listarEstudiantes();
                    break;
                case 4:
                    opcion4_EliminarEstudiante();
                    break;
                // Gestion de materias
                case 5:
                    opcion5_CrearMateria();
                    break;
                case 6:
                    opcion6_AgregarPreRequisito();
                    break;
                case 7:
                    opcion7_MostrarPreRequisitos();
                    break;
                case 8:
                    opcion8_InscribirEstudiante();
                    break;
                case 9:
                    opcion9_CancelarInscripcion();
                    break;
                case 10:
                    opcion10_MostrarColaEspera();
                    break;
                // Las opciones de horarios
                case 11:
                    opcion11_ReservarHorario();
                    break;
                case 12:
                    opcion12_LiberarHorario();
                    break;
                case 13:
                    opcion13_ConsultarDisponibilidad();
                    break;
                // Rutas en los edificios
                case 14:
                    opcion14_AgregarConexion();
                    break;
                case 15:
                    opcion15_CalcularRuta();
                    break;
                // Reportes academicos
                case 16:
                    opcion16_RegistrarNota();
                    break;
                case 17:
                    opcion17_VerReporte();
                    break;
                case 18:
                    opcion18_ReporteAnterior();
                    break;
                // Las opciones de deshacer / Rehacer
                case 19:
                    opcion19_Deshacer();
                    break;
                case 20:
                    opcion20_Rehacer();
                    break;
                //El batch
                case 21:
                    opcion21_ProcesarBatch();
                    break;
                //Gestor de profesores
                case 22:
                    opcion22_RegistrarProfesor();
                    break;
                case 23:
                    opcion23_BuscarProfesor();
                    break;
                case 24:
                    opcion24_AsignarMateriaProfesor();
                    break;
                // Y el salir
                case 25:
                    corriendo = false;
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println();
        }
    }

    // Este es el menu

    private static void mostrarMenu() {
        System.out.println("============================================================");
        System.out.println("         PLANIFICACION ACADEMICA - SISTEMA UNIVERSITARIO");
        System.out.println("============================================================");
        System.out.println("=== GESTION DE ESTUDIANTES ===");
        System.out.println(" 1- Registrar estudiante");
        System.out.println(" 2- Buscar estudiante por ID");
        System.out.println(" 3- Listar todos los estudiantes");
        System.out.println(" 4- Eliminar estudiante");
        System.out.println("=== GESTION DE MATERIAS ===");
        System.out.println(" 5- Crear materia");
        System.out.println(" 6- Agregar pre-requisito");
        System.out.println(" 7- Mostrar pre-requisitos");
        System.out.println(" 8- Inscribir estudiante");
        System.out.println(" 9- Cancelar inscripcion");
        System.out.println("10- Mostrar cola de espera");
        System.out.println("=== GESTION DE HORARIOS ===");
        System.out.println("11- Reservar horario en aula");
        System.out.println("12- Liberar horario");
        System.out.println("13- Consultar disponibilidad");
        System.out.println("=== RUTAS ENTRE EDIFICIOS ===");
        System.out.println("14- Agregar conexion entre edificios");
        System.out.println("15- Calcular ruta mas corta");
        System.out.println("=== REPORTES ACADEMICOS ===");
        System.out.println("16- Registrar nota");
        System.out.println("17- Ver reporte academico");
        System.out.println("18- Navegador de reportes (atras)");
        System.out.println("=== SISTEMA DESHACER/REHACER ===");
        System.out.println("19- Deshacer ultima operacion");
        System.out.println("20- Rehacer ultima operacion");
        System.out.println("=== PROCESAMIENTO POR LOTES ===");
        System.out.println("21- Procesar archivo CSV");
        System.out.println("=== GESTION DE PROFESORES ===");
        System.out.println("22- Registrar profesor");
        System.out.println("23- Buscar profesor por ID");
        System.out.println("24- Asignar materia a profesor");
        System.out.println("=== SALIR ===");
        System.out.println("25- Salir");
        System.out.println("------------------------------------------------------------");
    }

    // Aqui le damos vida a las opciones

    private static void opcion1_RegistrarEstudiante() {
        System.out.println("--- REGISTRO DE ESTUDIANTE ---");
        System.out.print("ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        int semestre = leerEntero("Semestre actual: ");
        gestorEstudiantes.registrarEstudiante(nombre, id, email, semestre);
    }

    private static void opcion2_BuscarEstudiante() {
        System.out.println("--- BUSCAR ESTUDIANTE ---");
        System.out.print("ID: ");
        String id = sc.nextLine().trim();
        try {
            Estudiante e = gestorEstudiantes.buscarPorId(id);
            System.out.println("\nResultado encontrado:");
            e.mostrarInformacion();
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion4_EliminarEstudiante() {
        System.out.println("--- ELIMINAR ESTUDIANTE ---");
        System.out.print("ID: ");
        String id = sc.nextLine().trim();
        try {
            Estudiante eliminado = gestorEstudiantes.eliminarEstudiante(id);
            System.out.println("Estudiante eliminado: " + eliminado.getNombre());
            // Registrar para deshacer
            gestorDR.registrarOperacion(new Operacion("ELIMINAR_ESTUDIANTE", "Eliminar estudiante " + eliminado.getId(), eliminado));
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion5_CrearMateria() {
        System.out.println("--- CREAR MATERIA ---");
        System.out.print("Codigo: ");
        String codigo = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        int cupos = leerEntero("Cupos maximos: ");
        int creditos = leerEntero("Creditos: ");
        gestorMaterias.crearMateria(codigo, nombre, cupos, creditos);
    }

    private static void opcion6_AgregarPreRequisito() {
        System.out.println("--- AGREGAR PRE-REQUISITO ---");
        System.out.print("Codigo de la materia: ");
        String mat = sc.nextLine().trim();
        System.out.print("Codigo del pre-requisito: ");
        String req = sc.nextLine().trim();
        gestorMaterias.agregarPreRequisito(mat, req);
    }

    private static void opcion7_MostrarPreRequisitos() {
        System.out.print("Codigo de la materia: ");
        String cod = sc.nextLine().trim();
        gestorMaterias.mostrarPreRequisitos(cod);
    }

    private static void opcion8_InscribirEstudiante() {
        System.out.println("--- INSCRIBIR ESTUDIANTE ---");
        System.out.print("ID del estudiante: ");
        String id = sc.nextLine().trim();
        System.out.print("Codigo de la materia: ");
        String cod = sc.nextLine().trim();
        try {
            gestorMaterias.inscribirEstudiante(id, cod);
            // Registrar para deshacer
            gestorDR.registrarOperacion(new Operacion("INSCRIPCION","Inscribir " + id + " en " + cod, new String[] { id, cod }));
        } catch (PreRequisitoNoAprobadoException | EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion9_CancelarInscripcion() {
        System.out.println("--- CANCELAR INSCRIPCION ---");
        System.out.print("ID del estudiante: ");
        String id = sc.nextLine().trim();
        System.out.print("Codigo de la materia: ");
        String cod = sc.nextLine().trim();
        gestorMaterias.cancelarInscripcion(id, cod);
        gestorDR.registrarOperacion(new Operacion("CANCELACION","Cancelar inscripcion de " + id + " en " + cod, new String[] { id, cod }));
    }

    private static void opcion10_MostrarColaEspera() {
        System.out.print("Codigo de la materia: ");
        String cod = sc.nextLine().trim();

        try {
            gestorMaterias.mostrarColaEspera(cod);
        } catch (ColaDeEsperaVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion11_ReservarHorario() {
        System.out.println("--- RESERVAR HORARIO EN AULA ---");
        System.out.print("Aula: ");
        String aula = sc.nextLine().trim();
        int dia = leerEntero("Dia (0=Domingo, 1=Lunes ... 6=Sabado): ");
        int hora = leerEntero("Hora (0-23): ");
        int dur = leerEntero("Duracion (horas): ");
        try {
            gestorHorarios.reservarHorario(aula, dia, hora, dur);
            //Aqui aplicamos para que se pueda deshacer o rehacer
            gestorDR.registrarOperacion(new Operacion("HORARIO","Reservar aula " + aula + " dia " + dia + " hora " + hora,new Object[] { aula, dia, hora, dur }));
        } catch (HorarioConflictivoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion12_LiberarHorario() {
        System.out.println("--- LIBERAR HORARIO ---");
        System.out.print("Aula: ");
        String aula = sc.nextLine().trim();
        int dia = leerEntero("Dia (0-6): ");
        int hora = leerEntero("Hora (0-23): ");
        int dur = leerEntero("Duracion (horas): ");
        gestorHorarios.liberarHorario(aula, dia, hora, dur);
    }

    private static void opcion13_ConsultarDisponibilidad() {
        System.out.print("Aula: ");
        String aula = sc.nextLine().trim();
        int dia = leerEntero("Dia (0-6): ");
        int hora = leerEntero("Hora (0-23): ");
        gestorHorarios.consultarDisponibilidad(aula, dia, hora);
    }

    private static void opcion14_AgregarConexion() {
        System.out.println("--- AGREGAR CONEXION ENTRE EDIFICIOS ---");
        gestorRutas.mostrarEdificios();
        if (gestorRutas.getTotalEdificios() == 0) {
            System.out.print("Nombre del primer edificio (nuevo): ");
            String n1 = sc.nextLine().trim();
            gestorRutas.agregarEdificio(n1);
        }
        System.out.print("Nombre del edificio origen (o nuevo): ");
        String orig = sc.nextLine().trim();
        // Si no existe, agregar
        boolean existeOrig = false;
        for (int i = 0; i < gestorRutas.getTotalEdificios(); i++) {
            if (gestorRutas.getNombreEdificios(i).equalsIgnoreCase(orig)) {
                existeOrig = true;
                break;
            }
        }
        if (!existeOrig)
            gestorRutas.agregarEdificio(orig);

        System.out.print("Nombre del edificio destino (o nuevo): ");
        String dest = sc.nextLine().trim();
        boolean existeDest = false;
        int idxOrig = -1, idxDest = -1;
        for (int i = 0; i < gestorRutas.getTotalEdificios(); i++) {
            if (gestorRutas.getNombreEdificios(i).equalsIgnoreCase(orig))
                idxOrig = i;
            if (gestorRutas.getNombreEdificios(i).equalsIgnoreCase(dest)) {
                existeDest = true;
                idxDest = i;
            }
        }
        if (!existeDest) {
            gestorRutas.agregarEdificio(dest);
            idxDest = gestorRutas.getTotalEdificios() - 1;
        }
        if (idxOrig == -1)
            idxOrig = gestorRutas.getTotalEdificios() - 2;

        int metros = leerEntero("Distancia en metros: ");
        gestorRutas.agregarConexion(idxOrig, idxDest, metros);
    }

    private static void opcion15_CalcularRuta() {
        System.out.println("--- CALCULAR RUTA MAS CORTA ---");
        gestorRutas.mostrarEdificios();
        int origen = leerEntero("Indice del edificio origen: ");
        int destino = leerEntero("Indice del edificio destino: ");
        gestorRutas.calcularRutaMasCorta(origen, destino);
    }

    private static void opcion16_RegistrarNota() {
        System.out.println("--- REGISTRAR NOTA ---");
        System.out.print("ID del estudiante: ");
        String id = sc.nextLine().trim();
        int semestre = leerEntero("Semestre (1-10): ");
        System.out.print("Codigo de la materia: ");
        String cod = sc.nextLine().trim();
        double nota = leerDouble("Nota (0.0 - 5.0): ");
        try {
            gestorReportes.registrarNota(id, semestre, cod, nota);
            gestorDR.registrarOperacion(new Operacion("NOTA","Registrar nota " + nota + " en " + cod + " para " + id, new Object[] { id, semestre, cod, nota }));
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion17_VerReporte() {
        System.out.print("ID del estudiante: ");
        String id = sc.nextLine().trim();
        try {
            gestorReportes.verReporteAcademico(id);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion18_ReporteAnterior() {
        try {
            gestorReportes.reporteAnterior();
        } catch (PilasDeshacerVaciaException | EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion19_Deshacer() {
        try {
            gestorDR.deshacer();
        } catch (PilasDeshacerVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion20_Rehacer() {
        try {
            gestorDR.rehacer();
        } catch (PilasDeshacerVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion21_ProcesarBatch() {
        System.out.println("--- PROCESAMIENTO MASIVO (BATCH) ---");
        System.out.print("Ruta del archivo CSV: ");
        String ruta = sc.nextLine().trim();
        try {
            gestorBatch.cargarArchivo(ruta);
            gestorBatch.procesarCola();
        } catch (ArchivoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void opcion22_RegistrarProfesor() {
        System.out.println("--- REGISTRAR PROFESOR ---");
        System.out.print("ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Telefono: ");
        String tel = sc.nextLine().trim();
        gestorProfesores.registrarProfesor(nombre, id, email, tel);
    }

    private static void opcion23_BuscarProfesor() {
        System.out.println("--- BUSCAR PROFESOR POR ID ---");
        System.out.print("ID del profesor: ");
        String id = sc.nextLine().trim();
        gestorProfesores.buscarProfesorPorId(id);
    }

    private static void opcion24_AsignarMateriaProfesor() {
        System.out.println("--- ASIGNAR MATERIA A PROFESOR ---");
        System.out.print("ID del profesor: ");
        String idP = sc.nextLine().trim();
        System.out.print("Codigo de la materia: ");
        String cod = sc.nextLine().trim();
        gestorProfesores.asignarMateria(idP, cod);
    }

    // Creamos unos datos de demostracion que pueden ser utilizados para ver el
    // funcionamiento del programa sin necesidad de agregar unos
    private static void cargarDatosDemostracion() {
        System.out.println("Cargando datos de demostración...");

        // Estudiantes
        gestorEstudiantes.registrarEstudiante("Ana Maria", "2024001", "ana.gomez@ucc.edu.co", 3);
        gestorEstudiantes.registrarEstudiante("Juan Perez", "2024002", "juan.perez@ucc.edu.co", 1);
        gestorEstudiantes.registrarEstudiante("Maria Lopez", "2024003", "maria.lopez@ucc.edu.co", 2);
        gestorEstudiantes.registrarEstudiante("Carlos Ruiz", "2024004", "carlos.ruiz@ucc.edu.co", 1);

        // Materias
        gestorMaterias.crearMateria("CALC101", "Calculo I", 3, 4);
        gestorMaterias.crearMateria("CALC102", "Calculo II", 30, 4);
        gestorMaterias.crearMateria("FIS101", "Fisica I", 30, 3);
        gestorMaterias.crearMateria("PROG101", "Programacion I", 25, 3);
        gestorMaterias.agregarPreRequisito("CALC102", "CALC101");

        // Notas para Ana
        try {
            gestorReportes.registrarNota("2024001", 1, "CALC101", 4.5);
            gestorReportes.registrarNota("2024001", 1, "FIS101", 2.8);
            gestorReportes.registrarNota("2024001", 1, "PROG101", 5.0);
            gestorReportes.registrarNota("2024001", 2, "CALC102", 3.5);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // Aulas
        gestorHorarios.agregarAula("101", 30);
        gestorHorarios.agregarAula("102", 40);
        gestorHorarios.agregarAula("Laboratorio 1-A", 20);

        // Edificios y conexiones
        gestorRutas.agregarEdificio("Ingenieria");
        gestorRutas.agregarEdificio("Biblioteca");
        gestorRutas.agregarEdificio("Cafeteria");
        gestorRutas.agregarEdificio("Rectoria");
        gestorRutas.agregarEdificio("Laboratorios");
        gestorRutas.agregarConexion(0, 1, 200); // Ingenieria-Biblioteca
        gestorRutas.agregarConexion(0, 2, 150); // Ingenieria-Cafeteria
        gestorRutas.agregarConexion(1, 3, 300); // Biblioteca-Rectoria
        gestorRutas.agregarConexion(2, 3, 180); // Cafeteria-Rectoria
        gestorRutas.agregarConexion(2, 4, 100); // Cafeteria-Laboratorios
        gestorRutas.agregarConexion(3, 4, 250); // Rectoria-Laboratorios

        // Profesores
        gestorProfesores.registrarProfesor("Jose Mendoza", "PROF001", "j.mendoza@ucc.edu.co", "3001234567");
        gestorProfesores.registrarProfesor("Laura Rios", "PROF002", "l.rios@ucc.edu.co", "3109876543");
        gestorProfesores.registrarProfesor("Andres Vargas", "PROF003", "a.vargas@ucc.edu.co", "3154567890");
        gestorProfesores.asignarMateria("PROF001", "CALC101");
        gestorProfesores.asignarMateria("PROF001", "CALC102");
        gestorProfesores.asignarMateria("PROF002", "FIS101");
        gestorProfesores.asignarMateria("PROF003", "PROG101");

        System.out.println("Datos de demostración cargados.\n");
    }

    // Estos son unos pequeños "Helpers" que ayudaran a que el codigo sea mas
    // dinamico
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número entero valido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número decimal valido.");
            }
        }
    }
}

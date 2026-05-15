import java.util.TreeMap;

public class Gestorhorarios {
    // TreeMap, esto ayuda a ordenar las aulas por nombre (un orden alfabetico)
    private TreeMap<String, Aula> aulas;

    public Gestorhorarios() {
        this.aulas = new TreeMap<>();
    }

    public void agregarAula(String nombre, int capacidad) {
        Aula aula = new Aula(nombre, capacidad);
        aulas.put(nombre, aula);
        System.out.println("Aula registrada: " + aula);
    }

    public Aula buscarAula(String nombre) {
        return aulas.get(nombre);
    }

    public void reservarHorario(String nombreAula, int dia, int hora, int duracion) throws HorarioConflictivoException {
        Aula aula = aulas.get(nombreAula);
        if (aula == null) {
            System.out.println("Aula no encontarada: " + nombreAula);
            return;
        }
        System.out.println("Verificando disponibilidad...");
        String[] dias = { "Domingo", "Lunes", "Martes", "Miercoles", "Juves", "Viernes", "Sabado" };

        for (int h = hora; h < hora + duracion && h < 24; h++) {
            boolean libre = aula.consultarDisponibilidad(dia, h);
            System.out.println(" " + dias[dia] + " " + h + ":00 ->" + (libre ? "LIBRE" : "OCUPADO"));
        }
        aula.reservar(dia, hora, duracion);
    }

    public void liberarHorario(String nombreAula, int dia, int hora, int duracion) {
        Aula aula = aulas.get(nombreAula);
        if (aula == null) {
            System.out.println("Aula no encontrada");
            return;
        }
        aula.liberar(dia, hora, duracion);
    }

    public void consultarDisponibilidad(String nombreAula, int dia, int hora) {
        Aula aula = aulas.get(nombreAula);
        if (aula == null) {
            System.out.println("Aula no encontrada");
            return;
        }
        String[] dias = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};

        boolean disponible = aula.consultarDisponibilidad(dia, hora);
        System.out.println(nombreAula + " el " + dias[dia] + " a las " + hora + ":00 -> " + (disponible ? "LIBRE" : "OCUPADO") );
    }

    public void listarAulas(){
        if(aulas.isEmpty()){
            System.out.println("No hay aulas registradas");
            return;
        }

        System.out.println("=== AULAS ===");
        for(Aula a : aulas.values()){
            System.out.println(" " + a);
        }
    }

    public TreeMap<String, Aula> getAulas() {
        return aulas;
    }

    
}

import java.util.HashMap;

public class Gestorprofesores {
    // Un HashMap para una busqueda rapida de profesor por ID
    private HashMap<String, Profesor> profesores;
    private Gestormaterias gestorMaterias;

    public Gestorprofesores(Gestormaterias gestorMaterias) {
        this.gestorMaterias = gestorMaterias;
        this.profesores = new HashMap<>();
    }

    // Metodo para registrar un profesor en el sistema
    public void registrarProfesor(String nombre, String id, String email, String telefono) {
        Profesor p = new Profesor(nombre, id, email, telefono, telefono);
        profesores.put(id, p);
        System.out.println("Profesor registrado: " + nombre + " (ID: " + id + ")");
    }

    // Un metodo que busque al profesor por id y muestre su informacion de contacto
    public void buscarProfesorPorId(String id) {
        Profesor p = profesores.get(id);
        if (p == null) {
            System.out.println("No existe un profesor con ID: " + id);
            return;
        }
        System.out.println("--- INFORMACION DEL DOCENTE ---");
        p.mostrarInformacion();
    }

    // Ahora necesitamos asignar una materia a un profesor y actualizar la materia
    // con el ID del profersor
    public void asignarMateria(String idProfesor, String codigoMateria) {
        Profesor p = profesores.get(idProfesor);
        if (p == null) {
            System.out.println("No existe un profesor con ID: " + idProfesor);
            return;
        }

        Materia m = gestorMaterias.buscarMateria(codigoMateria);
        if (m == null) {
            System.out.println("No existe una materia con codigo:" + codigoMateria);
            return;
        }

        // Revisamos si la materia ya tenia otro profesor y lo avisamos
        if (m.getIdProfesor() != null && !m.getIdProfesor().equals(idProfesor)) {
            System.out.println("La materia " + codigoMateria + " ya tenia asignado al profesor " + m.getIdProfesor()
                    + " Se reemplaza");
        }

        p.setCodigoMateria(codigoMateria);
        m.setIdProfesor(idProfesor);
        System.out.println("Asignacion existosa: " + p.getNombre() + " -> " + m.getNombre());
    }

    // Ahora un metodo para devolver el profesor asignado a una materia, o sino null
    // si no tiene
    public Profesor getProfesorDeMateria(String codigoMateria) {
        for (Profesor p : profesores.values()) {
            if (codigoMateria.equals(p.getCodigoMateria())) {
                return p;
            }
        }
        return null;
    }

    public void listarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados");
            return;
        }
        System.out.println("=== PROFESORES ===");
        for (Profesor p : profesores.values()) {
            String materia = p.getCodigoMateria() != null ? p.getCodigoMateria() : " (sin asignar)";
            System.out.println(" " + p.getId() + " - " + p.getNombre() + " | Materia: " + materia);
        }
    }

    public HashMap<String, Profesor> getProfesores() {
        return profesores;
    }

    

}

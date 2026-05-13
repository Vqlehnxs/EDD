import java.util.HashMap;

public class Gestorestudiantes {
    //Utilizamos HasMap para una busqueda rapida por ID
    private HashMap<String, Estudiante> indiceEstudiantes;
    //Un arreglo estatico de facultadaodes (con un tamaño fijo 5)
    private Facultad[] facultades;

    public Gestorestudiantes() {
        indiceEstudiantes = new HashMap<>();
        facultades = new Facultad[5];
        facultades[0] = new Facultad("Ingenieria", "ING");
        facultades[1] = new Facultad("Ciencias", "CIE");
        facultades[2] = new Facultad("Medicina", "MED");
        facultades[3] = new Facultad("Derecho", "DER");
        facultades[4] = new Facultad("Humanidades", "HUM");
    }

    // Metodo para registrar nuevos estudiantes

    public void registrarEstudiante(String nombre, String id, String email, int semestre){
        Estudiante e = new Estudiante(nombre, id, email, semestre);
        indiceEstudiantes.put(id, e);
        System.out.println("Estudiante registrado de manera exitosa");
    }

    // Metodo para buscar un estudiante por ID usando el hashmap

    public Estudiante buscarPorId(String id) throws EstudianteNoEncontradoException{
        Estudiante e = indiceEstudiantes.get(id);
        if (e == null){
            throw new EstudianteNoEncontradoException("Estudiante no encontrado - No existe un estudiante con este ID: " + id);
        }
        return e;
    }

    // Metodo que elimina un estudiante del sistema

    public Estudiante eliminarEstudiante(String id) throws EstudianteNoEncontradoException{
        Estudiante e = buscarPorId(id);
        indiceEstudiantes.remove(id);
        return e;
    }
    
    // Registra nuevamente un estudiante (para rehacer una eliminacion)

    public void reRegistrarEstuidante(Estudiante e){
        indiceEstudiantes.put(e.getId(), e);
    }

    // Lista todos los estuidantes registrados

    public void listarEstudiantes(){
        if(indiceEstudiantes.isEmpty()){
            System.out.println("No hay estudiantes registrados");
            return;
        }
        System.out.println("=== LISTA DE ESTUDIANTES ===");
        for(Estudiante e : indiceEstudiantes.values()){
            System.out.println(" " + e.getId() + " - " + e.getNombre() + " (Semestre " + e.getSemestre() + ")");
        }
    }

    //Muestra las 5 facultades del arreglo
    public void mostrarFacultades(){
        System.out.println("=== FACULTADES ===");
        for(int i = 0; i < facultades.length; i++){
            System.out.println(" " + i + "." + facultades[i]);
        }
    }

    public HashMap<String, Estudiante> getIndiceEstudiantes() {
        return indiceEstudiantes;
    }

    public boolean existeEstudiante(String id){
        return indiceEstudiantes.containsKey(id);
    }
}

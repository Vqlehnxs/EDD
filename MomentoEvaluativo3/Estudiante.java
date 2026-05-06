import java.util.LinkedList;

public class Estudiante extends Persona {
    private int semestre;
    /*Arrelog [10][20], 10 semestres, 20 materias por semestre */
    private double[][] notas;
    /*Nombres de materias por semestre (para mostar el reporte) */
    private String [][] nombresMaterias;
    /*Conteo de materias registradas por semestre */
    private int[] conteoMaterias;
    /*Historial de las materias cursadas, usando 
    lista enlazadas */
    private LinkedList<String> historialMaterias;

    public Estudiante(String nombre, String id, String email, int semestre) {
        super(nombre, id, email);
        this.semestre = semestre;
        this.notas = new double[10][20];
        this.nombresMaterias = new String[10][20];
        this.conteoMaterias = new int[10];
        this.historialMaterias = new LinkedList<>();
/*Inicializar notas en -1 para saber cuales estan vacias */
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 20; j++){
                notas[i][j] = -1;
            }
        }
    }

    public int getSemestre() {
        return semestre;
    }

    public double[][] getNotas() {
        return notas;
    }

    public String[][] getNombresMaterias() {
        return nombresMaterias;
    }

    public int[] getConteoMaterias() {
        return conteoMaterias;
    }

    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
/*Registra una nota en el semestre indicado. Ademas devuelve true si se pudo registrar | False si el semestre o el curso esta lleno */
    public boolean registrarNota(int semestre, String codigoMateria, double nota){
        int idx = semestre - 1;
        if(idx < 0 || idx >= 10) return false;
        if(conteoMaterias[idx] >= 20) return false;
        int pos = conteoMaterias[idx];
        notas[idx][pos] = nota;
        nombresMaterias[idx][pos] = codigoMateria;
        conteoMaterias[idx]++;

        if(!historialMaterias.contains(codigoMateria)){
            historialMaterias.add(codigoMateria);
        }
        return true;
    }
/*Calcula el promedio de un semestre especifico*/
    public double calcularPromedioPorSemestre(int semestre){
        int idx = semestre - 1;
        if(idx < 0 || idx >= 10 || conteoMaterias[idx] == 0) return 0.0;
        double suma = 0;
        for(int j = 0; j < conteoMaterias[idx]; j++){
            suma += notas[idx][j];
        }
        return suma / conteoMaterias[idx];
    }
/*Calcula el promedio acumulado de todos los semestres con notas */
    public double calcularPromedioAcumulado(){
        double suma = 0;
        int total = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < conteoMaterias[i]; j++){
                suma += notas[i][j];
                total++;
            }
        }
        if(total == 0) return 0.0;
        return suma / total;
    }
/* Elimina la ultima nota registrada en un semestre especifico*/
    public void removerUltimaNota(int semestre){
        int idx = semestre -1;
        if(idx >= 0 && idx < 10 && conteoMaterias[idx] > 0){
            conteoMaterias[idx]--; // Retrocede el contador
            int pos = conteoMaterias[idx];
            notas[idx][pos] = -1; // Limpia la nota
            nombresMaterias[idx][pos] = null; // Limpia el nombre
        }
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Semestre: " + getSemestre());
        System.out.printf("Promedio acumulado: %.2f%n", calcularPromedioAcumulado());
    }

    
}

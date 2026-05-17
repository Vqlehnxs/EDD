//Ahora el procesamiento batch: lee un CSV con solicitudes de inscripcion y las encola para poder porecesarlas
//El formato del CSV: idEstudiante, codigoMateria

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Gestorbatch {
    private Gestormaterias gestorMaterias;
    private Gestorestudiantes gestorEstudiantes;
    //Cola de procesamiento batch con cola "Queue"
    private Queue<String[]> colaSolicitudes;

    public Gestorbatch(Gestormaterias gestorMaterias, Gestorestudiantes gestorEstudiantes) {
        this.gestorMaterias = gestorMaterias;
        this.gestorEstudiantes = gestorEstudiantes;
        this.colaSolicitudes = new LinkedList<>();
    }

    //Lee el archivo CSV y encola todas las solicitudes
    public void cargarArchivo(String rutaArchivo) throws ArchivoInvalidoException{
        colaSolicitudes.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while((linea = br.readLine()) != null){
                linea = linea.trim();
                if(linea.isEmpty()) continue;
                String[] partes = linea.split(",");
                if(partes.length != 2){
                    throw new ArchivoInvalidoException("Archivo Invalido Exception - Linea invalida " + linea);
                }
                colaSolicitudes.add(new String[]{partes[0].trim(), partes[1].trim()});
            }
        } catch(IOException e){
            throw new ArchivoInvalidoException("Archivo invalido exception - No se pudo leer el archivo " + rutaArchivo);
        }
        System.out.println("Se encolaron " + colaSolicitudes.size() + " solicitudes");
    }

    //Procesamos toda la cola secuencialmente
    public void procesarCola(){
        if(colaSolicitudes.isEmpty()){
            System.out.println("La cola de solicitudes esta vacia");
            return;
        }
        
        System.out.println("Procesando cola...");
        int total = colaSolicitudes.size();
        int exitosas = 0;
        int fallidas = 0;
        int num = 1;

        while (!colaSolicitudes.isEmpty()) {
            String[] solicitud = colaSolicitudes.poll();
            String idEStudiante = solicitud[0];
            String codigoMateria = solicitud[1];

            try{
                gestorMaterias.inscribirEstudiante(idEStudiante, codigoMateria);
                System.out.println("[" + num + "/" + total + "] " + idEStudiante + " -> " + codigoMateria + " -> Exisosa");
                exitosas++;
            } catch(PreRequisitoNoAprobadoException | EstudianteNoEncontradoException e){
                System.out.println("[" + num + "/" + total + "] " + idEStudiante + " -> " + codigoMateria + " -> Fallida (" + e.getMessage() + ")");
                fallidas++;
            }
            num++;
        }

        System.out.println("\n=== RESUMEN ===");
        System.out.println("Exitosas: " + exitosas);
        System.out.println("Fallidas: " + fallidas);
    }
}

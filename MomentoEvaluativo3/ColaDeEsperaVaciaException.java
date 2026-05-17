//Excepcion personalizada que se lanza cuando se intenta extraer a un estudiante de la cola de espera y este no contiene ningun elemento
public class ColaDeEsperaVaciaException extends Exception{
    //Construye una nueva excepcion indicando que la cola de espera no tiene elemento. Por ejemplo "No hay estudiantes en la cola de espera"
    public ColaDeEsperaVaciaException(String mensaje) {
        //Pasa el mensaje de error al constructor 
        super(mensaje);
    }
    
}

//Excepcion personalizada que se lanza cuando se intenta registrar a un estudiante en un curso que ya ha alcanzado su limite maximo de capacida
public class CupoLlenoExpcetion extends Exception {
    //Este indica cuando el cupo esta agotado, por ejemplo "El grupo 3 de estructura de datos ya no tiene cupo"
    public CupoLlenoExpcetion(String mensaje) {
        //Registra el mensaje en la clase
        super(mensaje);
    }
    
}

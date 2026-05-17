/*Excepcion personalizada que se lanza cuando se intenta realizar una accion de deshacer pero la pila se encuentra vacia*/
public class PilasDeshacerVaciaException extends Exception {
    // Construye una nueva excepcion indicando que la pila de deshacer esta vacia, asi que manda un error detallado.
    public PilasDeshacerVaciaException(String mensaje) {
        super(mensaje);
        /*Este llama al constructor de exception para registrar el mensaje
        Asi queda disponible y atrapa la excepcion*/
    }

}

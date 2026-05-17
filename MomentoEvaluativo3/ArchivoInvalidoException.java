/*Y esta excepcion personalizada que se lanza cuando se intenta cargar, leer o procesar un archivo que no cumple con el formato esperado*/
public class ArchivoInvalidoException extends Exception{
    //Asi que la nueva excepcion indicael motivo por la cual el archivo fue rechazado. Por ejemplo "El archivo datos.csv no tiene la estructura requerida"
    public ArchivoInvalidoException(String mensaje) {
        //Se registra el mensaje de error en la clase para que se pueda recuperar despues
        super(mensaje);
    }
    
}

/*Excepcion personalizada para manejar los conflictos en el horario.
Al extender Exception. es como un chek, que obliga al llamarla a manejarla*/
public class HorarioConflictivoException extends Exception {
    /*El constructor recibe un mensaje de error
    Por ejemplo, "El horario del lunes a las 10 am esta ocupado"*/
    public HorarioConflictivoException(String mensaje){
        /*Este llama al constructor de exception para registrar el mensaje
        Asi queda disponible y atrapa la excepcion*/
        super(mensaje);
    }
}

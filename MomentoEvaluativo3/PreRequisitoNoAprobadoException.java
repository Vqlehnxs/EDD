/*Excepcion personalizada para manejar si los PreRequisitos no son aprobados.
Al extender Exception. es como un chek, que obliga al llamarla a manejarla*/
public class PreRequisitoNoAprobadoException extends Exception {
     /*El constructor recibe un mensaje de error
    Por ejemplo, "No se puede matricular calculo II porque no se ha aprobado calculo I"*/
    public PreRequisitoNoAprobadoException(String mensaje){
     /*Este llama al constructor de exception para registrar el mensaje
     Asi queda disponible y atrapa la excepcion*/
        super(mensaje);
    }
}

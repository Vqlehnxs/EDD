/*Igual a la excepcion personalizada para manejar los conflictos en el horario. Pero en este caso redireccionada a ols gestor de estudiantes
Al extender Exception. es como un chek, que obliga al llamarla a manejarla*/
public class EstudianteNoEncontradoException extends Exception{
     /*El constructor recibe un mensaje de error
    Por ejemplo, "El estudiante con ID xxx no fue encontrado"*/
    public EstudianteNoEncontradoException(String mensaje){
        /*Este llama al constructor de exception para registrar el mensaje
        Asi queda disponible y atrapa la excepcion*/
        super(mensaje);
    }
}

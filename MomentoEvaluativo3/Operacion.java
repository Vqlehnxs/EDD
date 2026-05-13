/*Esta es la operacion que puede deshacerse o rehacerse*/
/*Guardara el tipo de operacion y los datos necesarios para poder revertirla*/
public class Operacion {
    private String tipo;
    // Inscrion, cancelaciones, notas, o eliminar estuidantes
    private String descripcion;
    private Object datosEstado;
    // Un objeto con el estado anterior que depende del tipo claro

    public Operacion(String tipo, String descripcion, Object datosEstado) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.datosEstado = datosEstado;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Object getDatosEstado() {
        return datosEstado;
    }

    @Override
    public String toString() {
        return "[" + tipo + "]" + descripcion;
    }

    
}

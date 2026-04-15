
public class Contenedor {
    String id;
    double peso;
    int prioridad;

    public Contenedor(String id, double peso, int prioridad) {
        this.id = id;
        this.peso = peso;
        this.prioridad = prioridad;
    }

    public boolean esPeligroso(){
        return prioridad >= 3;
    }

    @Override
    public String toString() {
        return String.format("[%s | %.1f kg | P%d]", id, peso, prioridad);
    }

    
}

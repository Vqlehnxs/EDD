
public class Buque {
    private int id;
    private String nombre;
    private String paisOrigen;
    private int capacidad;

    public Buque(int id, String nombre, String paisOrigen, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Buque [id=" + id + ", nombre=" + nombre + ", paisOrigen=" + paisOrigen + ", capacidad=" + capacidad
                + "]";
    }

    
}



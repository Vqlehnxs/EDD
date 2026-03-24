
public class Carrito {
    private int id;
    private boolean disponible;
    
    public Carrito(int id, boolean disponible) {
        this.id = id;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setNumero(int id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Carrito #" + id;
    }

    
}

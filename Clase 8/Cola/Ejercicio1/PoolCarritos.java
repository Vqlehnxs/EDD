import java.util.LinkedList;
import java.util.Queue;

public class PoolCarritos {
    private Queue<Carrito> carritos;
    private int totalCarritos;

    public PoolCarritos(int cantidad) {
        this.carritos = new LinkedList<>();
        this.totalCarritos = cantidad;

        for (int i = 1; i <= cantidad; i++) {
            carritos.add(new Carrito(i, true));
        }

        System.out.println("[PoolCarritos] Inicializado con " + cantidad + " carritos.");
    }

    public synchronized Carrito pedirCarrito(Cliente cliente) throws InterruptedException {
        while (carritos.isEmpty()) {
            System.out.println(" " + cliente + " espera un carrito disponible...");
            wait();
        }

        Carrito c = carritos.poll();
        return c;
    }

    public synchronized void devolverCarrito(Carrito carrito) {
        carrito.setDisponible(true);
        carritos.add(carrito);
        notifyAll();
    }

    public int getTotalCarritos() {
        return totalCarritos;
    }

    public synchronized int getDisponibles() {
        return carritos.size();
    }

    public synchronized void mostrarEstado() {
        System.out.println("[PoolCarritos]" + carritos.size() + "/" + totalCarritos);
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class CajaPago implements Runnable {
    private int id;
    private Queue<Cliente> cola;
    private PoolCarritos pool;
    private boolean abierta;

    private static final int TIEMPO_ATENCION_MS = 300;

    public CajaPago(int id, PoolCarritos pool, boolean abierta) {
        this.id = id;
        this.cola = new LinkedList<>();
        this.pool = pool;
        this.abierta = true;
    }

    public int getId() {
        return id;
    }

    public synchronized void encolarCliente(Cliente cliente) {
        cola.add(cliente);
        System.out.println(" " + cliente + " se une a Caja #" + id);
        notifyAll();
    }

    public synchronized int tamañoCola() {
        return cola.size();
    }

    public synchronized void cerrar() {
        this.abierta = false;
        notifyAll();
    }

    @Override
    public void run() {
        System.out.println("[Caja #" + id + "] Abierta");
        while (true) {
            Cliente cliente = null;

            synchronized (this) {
                while (cola.isEmpty() && abierta) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (!abierta && cola.isEmpty()) {
                    break;
                }
                if (!cola.isEmpty()) {
                    cliente = cola.poll();
                }
            }

            if (cliente != null) {
                System.out.println("[Caja#" + id + "] Atendiendo a " + cliente + "...");
                try {
                    Thread.sleep(TIEMPO_ATENCION_MS); // simula tiempo de cobro
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // Al pagar, el carrito queda disponible
                Carrito c = cliente.getCarrito();
                if (c != null) {
                    pool.devolverCarrito(c);
                    System.out.println("[Caja #" + id + "] " + cliente
                            + " pagó. " + c + " devuelto al pool.");
                }
            }
        }
        System.out.println("[Caja#" + id + "] Cerrada. Cola vacía.");
    }

    @Override
    public String toString() {
        return "Caja#" + id + "(cola=" + cola.size() + ")";
    }

}

public class Main {
    private static final int NUM_CARRITOS = 25;
    private static final int NUM_CAJAS = 3;
    private static final int NUM_CLIENTES = 40;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Simulacion de supermercado ---");
        System.out.println("Carritos " + NUM_CARRITOS + " | Cajas: " + NUM_CAJAS + " | Clientes: " + NUM_CLIENTES);
        System.out.println("--------------------------------\n");

        Supermercado supermercado = new Supermercado(NUM_CARRITOS, NUM_CAJAS);
        Thread[] hilosClientes = new Thread[NUM_CLIENTES];
        for (int i = 1; i <= NUM_CLIENTES; i++) {
            final int idCliente = i;
            hilosClientes[i - 1] = new Thread(() -> {
                try {
                    Cliente cliente = new Cliente(idCliente);
                    supermercado.llegaCliente(cliente);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "HiloCliente-" + i);
        }

        for (Thread t : hilosClientes) {
            t.start();
            Thread.sleep(50);
        }

        for (Thread t : hilosClientes) {
            t.join();
        }

        supermercado.cerrar();

        System.out.println("\n--- Simulacion terminada ---");
    }
}

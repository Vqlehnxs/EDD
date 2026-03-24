import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private PoolCarritos pool;
    private List<CajaPago> cajas;
    private List<Thread> hilosCajas;

    public Supermercado(int numCarritos, int numCajas) {
        this.pool = new PoolCarritos(numCarritos);
        this.cajas = new ArrayList<>();
        this.hilosCajas = new ArrayList<>();

        for(int i = 1; i <= numCajas; i++){
            CajaPago caja = new CajaPago(i, pool, false);
            cajas.add(caja);
            Thread t = new Thread(caja, "HiloCaja-" + i);
            t.start();
        }
    }

    public void  llegaCliente(Cliente cliente) throws InterruptedException{
        System.out.println("\n[Supermercado] LLega " + cliente);

        Carrito carrito = pool.pedirCarrito(cliente);
        cliente.tomarCarrito(carrito);

        Thread.sleep(100);

        CajaPago cajaElegida = cajaMenorCola();
        cajaElegida.encolarCliente(cliente);
    }

    private CajaPago cajaMenorCola(){
        CajaPago menor = cajas.get(0);
        for(CajaPago caja: cajas){
            if(caja.tamañoCola() < menor.tamañoCola()){
                menor = caja;
            }
        }
        return menor;
    }

    public void cerrar() throws InterruptedException{
        System.out.println("\n[Supermercado] Cerrando cajas...");
        for(CajaPago caja : cajas){
            caja.cerrar();
        }
        for(Thread t : hilosCajas){
            t.join();
        }
        System.out.println("[Supermercado] Todas las cajas cerradas");
        pool.mostrarEstado();
    }

    public PoolCarritos getPool() {
        return pool;
    }

    public List<CajaPago> getCajas() {
        return cajas;
    }

    

    
}

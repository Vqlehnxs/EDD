import java.util.LinkedList;
import java.util.Queue;

public class FilaUnica {
    private Queue<Cliente1> fila;
    private long tamañoMaximo;
    private long sumaTamaños;
    private int muestras;

    public FilaUnica() {
        this.fila = new LinkedList<>();
        this.tamañoMaximo = 0;
        this.sumaTamaños = 0;
        this.muestras = 0;
    }

    public synchronized void encolar(Cliente1 cliente){
        fila.add(cliente);
        registrarMuestra();
    }

    public synchronized Cliente1 desencolar(){
        Cliente1 c = fila.poll();
        if(c != null) registrarMuestra();
        return c;
    }

    public synchronized int getTamaño(){
        return fila.size();
    }

    public synchronized boolean isEmpty(){
        return fila.isEmpty();
    }

    private void registrarMuestra(){
        long t = fila.size();
        if(t > tamañoMaximo) tamañoMaximo = sumaTamaños += t;
        muestras++;
    }

    public long getTamañoMaximo() {
        return tamañoMaximo;
    }

    public double getTamañoMedio(){
        if(muestras == 0) return 0;
        return (double) sumaTamaños / muestras;
    }
}

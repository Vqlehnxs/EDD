import java.util.Random;

public class CajaPago1 {
    private int id;
    private double minAtencion;
    private double maxAtencion;
    private boolean abierta;
    private double tiempoLibreDesde;
    private double tiempoAbiertoTotal;
    private double tiempoApertura;
    private Random random;

    public CajaPago1(int id, double minAtencion, double maxAtencion, double tiempoApertura) {
        this.id = id;
        this.minAtencion = minAtencion;
        this.maxAtencion = maxAtencion;
        this.abierta = true;
        this.tiempoLibreDesde = tiempoApertura;
        this.tiempoAbiertoTotal = 0;
        this.tiempoApertura = tiempoApertura;
        this.random = new Random();
    }

    public int getId() {
        return id;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void cerrar(double tiempoActual) {
        this.abierta = false;
        this.tiempoAbiertoTotal += (tiempoActual - tiempoApertura);
        System.out.printf("  [Caja#%d] Cerrada en t=%.1f min (abierta %.1f min)%n", id, tiempoActual,
                tiempoAbiertoTotal);
    }

    public boolean isLibre(double tiempoActual) {
        return abierta && tiempoActual >= tiempoLibreDesde;
    }

    public double atender(Cliente1 cliente, double tiempoActual) {
        cliente.setTiempoAtencion(tiempoActual);
        double duracion = minAtencion + random.nextDouble() * (maxAtencion - minAtencion);
        tiempoLibreDesde = tiempoActual + duracion;
        System.out.printf("  [Caja#%d] Atiende %s (%.1f min) -> libre en t=%.1f%n", id , cliente, duracion, tiempoLibreDesde);
        return tiempoLibreDesde;
    }

    public double getTiempoLibreDesde() {
        return tiempoLibreDesde;
    }

    public double getTiempoAbiertoTotal() {
        return tiempoAbiertoTotal;
    }

    @Override
    public String toString() {
        return "Caja #" + id;
    }

    

}

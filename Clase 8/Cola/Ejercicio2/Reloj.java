
public class Reloj {
    private double tiempoActual;

    public static final double FIN_JORNADA = 420.0;

    public Reloj() {
        this.tiempoActual = 0.0;
    }

    public synchronized double getTiempo(){
        return tiempoActual;
    }

    public synchronized void avanzar(double minutos){
        tiempoActual += minutos;
    }

    public synchronized boolean jornadaTerminada(){
        return tiempoActual >= FIN_JORNADA;
    }

    @Override
    public String toString(){
        int h = (int) (tiempoActual / 60);
        int m = (int) (tiempoActual % 60);
        return String.format("%02d:%02d (min %.1f)", h, m, tiempoActual);
    }
}

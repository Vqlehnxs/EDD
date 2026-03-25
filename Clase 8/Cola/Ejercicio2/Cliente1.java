public class Cliente1 {
    private int id;
    private double tiempoLlegada;
    private double tiempoAtencion;

    public Cliente1(int id, double tiempoLlegada) {
        this.id = id;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoAtencion = -1;
    }

    public int getId() {
        return id;
    }

    public double getTiempoLlegada() {
        return tiempoLlegada;
    }

    public double getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(double tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }
    
    public double getTiempoEspera(){
        if(tiempoAtencion < 0) return 0;
        return tiempoAtencion - tiempoLlegada;
    }

    @Override
    public String toString() {
        return "Cliente #" + id;
    }

    
}

public class Contenedor {
    private String codigo;
    private double peso;
    private String paisOrigen;
    private int idBuque;

    public Contenedor(String codigo, double peso, String paisOrigen, int idBuque) {
        this.codigo = codigo;
        this.peso = peso;
        this.paisOrigen = paisOrigen;
        this.idBuque = idBuque;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public int getIdBuque() {
        return idBuque;
    }

    @Override
    public String toString() {
        return "Contenedor [codigo=" + codigo + ", peso=" + peso + ", paisOrigen=" + paisOrigen + ", idBuque=" + idBuque
                + "]";
    }

    
}



public class moto {

    private int modelo;
    private String marca;
    private String color;
    private double cilindraje;
    private double precio;

    public moto(int modelo, String marca, String color, double cilindraje, double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.cilindraje = cilindraje;
        this.precio = precio;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String realizarMantenimeinto(String mtto){
        return "Mantenimiento realizado fue " + mtto;
    }

    @Override
    public String toString() {
        return "moto [modelo=" + modelo + ", marca=" + marca + ", color=" + color + ", cilindraje=" + cilindraje
                + ", precio=" + precio + "]";
    }

    

    }

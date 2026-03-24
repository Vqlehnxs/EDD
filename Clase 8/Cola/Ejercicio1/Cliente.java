public class Cliente {
    private int id;
    private Carrito carrito;
    
    public Cliente(int id) {
        this.id = id;
        this.carrito = null;
    }

    public int getId() {
        return id;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void tomarCarrito(Carrito carrito){
        this.carrito = carrito;
        carrito.setDisponible(false);
        System.out.println(" Cliente #" + id + " toma " + carrito);
    }

    public void devolverCarrito(){
        if(carrito != null){
            carrito.setDisponible(true);
            System.out.println(" Cliente #" + id + " devuelve " + carrito);
            carrito = null;
        }

    }

    @Override
    public String toString() {
        return "Cliente #" + id;
    }

    
}

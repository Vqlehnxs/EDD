public class Inventario {

    private Producto[] productos;
    private int cantidad;

    public Inventario(int capacidad) {
        this.productos = new Producto[capacidad];
        this.cantidad = 0;
    }

    public void agregarProducto(Producto p) {
        if (cantidad < productos.length) {
            productos[cantidad] = p;
            cantidad++;
        } else {
            System.out.println("No hay espacio disponible en el inventario");
        }
    }

    public Producto buscarPorId(int id){
        for (int i = 0; i < cantidad; i++){
            if (productos[i].getId() == id){
                return productos[i];
            }
        }
        return null;
    }

    public void actualizarStock(int id, int nuevaCantidad){
        Producto p = buscarPorId(id);
        if (p != null){
            p.setCantidadStock(nuevaCantidad);
            System.out.println("Stock actualizado: " + p);
        } else {
            System.out.println("Producto con ID: " + id + " no encontrado");
        }
    }

    public double generarInformeValorTotal(){
        double total = 0;
        for (int i = 0; i < cantidad; i++){
            total += productos[i].getPrecio() * productos[i].getCantidadStock();
        }
        return total;
    }

    public Producto[] obteneProductosAgotados(){
        int contador = 0;
        for (int i = 0; i < cantidad; i++){
            if (productos[i].getCantidadStock() < 5){
                contador++;
            }
        }
        Producto[] agotados = new Producto[contador];
        int j = 0;
        for (int i = 0; i < cantidad; i++){
            if(productos[i].getCantidadStock() < 5){
                agotados[j] = productos[i];
                j++;
            }
        }
        return agotados;
    }

    public void ordenarPorPrecioDescendente(){
        for(int i = 0; i < cantidad - 1; i++){
            for(int j = 0; j < cantidad - i - 1; j++){
                if (productos[j].getPrecio() < productos[j + 1].getPrecio()){
                    Producto temp = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = temp;
                }
            }
        }
    }

    public void mostrarProductos(){
        for(int i = 0; i < cantidad; i++){
            System.out.println(productos[i]);
        }
    }



    public static void main(String[] args) {

        Inventario inv = new Inventario(5);

        inv.agregarProducto(new Producto(1023, "Procesador Amd 7560g", 139.99, 200));
        inv.agregarProducto(new Producto(1093, "Placa Madre Asus Rog", 267.99, 15));
        inv.agregarProducto(new Producto(1022, "Pantalla Oled de 240 hz", 65.99, 1000));
        inv.agregarProducto(new Producto(1015, "Disco Nvm.2 de 3200 hz 1 tb", 134.99, 72));
        inv.agregarProducto(new Producto(1099, "Fuente Corsair 750w", 199.99, 5));

        System.out.println("Buscar id 1022: " + inv.buscarPorId(1022));

        inv.actualizarStock(1023, 201);

        System.out.println("Valor total: $" + inv.generarInformeValorTotal());

        System.out.println("Productos con stock bajo: ");
        for(Producto p : inv.obteneProductosAgotados()){
            System.out.println(p);
        }
        
        inv.ordenarPorPrecioDescendente();
        System.out.println("Productos ordenados por precio descendente: ");
        inv.mostrarProductos();

    }

}

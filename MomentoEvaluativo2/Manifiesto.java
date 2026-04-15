import java.util.Arrays;

public class Manifiesto {
    private Contenedor[] manifiesto;
    private int capacidad;
    private int cantidad;

    public Manifiesto(int n) {
        this.capacidad = n;
        this.manifiesto = new Contenedor[n];
        this.cantidad = 0;
    }

    public boolean registrar(Contenedor c){
        if(cantidad >= capacidad){
            System.out.println("Manifiesto lleno. No se puede registrar " + c.id);
            return false;
        }
        manifiesto[cantidad++] = c;
        return true;
    }

    public void resumen(){
        System.out.println("\n------- Manifiesto De Carga -------");
        double total = 0;
        for(int i = 0; i< cantidad; i++){
            System.out.println(" " + manifiesto[i]);
            total += manifiesto[i].peso;
        }
        System.out.printf(" Contenedores: %d | Peso Total: %.2f kg%n", cantidad, total);
        System.out.println("-----------------------------------\n");
    }

    public Contenedor[] getContenedores(){
        return Arrays.copyOf(manifiesto, cantidad);
    }
}

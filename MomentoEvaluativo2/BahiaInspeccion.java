import java.util.LinkedList;
import java.util.Queue;

public class BahiaInspeccion {
    private Queue<Contenedor> cola;

    public BahiaInspeccion() {
        this.cola = new LinkedList<>();
    }

    public void encolar(Contenedor c){
        if(c.esPeligroso()){
            cola.add(c);
            System.out.println(c.id + " enviado a inspeccion (prioridad " + c.prioridad + " )");
        }
    }

    public Contenedor inspeccionar(){
        if(cola.isEmpty()){
            System.out.println(" Cola de inspeccion vacia.");
            return null;
        }
        Contenedor c = cola.poll();
        System.out.println(" Inspeccionando: " + c);
        return c;
    }

    public void mostrarCola(){
        System.out.println("\n------- Cola De Inspecicon -------");
        if(cola.isEmpty()){
            System.out.println(" (Vacia)");
        } else{
            int pos = 1;
            for(Contenedor c: cola){
                System.out.println(" " + pos++ + "." + c);
            }
        }
        System.out.println("-----------------------------------\n");
    }

    public boolean isEmpty(){
        return cola.isEmpty();
    }
}

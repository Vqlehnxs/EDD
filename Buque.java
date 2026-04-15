import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Buque {
    private Stack<Contenedor> pila;
    private boolean modoEstabilidad;

    public Buque(boolean modoEstabilidad) {
        this.pila = new Stack<>();
        this.modoEstabilidad = modoEstabilidad;
    }

    public boolean apilar(Contenedor c){
        if(modoEstabilidad && !pila.isEmpty()){
            double pesoTope = pila.peek().peso;
            if(c.peso > pesoTope){
                System.out.printf(" %s rechazado (%.1f kg > tope %.1f kg) - riesgo de inestabilidad%n", c.id, c.peso, pesoTope);
                return false;
            }
        }
        pila.push(c);
        System.out.println(" Apilado: " + c);
        return true;
    }

    public void retirarFondo(){
        if(pila.isEmpty()){
            System.out.println(" El buque esta vacio.");
            return;
        }
        Stack<Contenedor> auxiliar = new Stack<>();

        while(pila.size() > 1){
            auxiliar.push(pila.pop());
        }

        Contenedor dañado = pila.pop();
        System.out.println(" Contenedor dañado retirado del fondo: " + dañado);

        while(!auxiliar.isEmpty()){
            pila.push(auxiliar.pop());
        }
        System.out.println(" Pila restaurada correctamente");
    }

    public void mostrarBuque(){
        System.out.println("\n------- Distribuccion Buque -------");
        if(pila.isEmpty()){
            System.out.println(" (Vacio)");
        } else{
            List<Contenedor> vista = new ArrayList<>(pila);
            for(int i = vista.size() - 1; i >= 0; i--){
                String etiqueta = (i == vista.size() - 1) ? " TOPE" : (i == 0) ? " FONDO" : "";
                System.out.println(" " + vista.get(i) + etiqueta);
            }
        }
        System.out.println("-----------------------------------\n");
    }

    public Stack<Contenedor> getPila(){
        return pila;
    }

}

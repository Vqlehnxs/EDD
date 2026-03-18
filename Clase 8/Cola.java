import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    public static void main(String[] args) {

        Queue<Integer> objCola = new LinkedList();

        objCola.add(29);
        objCola.add(16);
        objCola.offer(10);
        objCola.offer(34);

        System.err.println(objCola);

        System.out.println("Cabeza de la cola: " + objCola.element());

        System.out.println("Cabeza de la cola: " + objCola.peek());

        System.out.println("Elemento eliminado con poll: " + objCola.poll());
        
        System.out.println("Elemento eliminado con remove: " + objCola.remove());

        System.err.println(objCola);

        System.out.println("Tamano de la cola: " + objCola.size());

    }
}

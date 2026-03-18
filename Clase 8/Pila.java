import java.util.Stack;

public class Pila {
    public static void main(String[] args) {
        Stack<String> objPila = new Stack<>();

        objPila.push("Camilo");
        objPila.push("Daniela");
        objPila.push("Francisco");
        objPila.push("Dario");
        objPila.push("Daniela");

        System.out.println(objPila);

        System.out.println("Tope de la pila: " + objPila.peek());

        System.out.println("Pila vacia: " + objPila.empty());

        System.out.println("Elemento removido: " + objPila.pop());

        System.out.println(objPila);

        System.out.println(objPila.search("Camilo"));
        System.out.println(objPila.search("Daniela"));
        System.out.println(objPila.search("Francisco"));
        System.out.println(objPila.search("Dario"));

    }
}

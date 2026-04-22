/* La clase LinkedList es eficiente para insertar y eliminar elementos en los
extremos. Implementa una clase HistorialNavegacion que realice lo
siguiente:
Crea una instancia de LinkedList<String> para almacenar URLs.
Añade las siguientes URLs: google.com, github.com, stackoverflow.com.
Usa el método getLast() para mostrar la página actual.
Implementa una función "Atrás": elimina el último elemento y muestra la
nueva página actual.
Imprime el historial restante usando un bucle for-each. */

import java.util.LinkedList;

public class Ejercicio1 {
    
    LinkedList<String> historial;

    public Ejercicio1(){
        historial = new LinkedList<>();
    }

    public void visitar(String url){
        historial.addLast(url);
        System.out.println("Visitando: " + url);
    }

    public void paginaActual(){
        if(!historial.isEmpty()){
            System.out.println("Pagina actual: " + historial.getLast());
        } else {
            System.out.println("No hay paginas en el historial");
        }
    }

    public void atras(){
        if(historial.size() > 1){
            String eliminada = historial.removeLast();
            System.out.println("\n<- Atras (se elimino: " + eliminada + ")");
            System.out.println("Nueva pagina actual: " + historial.getLast());
        } else if(historial.size() == 1){
            System.out.println("\nEsta es la primera pagina del historial, no puedes retroceder mas");
        } else {
            System.out.println("\nEl historial esta vacio");
        }
    }

    public void mostrarHistorial(){
        System.out.println("\nHistorial restante:");
        for(String url : historial){
            System.out.println(" -> " + url);
        }
    }

    public static void main(String[] args){
        Ejercicio1 nav = new Ejercicio1();

        nav.visitar("google.com");
        nav.visitar("github.com");
        nav.visitar("stackoverflow.com");

        System.out.println();
        nav.paginaActual();
        nav.atras();
        nav.mostrarHistorial();
    }
}

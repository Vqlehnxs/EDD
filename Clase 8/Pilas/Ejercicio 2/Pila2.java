public class Pila2 {
    private Nodo2 tope;
    private String nombre;

    public Pila2(String nombre) {
        this.tope = null;
        this.nombre = nombre;
    }

    public void apilar(int valor) {
        Nodo2 nuevo = new Nodo2(valor);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public int desapilar() {
        if (estaVacia()) {
            System.out.println("  [" + nombre + "] La pila esta vacia, no se puede eliminar.");
            return Integer.MIN_VALUE;
        }
        int val = tope.valor;
        tope = tope.siguiente;
        return val;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrar() {
        System.out.print("  " + nombre + ": ");
        if (estaVacia()) {
            System.out.println("[vacia]");
            return;
        }
        Nodo2 actual = tope;
        System.out.print("tope -> ");
        while (actual != null) {
            System.out.print(actual.valor);
            if (actual.siguiente != null)
                System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
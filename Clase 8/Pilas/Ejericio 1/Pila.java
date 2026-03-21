public class Pila {
    private Nodo tope;

    public Pila() {
        tope = null;
    }

    public void apilar(char simbolo, int posicion) {
        Nodo nuevo = new Nodo(simbolo, posicion);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Nodo desapilar() {
        if (estaVacia())
            return null;
        Nodo nodo = tope;
        tope = tope.siguiente;
        return nodo;
    }

    public Nodo tope() {
        return tope;
    }

    public boolean estaVacia() {
        return tope == null;
    }
}

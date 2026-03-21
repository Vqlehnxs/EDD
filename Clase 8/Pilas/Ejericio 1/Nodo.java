public class Nodo {
    char simbolo;
    int posicion;
    Nodo siguiente;

    public Nodo(char simbolo, int posicion) {
        this.simbolo = simbolo;
        this.posicion = posicion;
        this.siguiente = null;
    }
}

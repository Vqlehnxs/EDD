public class Ejemplo {
    public static void main(String[] args) throws Exception {
        // Creación de arreglo/array/vector
        int[] a = {2, 6, 8, 1, 20, 40, 7, 3, 5};
        int suma = 0;
        System.out.println("Tamaño del arreglo: " + a.length);

        for(int i = 0; i < a.length; i++) {
            suma += a[i];
            System.out.println("a[" + i + "]=" + a[i]);
            System.out.println("Suma: " + suma);
        }
    }
}
// obtener la suma de numero pares e impares, mostrar los elementos de posiciones pares
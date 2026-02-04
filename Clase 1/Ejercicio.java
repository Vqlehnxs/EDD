public class Ejercicio {
    public static void main(String[] args) throws Exception {
        // Creación de arreglo/array/vector
        int[] a = {2, 6, 8, 1, 20, 40, 7, 3, 5};
        int sumaPar = 0;
        int sumaImpar = 0;
        System.out.println("Tamaño del arreglo: " + a.length);

        for(int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0){
                sumaPar += a[i];
            } else {
                sumaImpar += a[i];
            }
            
            if (i % 2 == 0) {
                System.out.println("Posición par: " + a[i] + " numero en la posición " + i);
            }

            System.out.println("a[" + i + "]=" + a[i]);
        }

        System.out.println("Suma par: " + sumaPar);
        System.out.println("Suma impar: " + sumaImpar);
    }
}
    // obtener la suma de numero pares e impares, mostrar los elementos de posiciones pares


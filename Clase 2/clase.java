public class clase {
    public static void main(String[] args) throws Exception {
        // Forma 1 - Definiendo el arreglo directamente con elementos
        int[] a = { 7, 2, 6, 1, 0, 3 };
        // El tamaño del arreglo se obtiene con la palabra reservada length
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        // sumar todos los elementos de arreglo
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        System.out.println("La suma de los elementos del arreglo a es: " + total); // 19
        /*
         * arreglo que se itera => int[] a = {7, 2, 6, 1, 0, 3};
         * Prueba de escritorio paso a paso
         * i i < a.length i++ total += a[i]
         * 0 0 < 6 true 1 total += 7 => total = 7
         * 1 < 6 true 2 total += 2 => total = 9
         * 2 < 6 true 3 total += 6 => total = 15
         * 3 < 6 true 4 total += 1 => total = 16
         * 4 < 6 true 5 total += 0 => total = 16
         * 5 < 6 true 6 total += 3 => total = 19
         * 6 < 6 false
         */
    }
}

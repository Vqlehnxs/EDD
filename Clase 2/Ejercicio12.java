public class Ejercicio12 {
    public static void main(String[] args) {

        int[] A = { 4, 9, 6, 9, 14, 9, 21, 1, 9 };
        int X = 9;

        int contador = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == X) {
                contador++;
            }
        }

        int[] B = new int[contador];
        int indiceB = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == X) {
                B[indiceB] = i + 1;
                indiceB++;
            }
        }

        System.out.println("Arreglo original: ");
        mostrarArreglo(A);

        System.out.println("Valor buscado X = " + X);

        System.out.println("Arreglo de posiciones:");
        mostrarArreglo(B);

        System.out.println("Detalle: ");
        for (int i = 0; i < B.length; i++) {
            System.out.println("El valor " + X + " aparece en la posición " + B[i]);
        }
    }

    public static void mostrarArreglo(int[] arreglo) {
        System.out.print("[");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}

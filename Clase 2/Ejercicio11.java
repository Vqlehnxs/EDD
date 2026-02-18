public class Ejercicio11 {
    public static void main(String[] args) {

        int[] A = { 5, -3, 0, 8, -7, 0, 12, -1, 4, 0, -9, 6 };

        int conteoNegativos = 0;
        int conteoCeros = 0;
        int conteoPositivos = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                conteoNegativos++;
            } else if (A[i] == 0) {
                conteoCeros++;
            } else {
                conteoPositivos++;
            }
        }

        int[] negativos = new int[conteoNegativos];
        int[] ceros = new int[conteoCeros];
        int[] positivos = new int[conteoPositivos];

        int indiceNeg = 0;
        int indiceCero = 0;
        int indicePos = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                negativos[indiceNeg] = A[i];
                indiceNeg++;
            } else if (A[i] == 0) {
                ceros[indiceCero] = A[i];
                indiceCero++;
            } else {
                positivos[indicePos] = A[i];
                indicePos++;
            }
        }

        System.out.println("Arreglo original: ");
        mostrarArreglo(A);

        System.out.println("Arreglo de Negativos: ");
        mostrarArreglo(negativos);

        System.out.println("Arreglo de Ceros: ");
        mostrarArreglo(ceros);

        System.out.println("Arreglo de Positivos: ");
        mostrarArreglo(positivos);
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

public class Ejercicio7 {
    public static void main(String[] args) {
        int[] A = { 12, 7, 23, 4, 18, 9, 31, 6, 15, 20 };
        int contarPares = 0;
        int contarImpares = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                contarPares++;
            } else {
                contarImpares++;
            }
        }

        int[] pares = new int[contarPares];
        int[] impares = new int[contarImpares];

        int indicePar = 0;
        int indiceImpar = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                pares[indicePar] = A[i];
                indicePar++;
            } else {
                impares[indiceImpar] = A[i];
                indiceImpar++;
            }
        }
        System.out.println("Arreglo original A: ");
        mostrarArreglo(A);

        System.out.println("Numeros pares: ");
        mostrarArreglo(pares);

        System.out.println("Numeros impares: ");
        mostrarArreglo(impares);
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

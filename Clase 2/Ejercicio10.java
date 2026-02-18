public class Ejercicio10 {
    public static void main(String[] args) {

    int[] A = { 6, 1, 5, 12, 4, 8, 7, 20 };
    int tamañoB = A.length / 2;
    int[] B = new int[tamañoB];

    for(int i = 0;i<tamañoB;i++){
        B[i] = A[i] + A[A.length - 1 - i];
    }

    System.out.print("Arreglo A: ");
    for (int num : A) System.out.print(num + " ");

    System.out.print("\nArreglo B: ");
    for (int num : B) System.out.print(num + " ");
}
}
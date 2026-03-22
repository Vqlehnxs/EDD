import java.util.Scanner;

public class Main2{

    static final int N = 5;

    public static void main(String[] args) {

        Pila2[] pilas = new Pila2[N + 1];
        for (int k = 1; k <= N; k++) {
            pilas[k] = new Pila2("P" + k);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.println("  Manejo de 5 pilas (P1, P2, P3, P4, P5)");
        System.out.println("=======================================================");
        System.out.println("  Ingrese dos numeros en cada turno:");
        System.out.println("  - i positivo: inserta j en la pila Pi");
        System.out.println("  - i negativo: elimina el tope de la pila P|i|");
        System.out.println("  - i = 0     : termina el programa");
        System.out.println("=======================================================");

        while (true) {
            System.out.println();
            System.out.print("  Numero de pila (i): ");
            int i = scanner.nextInt();

            if (i == 0) break;

            System.out.print("  Valor (j)         : ");
            int j = scanner.nextInt();

            int indice = Math.abs(i);

            if (indice < 1 || indice > N) {
                System.out.println("  Error: |i| debe estar entre 1 y " + N);
                continue;
            }

            if (i > 0) {
                pilas[indice].apilar(j);
                System.out.println("  -> Se inserto " + j + " en P" + indice);
            } else {
                int eliminado = pilas[indice].desapilar();
                if (eliminado != Integer.MIN_VALUE) {
                    System.out.println("  -> Se elimino " + eliminado + " de P" + indice);
                }
            }
        }

        scanner.close();

        System.out.println();
        System.out.println("=======================================================");
        System.out.println("  Contenido final de las pilas:");
        System.out.println("=======================================================");
        for (int k = 1; k <= N; k++) {
            pilas[k].mostrar();
        }
        System.out.println("=======================================================");
    }
}

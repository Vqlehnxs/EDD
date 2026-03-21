import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] expresiones = {
                "((a+b)*5)  -  7}"
        };

        String separar = " ";

        Scanner scanner = new Scanner(System.in);
        System.out.println(separar);
        System.out.println("  Ingrese una expresion (o presione Enter para saltar):");
        System.out.print("  > ");
        String entrada = scanner.nextLine().trim();
        if (!entrada.isEmpty()) {
            System.out.println("  Expresion: " + entrada);
            VerificadorEquilibrio.verificar(entrada);
            System.out.println(separar);
        }
        scanner.close();

        System.out.println("  --- Casos de prueba ---");
        for (String expr : expresiones) {
            System.out.println(separar);
            System.out.println("  Expresion: " + expr);
            VerificadorEquilibrio.verificar(expr);
        }
        System.out.println(separar);
    }
}

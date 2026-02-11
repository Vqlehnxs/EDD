import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de empleados: " );

        //Cantidad de empleados
        int N = scanner.nextInt();

        //Los arreglos dependiente de la cantidad de empleados, por eso se usa el "New double" para que tome la cantidad de empleados
        double[] A = new double[N];
        double[] B = new double[N];
        double[] C = new double[N];
        double[] T = new double[N];

        //for para ingresar el sueldo, asignaciones y deducciones en los arreglos
        for (int i = 0; i < N; i++){
            System.out.println("Empleado " + (i + 1));
            System.out.println("Ingrese el sueldo: " );
            A[i] = scanner.nextDouble();
            System.out.println("Ingrese las asignaciones: " );
            B[i] = scanner.nextDouble();
            System.out.println("Ingrese las deducciones: " );
            C[i] = scanner.nextDouble();

            //En esta parte se hace la operacion para el neto a pagar
            T[i] = A[i] + B[i] - C[i];
        }

        //Aqui se mostraran los resultados
        System.out.println("Resultados");
        for (int i = 0; i < N; i++){
        System.out.println("Empleado: " + (i + 1) + " Sueldo: " + A[i] + " Asignaciones: " + B[i] + " Deducciones: " + C[i] + " Neto a pagar: " + T[i]);
    }
    scanner.close();
    }
}

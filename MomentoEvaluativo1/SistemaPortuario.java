import java.util.Scanner;
import java.util.Random;

public class SistemaPortuario {

    static Buque[] buques = new Buque[10];
    static int cantidadBuques = 0;

    static Contenedor[] contenedores = new Contenedor[100];
    static int cantidadContenedores = 0;

    static String[][] matriz = new String[10][10];

    static Scanner sc = new Scanner(System.in);

    static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Error: ingrese solo numeros.");
            }
        }
    }

    static double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Error, ingrese solo numeros.");
            }
        }
    }

    public static void main(String[] args) {
        iniciarMatriz();
        generarDatosAleatorios();
        int opcion;
        do {
            System.out.println("\nMenu principal de portuario JH");
            System.out.println("1. Registrar Buque");
            System.out.println("2. Registrar Contenedor");
            System.out.println("3. Mostrar peso total de los contenedores");
            System.out.println("4. Contenedores por pais de origen");
            System.out.println("5. Lista de Buques");
            System.out.println("6. Salir");
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    menuBuques();
                    break;
                case 2:
                    menuContenedores();
                    break;
                case 3:
                    mostrarPesoTotal();
                    break;
                case 4:
                    listarPorOrigen();
                    break;
                case 5:
                    listarBuques();
                    break;
                case 6:
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 6);
    }

    static void iniciarMatriz() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = "[ ]";
            }
        }
    }

    static void generarDatosAleatorios() {
        Random rand = new Random();

        String[] nombresBuques = { "Titanic", "Kratos", "Crucero", "Cruz roja", "Navi" };
        String[] paises = { "Colombia", "Peru", "USA", "Tailandia", "Mexico", "Alemania", "Japon", "Francia", "Canada",
                "Guatemala" };

        for (int i = 0; i < 5; i++) {
            int id = 100 + i;
            String nombre = nombresBuques[i];
            String pais = paises[rand.nextInt(paises.length)];
            int capacidad = 5 + rand.nextInt(16);
            buques[cantidadBuques] = new Buque(id, nombre, pais, capacidad);
            cantidadBuques++;
        }

        int[] codigos = { 101, 102, 103, 104, 105 };
        for (int i = 0; i < 5; i++) {
            int codigo = codigos[i];
            double peso = 20 + rand.nextInt(81);
            String pais = paises[rand.nextInt(paises.length)];
            int idBuque = 100 + rand.nextInt(5);

            boolean colocado = false;
            for (int fila = 9; fila >= 0 && !colocado; fila--) {
                for (int col = 0; col < 10 && !colocado; col++) {
                    if (matriz[fila][col].equals("[ ]")) {
                        matriz[fila][col] = String.valueOf(codigo);
                        contenedores[cantidadContenedores] = new Contenedor(String.valueOf(codigo), peso, pais,
                                idBuque);
                        cantidadContenedores++;
                        colocado = true;
                    }
                }
            }
        }

        System.out.println("Datos aleatorios generados: 5 buques y " + cantidadContenedores + " contenedores.");
    }

    static void menuBuques() {
        System.out.println("\nRegistro de buques ");
        if (cantidadBuques >= 10) {
            System.out.println("No hay puesto disponible para mas buques");
            return;
        }

        System.out.println("Puestos disponibles: " + (10 - cantidadBuques));
        int id = leerEntero("ID del buque: ");

        for (int i = 0; i < cantidadBuques; i++) {
            if (buques[i].getId() == id) {
                System.out.println("Ya existe un buque con ese ID");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Pais de origen: ");
        String pais = sc.nextLine();
        int capacidad = leerEntero("Capacidad (numero de contenedores): ");

        buques[cantidadBuques] = new Buque(id, nombre, pais, capacidad);
        cantidadBuques++;
        System.out.println("Buque registrado correctamente");
    }

    static void menuContenedores() {
        System.out.println("\nRegistro de contenedores");

        if (cantidadBuques == 0) {
            System.out.println("Primero debe registrar un buque");
            return;
        }

        mostrarMatriz();

        System.out.print("Codigo del contenedor: ");
        String codigo = sc.nextLine();

        for (int i = 0; i < cantidadContenedores; i++) {
            if (contenedores[i].getCodigo().equals(codigo)) {
                System.out.println("Ya existe un contenedor con ese codigo");
                return;
            }
        }

        double peso = leerDecimal("Peso (kg): ");

        if (peso < 20 || peso > 100) {
            System.out.println("El peso debe estar entre 20 y 100 kg");
            return;
        }
        System.out.print("Pais de origen: ");
        String pais = sc.nextLine();
        int idBuque = leerEntero("ID del buque al que pertenece: ");

        boolean buqueExiste = false;
        for (int i = 0; i < cantidadBuques; i++) {
            if (buques[i].getId() == idBuque) {
                buqueExiste = true;
                break;
            }
        }
        if (!buqueExiste) {
            System.out.println("El buque con ID " + idBuque + " no existe.");
            return;
        }
        int contadorBuque = 0;
        for (int i = 0; i < cantidadContenedores; i++) {
            if (contenedores[i].getIdBuque() == idBuque) {
                contadorBuque++;
            }
        }

        int capacidadBuque = 0;
        for (int i = 0; i < cantidadBuques; i++) {
            if (buques[i].getId() == idBuque) {
                capacidadBuque = buques[i].getCapacidad();
                break;
            }
        }

        if (contadorBuque >= capacidadBuque) {
            System.out.println(
                    "El buque " + idBuque + " ya alcanzo su capacidad maxima de " + capacidadBuque + " contenedores.");
            return;
        }

        int col = leerEntero("Columna donde desea colocar el contenedor (0-9): ");

        if (col < 0 || col > 9) {
            System.out.println("Columna invalida.");
            return;
        }

        int filaDisponible = -1;
        for (int fila = 9; fila >= 0; fila--) {
            if (matriz[fila][col].equals("[ ]")) {
                filaDisponible = fila;
                break;
            }
        }

        if (filaDisponible == -1) {
            System.out.println("La columna " + col + " esta llena.");
            return;
        }

        matriz[filaDisponible][col] = codigo;
        contenedores[cantidadContenedores] = new Contenedor(codigo, peso, pais, idBuque);
        cantidadContenedores++;
        System.out.println("Contenedor colocado en fila " + filaDisponible + ", columna " + col);
        mostrarMatriz();
    }

    static void mostrarMatriz() {
        System.out.println("\n--- Estado de area ---");
        System.out.printf("%-8s", " ");
        for (int col = 0; col < 10; col++) {
            System.out.printf("%-12s", "A" + col);
        }
        System.out.println();
        for (int fila = 0; fila < 10; fila++) {
            System.out.printf("%-8s", "B" + fila);
            for (int col = 0; col < 10; col++) {
                System.out.printf("%-12s", matriz[fila][col]);
            }
            System.out.println();
        }
        int libres = 0;
        for (int f = 0; f < 10; f++)
            for (int c = 0; c < 10; c++)
                if (matriz[f][c].equals("[ ]"))
                    libres++;
        System.out.println("Puestos libres: " + libres + " | Ocupados: " + (100 - libres));
    }

    static void mostrarPesoTotal() {
        if (cantidadContenedores == 0) {
            System.out.println("No hay contenedores registrados.");
            return;
        }
        double total = 0;
        for (int i = 0; i < cantidadContenedores; i++) {
            total += contenedores[i].getPeso();
        }
        System.out.println("Peso total de todos los contenedores: " + total + " kg");
    }

    static void listarPorOrigen() {
        if (cantidadContenedores == 0) {
            System.out.println("No hay contenedores registrados.");
            return;
        }

        String[] paises = new String[cantidadContenedores];
        int totalPaises = 0;

        for (int i = 0; i < cantidadContenedores; i++) {
            String pais = contenedores[i].getPaisOrigen();
            boolean existe = false;
            for (int j = 0; j < totalPaises; j++) {
                if (paises[j].equals(pais)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                paises[totalPaises] = pais;
                totalPaises++;
            }
        }

        System.out.println("\nContenedores por pais de origen");
        for (int i = 0; i < totalPaises; i++) {
            System.out.println("\nPais: " + paises[i]);
            for (int j = 0; j < cantidadContenedores; j++) {
                if (contenedores[j].getPaisOrigen().equals(paises[i])) {
                    System.out.println("  " + contenedores[j]);
                }
            }
        }
    }

    static void listarBuques() {
        if (cantidadBuques == 0) {
            System.out.println("No hay buques registrados");
            return;
        }

        System.out.println("\nBuques registrados");
        for (int i = 0; i < cantidadBuques; i++) {
            System.out.println("ID: " + buques[i].getId() + " | Nombre: " + buques[i].getNombre() + " | Pais: "
                    + buques[i].getPaisOrigen() + " | Capacidad: " + buques[i].getCapacidad() + " contenedores");
        }
    }
}
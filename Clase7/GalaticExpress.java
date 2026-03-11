import java.util.Random;

public class GalaticExpress {
    
    public static void main(String[] args) {

        int[] energiaContenedores = new int[12];
        Random rand = new Random();

        System.out.println("--- Arreglo original ---");
        for(int i = 0; i < 12; i++){
            energiaContenedores[i] = 50 + rand.nextInt(101);
            System.out.print(energiaContenedores[i] + " ");
        }
        System.out.println();

        int contador = 0;
        for(int i = 0; i < 12; i++){
            if(energiaContenedores[i] % 10 == 0){
                contador++;
            }
        }

        int[] multiplos = new int[contador];
        int j = 0;
        for(int i = 0; i < 12; i++){
            if(energiaContenedores[i] % 10 == 0){
                multiplos[j] = energiaContenedores[i];
                j++;
            }
        }

        System.out.println("\n --- Valores multiplos de 10 ---");
        for(int i = 0; i < multiplos.length; i++){
            System.out.print(multiplos[i] + " ");
        }
        System.out.println();

        int [][] mapaCarga = new int [3][3];
        int index = 0;

        for(int fila = 0; fila < 3; fila++){
            for(int col = 0; col < 3; col++){
                if(index < multiplos.length){
                    mapaCarga[fila][col] = multiplos[index];
                    index++;
                } else {
                    mapaCarga[fila][col] = -1;
                }
            }
        }

        System.out.println("\n --- Mapa de carga 3x3 ---");
        for(int fila = 0; fila < 3; fila++){
            for(int col = 0; col < 3; col++){
                System.out.format("%-6d", mapaCarga[fila][col]);
            }
            System.out.println();
        }

        Suministro[] manifiesto = new Suministro[9];
        int posicion = 0;

        for(int fila = 0; fila < 3; fila++){
            for(int col = 0; col < 3; col++){
                if(mapaCarga[fila][col] != -1){
                    String id = "C-" + fila + "-" + col;
                    int energia = mapaCarga[fila][col];
                    String prioridad = energia > 100 ? "ALTA" : "ESTANDAR";
                    manifiesto[posicion] = new Suministro(id, energia, prioridad);
                } else{
                    manifiesto[posicion] = null;
                }
                posicion++;
            }
        }
        System.out.println("\n --- Manifiesto de vuelo ---");
        for(int i = 0; i < manifiesto.length; i++){
            if(manifiesto[i] != null){
                System.out.println(manifiesto[i]);
            } else{
                System.out.println("Posicion " + i + ": vacia");
            }
        }
    }


}

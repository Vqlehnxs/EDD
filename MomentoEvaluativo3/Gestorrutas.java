//Para gestionar la ruta entre los edificios usaremos una matriz int[N][N]
//Ademas, usare el algoritmo de Dijkstra para encontrar la ruta mas corta entre los edificios. Usando la implementacion de GeeksForGeeks
//obviamente lo adaptare para usar mi matriz y mostrar el camino completo

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Gestorrutas {
    private static final int MAX_EDIFICIOS = 20;
    private static final int INF = Integer.MAX_VALUE;
    //Aqui la matriz - distancias en metros (0 si no hay conexion)
    private int[][] distancia;
    private String[] nombreEdificios;
    private int totalEdificios;

    public Gestorrutas(){
        distancia = new int[MAX_EDIFICIOS][MAX_EDIFICIOS];
        nombreEdificios = new String[MAX_EDIFICIOS];
        totalEdificios = 0;
    }

    public void agregarEdificio(String nombre){
        if(totalEdificios >= MAX_EDIFICIOS){
            System.out.println("Maximo de edificios alcanzados");
            return;
        }
        nombreEdificios[totalEdificios] = nombre;
        totalEdificios++;
        System.out.println("Edificio registrado: " + nombre + " (indice " + (totalEdificios - 1) + ")");
    }

    public void agregarConexion(int origen, int destino, int metros){
        if(origen < 0 || origen >= totalEdificios ||destino < 0 || destino >= totalEdificios ){
            System.out.println("Indice de edificios invalido");
            return;
        }
        //Este es el grafo (es decir las conexiones entre los destinos)
        distancia[origen][destino] = metros;
        distancia[destino][origen] = metros;
        System.out.println("Conexion: " + nombreEdificios[origen] + " <-> " + nombreEdificios[destino] + " (" + metros + "m)");
    }

    //Ahora calcularemos la ruta mas corta entre edificios, usando el algoritmo de Diajkstra
    //Tomare como base el algoritmo de GeeksForGeeks
    public void calcularRutaMasCorta(int origen, int destino){
        if(origen < 0 || origen>= totalEdificios || destino < 0 || destino >= totalEdificios){
            System.out.println("Indice de edificios invalido");
            return;
        }

        int n = totalEdificios;
        int[] dist = new int[n];
        int[] anterior = new int[n]; // Para poder "reconstruir" el camino
        boolean[] visitado = new boolean[n];

        Arrays.fill(dist, INF);
        Arrays.fill(anterior, -1);
        dist[origen] = 0;

        //Ahora usaremos un PriorityQueue parar ordenar por distancia acumulada
        //Es decir cada elemento: int[] {distancia, nodo}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, origen});

        while(!pq.isEmpty()){
            int[] actual = pq.poll();
            int nodoActual = actual[1];
            if(visitado[nodoActual]) continue;
            visitado[nodoActual] = true;

            for(int vecino = 0; vecino < n; vecino++){
                if(distancia[nodoActual][vecino] > 0 && !visitado[vecino]){
                    int nuevaDist = dist[nodoActual] + distancia[nodoActual][vecino];

                    if(nuevaDist < dist[vecino]){
                        dist[vecino] = nuevaDist;
                        anterior[vecino] = nodoActual;
                        pq.add(new int[]{nuevaDist, vecino});
                    }
                }
            }
        }

        //Mostramos el resultado
        System.out.println("--- RESULTADO ---");
        if(dist[destino] == INF){
            System.out.println("No existe ruta entre " + nombreEdificios[origen] + " y " + nombreEdificios[destino]);
            return;
        }

        //Recosntruimos el camino
        LinkedList<Integer> camino = new LinkedList<>();
        int nodo = destino;
        while(nodo != -1){
            camino.addFirst(nodo);
            nodo = anterior[nodo];
        }

        System.out.println("Ruta mas corta:\n ");
        for(int i = 0; i < camino.size(); i++){
            int actual2 = camino.get(i);
            System.out.print(nombreEdificios[actual2]);
            if(i < camino.size() - 1){
                int sig = camino.get(i + 1);
                System.out.print(" -> " + nombreEdificios[sig] + " (" + distancia[actual2][sig] + "m)");
                if(i + 1 < camino.size() - 1) System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println(" Distancia TOTAL: " + dist[destino] + " metros" );
    }

    public void mostrarEdificios(){
        if(totalEdificios == 0){
            System.out.println("No hay edificios registrados");
            return;
        }
        System.out.println("Edificios regisrados:");
        for(int i = 0; i < totalEdificios; i++){
            System.out.println(" " + i + ": " + nombreEdificios[i]);
        }
    }

    public String getNombreEdificios(int idx) {
        return nombreEdificios[idx];
    }

    public int getTotalEdificios() {
        return totalEdificios;
    }

    
}

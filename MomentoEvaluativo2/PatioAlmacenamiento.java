public class PatioAlmacenamiento {
    private Contenedor[][] patio;
    private int filas;
    private int columnas;

    public PatioAlmacenamiento(int R, int K) {
        this.filas = R;
        this.columnas = K;
        this.patio = new Contenedor[R][K];
    }

    public int[] ubicar(Contenedor c){
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                if(patio[i][j] == null){
                    patio[i][j] = c;
                    System.out.printf(" %s → celda (%d,%d)%n", c.id, i, j);
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalStateException("ALERTA: Puerto saturado - no hay espacio en el patio.");
    }

    public void mostarPatio(){
        System.out.println("\n------- Patio De Almacenamiento -------");
        for(int i = 0; i < filas; i++){
            System.out.print(" | ");
            for(int j = 0; j < columnas; j++){
                if(patio[i][j] == null){
                    System.out.printf("%-12s", "[ LIBRE ]");
                } else{
                    System.out.printf("%-12s", "[" + patio[i][j].id + "]");
                }
            }
            System.out.println("|");
        }
        System.out.println("--------------------------------------\n");
    }
}

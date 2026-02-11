public class Ejercicio4 {

    public static void main(String[] args) {

        int[] grupo1 = { 34, 23, 12, 45 };
        int[] grupo2 = { 12, 9, 17, 89 };
        int mayorGrupo1 = grupo1[0];
        int mayorGrupo2 = grupo2[0];
        for (int i = 1; i < grupo1.length; i++) {
            if (grupo1[i] > mayorGrupo1) {
                mayorGrupo1 = grupo1[i];
            }
            if (grupo2[i] > mayorGrupo2) {
                mayorGrupo2 = grupo2[i];
            }
        }
        
        int mayorEnGeneral = 0;

        if (mayorGrupo1 > mayorGrupo2) {
            mayorEnGeneral = mayorGrupo1;
        } else {
            mayorEnGeneral = mayorGrupo2;
        }

        System.out.println("La edad mayor de los dos grupos es: " + mayorEnGeneral);
    }
}
public class Ejercicio8 {
    public static void main(String[] args) {
        int[] numeros = {15, 8, 23, 8, 45, 12, 45, 7, 19, 23, 45, 8, 34, 7, 29, 15, 45, 8, 12, 7, 23, 45, 8, 19, 7, 34, 45, 15, 8, 7};

        int mayor = numeros[0];
        int menor = numeros[0];

        for (int i = 1 ; i < numeros.length ; i++ ){
            if (numeros[i] > mayor){
                mayor = numeros[i];
            }

            if (numeros[i] < menor){
                menor = numeros[i];
            }
        }

        int conteoMayor = 0;
        int conteoMenor = 0;

        for (int i = 0 ; i < numeros.length ; i++){
            if (numeros[i] == mayor) conteoMayor++;
            if (numeros[i] == menor) conteoMenor++;
        }

        System.out.println("Numero mayor: " + mayor + " (Se repite " + conteoMayor + " veces)");
        System.out.println("Numero menor: " + menor + " (Se repite " + conteoMenor + " veces)");
    }
}

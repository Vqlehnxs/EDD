public class Ejercicio9 {
    public static void main(String[] args) {
        
        int[] numeros = { 5, 12, 8, 5, 23, 5, 15, 8, 19, 5};
        int numeroBuscado = 5;
        int contador = 0;
        for (int i = 0 ; i < numeros.length ; i ++){
            if (numeros[i] == numeroBuscado){
                contador++;
            }
        }

        System.out.println("Numero buscado: " + numeroBuscado);
        System.out.println("Veces que se repite el numero: " + contador);
    }
}

public class Ejercicio5 {
    public static void main(String[] args) {
        double[] preciosUnitario = {853.0, 25.2, 45, 324};
        int[] cantidadesCompradas = {3, 10, 6, 2};
        String[] descripciones = {"Lapto", "Mouse", "Teclado", "Monitor"};
        double[] totalGastos = new double[descripciones.length];
        double totalGeneral = 0;
        int indiceMayor = 0;
        double mayorGasto = totalGastos[0];

        for(int i = 0 ; i < descripciones.length; i++){
            totalGastos[i] = preciosUnitario[i] * cantidadesCompradas[i];
            totalGeneral += totalGastos[i];
            if (totalGastos[i] > mayorGasto){
                mayorGasto = totalGastos[i];
                indiceMayor = i;
            }
            System.out.println("Producto: " + descripciones[i] + " Precio unitario: " + preciosUnitario[i] + " Cantidad comprada: " + cantidadesCompradas[i] + " total gastado: " + totalGastos[i]);

        }

        System.out.println("Total general de la compra: " + totalGeneral);
        System.out.println("Descripcion: " + descripciones[indiceMayor]);
        System.out.println("Mayor gasto: " + mayorGasto);
        
    }
}

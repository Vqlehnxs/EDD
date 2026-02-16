public class Ejercicio6 {
    public static void main(String[] args) {
        double[] alquileres = {12000, 450, 800, 950};
        double[] porcentaje = {15, 10, 6, 5.9};
        double[] ganancias = new double[alquileres.length];
        double gananciasTotal = 0;
        for(int i = 0; i < alquileres.length ; i++){
            ganancias[i] = (alquileres[i] * porcentaje[i])/100;
            gananciasTotal += ganancias[i];
            System.out.println("Vivienda " + (i+1) + " Alquiler: " + alquileres[i] + " Porcentaje: " + porcentaje[i] + " Ganacia: " + ganancias[i]);
        }

        System.out.println("Ganancias totales: " + gananciasTotal);
    }
}

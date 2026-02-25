public class EjecutarMoto {
    public static void main(String[] args) {
        
        moto[] m = new moto[8];
        m[0] = new moto(2026, "AKT", "Negro", 125.0, 1250.0);
        m[1] = new moto(2025, "Kawasaki ninja", "Verde", 400.0, 25000.0);
        m[2] = new moto(2026, "Honda", "Rojo", 350.0, 40000.0);
        m[3] = new moto(2027, "Honda c90", "DoradoNegro", 90.0, 10000.0);
        m[4] = new moto(2015, "Sym Automatica", "Blanco", 150.0, 4500.0);
        m[5] = new moto(2020, "Suzuki", "Azul", 150.0, 2350.0);
        m[6] = new moto(2016, "BMW", "Gris", 1200.0, 40000.0);
        m[7] = new moto(2018, "Harley Davidson", "Negro", 1800.0, 35000.0);

        int suma = 0; 
        for (int i = 0; i < m.length; i++) {
            suma += m[i].getModelo();
        }

        System.out.println("El promedio de modelo de las motos del arreglo es: " + (suma / m.length));

        String cad = " \n";
        for (int i = 0; i < m.length; i++) {
            if (m[i].getPrecio() <= 20000.0){
                cad += m[i].getMarca() + " " + m[i].getPrecio() + " \n";
            }
        }

        System.out.println("Las motos que puedo comprar con 20000 US son: " + cad);
    }
}

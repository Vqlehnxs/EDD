/*Un Map asocia una llave única a un valor. Utiliza HashMap<Integer, String>
para gestionar un almacén:
Registra 3 productos: (101, "Laptop"), (102, "Mouse"), (103, "Teclado").
Verifica si existe la llave 102 usando containsKey() .
Intenta insertar un nuevo producto con la llave 101. ¿Qué sucede con el
valor original?
Recorre el mapa imprimiendo: "Código: [Llave] -> Producto: [Valor]" */

import java.util.HashMap;

public class Ejercicio22 {
    public static void main(String[] args) {
        HashMap<Integer, String> almacen = new HashMap<>();

        almacen.put(101, "Laptop");
        almacen.put(102, "Mouse");
        almacen.put(103, "Teclado");

        System.out.println("Existe la llave 102? " + almacen.containsKey(102));

        almacen.put(101, "Monitor");

        System.out.println("Llave 101 sobreescrita con " + almacen.get(101));

        System.out.println("\nInventario:");
        for(HashMap.Entry<Integer, String> entry : almacen.entrySet()){
            System.out.println("Codigo: " + entry.getKey() + " -> Producto: " + entry.getValue());
        }
    }
}

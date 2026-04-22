import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio33 {
    
    public static void main(String[] args) {
        
        Map<String, List<String>> pedidos = new HashMap<>();

        List<String> productosAna = new ArrayList<>();
        productosAna.add("Camisa");
        productosAna.add("Pantalo");
        pedidos.put("Ana", productosAna);

        List<String> productosLuis = new ArrayList<>();
        productosLuis.add("Zapatos");
        pedidos.put("Luis", productosLuis);

        System.out.println("Ana tiene: " + pedidos.get("Ana").size() + " productos");
        pedidos.get("Luis").add("Medias");

        for(Map.Entry<String, List<String>> entry : pedidos.entrySet()){
            System.out.println("Cliente: " + entry.getKey() + " -> Productos: " + entry.getValue());
        }
    }
}

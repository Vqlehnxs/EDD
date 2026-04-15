public class MotorPortuario {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     MOTOR LOGICO DE CONTROL PORTUARIO    ║");
        System.out.println("║           Puerto de Data-Bay             ║");
        System.out.println("╚══════════════════════════════════════════╝");

        System.out.println("\n Registro de Manifiesto"); // Este es el Modulo 1
        Manifiesto manifiesto = new Manifiesto(6);
        manifiesto.registrar(new Contenedor("C001", 1200.0, 1));
        manifiesto.registrar(new Contenedor("C002", 850.5, 3)); // Prioridad Peligroso
        manifiesto.registrar(new Contenedor("C003", 2300.0, 2)); 
        manifiesto.registrar(new Contenedor("C004", 500.0, 4)); // Prioridad Alta
        manifiesto.registrar(new Contenedor("C005", 1800.0, 1));
        manifiesto.registrar(new Contenedor("C006", 750.0, 3)); // Prioridad Peligroso
        manifiesto.resumen();

        System.out.println("Patio de Almacenamiento (3x3)"); // Este es el Modulo 2
        PatioAlmacenamiento patio = new PatioAlmacenamiento(3, 3);
        try{
            for(Contenedor c: manifiesto.getContenedores()){
                patio.ubicar(c);
            }
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
        patio.mostarPatio();

        System.out.println("Bahia de Inspeccion"); // Este es el Modulo 3
        BahiaInspeccion inspeccion = new BahiaInspeccion();
        for(Contenedor c : manifiesto.getContenedores()){
            inspeccion.encolar(c);
        }
        inspeccion.mostrarCola();
        System.out.println(" Procesando cola de inspeccion:");
        while(!inspeccion.isEmpty()){
            inspeccion.inspeccionar();
        }

        System.out.println("Ubicacion en el Buque"); // Este es el Modulo 4
        Buque buque = new Buque(true); // El modo de estabilidad estara en true

        Contenedor[] carga = {
            new Contenedor("C003", 2300.0, 2),
            new Contenedor("C001", 1200.0, 1),
            new Contenedor("C005", 1800.0, 1), // Sera rechazado al ser mayor que 1200
            new Contenedor("C006", 750.0, 3),
            new Contenedor("C002", 850.0, 3), //Sera rechazado al ser mayor que 750
            new Contenedor("C004", 500.0, 4),
        };

        for(Contenedor c : carga){
            buque.apilar(c);
        }
        buque.mostrarBuque();

        //Aqui se retira los contenedores afectados del fondo
        System.out.println("  OPERACIÓN CRITICA: Contenedor del fondo presenta falla..."); 
        buque.retirarFondo(); 
        buque.mostrarBuque();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║          Operaciones completadas         ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}

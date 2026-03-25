public class Estadisticas {
    private int clientesAtendidos;
    private double tiempoMaxEspera;
    private double sumaEsperas;

    public Estadisticas() {
        this.clientesAtendidos = 0;
        this.tiempoMaxEspera = 0;
        this.sumaEsperas = 0;
    }

    public void registrarCliente(Cliente1 cliente) {
        clientesAtendidos++;
        double espera = cliente.getTiempoEspera();
        sumaEsperas += espera;
        if (espera > tiempoMaxEspera)
            tiempoMaxEspera = espera;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public double getTiempoMaxEspera() {
        return tiempoMaxEspera;
    }

    public double getTiempoMedioEspera() {
        if (clientesAtendidos == 0)
            return 0;
        return sumaEsperas / clientesAtendidos;
    }

    public void imprimir(FilaUnica fila, double tiempoCaja4Abierta) {
        System.out.println("\n--------- ESTADÍSTICAS ---------");
        System.out.println("Clientes atendidos:         " + clientesAtendidos);
        System.out.printf("Tamaño medio de la fila:    %.2f clientes%n", fila.getTamañoMedio());
        System.out.println("Tamaño máximo de la fila:   " + fila.getTamañoMaximo() + " clientes");
        System.out.printf("Tiempo máximo de espera:    %.2f min%n", tiempoMaxEspera);
        System.out.printf("Tiempo medio de espera:     %.2f min%n", getTiempoMedioEspera());
        System.out.printf("Tiempo abierta Caja 4:      %.2f min%n", tiempoCaja4Abierta);
        System.out.println("----------------------------------");
    }
}

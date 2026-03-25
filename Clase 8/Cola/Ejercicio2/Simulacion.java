import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacion {
    private static final double[][] TIEMPOS_ATENCION = {
            { 1.5, 2.5 }, { 2.0, 5.0 }, { 2.0, 4.0 }, { 2.0, 4.5 }
    };

    private static final int UMBRAL_CAJA4 = 20;

    private Reloj reloj;
    private FilaUnica fila;
    private List<CajaPago1> cajas;
    private CajaPago1 caja4;
    private Estadisticas estadisticas;
    private Random random;
    private int contadorClientes;
    private double proximaLlegada;

    public Simulacion() {
        this.reloj = new Reloj();
        this.fila = new FilaUnica();
        this.cajas = new ArrayList<>();
        this.estadisticas = new Estadisticas();
        this.random = new Random();
        this.contadorClientes = 0;

        for (int i = 1; i <= 3; i++) {
            cajas.add(new CajaPago1(i, TIEMPOS_ATENCION[i - 1][0], TIEMPOS_ATENCION[i - 1][1], 0.0));
        }

        caja4 = null;

        proximaLlegada = siguienteIntervaloLlegada();
    }

    private double siguienteIntervaloLlegada() {
        return random.nextDouble() * 2.0;
    }

    public void ejecutar() {
        System.out.println("Iniciando simulación (jornada: 420 min)...\n");

        while (!reloj.jornadaTerminada()) {
            double t = reloj.getTiempo();

            asignarClientesACajasLibres(t);

            gestionarCaja4(t);

            // Calcular próximo evento
            double proximoEvento = calcularProximoEvento();

            if (proximoEvento <= t) {
                proximoEvento = t + 0.001;
            }

            if (proximoEvento > Reloj.FIN_JORNADA) {
                reloj.avanzar(Reloj.FIN_JORNADA - t);
                break;
            }

            reloj.avanzar(proximoEvento - t);
            t = reloj.getTiempo();

            if (t >= proximaLlegada) {
                procesarLlegada(t);
                proximaLlegada = t + siguienteIntervaloLlegada();
            }
        }

        double tFinal = reloj.getTiempo();
        if (caja4 != null && caja4.isAbierta()) {
            caja4.cerrar(tFinal);
        }

        double tiempoCaja4 = (caja4 != null) ? caja4.getTiempoAbiertoTotal() : 0.0;
        estadisticas.imprimir(fila, tiempoCaja4);
    }

    private void asignarClientesACajasLibres(double t) {
        List<CajaPago1> todasCajas = todasLasCajas();

        boolean cambio = true;
        while (cambio && !fila.isEmpty()) {
            cambio = false;
            List<CajaPago1> libres = new ArrayList<>();

            for (CajaPago1 c : todasCajas) {
                if (c.isLibre(t))
                    libres.add(c);
            }
            if (!libres.isEmpty() && !fila.isEmpty()) {
                CajaPago1 elegida = libres.get(random.nextInt(libres.size()));
                Cliente1 cliente = fila.desencolar();

                if (cliente != null) {
                    elegida.atender(cliente, t);
                    estadisticas.registrarCliente(cliente);
                    cambio = true;
                }
            }
        }
    }

    private void gestionarCaja4(double t) {
        if (caja4 == null || !caja4.isAbierta()) {
            if (fila.getTamaño() > UMBRAL_CAJA4) {
                caja4 = new CajaPago1(4,
                        TIEMPOS_ATENCION[3][0],
                        TIEMPOS_ATENCION[3][1],
                        t);
                System.out.printf("[t=%.1f] Caja 4 ABIERTA (fila=%d)%n", t, fila.getTamaño());
            }
        } else { // solo llega aquí si caja4 != null && caja4.isAbierta()
            if (fila.isEmpty()) {
                caja4.cerrar(t);
            }
        }
    }

    private double calcularProximoEvento() {
        double minimo = proximaLlegada;
        for (CajaPago1 c : todasLasCajas()) {
            double libre = c.getTiempoLibreDesde();
            if (libre < minimo)
                minimo = libre;
        }
        return minimo;
    }

    private void procesarLlegada(double t) {
        contadorClientes++;
        Cliente1 cliente = new Cliente1(contadorClientes, t);
        fila.encolar(cliente);
        System.out.printf("[t=%.1f] Llega %s (fila=%d)%n", t, cliente, fila.getTamaño());
    }

    private List<CajaPago1> todasLasCajas() {
        List<CajaPago1> todas = new ArrayList<>(cajas);
        if (caja4 != null && caja4.isAbierta())
            todas.add(caja4);
        return todas;
    }
}

public class Aula {
    private String nombre;
    private int capacidad;
    /*Matriz de disponibilidad, 7 dias y 24 horas
    true si esta ocupado, false si esta libre*/
    private boolean[][] horario;

    public Aula(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.horario = new boolean[7][24];
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean[][] getHorario() {
        return horario;
    }

    private String nombreDia(int dia){
        String[] dias = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        return dias[dia];
    }

    /*Verifica si un bloque horario esta disponible*/
    public boolean consultarDisponibilidad(int dia, int hora){
        if(dia < 0 || dia > 6 || hora < 0 || hora > 23) return false;
        return !horario[dia][hora];
    }

    /*Reserva un bloque de horas, y lanza la excepcion si hay un conflicto*/
    public void reservar(int dia, int hora, int duracion) throws HorarioConflictivoException{
        /*Primero verifica que todo el bloque este libre*/
        for(int h = hora; h < hora + duracion && h <24; h++){
            if(horario[dia][h]){
                throw new HorarioConflictivoException("Horario conflictivo - " + nombreDia(dia) + " " + h + ":00 ya esta reservado");
            }
        }

        //Reservar
        for(int h = hora; h < hora + duracion && h <24; h++){
            horario[dia][h] = true;
        }
        System.out.println("Reserva exitosa");
    }

    /*Libera un bloque de horas*/
    public void liberar(int dia, int hora, int duracion){
        for(int h = hora; h < hora + duracion && h < 24; h++){
            horario[dia][h] = false;
        }
        System.out.println("Horario liberado");
    }

    @Override
    public String toString() {
        return nombre + " (Capacidad: " + capacidad + ")";
    }

    
}

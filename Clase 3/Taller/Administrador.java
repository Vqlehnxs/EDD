public class Administrador {

    public static void main(String[] args) {
        
        Clase[] c = new Clase[5];

        c[0] = new Clase(1194, "Estructura de datos", "Jhon Cano", 31);
        c[1] = new Clase(1065, "Probabilidad y Estadistica", "Henry Pulgarin", 24);
        c[2] = new Clase(3085, "Automatas y lenguaje", "Andres Felipe", 30);
        c[3] = new Clase(2031, "Calculo integral", "Segundo Alberto", 28);
        c[4] = new Clase(2914, "Fisica y magnetismo", "Andres Felipe", 25);

        int totalEstudiantes = 0;

        for (int i = 0; i < c.length; i++) {
            totalEstudiantes += c[i].getEstudiantes();
        }

        System.out.println("El total de estudiantes que hay dentro de todos los cursos es de " + totalEstudiantes + " estudiantes");

        String cursoDeEstructura = "";

        for (int i = 0; i < c.length; i++) {
            if(c[i].getCurso() == "Estructura de datos"){
                cursoDeEstructura = c[i].getCurso();
                totalEstudiantes = c[i].getEstudiantes();
            }
        }

        System.out.println("En el curso de " + cursoDeEstructura + " hay un total de " + totalEstudiantes + " estudiantes");

    }
    
}

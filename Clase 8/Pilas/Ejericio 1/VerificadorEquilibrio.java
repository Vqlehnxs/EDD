public class VerificadorEquilibrio {

    private static char aperturaEsperada(char cierre) {
        switch (cierre) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return 0;
        }
    }

    private static boolean esApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean esCierre(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static void verificar(String expresion) {
        Pila pila = new Pila();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (esApertura(c)) {
                pila.apilar(c, i);

            } else if (esCierre(c)) {
                char esperado = aperturaEsperada(c);

                if (pila.estaVacia()) {
                    System.out.println("  Estado  : No equilibrado");
                    System.out.println("  Detalle : Error en posicion " + i + ": '" + c + "' no tiene apertura correspondiente.");
                    return;
                }

                Nodo tope = pila.desapilar();

                if (tope.simbolo != esperado) {
                    System.out.println("  Estado  : X  NO EQUILIBRADA");
                    System.out.println("  Detalle : Error en posicion " + i + ": se esperaba el cierre de '" + tope.simbolo + "' (abierto en posicion " + tope.posicion + "), pero se encontro '" + c + "'.");
                    return;
                }
            }
        }

        if (!pila.estaVacia()) {
            StringBuilder sb = new StringBuilder();
            Nodo actual = pila.tope();
            while (actual != null) {
                sb.append("'").append(actual.simbolo)
                        .append("' (pos ").append(actual.posicion).append(") ");
                actual = actual.siguiente;
            }
            System.out.println("  Estado  : No equilibrado");
            System.out.println("  Detalle : Faltan cierres para: " + sb.toString().trim());
            return;
        }

        System.out.println("  Estado  : Equilibrada");
        System.out.println("  Detalle : La expresion tiene parentesis equilibrados.");
    }
}

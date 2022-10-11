public class Main {
    public static void main(String[] args) {
        System.out.println(obtenerNotacionNPI("(3*4)+(5*7)"));


    }

    private static String obtenerNotacionNPI(String operacion) {
        String notacionNPI = "";
        String auxiliar = "";

        for (int i = 0; i < operacion.length(); i++) {
            switch (operacion.charAt(i)) {
                case '+', '-', '*', '/':
                    auxiliar += operacion.charAt(i);
                    break;
                case '(', '{', '[':
                    auxiliar += operacion.charAt(i);
                    break;
                case ')':
                    notacionNPI += auxiliar.substring(auxiliar.lastIndexOf('(') + 1);
                    auxiliar = auxiliar.substring(0, auxiliar.lastIndexOf('('));
                    break;
                case '}':
                    notacionNPI += auxiliar.substring(auxiliar.lastIndexOf('{') + 1);
                    auxiliar = auxiliar.substring(0, auxiliar.lastIndexOf('{'));
                    break;
                case ']':
                    notacionNPI += auxiliar.substring(auxiliar.lastIndexOf('[') + 1);
                    auxiliar = auxiliar.substring(0, auxiliar.lastIndexOf('['));
                    break;
                case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0':
                    notacionNPI += operacion.charAt(i);
                    break;
                default:
                    System.out.println("Que carajos ingresaste, no es ni un numero o un signo de agrupacion");
                    break;
            }
        }
        notacionNPI += auxiliar;
        return notacionNPI;
    }
}
package metodos;

/**
 *
 * @author a18danielmr
 */
public class Validaciones {

    public static boolean cif(String cif) {
        boolean a = true;
        try {
            if (cif.length() != 9) {
                a = false;
                throw new Excepciones("Longitud erronea (debe ser 9)");
            }
            if (!cif.substring(0, 1).matches("[A-Za-z]")) {
                a = false;
                throw new Excepciones("El primer carácter debe ser una letra");
            }
            if (!cif.substring(1, 8).matches("[0-9]*")) {
                a = false;
                throw new Excepciones("El cif debe contener 7 números entre ambas letras");
            }
            if (!cif.substring(8).matches("[A-Za-z]")) {
                a = false;
                throw new Excepciones("El último carácter debe ser una letra");
            }
        } catch (Excepciones e) {
            System.out.println(e.getError());
        }
        return a;
    }

    public static boolean coche(String cod) {
        boolean a = true;
        try {
            if (cod.charAt(0) != 'V' && cod.charAt(0) != 'A') {
                a = false;
                throw new Excepciones("El codigo debe empezar por A o V en función de su finalidad");
            }
            if (!cod.substring(1).matches("[0-9]*")) {
                a = false;
                throw new Excepciones("El código debe contener una letra seguida de 3 digitos");
            }
        } catch (Excepciones e) {
            System.out.println(e.getError());
        }
        return a;
    }

    public static boolean estado(char estado) {
        boolean a = true;
        try {
            if (estado != 'L' || estado != 'R') {
                a = false;
                throw new Excepciones("El estado solo puede ser L o R");
            }
        } catch (Excepciones e) {
            System.out.println(e.getError());
        }
        return a;
    }
}

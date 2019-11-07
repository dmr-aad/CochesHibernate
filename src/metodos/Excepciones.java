package metodos;

/**
 *
 * @author a18danielmr
 */
public class Excepciones extends Exception {

    private String error;

    public Excepciones(String message) {
        super(message);
        this.error = message;
    }

    public String getError() {
        return error;
    }

    public Excepciones() {
    }

}

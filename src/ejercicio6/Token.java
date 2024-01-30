package ejercicio6;

public class Token {
    private String comparador;
    private boolean isDoble;
    private String descripcionError;

    public Token(String comparador, boolean isDoble, String descripcionError) {
        this.comparador = comparador;
        this.isDoble = isDoble;
        this.descripcionError = descripcionError;
    }

    public String getComparador() {
        return comparador;
    }

    public boolean isDoble() {
        return isDoble;
    }

    public String getDescripcionError() {
        return descripcionError;
    }
}

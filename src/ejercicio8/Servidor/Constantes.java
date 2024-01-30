package ejercicio8.Servidor;

public class Constantes {
    public static final String ERROR_CREAR_DATAGRAM="Nose se ha podido crear el Datagram";
    public static final int NUM_SALIR = 1;
    public static final String TEXT_SALIR = "Salir del programa";
    public static final int NUM_SUMAR = 2;
    public static final String TEXT_SUMAR = "Sumar";
    public static final int NUM_MULTIPLICAR = 3;
    public static final String TEXT_MULTIPLICAR = "Multiplicar";
    public static final int NUM_DIVIDIR = 4;
    public static final String TEXT_DIVIDIR = "Dividir";
    public static final int NUM_RESTO = 5;
    public static final String TEXT_RESTO = "Resto";
    public static final int NUM_RESTA = 6;
    public static final String TEXT_RESTA = "Resta";
    public static final String PALABRA_SALIDA = "EXIT";
    public static final int[] tiposOperacion = {NUM_SUMAR,NUM_MULTIPLICAR,NUM_DIVIDIR,NUM_RESTO,NUM_RESTA};

    public static final String TEXT_MENU = String.format("----MENU----\n%d-> %s\n%d-> %s\n%d-> %s\n%d-> %s\n%d-> %s\n%d-> %s", NUM_SALIR, TEXT_SALIR, NUM_SUMAR, TEXT_SUMAR, NUM_MULTIPLICAR, TEXT_MULTIPLICAR, NUM_DIVIDIR, TEXT_DIVIDIR, NUM_RESTO, TEXT_RESTO, NUM_RESTA, TEXT_RESTA);

}

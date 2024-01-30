package ejercicio5;

public class Constantes {
    public static final String HOST = "localhost";
    public static final int PUERTO = 5000;
    public static final String ERROR_SER_ARRANQUE = "Fallo en la unión del servidor";
    public static final String ERROR_SER_ESPERA = "Fallo en la espera";
    public static final String ERROR_CLI_CONECTAR = "Error al conectar con servidor";
    public static final String ERROR_CLI_CERRAR = "Error al cerrar el servidor";
    public static final int TIME_TEMPORIZADOR = 200000;
    public static final String PALABRA_SALIDA = "EXIT";
    public static final int NUM_SALIR = 1;
    private static final String TEXT_SALIR = "Salir del programa";
    public static final int NUM_SUMAR = 2;
    private static final String TEXT_SUMAR = "Sumar";
    public static final int NUM_MULTIPLICAR = 3;
    private static final String TEXT_MULTIPLICAR = "Multiplicar";
    public static final int NUM_DIVIDIR = 4;
    private static final String TEXT_DIVIDIR = "Dividir";
    public static final int NUM_RESTO = 5;
    private static final String TEXT_RESTO = "Resto";
    public static final int NUM_RESTA = 6;
    private static final String TEXT_RESTA = "Resta";
    public static final String TEXT_MENU =String.format("----MENU----\n%d-> %s\n%d-> %s\n%d-> %s\n%d-> %s\n%d-> %s\n%d-> %s",NUM_SALIR,TEXT_SALIR,NUM_SUMAR,TEXT_SUMAR,NUM_MULTIPLICAR,TEXT_MULTIPLICAR,NUM_DIVIDIR,TEXT_DIVIDIR,NUM_RESTO,TEXT_RESTO,NUM_RESTA,TEXT_RESTA);
}

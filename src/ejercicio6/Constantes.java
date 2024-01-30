package ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Constantes {
    public static final String HOST = "localhost";
    public static final int PUERTO = 54321;
    public static final String ERROR_SER_ARRANQUE = "Fallo en la creación del servidor";
    public static final String ERROR_SER_CLOSE_CLIENTE = "(Servidor) -> Error al cerrar la conexión del cliente";
    public static final String ERROR_SER_ESPERA = "Fallo en la conexión del cliente";
    public static final String ERROR_CLI_CONECTAR = "Error al conectar con servidor";
    public static final String ERROR_CLI_CERRAR = "Error al cerrar el servidor";
    private static final String COMANDO_DIR = "dir";
    private static final String TEXT_FORMAT_COMANDO_DIR = "Mostraremos los archivos y sus sistemas del directorio -> %s";
    private static final String COMANDO_CD = "cd";
    private static final String TEXT_FORMAT_COMANDO_CD = "Nos movemos al directorio -> %s";
    private static final String COMANDO_CP = "cp";
    private static final String TEXT_FORMAT_COMANDO_CP = "Movemos los archivos del directorio -> %s, al directorio -> %s";
    private static final String COMANDO_MV = "mv";
    private static final String TEXT_FORMAT_COMANDO_MV = "Copiando los archivos del directorio -> %s, al directorio -> %s";
    public static final String COMANDO_CLEAR = "clear";
    public static final String TEXT_PEDIR_COMANDO = "Introduce un comando (cd,dir,mv,clear,cp)";
    public static final int MAX_ESPACIOS_DOBLE = 1;
    public static final int MAX_ESPACIOS = 0;
    public static final String SEPARADOR_ESPACIO = " ";
    public static final int TAMAÑO_ARRAY_COMPUESTO = 2;
    public static final List<Token> LIST_TOKEN = new ArrayList<>();

    static{
        LIST_TOKEN.add(new Token(COMANDO_CD, false, TEXT_FORMAT_COMANDO_CD));
        LIST_TOKEN.add(new Token(COMANDO_CP, true, TEXT_FORMAT_COMANDO_CP));
        LIST_TOKEN.add(new Token(COMANDO_MV, true, TEXT_FORMAT_COMANDO_MV));
        LIST_TOKEN.add(new Token(COMANDO_DIR,false,TEXT_FORMAT_COMANDO_DIR));
    }
}

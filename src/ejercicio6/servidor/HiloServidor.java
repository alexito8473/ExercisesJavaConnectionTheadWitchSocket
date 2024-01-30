package ejercicio6.servidor;

import ejercicio6.ConsoleInput;
import ejercicio6.Constantes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;

public class HiloServidor extends Thread {
    private DataOutputStream salida ;
    private DataInputStream entrada ;
    private Socket socket;

    public HiloServidor( Socket socket ) throws IOException {
        this.socket = socket;
        entrada = new DataInputStream(socket.getInputStream());
        salida = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                enviarString(Constantes.TEXT_PEDIR_COMANDO);
                enviarString(comprobarComando(recogerDatoString().trim()));
            }
        } catch (Exception e) {
        }
        try {
            socket.close();
        } catch (IOException ex) {
            System.err.println(Constantes.ERROR_SER_CLOSE_CLIENTE);
        }
    }

    private String recogerDatoString() throws IOException {
        String result = "";
        result = entrada.readUTF();
        return result;
    }

    private String comprobarComando( String frase ) {
        Optional<String> directorio;
        String[] compuesto;
        boolean salida = false;
        int cantidad = 0;
        String resultado = "Has introducido incorrectamente el comando";
        if ( frase.equals(Constantes.COMANDO_CLEAR) ) {
            resultado = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nVamos a limpiar la pantalla ahora mismo";
        } else {
            do {
                if ( !( directorio = comprobarRuta(frase, Constantes.LIST_TOKEN.get(cantidad).getComparador(), Constantes.LIST_TOKEN.get(cantidad).isDoble()) ).isEmpty() ) {
                    if ( Constantes.LIST_TOKEN.get(cantidad).isDoble() ) {
                        compuesto = sacarDosNombresConUnVacio(directorio.get());
                        resultado = String.format(Constantes.LIST_TOKEN.get(cantidad).getDescripcionError(), compuesto[0], compuesto[1]);
                    } else {
                        resultado = String.format(Constantes.LIST_TOKEN.get(cantidad).getDescripcionError(), directorio.get());
                    }
                    salida = true;
                }
                cantidad++;
                if ( cantidad == Constantes.LIST_TOKEN.size() ) {
                    salida = true;
                }
            } while (!salida);
        }
        return resultado;
    }

    private Optional<String> comprobarRuta( String frase, String comparador, boolean isDoble ) {
        String salida;
        int maximoEspacio = isDoble ? Constantes.MAX_ESPACIOS_DOBLE : Constantes.MAX_ESPACIOS;
        if ( frase.length() > comparador.length() ) {
            if ( frase.substring(0, comparador.length() + 1).equals(comparador + " ") ) {
                if ( !( salida = frase.substring(comparador.length()) ).isBlank() ) {
                    if ( cuantoContiene(salida.trim(), Constantes.SEPARADOR_ESPACIO) == maximoEspacio ) {
                        return Optional.of(salida.trim());
                    }
                }
            }
        }
        return Optional.empty();
    }

    private String[] sacarDosNombresConUnVacio( String frase ) {
        String[] salida = new String[Constantes.TAMAÑO_ARRAY_COMPUESTO];
        int posicion_Vacia = 0;
        while (!String.valueOf(frase.charAt(posicion_Vacia)).equals(" ")) {
            posicion_Vacia++;
        }
        salida[0] = frase.substring(0, posicion_Vacia);
        salida[1] = frase.substring(posicion_Vacia, frase.length());
        return salida;
    }

    private int cuantoContiene( String frase, String comprador ) {
        int contador = 0;
        for ( int i = 0; i < frase.length(); i++ ) {
            if ( String.valueOf(frase.charAt(i)).equals(comprador) ) {
                contador++;
            }
        }
        return contador;
    }

    private void enviarString( String frase ) throws IOException {
        salida.writeUTF(frase);
    }
}

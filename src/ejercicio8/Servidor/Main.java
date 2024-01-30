package ejercicio8.Servidor;

import java.util.Arrays;

public class Main {

    public void ejercicio7() {
        Servidor servidor;
        double numero1, numero2;
        int tipo;
        boolean salida = false;
        try {
            servidor = new Servidor();
            servidor.recibirDatos();
            do {
                servidor.enviarDatosString(Constantes.TEXT_MENU);
                tipo = Integer.valueOf(servidor.recibirDatos());
                System.out.println(tipo);
                if ( tipo == Constantes.NUM_SALIR ) {
                    salida = false;
                    servidor.enviarDatosString(Constantes.PALABRA_SALIDA);
                } else {
                    int finalTipo = tipo;
                    if ( Arrays.stream(Constantes.tiposOperacion).anyMatch(t -> t == finalTipo) ) {
                        servidor.enviarDatosBoolean(true);
                        numero1 = Double.parseDouble(servidor.recibirDatos());
                        numero2 = Double.parseDouble(servidor.recibirDatos());
                        servidor.enviarDatosDouble(servidor.realizarOperacion(tipo, numero1, numero2));
                    } else {
                        servidor.enviarDatosBoolean(false);
                    }
                }
            } while (!salida);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main( String[] args ) {
        new Main().ejercicio7();
    }
}

package ejercicio7NoTerminado.Servidor;

import java.util.Arrays;

public class Main {

    public void ejercicio7() {
        Servidor servidor;
        double numero1, numero2;
        int tipo;
        boolean salida = false;
        try {
            servidor = new Servidor();
            System.out.println("Server iniciado");
            do {
                tipo = Integer.valueOf(servidor.recibirDatos());
                if ( tipo == Constantes.NUM_SALIR ) {
                    salida = false;
                } else {
                    numero1 = Double.parseDouble(servidor.recibirDatos());
                    numero2 = Double.parseDouble(servidor.recibirDatos());
                    servidor.enviarDatosDouble(servidor.realizarOperacion(tipo, numero1, numero2));
                }
            } while (!salida);
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Termino el sistema");
    }

    public static void main( String[] args ) {
        new Main().ejercicio7();
    }
}

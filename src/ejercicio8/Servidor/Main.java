package ejercicio8.Servidor;

import java.util.Arrays;

public class Main {

    public void ejercicio8() {
        Servidor servidor;
        double numero1, numero2;
        int tipo;
        boolean salida = false;
        try {
            servidor = new Servidor();
            System.out.println("Server iniciado");
            servidor.recibirDatos();
            do {
                servidor.enviarDatosString(Constantes.TEXT_MENU);
                try {
                    tipo = Integer.valueOf(servidor.recibirDatos());
                    int finalTipo = tipo;
                    if( Arrays.stream(Constantes.tiposOperacion).anyMatch(t -> t== finalTipo)){
                        servidor.enviarDatosBoolean(true);
                        if ( tipo == Constantes.NUM_SALIR ) {
                            salida = false;
                            servidor.enviarDatosBoolean(true);
                        } else {
                            servidor.enviarDatosBoolean(false);
                            numero1 = Double.parseDouble(servidor.recibirDatos());
                            numero2 = Double.parseDouble(servidor.recibirDatos());
                            servidor.enviarDatosDouble(servidor.realizarOperacion(tipo, numero1, numero2));
                        }
                    }else{
                        servidor.enviarDatosBoolean(false);
                    }
                }catch (Exception e){
                    servidor.enviarDatosBoolean(false);
                }
            } while (!salida);
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Termino el sistema");
    }

    public static void main( String[] args ) {
        new Main().ejercicio8();
    }
}

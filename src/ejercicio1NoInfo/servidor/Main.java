package ejercicio1NoInfo.servidor;

import ejercicio1NoInfo.Constantes;

public class Main {
    private void parteServidor() {
        Servidor servidor = null;
        try {
            servidor = new Servidor();
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_SER_ARRANQUE);
        }
        try {
            servidor.espera();
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_SER_ESPERA);
        }
        servidor.enviarMensaje();
    }

    public static void main(String[] args) {
        new Main().parteServidor();
    }
}

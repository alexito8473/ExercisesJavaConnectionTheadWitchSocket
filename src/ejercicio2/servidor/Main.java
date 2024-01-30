package ejercicio2.servidor;

import ejercicio2.Constantes;

public class Main {
    private void parteServidor() {
        Servidor servidor = new Servidor();
        try {
            servidor.arrancar();
            servidor.conectarCliente();
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_SER_ARRANQUE);
        }
        try {
          //  servidor.espera();
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_SER_ESPERA);
        }
        servidor.transferirMensajes();
    }

    public static void main(String[] args) {
        new Main().parteServidor();
    }
}

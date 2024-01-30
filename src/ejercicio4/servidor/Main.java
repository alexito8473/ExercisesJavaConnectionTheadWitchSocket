package ejercicio4.servidor;

import ejercicio2.Constantes;

import java.util.concurrent.TimeUnit;

public class Main {
    private void parteServidor() {
        Servidor servidor = new Servidor();
        System.out.println("----------------------------------Estamos en el gran super mega ultra servidor----------------------------------");
        System.out.println("Verde el servidor, azul el cliente");
        try {
            servidor.arrancar();
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_SER_ARRANQUE);
        }
        try {
            servidor.conectarCliente();
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_SER_ESPERA);
        }
        servidor.transferirMensajes();
    }

    public static void main(String[] args) {
        new Main().parteServidor();
    }
}

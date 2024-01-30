package ejercicio6.servidor;

import ejercicio6.Constantes;

public class Main {
    private void parteServidor() {
        Servidor servidor;
        System.out.println("----------------------------------Estamos en el gran super mega ultra servidor----------------------------------");
        System.out.println("Verde el servidor, azul el cliente");
        try {
            servidor = new Servidor();
            while (true) {
                try {
                    servidor.conectarCliente();
                } catch (Exception e) {
                    System.out.println(Constantes.ERROR_SER_ESPERA);
                }
            }
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_SER_ARRANQUE);
        }
    }

    public static void main(String[] args) {
        new Main().parteServidor();
    }
}

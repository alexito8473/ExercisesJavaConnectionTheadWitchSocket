package ejercicio5.servidor;

import ejercicio5.Constantes;

public class Main {
    private void parteServidor() {
        Servidor servidor = new Servidor();
        System.out.println("----------------------------------Estamos en el gran super mega ultra servidor----------------------------------");
        System.out.println("Verde el servidor, azul el cliente");
        try {
            servidor.arrancar();
            try {
                servidor.conectarCliente();
                try{
                    servidor.llamadaConCliente();
                }catch (Exception e){
                }
            } catch (Exception e) {
                System.out.println(Constantes.ERROR_SER_ESPERA);
            }
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_SER_ARRANQUE);
        }


    }

    public static void main(String[] args) {
        new Main().parteServidor();
    }
}

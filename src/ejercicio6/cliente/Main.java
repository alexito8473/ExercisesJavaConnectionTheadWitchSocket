package ejercicio6.cliente;


import ejercicio6.Constantes;

public class Main {
    private void ejercicioCliente() {
        Cliente cliente = null;
        System.out.println("----------------------------------Somos el ultra mega ultimate cliente----------------------------------");
        System.out.println("Verde el cliente, azul el servidor");
        try {
            cliente = new Cliente(Constantes.HOST, Constantes.PUERTO);
            try {
                cliente.conectar();
                try {
                    cliente.transferirMensajes();
                } catch (Exception e) {
                    System.err.println(e);
                }
            } catch (Exception e) {
                System.err.println(Constantes.ERROR_CLI_CERRAR);
            }
        } catch (Exception e) {
            System.err.println(Constantes.ERROR_CLI_CONECTAR);
        }
    }

    public static void main(String[] args) {
        new Main().ejercicioCliente();
    }
}

package ejercicio1NoInfo.cliente;

import ejercicio1NoInfo.Constantes;

public class Main {
    private void ejercicioCliente(){
        Cliente cliente = null;
        try{
            cliente = new Cliente(Constantes.HOST,Constantes.PUERTO);
        }catch (Exception e){
            System.err.println(Constantes.ERROR_CLI_CERRAR);
        }
        try{
            cliente.transferirMensaje();
        }catch (Exception e){
            System.err.println(Constantes.ERROR_CLI_CERRAR);
        }

    }
    public static void main(String[] args) {
        new Main().ejercicioCliente();
    }
}

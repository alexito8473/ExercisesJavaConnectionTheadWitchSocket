package ejercicio2.cliente;


import ejercicio2.Constantes;

public class Main {
    private void ejercicioCliente(){
        Cliente cliente = null;
        try{
            cliente = new Cliente(Constantes.HOST,Constantes.PUERTO);
        }catch (Exception e){
            System.err.println(Constantes.ERROR_CLI_CONECTAR);
        }
        try{
            cliente.conectar();
            cliente.transferirMensaje();
        }catch (Exception e){
            System.err.println(Constantes.ERROR_CLI_CERRAR);
        }

    }
    public static void main(String[] args) {
        new Main().ejercicioCliente();
    }
}

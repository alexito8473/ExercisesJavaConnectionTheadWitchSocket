package ejercicio4.cliente;



public class Main {
    public static final String HOST = "192.168.10.179";
    public static final int PUERTO = 54321;
    private void ejercicioCliente(){
        Cliente cliente = null;
        System.out.println("----------------------------------Somos el ultra mega ultimate cliente----------------------------------");
        System.out.println("Verde el cliente, azul el servidor");
        try{
            cliente = new Cliente(HOST,PUERTO);
        }catch (Exception e){

        }
        try{
            cliente.conectar();
            cliente.transferirMensajes();
        }catch (Exception e){

        }

    }
    public static void main(String[] args) {
        new Main().ejercicioCliente();
    }
}

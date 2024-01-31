package udpConexionEstablecer.Cliente;


public class Main {
    private void ejercicio8() {
        System.out.println("---Estamos en el cliente---");
        Cliente cliente;
        try {
            cliente = new Cliente();
            cliente.establecerConexion();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void main( String[] args ) {
        new Main().ejercicio8();
    }
}

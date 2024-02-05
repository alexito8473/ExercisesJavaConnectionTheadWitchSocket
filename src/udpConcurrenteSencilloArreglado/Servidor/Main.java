package udpConcurrenteSencilloArreglado.Servidor;

public class Main {
    public void ejercicio8() {
        Servidor servidor;
        try {
            servidor = new Servidor();
            System.out.println("Server iniciado");
            while (true){
                servidor.conversacion();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Termino el sistema");
    }

    public static void main( String[] args ) {
        new Main().ejercicio8();
    }
}

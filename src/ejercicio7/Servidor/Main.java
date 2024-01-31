package ejercicio7.Servidor;

public class Main {

    public void ejercicio7() {
        Servidor servidor;

        try {
            servidor = new Servidor();
            System.out.println("Server iniciado");
            servidor.conversacion();
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Termino el sistema");
    }

    public static void main( String[] args ) {
        new Main().ejercicio7();
    }
}

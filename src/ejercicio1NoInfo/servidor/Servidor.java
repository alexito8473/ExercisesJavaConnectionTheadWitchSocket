package ejercicio1NoInfo.servidor;

import ejercicio1NoInfo.Constantes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket servidor;
    private Socket socCli = null;

    public Servidor() throws IOException {
        servidor = new ServerSocket(Constantes.PUERTO);
        System.out.println("Servidor iniciado");
    }

    public void espera() throws IOException {
        System.out.println("Esperando conexión");
        while (true) {
            socCli = servidor.accept();
            System.out.println("Cliente conectado");
        }
    }

    public void enviarMensaje() {
        System.out.println("(Servidor) Mensaje enviado");
        System.out.println("(Servidor) Mensaje recibido");
    }
}

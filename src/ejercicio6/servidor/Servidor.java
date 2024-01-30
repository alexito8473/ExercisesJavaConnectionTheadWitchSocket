package ejercicio6.servidor;


import ejercicio6.Constantes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor  {

    private ServerSocket servidor;
    private Socket socCli = null;

    public Servidor() throws IOException {
        servidor = new ServerSocket(Constantes.PUERTO);
        System.out.println("Servidor iniciado");
    }

    public void conectarCliente() throws IOException {
        System.out.println("Esperando conexión");
            socCli = servidor.accept();
            System.out.println("(Servidor) Cliente conectado correctamente");
            HiloServidor hilo = new HiloServidor(socCli);
            hilo.start();
    }

}
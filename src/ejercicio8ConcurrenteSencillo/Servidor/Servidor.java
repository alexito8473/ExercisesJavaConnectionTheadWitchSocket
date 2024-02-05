package ejercicio8ConcurrenteSencillo.Servidor;

import ejercicio8ConcurrenteSencillo.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    private final DatagramSocket socket;

    public Servidor() throws SocketException {
        this.socket = new DatagramSocket(ConstanteGlobal.PUERTO);
    }

    public void conversacion() throws IOException, InterruptedException {
        HiloServidor hilo = new HiloServidor(socket);
        hilo.start();
        System.out.println("Cliente conectado");
    }
}

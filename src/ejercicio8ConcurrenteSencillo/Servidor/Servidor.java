package ejercicio8ConcurrenteSencillo.Servidor;

import ejercicio8ConcurrenteSencillo.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

import static ejercicio8.Cliente.Constantes.*;

public class Servidor {
    private final DatagramSocket socket;

    public Servidor() throws SocketException {
        this.socket = new DatagramSocket(ConstanteGlobal.PUERTO);
    }

    public void conversacion() throws IOException, InterruptedException {
        byte[] bytes = new byte[ConstanteGlobal.BUFFER_MAX];
        DatagramPacket data = new DatagramPacket(bytes,bytes.length);
        socket.receive(data);
        HiloServidor hilo = new HiloServidor(socket,data);
        hilo.start();
        Thread.sleep(100);
        System.out.println("Cliente conectado");
    }
}

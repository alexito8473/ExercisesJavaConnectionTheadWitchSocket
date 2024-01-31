package udpConexionEstablecer.Servidor;

import udpConexionEstablecer.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    private final DatagramSocket socket;

    public Servidor() throws SocketException {
        this.socket = new DatagramSocket(ConstanteGlobal.PUERTO);
    }

    public void conversacion() throws SocketException {
        byte[] bytes = new byte[ConstanteGlobal.BUFFER_MAX];
        DatagramPacket data = new DatagramPacket(bytes,bytes.length);
        try {
            socket.receive(data);
        } catch (IOException e) {
            throw new RuntimeException("Erro en la espera");
        }
        HiloServidor hilo = new HiloServidor(data);
        hilo.start();
        System.out.println("Cliente conectado");
    }
}

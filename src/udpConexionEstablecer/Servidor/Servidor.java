package udpConexionEstablecer.Servidor;

import udpConexionEstablecer.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    private final DatagramSocket socket;
    private final byte[] bytes = new byte[ConstanteGlobal.BUFFER_MAX];
    private final DatagramPacket data = new DatagramPacket(bytes,bytes.length);
    public Servidor() throws SocketException {
        this.socket = new DatagramSocket(ConstanteGlobal.PUERTO);
    }

    public void conversacion() throws SocketException {
        try {
            socket.receive(data);
            HiloServidor hilo = new HiloServidor(data);
            hilo.start();
            System.out.println("Cliente conectado");
        } catch (IOException e) {
            System.out.println("Fallo en la conexión del cliente");
        }
    }

}

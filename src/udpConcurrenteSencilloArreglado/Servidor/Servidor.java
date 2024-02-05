package udpConcurrenteSencilloArreglado.Servidor;

import udpConcurrenteSencilloArreglado.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    private final DatagramSocket socket;
    private String[] mensajeSeparado;
    private final byte[] bytes = new byte[udpConexionEstablecer.Constante.ConstanteGlobal.BUFFER_MAX];
    private DatagramPacket data = new DatagramPacket(bytes, bytes.length);
    private String concatenacion;

    public Servidor() throws SocketException {
        this.socket = new DatagramSocket(ConstanteGlobal.PUERTO);
    }

    public void conversacion() throws IOException, InterruptedException {
        HiloServidor hilo;
        socket.receive(data);
        concatenacion = new String(data.getData()).trim();
          if ( Integer.parseInt(concatenacion.split(":")[0])!= Constantes.NUM_SALIR   ) {
            hilo = new HiloServidor(socket, concatenacion,data);
            hilo.start();
            System.out.println("Petición aceptada");
        }
    }

}

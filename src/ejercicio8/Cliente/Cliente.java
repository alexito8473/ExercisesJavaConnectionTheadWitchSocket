package ejercicio8.Cliente;

import ejercicio8.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.*;

public class Cliente {
    private final DatagramSocket socket;
    private final InetAddress destinoIp;
    private final int puerto;

    public Cliente() throws SocketException, UnknownHostException {
        socket = new DatagramSocket(); // Lo vamos a asociar aleatoriamente
        destinoIp = InetAddress.getByName(ConstanteGlobal.DIRECCION_SERVIDOR);
        puerto = ConstanteGlobal.PUERTO;
    }

    public String recibirDatos() {
        byte[] bytes = new byte[ConstanteGlobal.BUFFER_MAX];
        DatagramPacket datos = new DatagramPacket(bytes, bytes.length);
        try {
            socket.receive(datos);
            return new String(datos.getData()).trim();
        } catch (IOException e) {
            System.out.println("No he recibido nada");
        }
        return "";
    }

    public void enviarDatosString( String mensaje ) throws IOException {
        byte[] mensajeBytes = mensaje.getBytes();
        DatagramPacket datos;
        if ( mensajeBytes.length < ConstanteGlobal.BUFFER_MAX ) {
            datos = new DatagramPacket(mensajeBytes, mensajeBytes.length, destinoIp, puerto);
            socket.send(datos);
        } else {
            System.out.println(Constantes.WARNING_MAX_LENGTH);
        }
    }

    public void enviarDatosInt( int numero ) throws IOException {
        enviarDatosString(String.valueOf(numero));

    }

    public void enviarDatosDouble( double numero ) throws IOException {
        enviarDatosString(String.valueOf(numero));
    }
}

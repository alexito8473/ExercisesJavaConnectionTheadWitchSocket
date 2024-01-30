package ejercicio7NoTerminado.Servidor;

import ejercicio7NoTerminado.Cliente.Constantes;
import ejercicio7NoTerminado.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import static ejercicio8.Cliente.Constantes.*;

public class Servidor {
    private final DatagramSocket socket;
    private int puerto;
    private InetAddress destinoIP;

    public Servidor() throws SocketException {
        socket = new DatagramSocket(ConstanteGlobal.PUERTO);
    }

    public String recibirDatos() {
        byte[] bytes = new byte[ConstanteGlobal.BUFFER_MAX];
        DatagramPacket datos = new DatagramPacket(bytes, bytes.length);
        try {
            socket.receive(datos);
            destinoIP = datos.getAddress();
            puerto=datos.getPort();
            return new String(datos.getData()).trim();
        } catch (IOException e) {
            System.out.println("No he recibido nada");
        }
        return "-1";
    }

    public void enviarDatosString( String mensaje ) throws IOException {
        byte[] mensajeBytes = mensaje.getBytes();
        DatagramPacket datos;
        if ( mensajeBytes.length < ConstanteGlobal.BUFFER_MAX ) {
            datos = new DatagramPacket(mensajeBytes, mensajeBytes.length, destinoIP, puerto);
            socket.send(datos);
        } else {
            System.out.println(Constantes.WARNING_MAX_LENGTH);
        }
    }

    public void enviarDatosDouble( double numero ) throws IOException {
        enviarDatosString(String.valueOf(numero));
    }
    public void enviarDatosBoolean( boolean bandera ) throws IOException {
        enviarDatosString(String.valueOf(bandera));
    }
    public double realizarOperacion( int tipo, double numero1, double numero2 ) {
        return switch (tipo) {
            case NUM_SUMAR -> numero1 + numero2;
            case NUM_MULTIPLICAR -> numero1 * numero2;
            case NUM_DIVIDIR -> numero1 / numero2;
            case NUM_RESTO -> numero1 % numero2;
            case NUM_RESTA -> numero1 - numero2;
            default -> throw new IllegalStateException("Unexpected value: " + tipo);
        };
    }
}

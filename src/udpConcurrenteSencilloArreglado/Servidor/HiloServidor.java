package udpConcurrenteSencilloArreglado.Servidor;

import ejercicio7.Cliente.Constantes;
import ejercicio7.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

import static ejercicio8.Cliente.Constantes.*;

public class HiloServidor extends Thread {
    private final DatagramSocket socket;
    private byte[] bytes = new byte[ConstanteGlobal.BUFFER_MAX];
    private int puerto;
    private InetAddress destinoIP;
    private final String mensaje;

    public HiloServidor( DatagramSocket socket, String mensaje , DatagramPacket data) {
        this.socket = socket;
        this.mensaje = mensaje;
        destinoIP = data.getAddress();
        puerto = data.getPort();
    }

    @Override
    public void run() {
        String[] cocatenacion = mensaje.trim().split(":");
        try {
            enviarDatosDouble(realizarOperacion(Integer.valueOf(cocatenacion[0]),  Double.valueOf(cocatenacion[1].replace(",",".")), Double.valueOf(cocatenacion[2].replace(",","."))));
        } catch (IOException e) {
        }
    }


    public void enviarDatosString( String mensaje ) throws IOException {
        byte[] mensajeBytes = mensaje.getBytes();
        if ( mensajeBytes.length < ConstanteGlobal.BUFFER_MAX ) {
            socket.send(new DatagramPacket(mensajeBytes, mensajeBytes.length, destinoIP, puerto));
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

    public double realizarOperacion( double tipo, double numero1, double numero2 ) {
        return switch ((int) tipo) {
            case NUM_SUMAR -> numero1 + numero2;
            case NUM_MULTIPLICAR -> numero1 * numero2;
            case NUM_DIVIDIR -> numero1 / numero2;
            case NUM_RESTO -> numero1 % numero2;
            case NUM_RESTA -> numero1 - numero2;
            default -> throw new IllegalStateException("Unexpected value: " + tipo);
        };
    }
}

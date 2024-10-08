package ejercicio8ConcurrenteSencillo.Servidor;

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
    private DatagramPacket datos;
    private byte[] bytes= new byte[ConstanteGlobal.BUFFER_MAX];
    private int puerto;
    private InetAddress destinoIP;

    public HiloServidor( DatagramSocket socket ) {
        this.socket = socket;
    }

    @Override
    public void run() {
        double numero1, numero2;
        int tipo;
        System.out.println();
        String[] cocatenacion = recibirDatos().trim().split(":");
        Arrays.stream(cocatenacion).forEach(t -> System.out.println(t));
        tipo = Integer.valueOf(cocatenacion[0]);
        numero1 = Double.valueOf(cocatenacion[1].replace(",","."));
        numero2 = Double.valueOf(cocatenacion[2].replace(",","."));
        try {
            enviarDatosDouble(realizarOperacion(tipo, numero1, numero2));
        } catch (IOException e) {
        }
    }


    public String recibirDatos() {
        datos = new DatagramPacket(bytes,bytes.length);
        try {
            socket.receive(datos);
            destinoIP = datos.getAddress();
            puerto = datos.getPort();
            return new String(datos.getData()).trim();
        } catch (IOException e) {
            System.out.println("No he recibido nada");
        }
        return "-1";
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

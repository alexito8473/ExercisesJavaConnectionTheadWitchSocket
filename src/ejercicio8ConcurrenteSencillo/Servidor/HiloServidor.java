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
    private byte[] bytes;
    private int puerto;
    private InetAddress destinoIP;

    public HiloServidor( DatagramSocket socket, DatagramPacket datos ) {
        this.socket = socket;
        this.bytes=new byte[ConstanteGlobal.BUFFER_MAX];
        destinoIP = datos.getAddress();
        puerto=datos.getPort();
        this.datos= new DatagramPacket(bytes, bytes.length, destinoIP, puerto);
    }

    @Override
    public void run() {
        double numero1, numero2;
        int tipo;
        boolean salida = false;
        System.out.println();
        do {
            tipo = (int)Double.parseDouble(recibirDatos());
            if ( tipo == ejercicio7.Servidor.Constantes.NUM_SALIR ) {
                salida = false;
            } else {
                numero1 = Double.parseDouble(recibirDatos());
                numero2 = Double.parseDouble(recibirDatos());
                try {
                    enviarDatosDouble(realizarOperacion(tipo, numero1, numero2));
                } catch (IOException e) {
                }
            }
        } while (!salida);
    }

    public String recibirDatos() {
        try {
            socket.receive(datos);
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

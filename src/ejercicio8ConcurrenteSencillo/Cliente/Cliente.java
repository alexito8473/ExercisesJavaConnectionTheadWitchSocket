package ejercicio8ConcurrenteSencillo.Cliente;

import ejercicio8ConcurrenteSencillo.ConsoleInput;
import ejercicio8ConcurrenteSencillo.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import static ejercicio7NoTerminado.Cliente.Constantes.*;

public class Cliente {
    private final DatagramSocket socket;
    private final InetAddress destinoIp;
    private final int puerto;

    public Cliente() throws SocketException, UnknownHostException {
        socket = new DatagramSocket(); // Lo vamos a asociar aleatoriamente
        destinoIp = InetAddress.getByName(ConstanteGlobal.DIRECCION_SERVIDOR);
        puerto = ConstanteGlobal.PUERTO;
    }

    public void conversacion() throws IOException {
        boolean salida = false;
        ConsoleInput con = new ConsoleInput(new Scanner(System.in));
        String tipoOperacion;
        double numero1;
        boolean controlador;
        double numero2;
        enviarDatosString("");
        do {
            System.out.println(recibirDatos());
            tipoOperacion = con.readString();
            enviarDatosString(tipoOperacion);
            controlador = Boolean.valueOf(recibirDatos());
            if ( controlador ) {
                if ( Boolean.valueOf(recibirDatos()) ) {
                    salida = true;
                } else {
                    System.out.println("Introduce un numero");
                    numero1 = con.readDouble();
                    System.out.println("Introduce un numero");
                    numero2 = con.readDouble();
                    enviarDatosDouble(numero1);
                    enviarDatosDouble(numero2);
                    System.out.printf("El tipo de operación es %-6s con el numero %.2f y el numero %.2f, con el resultado %s\n", tipoOperacion(Integer.parseInt(tipoOperacion)), numero1, numero2, recibirDatos());
                }
            } else {
                System.out.println("Introduce un numero que este en el rango");
            }
        } while (!salida);
        System.out.println("Hemos salida del programa");
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
    private String tipoOperacion( int numero ) {
        return switch (numero) {
            case NUM_SUMAR -> TEXT_SUMAR;
            case NUM_MULTIPLICAR -> TEXT_MULTIPLICAR;
            case NUM_DIVIDIR -> TEXT_DIVIDIR;
            case NUM_RESTO -> TEXT_RESTO;
            case NUM_RESTA -> TEXT_RESTA;
            default -> throw new IllegalStateException("Unexpected value: " + numero);
        };
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

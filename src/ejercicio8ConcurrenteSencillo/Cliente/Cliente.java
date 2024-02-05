package ejercicio8ConcurrenteSencillo.Cliente;

import ejercicio7.Cliente.Constantes;
import ejercicio7.ConsoleInput;
import ejercicio7.Constante.ConstanteGlobal;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import static ejercicio7.Cliente.Constantes.*;

public class Cliente {
    private final DatagramSocket socket;
    private final InetAddress destinoIp;
    private final int puerto;

    public Cliente() throws SocketException, UnknownHostException {
        socket = new DatagramSocket(); // Lo vamos a asociar aleatoriamente
        destinoIp = InetAddress.getByName(ejercicio7.Constante.ConstanteGlobal.DIRECCION_SERVIDOR);
        puerto = ejercicio7.Constante.ConstanteGlobal.PUERTO;
    }

    public void conversacion() throws IOException {
        boolean salida = false;
        ConsoleInput con = new ConsoleInput(new Scanner(System.in));
        int tipoOperacion;
        double numero1;
        double numero2;
        String concatenacion;
        do {
            System.out.println(TEXT_MENU);
            tipoOperacion = con.readIntInRange(NUM_SALIR, NUM_SUMAR, NUM_MULTIPLICAR, NUM_DIVIDIR, NUM_RESTO, NUM_RESTA);
            if ( tipoOperacion == NUM_SALIR ) {
                salida=true;
            } else {
                System.out.println("Introduce un numero");
                numero1=con.readDouble();
                System.out.println("Introduce un numero");
                numero2=con.readDouble();
                concatenacion=String.format("%d:%.2f:%.2f:",tipoOperacion,numero1,numero2);
                enviarDatosString(concatenacion);
                System.out.printf("El tipo de operación es %-6s con el numero %.2f y el numero %.2f, con el resultado %s\n",tipoOperacion(tipoOperacion),numero1,numero2,recibirDatos());
            }
        } while (!salida);
        System.out.println("Hemos salida del programa");
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
    public String recibirDatos() {
        byte[] bytes = new byte[ejercicio7.Constante.ConstanteGlobal.BUFFER_MAX];
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
        if ( mensajeBytes.length < ConstanteGlobal.BUFFER_MAX ) {
            socket.send(new DatagramPacket(mensajeBytes, mensajeBytes.length, destinoIp, puerto));
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

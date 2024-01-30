package ejercicio5.servidor;

import ejercicio5.ConsoleInput;
import ejercicio5.Constantes;
import ejercicio5.Color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Servidor {
    private final ConsoleInput console = new ConsoleInput(new Scanner(System.in));
    private ServerSocket servidor;
    private Socket socCli = null;
    private DataOutputStream salida = null;
    private DataInputStream entrada = null;

    public Servidor() {
    }

    public void arrancar() throws IOException {
        servidor = new ServerSocket(Constantes.PUERTO);
        System.out.println("Servidor iniciado");
    }

    public void conectarCliente() throws IOException {
        System.out.println("Esperando conexión");
        socCli = servidor.accept();
        entrada = new DataInputStream(socCli.getInputStream());
        salida = new DataOutputStream(socCli.getOutputStream());
        System.out.println("(Servidor) Cliente conectado correctamente");
    }

    public void llamadaConCliente() throws IOException {
        boolean salida = false;
        int tipoOperación;
        double numero1;
        double numero2;
        do {
            enviarString(Constantes.TEXT_MENU);
            if ((tipoOperación = recogerDatoInt()) == Constantes.NUM_SALIR) {
                salida = true;
            } else {
                enviarString("Introduce el primer número");
                numero1 = recogerDatoDouble();
                enviarString("Introduce el segundo número");
                numero2 = recogerDatoDouble();
                enviarDouble(calculadora(tipoOperación, numero1, numero2));
            }
        } while (!salida);
        socCli.close();
        System.out.println("(Servidor) Conexión finalizada");
    }

    private double calculadora(int tipoOperación, double numero1, double numero2) {
        return switch (tipoOperación) {
            case Constantes.NUM_SUMAR -> numero1 + numero2;
            case Constantes.NUM_MULTIPLICAR -> numero1 * numero2;
            case Constantes.NUM_DIVIDIR -> numero1 / numero2;
            case Constantes.NUM_RESTO -> numero1 % numero2;
            case Constantes.NUM_RESTA -> numero1 - numero2;
            default -> throw new IllegalStateException("Error");
        };
    }

    private int recogerDatoInt() {
        int result = 0;
        try {
            result = entrada.readInt();
        } catch (Exception e) {
            System.out.println("No se ha podidio recibir el dato int");
        }
        return result;
    }

    private double recogerDatoDouble() {
        double result = 0.0;
        try {
            result = entrada.readDouble();
        } catch (Exception e) {
            System.out.println("No se ha podidio recibir el dato int");
        }
        return result;
    }

    private void enviarString(String frase) {
        try {
            salida.writeUTF(frase);
        } catch (Exception e) {
            System.out.println("Error en enviar el mensaje del cliente");
        }
    }

    private void enviarDouble(double numero) {
        try {
            salida.writeDouble(numero);
        } catch (Exception e) {
            System.out.println("Error en enviar el mensaje del cliente");
        }
    }
}
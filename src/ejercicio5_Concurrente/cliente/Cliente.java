package ejercicio5_Concurrente.cliente;

import ejercicio5.Color;
import ejercicio5.ConsoleInput;
import ejercicio5.Constantes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private final ConsoleInput console = new ConsoleInput(new Scanner(System.in));
    private final String HOST;
    private DataOutputStream salida = null;
    private DataInputStream entrada = null;
    private final int PUERTO;
    private Socket cliente;

    public Cliente(final String HOST, final int PUERTO) {
        this.HOST = HOST;
        this.PUERTO = PUERTO;

    }

    public void conectar() throws IOException {
        cliente = new Socket(HOST, PUERTO);
        System.out.println("Conectado al servidor\n");
        entrada = new DataInputStream(cliente.getInputStream());
        salida = new DataOutputStream(cliente.getOutputStream());
    }

    public void transferirMensajes() throws IOException {
        boolean salida = false;
        int tipoOperación;
        double numero1;
        double numero2;
        do {
            recogerDatoString();
            tipoOperación = console.readIntInRange(Constantes.NUM_RESTA, Constantes.NUM_MULTIPLICAR, Constantes.NUM_SALIR, Constantes.NUM_DIVIDIR, Constantes.NUM_SUMAR, Constantes.NUM_RESTO);
            enviarDatoInt(tipoOperación);
            if (tipoOperación == Constantes.NUM_SALIR) {
                salida = true;
            } else {
                recogerDatoString();
                enviarDatoDouble((numero1 = console.readDouble()));
                recogerDatoString();
                enviarDatoDouble((numero2 = console.readDouble()));
                System.out.printf("%sTipo operación -> %s\nNumeros usados -> %f y %f\nEl resultado es -> %f%s\n",Color.GREEN , tipoOperacion(tipoOperación), numero1, numero2, recogerDatoDouble(),Color.RESET);

            }
        } while (!salida);
        cliente.close();
        System.out.println("(Cliente) Conexión finalizada");
    }

    private String tipoOperacion(int tipoOperación) {
        return switch (tipoOperación) {
            case Constantes.NUM_DIVIDIR -> "dividir";
            case Constantes.NUM_RESTO -> "resto";
            case Constantes.NUM_RESTA -> "resta";
            case Constantes.NUM_SUMAR -> "sumar";
            case Constantes.NUM_MULTIPLICAR -> "multiplicar";

            default -> throw new IllegalStateException("Unexpected value: " + tipoOperación);
        };
    }

    private String recogerDatoString() {
        String resultado = "";
        try {
            resultado = entrada.readUTF();
            System.out.println("(Servidor)-> " + Color.CYAN + resultado + Color.RESET);
        } catch (Exception e) {
            System.out.println("No se ha recibido nada");
        }
        return resultado;
    }

    private double recogerDatoDouble() {
        double result = 0.0;
        try {
            result = entrada.readDouble();
            System.out.println("(Servidor)-> " + Color.CYAN + result + Color.RESET);
        } catch (Exception e) {
            System.out.println("No se ha recibido nada");
        }
        return result;
    }

    private void enviarDatoInt(int numero) {
        try {
            salida.writeInt(numero);
        } catch (Exception e) {
            System.out.println("Error en enviar el mensaje del cliente");
        }
    }

    private void enviarDatoDouble(double numero) {
        try {
            salida.writeDouble(numero);
        } catch (Exception e) {
            System.out.println("Error en enviar el mensaje del cliente");
        }
    }
}

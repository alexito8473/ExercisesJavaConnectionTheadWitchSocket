package ejercicio6.cliente;

import ejercicio6.Color;
import ejercicio6.ConsoleInput;
import ejercicio6.Constantes;

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
        do {
            recogerDatoStringConSalida();
            enviarString(console.readString());
            recogerDatoStringConSalida();
        } while (true);
    }

    private void enviarString(String frase) {
        try {
            salida.writeUTF(frase);
        } catch (Exception e) {
            System.out.println("Error en enviar el mensaje del cliente");
        }
    }
    private String recogerDatoStringConSalida() {
        String resultado = "";
        try {
            resultado = entrada.readUTF();
            System.out.println("(Servidor)-> " + Color.CYAN + resultado + Color.RESET);
        } catch (Exception e) {
            System.out.println("No se ha recibido nada");
        }
        return resultado;
    }
    private String recogerDatoString() {
        String resultado = "";
        try {
            resultado = entrada.readUTF();
        } catch (Exception e) {
            System.out.println("No se ha recibido nada");
        }
        return resultado;
    }

}

package ejercicio4.cliente;

import ejercicio2.Color;
import ejercicio4.ConsoleInput;
import ejercicio4.Constantes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    public void transferirMensajes() {
        String mensaje;
        try {
            mensaje = readUTF();
            while (!mensaje.isEmpty() && !mensaje.equals(Constantes.PALABRA_SALIDA)) {
                mensaje = console.readString("(Soy el cliente)");
                // procesandoMensaje();
                writeUTF(mensaje);
                if (!mensaje.equals(Constantes.PALABRA_SALIDA)) {
                    mensaje = readUTF();
                }
            }
            cliente.close();
        } catch (Exception e) {
            System.out.println("(Cliente) Error en la desconexión");
        }

        System.out.println("(Cliente) Conexión finalizada");
    }

    private void procesandoMensaje() {
        String frase = "Enviando mensaje . . .";
        for (int i = 0; i < frase.length(); i++) {
            System.out.print(frase.charAt(i));
            try {
                TimeUnit.MICROSECONDS.sleep(Constantes.TIME_TEMPORIZADOR);
            } catch (Exception e) {
            }
        }
        System.out.println();
    }

    private String readUTF() {
        String resultado = "";
        try {
            resultado = entrada.readUTF();
            System.out.println("(Servidor)-> " + Color.CYAN + resultado + Color.RESET);
        } catch (Exception e) {
            System.out.println("No se ha recibido nada");
        }
        return resultado;
    }

    private void writeUTF(String frase) {
        try {
            salida.writeUTF(frase);
        } catch (Exception e) {
            System.out.println("Error en enviar el mensaje del cliente");
        }
    }
}

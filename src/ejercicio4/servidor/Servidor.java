package ejercicio4.servidor;

import ejercicio2.Color;
import ejercicio4.ConsoleInput;
import ejercicio4.Constantes;

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

    public void transferirMensajes() {
        boolean salida = false;
        String mensaje;
        try {
            while (!salida && !((mensaje = console.readString("(Soy el servidor)")).equals(Constantes.PALABRA_SALIDA))) {
                //procesandoMensaje();
                writeUTF(mensaje);
                if (readUTF().equals(Constantes.PALABRA_SALIDA)) {
                    salida = true;
                }
            }
        } catch (Exception e) {
        }
        System.out.println("(Servidor) Conexión finalizada");
    }

    private String readUTF() {
        String resultado = "";
        try {
            resultado = entrada.readUTF();
            System.out.println("(Cliente)-> " + Color.CYAN + resultado + Color.RESET);
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

}

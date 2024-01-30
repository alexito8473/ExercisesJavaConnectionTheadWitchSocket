package ejercicio2.servidor;

import ejercicio1NoInfo.Constantes;
import ejercicio2.Color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket servidor;
    private Socket socCli = null;
    private DataOutputStream salida= null;
    private DataInputStream entrada= null;

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

    private void espera() throws IOException {
        System.out.println("Esperando conexión");
        while (true) {
            socCli = servidor.accept();
            System.out.println("Cliente conectado\n");
        }
    }

    public void transferirMensajes() {
        writeUTF("Soy el servidor y te mando un mensaje de testeo\n");
        readUTF();
        System.out.println("(Servidor) Mensaje recibido");
    }

    private void readUTF() {
        try {
            System.out.println(Color.CYAN+ entrada.readUTF()+Color.RESET);
        } catch (Exception e) {
            System.out.println("Error en leer el mensaje del cliente");
        }
    }
    private void writeUTF(String frase) {
        try {
            salida.writeUTF(frase);
        } catch (Exception e) {
            System.out.println("Error en enviar el mensaje del cliente");
        }
    }
}

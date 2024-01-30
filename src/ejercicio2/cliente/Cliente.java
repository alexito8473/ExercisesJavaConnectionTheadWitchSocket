package ejercicio2.cliente;

import ejercicio2.Color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    private final String HOST ;
    private DataOutputStream salida=null;
    private DataInputStream entrada=null;
    private final int PUERTO ;
    private Socket cliente;
    public Cliente(final String HOST, final int PUERTO)  {
        this.HOST=HOST;
        this.PUERTO=PUERTO;

    }
    public void conectar() throws IOException{
        cliente = new Socket(HOST,PUERTO);
        System.out.println("Servidor conectado\n");
        entrada= new DataInputStream(cliente.getInputStream());
        salida= new DataOutputStream(cliente.getOutputStream());
    }
    public void transferirMensaje() throws IOException {
        readUTF();
        writeUTF("Hey como estas server\n");
        cliente.close();
    }
    private void readUTF() {
        try {
            System.out.println(Color.GREEN+entrada.readUTF()+Color.RESET);
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

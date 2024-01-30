package ejercicio1NoInfo.cliente;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    private final String HOST ;
    private final int PUERTO ;
    private Socket cliente;
    public Cliente(final String HOST, final int PUERTO) throws IOException {
        this.HOST=HOST;
        this.PUERTO=PUERTO;
        cliente = new Socket(HOST,PUERTO);
        System.out.println("Servidor conectado");
    }
    public void transferirMensaje() throws IOException {
        System.out.println("(Cliente) Mandando mensaje");
        System.out.println("(Cliente) Recibir mensaje");
        cliente.close();
    }
}

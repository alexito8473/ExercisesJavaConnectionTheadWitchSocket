package ejercicio5_Concurrente.servidor;


import ejercicio5_Concurrente.ConsoleInput;
import ejercicio5_Concurrente.Constantes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor  {

    private ServerSocket servidor;
    private Socket socCli = null;


    public Servidor() throws IOException {
        servidor = new ServerSocket(Constantes.PUERTO);
        System.out.println("Servidor iniciado");
    }


    public void conectarCliente() throws IOException {
        System.out.println("Esperando conexión");
            socCli = servidor.accept();
            System.out.println("(Servidor) Cliente conectado correctamente");
            HiloServidor hilo = new HiloServidor(socCli);
            hilo.start();
    }

}
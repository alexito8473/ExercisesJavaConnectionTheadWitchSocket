package ejercicio8.Cliente;


import ejercicio8.ConsoleInput;

import java.util.Scanner;

import static ejercicio7NoTerminado.Cliente.Constantes.*;

public class Main {
    private void ejercicio8() {
        System.out.println("---Estamos en el cliente---");
        Cliente cliente;
        try {
            cliente = new Cliente();
            cliente.conversacion();
        } catch (Exception e) {
            System.err.println(e);
        }
    }



    public static void main( String[] args ) {
        new Main().ejercicio8();
    }
}

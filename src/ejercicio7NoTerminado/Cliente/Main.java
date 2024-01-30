package ejercicio7NoTerminado.Cliente;


import ejercicio7NoTerminado.ConsoleInput;

import java.util.Scanner;

import static ejercicio7NoTerminado.Cliente.Constantes.*;

public class Main {
    private void ejercicio7() {
        System.out.println("---Estamos en el cliente---");
        Cliente cliente;
        boolean salida = false;
        ConsoleInput con = new ConsoleInput(new Scanner(System.in));
        int tipoOperacion;
        double numero1;
        double numero2;
        String controlador;
        try {
            cliente = new Cliente();
            do {
                System.out.println(TEXT_MENU);
                tipoOperacion = con.readIntInRange(NUM_SALIR, NUM_SUMAR, NUM_MULTIPLICAR, NUM_DIVIDIR, NUM_RESTO, NUM_RESTA);
                if ( tipoOperacion == NUM_SALIR ) {
                    salida=true;
                } else {
                    System.out.println("Introduce un numero");
                    numero1=con.readDouble();
                    System.out.println("Introduce un numero");
                    numero2=con.readDouble();
                    cliente.enviarDatosInt(tipoOperacion);
                    cliente.enviarDatosDouble(numero1);
                    cliente.enviarDatosDouble(numero2);
                    System.out.printf("El tipo de operación es %-6s con el numero %.2f y el numero %.2f, con el resultado %s\n",tipoOperacion(tipoOperacion),numero1,numero2,cliente.recibirDatos());
                }
            } while (!salida);
            System.out.println("Hemos salida del programa");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private String tipoOperacion( int numero ) {
        return switch (numero) {
            case NUM_SUMAR -> TEXT_SUMAR;
            case NUM_MULTIPLICAR -> TEXT_MULTIPLICAR;
            case NUM_DIVIDIR -> TEXT_DIVIDIR;
            case NUM_RESTO -> TEXT_RESTO;
            case NUM_RESTA -> TEXT_RESTA;
            default -> throw new IllegalStateException("Unexpected value: " + numero);
        };
    }

    public static void main( String[] args ) {
        new Main().ejercicio7();
    }
}

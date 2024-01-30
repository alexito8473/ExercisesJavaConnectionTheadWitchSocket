package ejercicio8.Cliente;


import ejercicio5.Color;
import ejercicio8.ConsoleInput;

import java.util.Scanner;

import static ejercicio8.Cliente.Constantes.*;

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
            cliente.enviarDatosString("");
            do {
                System.out.println(cliente.recibirDatos());
                tipoOperacion = con.readIntInRange();
                cliente.enviarDatosInt(tipoOperacion);
                controlador = cliente.recibirDatos();
                if ( controlador.equals(PALABRA_SALIDA) ) {
                    salida = true;
                } else {
                    if ( Boolean.valueOf(controlador) ) {
                        System.out.println("Introduce el primer numero");
                        cliente.enviarDatosDouble(numero1 = con.readDouble());
                        System.out.println("Introduce el segundo numero");
                        cliente.enviarDatosDouble(numero2 = con.readDouble());
                        System.out.printf("%sTipo operación -> %s\nNumeros usados -> %f y %f\nEl resultado es -> %s%s\n", Color.GREEN, tipoOperacion(tipoOperacion), numero1, numero2, cliente.recibirDatos(), Color.RESET);
                    } else {
                        System.out.println("Dato incorrecto");
                    }

                }
            } while (!salida);
            System.out.println("Hemos salida del programa");
        } catch (Exception e) {
            System.err.println(ERROR_CREAR_DATAGRAM);
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

package ejercicio8.Cliente;


import ejercicio8.ConsoleInput;

import java.util.Scanner;

import static ejercicio7NoTerminado.Cliente.Constantes.*;

public class Main {
    private void ejercicio8() {
        System.out.println("---Estamos en el cliente---");
        Cliente cliente;
        boolean salida = false;
        ConsoleInput con = new ConsoleInput(new Scanner(System.in));
        String tipoOperacion;
        double numero1;
        boolean controlador;
        double numero2;
        try {
            cliente = new Cliente();
            cliente.enviarDatosString("");
            do {
               System.out.println(cliente.recibirDatos());
                tipoOperacion = con.readString();
                cliente.enviarDatosString(tipoOperacion);
                controlador=Boolean.valueOf(cliente.recibirDatos());
                if(controlador){
                    if (Boolean.valueOf(cliente.recibirDatos())) {
                        salida=true;
                    } else {
                        System.out.println("Introduce un numero");
                        numero1=con.readDouble();
                        System.out.println("Introduce un numero");
                        numero2=con.readDouble();
                        cliente.enviarDatosDouble(numero1);
                        cliente.enviarDatosDouble(numero2);
                        System.out.printf("El tipo de operación es %-6s con el numero %.2f y el numero %.2f, con el resultado %s\n",tipoOperacion(Integer.parseInt(tipoOperacion)),numero1,numero2,cliente.recibirDatos());
                    }
                }else {
                    System.out.println("Introduce un numero que este en el rango");
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
        new Main().ejercicio8();
    }
}

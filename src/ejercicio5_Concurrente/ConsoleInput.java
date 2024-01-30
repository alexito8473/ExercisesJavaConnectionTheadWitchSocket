package ejercicio5_Concurrente;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.OptionalInt;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner sc;

    public ConsoleInput(Scanner sc) {
        this.sc = sc;
    }

    private void cleanInput() {
        sc.nextLine();
    }

    // Hecho con los bytes
    public byte readByte() {
        byte resultado = 0;
        boolean salir = false;
        do {
            try {
                resultado = sc.nextByte();
                salir = true;
            } catch (InputMismatchException e) {
                System.err.println("Introduce el valor bien(byte)");
            } finally {
                cleanInput();
            }
        } while (!salir);
        return resultado;
    }

    public byte readByteLessThan(byte upperBound) {
        byte i = 0;
        if (upperBound == Byte.MIN_VALUE) {
            throw new IllegalArgumentException("El byte no puede ser mas pequeño que -128");
        }
        do {
            i = readByte();
            if (i >= upperBound) {
                System.out.println("El dato debe ser menor que " + upperBound);
            }
        } while (!(i < upperBound));
        return i;

    }

    public byte readByteLessOrEqualThan(byte upperBound) {
        byte i = 0;
        do {
            i = readByte();
            if (i > upperBound) {
                System.out.println("El dato debe ser menor que " + (upperBound + 1));
            }
        } while (!(i <= upperBound));
        return i;
    }

    public byte readByteGreaterThan(byte cantidad) {
        byte i = 0;
        if (cantidad == Byte.MAX_VALUE) {
            throw new IllegalArgumentException("El byte introducido por parametro no puede ser mas grande que 127");
        }
        do {
            i = readByte();
            if (i <= cantidad) {
                System.out.println("El dato debe ser mayor que " + cantidad);
            }
        } while (!(i > cantidad));
        return i;
    }

    public byte readByteGreaterOrEqualThan(byte cantidad) {
        byte i = 0;
        do {
            i = readByte();
            if (i < cantidad) {
                System.out.println("El dato debe ser mayor o igual que " + cantidad);
            }
        } while (!(i >= cantidad));
        return i;
    }

    public byte readbyteInRange(byte a, byte b) {
        byte c = 0;
        boolean salir = false;
        do {
            c = readByte();
            if (c >= a && c <= b) {
                salir = true;
            } else if (c >= b && c <= a) {
                salir = true;
            } else {
                System.out.println("Su dato no esta en el rango. Vuelve a escribirlo");
            }
        } while (!salir);
        return c;
    }
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Hecho con los shorts
    public short readShort() {
        short resultado = 0;
        boolean salir = false;
        do {
            try {
                resultado = sc.nextShort();
                salir = true;
            } catch (Exception e) {
                System.err.println("Introduce el valor bien(short)");
            } finally {
                cleanInput();
            }
        } while (!salir);
        return resultado;
    }

    public short readShortLessThan(short upperBound) {
        short i = 0;
        boolean salir = false;
        if (Short.MIN_VALUE == upperBound) {
            throw new NumberFormatException("El short introducido por parametro no puede ser mas pequeño que -32768");
        }
        do {
            i = readShort();
            if (i < upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public short readShortLessOrEqualThan(short upperBound) {
        short i;
        boolean salir = false;
        do {
            i = readShort();
            if (i <= upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor o igual que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public short readByteGreaterThan(short cantidad) {
        short i;
        boolean salir = false;
        if (Short.MAX_VALUE == cantidad) {
            throw new NumberFormatException("El short introducido por parametro no puede ser 32767, debe ser menor");
        }
        do {
            i = readShort();
            if (i > cantidad) {
                salir = true;
            } else {
                System.out.println("El dato debe ser mayor que " + cantidad);
            }
        } while (!salir);
        return i;
    }

    public short readShortGreaterOrEqualThan(short cantidad) {
        short i;
        do {
            i = readShort();
            if (i < cantidad) {
                System.out.println("El dato debe ser mayor o igual que " + cantidad);

            }
        } while (!(i >= cantidad));
        return i;
    }

    public short readShortInRange(short a, short b) {
        short c;
        boolean salir = false;
        do {
            c = readShort();
            if (c >= a && c <= b) {
                salir = true;
            } else if (c >= b && c <= a) {
                salir = true;
            } else {
                System.out.println("Su dato no esta en el rango. Vuelve a escribirlo");
            }
        } while (!salir);
        return c;

    }

    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Hecho con los int
    public int readInt() {
        int resultado = 0;
        boolean salida = false;
        do {
            try {
                System.out.print("\n-> ");
                resultado = sc.nextInt();
                salida = true;
            } catch (Exception e) {
                System.err.println("Introduce el valor bien(int)");
            } finally {
                cleanInput();
            }
        } while (!salida);
        return resultado;
    }

    public int readInt(String frase) {
        System.out.print(frase);
        return readInt();
    }

    public int readIntLessThan(int upperBound) {
        int i = 0;
        boolean salir = false;
        if (Integer.MIN_VALUE == upperBound) {
            throw new NumberFormatException(
                    "El int introducido por parametro no puede ser mas pequeño que -2147483648");
        }
        do {
            i = readInt();
            if (i < upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public int readIntLessOrEqualThan(int upperBound) {
        int i = 0;
        boolean salir = false;
        do {
            i = readInt();
            if (i <= upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor o igual que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public int readIntGreaterThan(int cantidad) {
        int i = 0;
        boolean salir = false;
        if (Integer.MAX_VALUE == cantidad) {
            throw new NumberFormatException("El int introducido por parametro no puede ser 2147483647");
        }
        do {
            i = readInt();
            if (i > cantidad) {
                salir = true;
            } else {
                System.out.println("El dato debe ser mayor que " + cantidad);
            }
        } while (!salir);
        return i;
    }

    public int readIntGreaterOrEqualThan(int cantidad) {
        return readIntGreaterOrEqualThan(cantidad, "");
    }

    public int readIntGreaterOrEqualThan(int cantidad, String frase) {
        int i = 0;
        boolean salir = false;
        do {
            i = readInt(frase);
            if (i >= cantidad) {
                salir = true;
            } else {
                System.out.println("El dato debe ser mayor o igual que " + cantidad);
            }

        } while (!salir);
        return i;
    }

    public int readIntInRange(int a, int b) {
        int c = 0;
        boolean salir = false;
        do {
            c = readInt();
            if (c >= a && c <= b) {
                salir = true;
            } else if (c >= b && c <= a) {
                salir = true;
            } else {
                System.out.println("Su dato no esta en el rango. Vuelve a escribirlo");
            }
        } while (!salir);
        return c;
    }
    public int readIntInRange(int... a ) {
        int c = 0;
        OptionalInt numeroMinimo= Arrays.stream(a).min();
        OptionalInt numeroMaximo= Arrays.stream(a).max();
        boolean salir = false;
        do {
            c = readInt();
            if (c >= numeroMinimo.getAsInt() && c <= numeroMaximo.getAsInt()) {
                salir = true;
            } else if (c >= numeroMaximo.getAsInt() && c <= numeroMinimo.getAsInt()) {
                salir = true;
            } else {
                System.out.println("Su dato no esta en el rango. Vuelve a escribirlo");
            }
        } while (!salir);
        return c;
    }
    public int readIntInRangeDelTamaño(int longitud) {
        int salida = 0;
        boolean salir = false;
        do {
            salida = readInt();
            if (String.valueOf(salida).length() == longitud) {
                salir = true;
            } else {
                System.out.println("Rango invalido, su tamaño debe de ser de " + longitud + " caracteres");
            }
        } while (!salir);
        return salida;
    }

    public int readIntInRangeDelTamaño(int longitud, String frase) {
        int salida = 0;
        boolean salir = false;
        do {
            salida = readInt(frase);
            if (String.valueOf(salida).length() == longitud) {
                salir = true;
            } else {
                System.out.println("Rango invalido, su tamaño debe de ser de " + longitud + " caracteres");
            }
        } while (!salir);
        return salida;
    }
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Hecho con los long
    public long readLong() {
        long resultado = 0;
        boolean salida = false;
        do {
            try {
                resultado = sc.nextLong();
                salida = true;
            } catch (Exception e) {
                System.err.println("Introduce el valor bien(long)");
            } finally {
                cleanInput();
            }
        } while (!salida);
        return resultado;
    }

    public long readLongLessThan(long upperBound) {
        long i = 0;
        boolean salir = false;
        if (Long.MIN_VALUE == upperBound) {
            throw new NumberFormatException();
        }
        do {
            i = readLong();
            if (i < upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public long readLongLessOrEqualThan(long upperBound) {
        long i = 0;
        boolean salir = false;
        do {
            i = readLong();
            if (i <= upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public long readLongGreaterThan(long cantidad) {
        long i = 0;
        boolean salir = false;
        if (Long.MAX_VALUE == cantidad) {
            throw new NumberFormatException("El int introducido por parametro no puede ser 2147483647");
        }
        do {
            i = readLong();
            if (i > cantidad) {
                salir = true;
            } else {
                System.out.println("El dato debe ser mayor que " + cantidad);
            }
        } while (!salir);
        return i;
    }

    public long readLongGreaterOrEqualThan(long cantidad) {
        long i = 0;
        boolean salir = false;
        do {
            i = readLong();
            if (i >= cantidad) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + cantidad);
            }
        } while (!salir);
        return i;
    }

    public float readLongInRange(long a, long b) {
        long c = 0;
        boolean salir = false;
        do {
            c = readLong();
            if (c >= a && c <= b) {
                salir = true;
            } else if (c >= b && c <= a) {
                salir = true;
            } else {
                System.out.println("Su dato no esta en el rango. Vuelve a escribirlo");
            }
        } while (!salir);
        return c;

    }
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Hecho con los float
    public float readFloat() {
        float resultado = 0.0f;
        boolean salida = false;
        do {
            try {
                resultado = sc.nextFloat();
                salida = true;
            } catch (Exception e) {
                System.err.println("Introduce el valor bien(float)");
            } finally {
                cleanInput();
            }
        } while (!salida);
        return resultado;
    }

    public float readFloattLessThan(float upperBound) {
        float i = 0;
        boolean salir = false;
        if (Float.MIN_VALUE == upperBound) {
            throw new NumberFormatException();
        }
        do {
            i = readFloat();
            if (i < upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public float readFloatLessOrEqualThan(float upperBound) {
        float i;
        do {
            i = readFloat();
            if (i > upperBound) {
                System.out.println("El dato debe ser menor o igual que " + upperBound);
            }
        } while (!(i <= upperBound));
        return i;
    }

    public float readFloatGreaterThan(float cantidad) {
        float i;
        if (Float.MAX_VALUE == cantidad) {
            throw new NumberFormatException("El int introducido por parametro no puede ser 2147483647");
        }
        do {
            i = readFloat();
            if (i <= cantidad) {
                System.out.println("El dato debe ser mayor que " + cantidad);
            }
        } while (!(i > cantidad));
        return i;
    }

    public float readFloatGreaterOrEqualThan(float cantidad) {
        float i;
        do {
            i = readFloat();
            if (i < cantidad) {
                System.out.println("El dato debe ser mayor que " + cantidad);
            }
        } while (!(i >= cantidad));
        return i;

    }

    public float readFloatInRange(float a, float b) {
        float c;
        boolean salir = false;
        do {
            c = readFloat();
            if (c >= a && c <= b) {
                salir = true;
            } else if (c >= b && c <= a) {
                salir = true;
            } else {
                System.out.println("Su dato no esta en el rango. Vuelve a escribirlo");
            }
        } while (!salir);
        return c;

    }
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Hecho con los double
    public double readDouble() {
        double resultado = 0.0;
        boolean salida = false;
        do {
            try {
                System.out.print("\n-> ");
                resultado = sc.nextDouble();
                salida = true;
            } catch (Exception e) {
                System.err.println("Introduce el valor bien(double)");
            } finally {
                cleanInput();
            }
        } while (!salida);
        return resultado;
    }

    public double readDouble(String frase) {
        System.out.print(frase);
        return readDouble();
    }

    public double readDoubletLessThan(double upperBound) {
        double i;
        boolean salir = false;
        if (Double.MIN_VALUE == upperBound) {
            throw new NumberFormatException();
        }
        do {
            i = readDouble();
            if (i < upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public double readDoubleLessOrEqualThan(double upperBound) {
        double i;
        boolean salir = false;
        do {
            i = readDouble();
            if (i <= upperBound) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + upperBound);
            }
        } while (!salir);
        return i;
    }

    public double readDoubleGreaterThan(double cantidad) {
        double i;
        boolean salir = false;
        if (Double.MAX_VALUE == cantidad) {
            throw new NumberFormatException();
        }
        do {
            i = readDouble();
            if (i > cantidad) {
                salir = true;
            } else {
                System.out.println("El dato debe ser mayor que " + cantidad);
            }
        } while (!salir);
        return i;
    }

    public double readDoubleGreaterOrEqualThan(double cantidad) {
        return readDoubleGreaterOrEqualThan(cantidad, "");
    }

    public double readDoubleGreaterOrEqualThan(double cantidad, String frase) {
        double i;
        boolean salir = false;
        do {
            i = readDouble(frase);
            if (i >= cantidad) {
                salir = true;
            } else {
                System.out.println("El dato debe ser menor que " + cantidad);
            }
        } while (!salir);
        return i;

    }

    public double readDoubleInRange(double a, double b) {
        double c;
        boolean salir = false;
        do {
            c = readDouble();
            if (c >= a && c <= b) {
                salir = true;
            } else if (c >= b && c <= a) {
                salir = true;
            } else {
                System.out.println("Su dato no esta en el rango. Vuelve a escribirlo");
            }
        } while (!salir);
        return c;
    }
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public char readChar() {
        boolean salir;
        String cadena;
        char resultado = 0;
        do {
            try {
                cadena = readString();
                if (cadena.length() > 1) {
                    System.out.println("Solo se puede introducir un caracter");
                    salir = false;
                } else {
                    resultado = cadena.charAt(0);
                    salir = true;
                }
            } catch (Exception e) {
                System.err.println("Valor invalido");
                salir = false;
            }
        } while (!salir);
        return resultado;
    }

    public char readChar(String validCharacters) {
        if (validCharacters.isEmpty()) {
            throw new ArithmeticException("Cadena vacia");
        }
        char resultado;
        String frase, patter = String.format("[%s]", validCharacters);
        do {
            resultado = readChar();
            frase = String.valueOf(resultado);
        } while (!frase.matches(patter));
        return resultado;
    }

    public char readVowel() {
        char resultado = 0;
        resultado += readChar("aeiouáéíóúAEIOUÁÉÍÓÚ");
        return resultado;
    }

    public char readDigit() {
        char resultado = 0;
        resultado += readChar("0-9");
        return resultado;
    }

    public char readLowerCase() {
        char resultado = 0;
        resultado += readChar("a-záéíóú");
        return resultado;
    }

    public char readUpperCase() {
        char resultado = 0;
        resultado += readChar("A-ZÁÉÍÓÚ");
        return resultado;
    }

    public String readString() {
        String frase;
        boolean exit = false;
        do {
            System.out.print("-> ");
            frase = sc.nextLine();
            if (!frase.isBlank()) {
                exit = true;
            } else {
                System.out.println("Introduce un valor");
            }
        } while (!exit);
        return frase;
    }

    public String readString(String frasesita) {
        System.out.print(frasesita);
        return readString();
    }
    public String readStringTamañoMaximoNoCaracterIngleses(String frasesita,int maximo) {
        if(maximo==0){
            throw new IllegalArgumentException("El numero maximo no puede ser 0");
        }
        System.out.print(frasesita);
        boolean salida;
        String recogida;
        do {
            salida=true;
            recogida=readString(maximo);
            char[] filtro = recogida.toCharArray();
            for (int i=0;i<filtro.length;i++){
                if (!String.valueOf(filtro[i]).matches("[\\x00-\\x7F]")) {
                    salida=false;
                }
            }
            if(!salida){
                System.out.println("No puedes introducir caracteres extraños");
            }
        }while(!salida);
        return recogida;
    }
    public String readString(int maxLength) {
        if (maxLength < 1) {
            throw new IllegalArgumentException();
        }
        String palabra;
        do {
            palabra = readString();
            if (palabra.length() > maxLength) {
                System.out.println("Frase demasiado grande");
            }
        } while (!(palabra.length() <= maxLength));
        return palabra;
    }

    public boolean readBooleanUsingChar(char affirmativeValue) {
        char res, resAuxi, res2Auxi;
        res = readChar();
        resAuxi = Character.toLowerCase(res);
        res2Auxi = Character.toLowerCase(affirmativeValue);
        if (res2Auxi == resAuxi) {
            return true;
        } else {
            return false;
        }
    }

    public boolean readBooleanUsingChar() {
        Character resultado;
        resultado = readChar();
        if (resultado.equals('s') || resultado.equals('S')) {
            return true;
        } else {
            return false;
        }
    }

    public boolean readBooleanUsingChar(char affirmativeValue, char negativeValue) {
        boolean error = true;
        char dato;
        String frase1 = String.valueOf(affirmativeValue), frase2 = String.valueOf(negativeValue), frase3;
        do {
            dato = readChar();
            frase3 = String.valueOf(dato);
            if (frase3.equalsIgnoreCase(frase1)) {
                error = false;
            } else if (frase3.equalsIgnoreCase(frase2)) {
                return false;
            }
        } while (error);
        return true;
    }

    public boolean readBooleanUsingInt(int affirmativeValue) {
        int numero;
        numero = readInt();
        if (numero == affirmativeValue) {
            return true;
        } else {
            return false;
        }
    }

    public boolean readBooleanUsingInt(int affirmativeValue, int negativeValue) {
        boolean error = true;
        do {
            int dato;
            dato = readInt();
            if (dato == affirmativeValue) {
                error = false;
            } else if (dato == negativeValue) {
                return false;
            }
        } while (error);

        return true;
    }

    public boolean readBooleanUsingString(String affirmativeValue, String negativeValue) {
        return readBooleanUsingString(affirmativeValue, negativeValue, "");
    }

    public boolean readBooleanUsingString(String affirmativeValue, String negativeValue, String frase) {
        boolean error = true;
        String dato;
        do {
            dato = readString(frase);
            if (dato.equalsIgnoreCase(affirmativeValue)) {
                error = false;
            } else if (dato.equalsIgnoreCase(negativeValue)) {
                return false;
            }
        } while (error);

        return true;
    }
}


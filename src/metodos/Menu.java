
package metodos;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18danielmr
 */
public class Menu {
    
    public static int principal(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_HIBERNATE***\n"
                + "1. Altas\n"
                + "2. Bajas\n"
                + "3. Modificaciones\n"
                + "4. Listados\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int altas(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_ALTAS***\n"
                + "1. Empresa\n"
                + "2. Coche\n"
                + "3. Uso\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    
    public static int bajas(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_BAJAS***\n"
                + "1. Coche de Alquiler\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int modificar(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_MODIFICAR***\n"
                + "1. Coche de Venta\n"
                + "2. Coche de Alquiler\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int listados(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_LISTADOS***\n"
                + "1. Todas las empresas con sus coches\n"
                + "2. Una empresa determinada con sus coches\n"
                + "3. Importe total recaudado por un coche de alquiler\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int confirmacion(BufferedReader lee, String mensaje) throws IOException {
        int op;
        System.out.println(mensaje + "\n"
                + "1. Si\n"
                + "2. No");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
}

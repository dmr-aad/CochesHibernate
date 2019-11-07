package metodos;

import clases.Coche;
import clases.CocheAlquiler;
import clases.CocheVenta;
import clases.Empresa;
import cocheshibernate.NewHibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author a18danielmr
 */
public class Altas {
    
    public int codVenta = 0;
    public int codAlquiler = 0;

    public static void empresas(BufferedReader lee) throws IOException {
        String cif, nombre;
        int telefono, op;
        Coche c;
        do {
            System.out.println("Introduce el cif");
            cif = lee.readLine();
        } while (!Validaciones.cif(cif));
        System.out.println("Introduce el nombre");
        nombre = lee.readLine();
        System.out.println("Introduce el telefono");
        telefono = Integer.parseInt(lee.readLine());
        Empresa e = new Empresa(cif, nombre, telefono);
        op = Menu.confirmacion(lee, "¿Quiere añadir coches a esta empresa?");
        if (op == 1) {
            //añadir coches
        }
        guardarModificar(e);
    }
    
    public static void coche(BufferedReader lee) throws IOException {
        String marca, modelo, codigo;
        Empresa e;
        do {            
            System.out.println("Introduce el código (V para venta // A para alquiler)");
            codigo = lee.readLine();
        } while (!Validaciones.coche(codigo));
        System.out.println("Introduce la marca");
        marca = lee.readLine();
        System.out.println("Introduce el modelo");
        modelo = lee.readLine();
        switch (codigo.charAt(0)) {
            case 'V':
                //cocheVenta
                break;
            case 'A':
                //cocheAlquiler
                break;
        }
    }
    
    public static void cocheVenta(String codigo, String marca, String modelo, BufferedReader lee) throws IOException {
        float precio;
        System.out.println("Introduce el precio de venta del coche");
        precio = Float.parseFloat(lee.readLine());
        
        CocheVenta ca = new CocheVenta(precio, codigo, marca, modelo);
    }

    public static void guardarModificar(Object objeto) {
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    
}

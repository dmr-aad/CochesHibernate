package metodos;

import clases.Coche;
import clases.CocheAlquiler;
import clases.CocheVenta;
import clases.Empresa;
import clases.Uso;
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

    public static void main(BufferedReader lee) throws IOException {
        int op;
        op = Menu.altas(lee);
        switch (op) {
            case 1:
                empresa(lee);
                break;
            case 2:
                coche(lee);
                break;
            case 3:
                uso(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }

    public static void empresa(BufferedReader lee) throws IOException {
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
        guardarModificar(e);
        do {            
            op = Menu.confirmacion(lee, "¿Quiere añadir coches a esta empresa?");
            if (op == 1) {
                añadirCoche(e, lee);
            }
        } while (op == 1);
    }

    public static void añadirCoche(Empresa e, BufferedReader lee) throws IOException {
        String marca, modelo, codigo;
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
                CocheVenta cv = añadirCocheVenta(codigo, marca, modelo, e, lee);
                e.getCoches().add(cv);
                break;
            case 'A':
                CocheAlquiler ca = añadirCocheAlquiler(codigo, marca, modelo, e, lee);
                e.getCoches().add(ca);
                break;
        }
    }
    
    public static CocheVenta añadirCocheVenta(String codigo, String marca, String modelo, Empresa e, BufferedReader lee) throws IOException {
        float precio;
        System.out.println("Introduce el precio de venta del coche");
        precio = Float.parseFloat(lee.readLine());
        CocheVenta cv = new CocheVenta(precio, codigo, marca, modelo);
        cv.setEmpresa(e);
        guardarModificar(cv);
        return cv;
    } 

    public static CocheAlquiler añadirCocheAlquiler(String codigo, String marca, String modelo, Empresa e, BufferedReader lee) throws IOException {
        float precio;
        char estado;
        System.out.println("Introduce el precio de alquiler del coche");
        precio = Float.parseFloat(lee.readLine());
        estado = 'L';
        CocheAlquiler ca = new CocheAlquiler(precio, estado, codigo, marca, modelo);
        ca.setEmpresa(e);
        guardarModificar(ca);
        return ca;
    }

    public static void coche(BufferedReader lee) throws IOException {
        int op;
        if (Comprobar.existeEmpresa()) {
            String marca, modelo, codigo, cif;
            Empresa e;
            do {
                System.out.println("Introduce el código (V para venta // A para alquiler)");
                codigo = lee.readLine();
            } while (!Validaciones.coche(codigo));
            System.out.println("Introduce la marca");
            marca = lee.readLine();
            System.out.println("Introduce el modelo");
            modelo = lee.readLine();
            Visualizar.empresas();
            do {
                System.out.println("Introduce el codigo de la empresa a la que pertenece: ");
                cif = lee.readLine();
                e = Recuperar.empresa(cif);
                if (e == null) {
                    System.out.println("No existe ninguna empresa con ese código");
                }
            } while (e == null);
            switch (codigo.charAt(0)) {
                case 'V':
                    cocheVenta(codigo, marca, modelo, e, lee);
                    break;
                case 'A':
                    cocheAlquiler(codigo, marca, modelo, e, lee);
                    break;
            }
        } else {
            System.out.println("Aún no se ha dado de alta ninguna empresa");
            op = Menu.confirmacion(lee, "¿Desea crearla?");
            if (op == 1) {
                empresa(lee);
            }
        }
    }

    public static void cocheVenta(String codigo, String marca, String modelo, Empresa e, BufferedReader lee) throws IOException {
        float precio;
        System.out.println("Introduce el precio de venta del coche");
        precio = Float.parseFloat(lee.readLine());
        CocheVenta cv = new CocheVenta(precio, codigo, marca, modelo);
        cv.setEmpresa(e);
        guardarModificar(cv);
    } 

    public static void cocheAlquiler(String codigo, String marca, String modelo, Empresa e, BufferedReader lee) throws IOException {
        float precio;
        char estado;
        System.out.println("Introduce el precio de alquiler del coche");
        precio = Float.parseFloat(lee.readLine());
        estado = 'L';
        CocheAlquiler ca = new CocheAlquiler(precio, estado, codigo, marca, modelo);
        ca.setEmpresa(e);
        guardarModificar(ca);
    }
    
    public static void uso(BufferedReader lee) throws IOException {
        if (Comprobar.existeCocheAlquiler()) {
            java.util.Date fechaAlquiler;
            java.util.Date fechaEntrega;
            int diasAlquilado;
            float importe;
            String cod_ca, fAlquiler, fEntrega;
            CocheAlquiler ca;
            System.out.println("Introduce la fecha de alquiler (dd/MM/yyyy)");
            fAlquiler = lee.readLine();
            System.out.println("Introduce la fecha de entrega (dd/MM/yyyy)");
            fEntrega = lee.readLine();
            fechaAlquiler = Funciones.convertirFecha(fAlquiler);
            fechaEntrega = Funciones.convertirFecha(fEntrega);
            
            diasAlquilado = Funciones.restarDias(fechaEntrega, fechaAlquiler);
            
            java.sql.Date fechaAlquilerSQL = new java.sql.Date(fechaAlquiler.getTime());
            java.sql.Date fechaEntregaSQL = new java.sql.Date(fechaEntrega.getTime());
            Visualizar.cochesAlquiler();
            System.out.println("Introduce el codigo del coche de alquiler");
            cod_ca = lee.readLine();
            ca = Recuperar.cocheAlquiler(cod_ca);
            importe = (float) (ca.getPrecio() * diasAlquilado);
            
            Uso u = new Uso(fechaAlquilerSQL, fechaEntregaSQL, importe);
            //registro el coche en el uso
            u.setCoche(ca);
            //guardo el uso
            guardarModificar(u);
        } else {
            System.out.println("No hay coches de alquiler disponibles");
        }
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

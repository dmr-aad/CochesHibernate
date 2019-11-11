
package metodos;

import clases.CocheAlquiler;
import clases.Empresa;
import cocheshibernate.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author a18danielmr
 */
public class Visualizar {
    
    public static void empresas() {
        try {
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            List<Empresa> empresas = sesion.createCriteria(Empresa.class).list();
            sesion.close();
            if (!empresas.isEmpty()) {
                System.out.println("cif\t\tnombre\t\ttelefono");
                for (Empresa empresa : empresas) {
                    System.out.println(empresa.getCif() + "\t\t" + empresa.getNombre() + "\t\t" + empresa.getTelefono());
                }
            } else {
                System.out.println("No hay empresas");
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cochesAlquiler() {
        try {
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            List<CocheAlquiler> coches = sesion.createCriteria(CocheAlquiler.class).list();
            sesion.close();
            if (!coches.isEmpty()) {
                System.out.println("codigo\t\tmarca\t\tmodelo\t\tprecio\t\testado");
                for (CocheAlquiler coche : coches) {
                    System.out.println(coche.getCodigo() + "\t\t" + coche.getMarca() + "\t\t" + coche.getModelo() + "\t\t" + coche.getPrecio() + "\t\t" + coche.getEstado());
                }
            } else {
                System.out.println("No hay coches de alquiler");
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}

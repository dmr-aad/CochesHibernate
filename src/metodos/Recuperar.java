
package metodos;

import clases.CocheAlquiler;
import clases.Empresa;
import cocheshibernate.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author a18danielmr
 */
public class Recuperar {
    
    public static Empresa empresa(String cif) {
        Session sesion;
        Empresa e = null;
        try {
            sesion = NewHibernateUtil.getSession();
            e = (Empresa) sesion.get(Empresa.class, cif);
            sesion.close();
        } catch(HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return e;
    }
    
    public static CocheAlquiler cocheAlquiler(String cod) {
        Session sesion;
        CocheAlquiler ca = null;
        try {
            sesion = NewHibernateUtil.getSession();
            ca = (CocheAlquiler) sesion.get(CocheAlquiler.class, cod);
            sesion.close();
        } catch(HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return ca;
    }
}

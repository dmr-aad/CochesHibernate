
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
public class Comprobar {
    
    public static boolean existeEmpresa(){
        boolean existe = false;
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            List<Object> empresas = sesion.createCriteria(Empresa.class).list();
            if (!empresas.isEmpty()){
                existe = true;
            }
        } catch(HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;
    }
    
    public static boolean existeCocheAlquiler() {
        boolean existe = false;
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            List<Object> cochesAlquiler = sesion.createCriteria(CocheAlquiler.class).list();
            if (!cochesAlquiler.isEmpty()){
                existe = true;
            }
        } catch(HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;
    }
}

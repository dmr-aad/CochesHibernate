
package metodos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author a18danielmr
 */
public class Funciones {
    
    public static int restarDias(Date fechaFin, Date fechaInicial) {
        int diferencia = (int) ((fechaFin.getTime() - fechaInicial.getTime())/86400000);
        return diferencia;
    }
    
    public static Date convertirFecha(String fecha) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaRetorno = null;
        try {
            fechaRetorno = df.parse(fecha);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return fechaRetorno;
    }
}

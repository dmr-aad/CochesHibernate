
package cocheshibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import metodos.Altas;
import metodos.Creacion;
import metodos.Menu;

/**
 *
 * @author a18danielmr
 */
public class CochesHibernate {

    static Connection conex;
    static Statement s;
    static ResultSet rs;
    
    public static void main(String[] args) throws IOException {
        String url = "jdbc:mysql://localhost:3307/?user=root&password=usbw";
        int op;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        try {
            conex = DriverManager.getConnection(url);
            s = conex.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
        try {
            if (!s.executeQuery("SHOW DATABASES LIKE 'cochesdanihibernate'").first()) {
                Creacion.crearTablas(s);
            } else {
                s.execute("USE cochesdanihibernate");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(2);
        }

        NewHibernateUtil.getSessionFactory();
        
        do {
            op = Menu.principal(lee);
            switch (op) {
                case 1:
                    Altas.main(lee);
                    break;
                case 2:
                    System.out.println("En construcción");
                    break;
                case 3:
                    System.out.println("En construcción");
                    break;
                case 4:
                    System.out.println("En construcción");
                    break;
                case 0:
                    NewHibernateUtil.getSessionFactory().close();
                    System.out.println("SALIENDO...");
                    break;
            }
        } while (op != 0);
    }
    
}

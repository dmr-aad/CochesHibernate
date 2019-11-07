
package metodos;

import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author a18danielmr
 */
public class Creacion {
    
    public static void crearTablas(Statement sentencia) {
        try {
            sentencia.execute("CREATE DATABASE IF NOT EXISTS cochesdanihibernate");
            
            sentencia.execute("USE cochesdanihibernate");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS empresas("
                    + " cif         CHAR(9) NOT NULL, "
                    + " nombre      VARCHAR(15) NOT NULL,"
                    + " telefono    CHAR(9) NOT NULL,"
                    + " PRIMARY KEY(cif)"
                    + ")"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS coches("
                    + " codigo      CHAR(4) NOT NULL,"
                    + " marca       VARCHAR(10) NOT NULL,"
                    + " modelo      VARCHAR(10) NOT NULL,"
                    + " cif     CHAR(9) NOT NULL,"
                    + " PRIMARY KEY(codigo),"
                    + " CONSTRAINT FK1_EMPRESA"
                    + "     FOREIGN KEY (cif) REFERENCES EMPRESAS (cif)"
                    + "         ON DELETE CASCADE ON UPDATE CASCADE,"
                    + " INDEX FK1_EMPRESA(cif)"
                    + ")"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS cochesAlquiler("
                    + " codigo      CHAR(4) NOT NULL,"
                    + " precio      FLOAT NOT NULL,"
                    + " estado      CHAR(1) NOT NULL,"
                    + " PRIMARY KEY(codigo),"
                    + " CONSTRAINT FK1_COCHE"
                    + "     FOREIGN KEY (codigo) REFERENCES COCHES (codigo)"
                    + "         ON DELETE CASCADE ON UPDATE CASCADE,"
                    + " INDEX FK1_COCHE(codigo)"
                    + ")"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS cochesVenta("
                    + " codigo      CHAR(4) NOT NULL,"
                    + " precio      FLOAT NOT NULL,"
                    + " PRIMARY KEY(codigo),"
                    + " CONSTRAINT FK2_COCHE"
                    + "     FOREIGN KEY (codigo) REFERENCES COCHES (codigo)"
                    + "         ON DELETE CASCADE ON UPDATE CASCADE,"
                    + " INDEX FK2_COCHE(codigo)"
                    + ")"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS usos("
                    + " codigo          CHAR(4) NOT NULL,"
                    + " fechaAlquiler    DATE NOT NULL,"
                    + " fechaEntrega    DATE NOT NULL,"
                    + " importe     FLOAT NOT NULL,"
                    + " PRIMARY KEY(fechaAlquiler, codigo),"
                    + " CONSTRAINT FK3_COCHE"
                    + "     FOREIGN KEY (codigo) REFERENCES COCHES (codigo)"
                    + "         ON DELETE CASCADE ON UPDATE CASCADE,"
                    + " INDEX FK3_COCHE(codigo)"
                    + ")"
                    + "ENGINE INNODB;");
        } catch (SQLException e) {
            System.out.println("\nAVISO: Ha surgido un problema a la hora de generar las tablas:\n" + e);
        }
    }
}

package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDaoImp {
    public static Connection getConexion() throws Exception {
        Connection Con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      
        Con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" 
                + "databaseName=Saneamiento_RDR;" + "user=sa;" 
                        + "password=1234;");
        return Con;
    }
}

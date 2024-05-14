package Datos;

import java.sql.SQLException;

public interface LoginDao extends General{
    public Login buscarIdLogin(Object id) throws SQLException;
    public int Logeo(Object user, Object password) throws SQLException;
    public Login buscarPersonal(Object id) throws SQLException;
}

package Datos;

import java.sql.SQLException;

public interface General {
    public boolean grabar(Object object) throws SQLException;
    public boolean eliminar(Object object) throws SQLException;
    public boolean modificar(Object object) throws SQLException;
}

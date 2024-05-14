package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CajaDao extends General{
    public ArrayList obtenerListaRecibo(Object idVivienda) throws SQLException;
    public int buscarTicket(Object ticket) throws SQLException;
    public double reportMensualSan(Object anio, Object mes) throws SQLException;
}

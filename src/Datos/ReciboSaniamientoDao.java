package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReciboSaniamientoDao extends General{
    public ArrayList obtenerListaRecibo(Object idVivienda) throws SQLException;
    public double obtenerDeudaAnterior(Object idVivienda) throws SQLException;
    public ArrayList obtenerDatosImprimir() throws SQLException;
    public boolean buscarRecibosGenerados() throws SQLException;
    public void generarRecibos() throws SQLException;
    public int ultimoTicketGenerado() throws SQLException;
    public void actualizarTicket(Object ticket, Object idRecibo) throws SQLException;
    public ArrayList obtenerRecibosSinTicket() throws SQLException;
    public ArrayList mostrarCorte() throws SQLException;
}

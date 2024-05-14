package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class ReciboSaniamientoDaoImp implements ReciboSaniamientoDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private ReciboSaniamiento objR;

    public ReciboSaniamientoDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objR = (ReciboSaniamiento) object;
        try {
            String sql = "insert into ReciboSaniamiento (anio, estadoPago, fechaPagoCaja, mes, fechaEmision, fechaPago, ticket, "
                    + "idVivienda, impAgua, impBP) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, objR.getAnio());
            pst.setString(2, objR.getEstadoPago());
            pst.setString(3, objR.getFechaPagoCaja());
            pst.setString(4, objR.getMes());
            pst.setString(5, objR.getFechaEmision());
            pst.setString(6, objR.getFechaPago());
            pst.setString(7, objR.getTicket());
            pst.setInt(8, objR.getObjVivienda().getIdVivienda());
            pst.setDouble(9, objR.getImpAgua());
            pst.setDouble(10, objR.getImopBP());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object idReciboSaniamiento) throws SQLException {
        try {
            String sql = "UPDATE ReciboSaniamiento SET estadoPago=?, fechaPagoCaja=? where idRecSania = " + (Integer) idReciboSaniamiento;
            pst = con.prepareStatement(sql);
            pst.setString(1, "Pago");
            pst.setString(2, cargarFecha());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaRecibo(Object idVivienda) throws SQLException {
        ArrayList<ReciboSaniamiento> ltsReciboSaniamiento = new ArrayList();
        try {
            String sql = "SELECT * FROM ReciboSaniamiento where anio = YEAR(GETDATE()) and idVivienda = " + (Integer) idVivienda;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objR = new ReciboSaniamiento();
                objR.setIdRecibo(rs.getInt(1));
                objR.setAnio(rs.getInt(2));
                objR.setEstadoPago(rs.getString(3));
                objR.setFechaPagoCaja(rs.getString(4));
                objR.setMes(rs.getString(5));
                objR.setFechaEmision(rs.getString(6));
                objR.setFechaPago(rs.getString(7));
                objR.setTicket(rs.getString(8));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objR.setObjVivienda(objV.buscarIdVivienda(rs.getInt(9)));
                objR.setImpAgua(rs.getDouble(10));
                objR.setImopBP(rs.getDouble(11));
                ltsReciboSaniamiento.add(objR);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsReciboSaniamiento;
    }

    @Override
    public double obtenerDeudaAnterior(Object idVivienda) throws SQLException {
        double deuda = 0;
        try {
            String sql = "select sum(impAgua) from ReciboSaniamiento where anio != YEAR(GETDATE()) and estadoPago = 'No Pago' and idVivienda = " + (Integer) idVivienda;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                deuda += rs.getDouble(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return deuda;
    }

    @Override
    public ArrayList obtenerDatosImprimir() throws SQLException {
        ArrayList<String> ltsDatos = new ArrayList();
        try {
            String sql = "IF (SELECT DAY(GETDATE())) >= 15 "
                    + "BEGIN "
                    + " select (case MONTH(GETDATE()) when 1 then 'ENERO' "
                    + " when 2 then 'FEBRERO' when 3 then 'MARZO' when 4 then 'ABRIL' "
                    + " when 5 then 'MAYO' when 6 then 'JUNIO' when 7 then 'JULIO' "
                    + " when 8 then 'AGOSTO' when 9 then 'SETIEMBRE' when 10 then 'OCTUBRE' "
                    + " when 11 then 'NOVIEMBRE' when 12 then 'DICIEMBRE' "
                    + " else '' END) , DATEADD(DAY, 15, EOMONTH(GETDATE(), -1)), DATEADD(DAY, 14, EOMONTH(GETDATE())) "
                    + "END "
                    + "ELSE "
                    + "BEGIN "
                    + " select (case MONTH(EOMONTH(GETDATE(), -1)) when 1 then 'ENERO' "
                    + " when 2 then 'FEBRERO' when 3 then 'MARZO' when 4 then 'ABRIL' "
                    + "	when 5 then 'MAYO' when 6 then 'JUNIO' when 7 then 'JULIO' "
                    + "	when 8 then 'AGOSTO' when 9 then 'SETIEMBRE' when 10 then 'OCTUBRE' "
                    + "	when 11 then 'NOVIEMBRE' when 12 then 'DICIEMBRE'  "
                    + "	else '' END) , DATEADD(DAY, 15, EOMONTH(GETDATE(), -2)), DATEADD(DAY, 14, EOMONTH(GETDATE(), -1)) "
                    + "END ";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ltsDatos.add(rs.getString(1));
                ltsDatos.add(rs.getString(2));
                ltsDatos.add(rs.getString(3));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDatos;
    }

    @Override
    public boolean buscarRecibosGenerados() throws SQLException {
        boolean estado = true;
        try {
            String sql = "select * from ReciboSaniamiento where anio = YEAR(GETDATE()) AND mes = (case MONTH(GETDATE()) when 1 then 'ENERO' "
                    + "when 2 then 'FEBRERO' when 3 then 'MARZO' when 4 then 'ABRIL' when 5 then 'MAYO' when 6 then 'JUNIO' when 7 then 'JULIO' "
                    + "when 8 then 'AGOSTO' when 9 then 'SETIEMBRE' when 10 then 'OCTUBRE' when 11 then 'NOVIEMBRE' when 12 then 'DICIEMBRE' else '' END)";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                estado = false;
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return estado;
    }

    @Override
    public void generarRecibos() throws SQLException {
        try {
            String sql = "EXEC CrearRecibos";
            pst = con.prepareStatement(sql);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int ultimoTicketGenerado() throws SQLException {
        int ticket = 0;
        try {
            String sql = "select CASE WHEN MAX(CONVERT(INT, ticket)) IS NULL THEN 1000 ELSE MAX(CONVERT(INT, ticket)) end from ReciboSaniamiento";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ticket = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ticket;
    }

    @Override
    public void actualizarTicket(Object ticket, Object idRecibo) throws SQLException {
        try {
            String sql = "if(select ticket from ReciboSaniamiento where idRecSania = " + (Integer) idRecibo + ") is null "
                    + " begin "
                    + "   update ReciboSaniamiento set ticket = '" + String.valueOf(ticket) + "' where idRecSania = " + (Integer) idRecibo
                    + " end";
            pst = con.prepareStatement(sql);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerRecibosSinTicket() throws SQLException {
        ArrayList<ReciboSaniamiento> ltsReciboSaniamiento = new ArrayList();
        try {
            String sql = "select * from ReciboSaniamiento where fechaEmision = DATEADD(DAY, 15, EOMONTH(GETDATE(), -1)) and "
                    + "fechaPago = DATEADD(DAY, 14, EOMONTH(GETDATE())) and ticket is null";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objR = new ReciboSaniamiento();
                objR.setIdRecibo(rs.getInt(1));
                objR.setAnio(rs.getInt(2));
                objR.setEstadoPago(rs.getString(3));
                objR.setFechaPagoCaja(rs.getString(4));
                objR.setMes(rs.getString(5));
                objR.setFechaEmision(rs.getString(6));
                objR.setFechaPago(rs.getString(7));
                objR.setTicket(rs.getString(8));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objR.setObjVivienda(objV.buscarIdVivienda(rs.getInt(9)));
                objR.setImpAgua(rs.getDouble(10));
                objR.setImopBP(rs.getDouble(11));
                ltsReciboSaniamiento.add(objR);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsReciboSaniamiento;
    }
    
    @Override
    public ArrayList mostrarCorte() throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        Vivienda objV = null;
        try {
            String sql = "SELECT idVivienda, count(idVivienda), STRING_AGG(' ' + LEFT(mes, 3), ', ') "
                    + "FROM ReciboSaniamiento WHERE estadoPago = 'No pago' AND "
                    + "fechaEmision <= DATEADD(DAY, 15, EOMONTH(GETDATE(), -2)) GROUP BY idVivienda";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objV = objViv.buscarIdVivienda(rs.getInt(1));
                objV.setMesesDebe(rs.getInt(2));
                objV.setMeses(rs.getString(3));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }
    
    private String cargarFecha() {
        Calendar cal = Calendar.getInstance();
        Timestamp fecha_hora = new Timestamp(cal.getTimeInMillis());
        String fechaSistema = String.valueOf(fecha_hora);
        return fechaSistema.substring(0, 10);
    }    
}

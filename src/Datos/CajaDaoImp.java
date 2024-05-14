package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CajaDaoImp implements CajaDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Caja objC;

    public CajaDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objC = (Caja) object;
        try {
            String sql = "insert into Caja (fechaPago, pago, descuento, totalPago, idVivienda) "
                    + "values (?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objC.getFechaPago());
            pst.setDouble(2, objC.getPago());
            pst.setDouble(3, objC.getDescuento());
            pst.setDouble(4, objC.getTotalPago());
            pst.setInt(5, objC.getObjV().getIdVivienda());
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
    public boolean modificar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList obtenerListaRecibo(Object idVivienda) throws SQLException {
        ArrayList<ReciboSaniamiento> ltsReciboSaniamiento = new ArrayList();
        ReciboSaniamiento objR = null;
        try {
            String sql = "SELECT * FROM ReciboSaniamiento where estadoPago = 'No Pago' and idVivienda = " + (Integer) idVivienda;
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
    public int buscarTicket(Object ticket) throws SQLException {
        int idVivienda = 0;
        try {
            String sql = "SELECT idVivienda FROM ReciboSaniamiento where ticket = '" + String.valueOf(ticket) + "'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idVivienda = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return idVivienda;
    }

    @Override
    public double reportMensualSan(Object anio, Object mes) throws SQLException {
        double pagoMensualReporte = 0;
        try {
            String sql = "SELECT SUM(Ca.totalPago) AS SumaPagos FROM Caja Ca INNER JOIN Vivienda V ON Ca.idVivienda = V.idVivienda INNER JOIN Contribuyente C ON "
                    + "V.idContribuyente = C.idContribuyente WHERE YEAR(Ca.fechaPago) = " + (Integer) anio + " AND MONTH(Ca.fechaPago) = "
                    + (Integer) mes + " GROUP BY YEAR(Ca.fechaPago), MONTH(Ca.fechaPago);";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                pagoMensualReporte = rs.getDouble(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return pagoMensualReporte;
    }
}

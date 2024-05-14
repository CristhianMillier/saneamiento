package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class TipDocDaoImp implements TipDocDao{
    
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private TipDoc objT;

    public TipDocDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void obtenerListaComboTipDoc(JComboBox<TipDoc> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM TipoDocumento where estado = 'Si' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objT = new TipDoc();
                objT.setIdTipDoc(rs.getInt(1));
                objT.setNombre(rs.getString(2));
                jComboBox.addItem(objT);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public TipDoc buscarIdTipDoc(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM TipoDocumento where idTipDoc = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objT = new TipDoc();
                objT.setIdTipDoc(rs.getInt(1));
                objT.setNombre(rs.getString(2));
                objT.setEstado(rs.getString(3));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objT;
    }
}

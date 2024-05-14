package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoViviendaDaoImp implements TipoViviendaDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private TipoVivienda objTV;

    public TipoViviendaDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objTV = (TipoVivienda) object;
        try {
            String sql = "insert into TipoVivienda (descripcion, tipo, impAgua, impBP, estado) "
                    + "values (?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objTV.getDescripcion());
            pst.setInt(2, objTV.getTipo());
            pst.setDouble(3, objTV.getImpAgua());
            pst.setDouble(4, objTV.getImpBP());
            pst.setString(5, objTV.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objTV = (TipoVivienda) object;
        try {
            String sql = "UPDATE TipoVivienda SET estado=? where idTipVivienda = " + objTV.getIdTipViv();
            pst = con.prepareStatement(sql);
            pst.setString(1, "No");
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objTV = (TipoVivienda) object;
        try {
            String sql = "UPDATE TipoVivienda SET descripcion=?, tipo=?, impAgua=?, impBP=?, "
                    + "estado=? where idTipVivienda = " + objTV.getIdTipViv();
            pst = con.prepareStatement(sql);
            pst.setString(1, objTV.getDescripcion());
            pst.setInt(2, objTV.getTipo());
            pst.setDouble(3, objTV.getImpAgua());
            pst.setDouble(4, objTV.getImpBP());
            pst.setString(5, objTV.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerComercial() throws SQLException {
        ArrayList<TipoVivienda> ltsTipoVivienda = new ArrayList();
        try {
            String sql = "SELECT * FROM TipoVivienda where tipo = 2 order by descripcion";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTV = new TipoVivienda();
                objTV.setIdTipViv(rs.getInt(1));
                objTV.setDescripcion(rs.getString(2));
                objTV.setTipo(rs.getInt(3));
                objTV.setImpAgua(rs.getDouble(4));
                objTV.setImpBP(rs.getDouble(5));
                objTV.setEstado(rs.getString(6));
                ltsTipoVivienda.add(objTV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsTipoVivienda;
    }

    @Override
    public ArrayList obtenerResidencial() throws SQLException {
        ArrayList<TipoVivienda> ltsTipoVivienda = new ArrayList();
        try {
            String sql = "SELECT * FROM TipoVivienda where tipo = 1 order by descripcion";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTV = new TipoVivienda();
                objTV.setIdTipViv(rs.getInt(1));
                objTV.setDescripcion(rs.getString(2));
                objTV.setTipo(rs.getInt(3));
                objTV.setImpAgua(rs.getDouble(4));
                objTV.setImpBP(rs.getDouble(5));
                objTV.setEstado(rs.getString(6));
                ltsTipoVivienda.add(objTV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsTipoVivienda;
    }

    @Override
    public void obtenerComboComercial(JComboBox<TipoVivienda> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM TipoVivienda where estado = 'Si' and tipo = 2 order by descripcion";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTV = new TipoVivienda();
                objTV.setIdTipViv(rs.getInt(1));
                objTV.setDescripcion(rs.getString(2));
                objTV.setTipo(rs.getInt(3));
                objTV.setImpAgua(rs.getDouble(4));
                objTV.setImpBP(rs.getDouble(5));
                objTV.setEstado(rs.getString(6));
                jComboBox.addItem(objTV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void obtenerComboResidencial(JComboBox<TipoVivienda> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM TipoVivienda where estado = 'Si' and tipo = 1 order by descripcion";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTV = new TipoVivienda();
                objTV.setIdTipViv(rs.getInt(1));
                objTV.setDescripcion(rs.getString(2));
                objTV.setTipo(rs.getInt(3));
                objTV.setImpAgua(rs.getDouble(4));
                objTV.setImpBP(rs.getDouble(5));
                objTV.setEstado(rs.getString(6));
                jComboBox.addItem(objTV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public TipoVivienda buscarIdTipVivienda(Object id) throws SQLException {
        objTV = null;
        try {
            String sql = "SELECT * FROM TipoVivienda where idTipVivienda = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTV = new TipoVivienda();
                objTV.setIdTipViv(rs.getInt(1));
                objTV.setDescripcion(rs.getString(2));
                objTV.setTipo(rs.getInt(3));
                objTV.setImpAgua(rs.getDouble(4));
                objTV.setImpBP(rs.getDouble(5));
                objTV.setEstado(rs.getString(6));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objTV;
    }

    @Override
    public boolean buscarDescripcion(Object descripcion) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM TipoVivienda where descripcion = '" + (String) descripcion + "'";
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
    public ArrayList buscarTipoViviendaComercial(Object descripcion) throws SQLException {
        ArrayList<TipoVivienda> ltsTipoVivienda = new ArrayList();
        try {
            String sql = "SELECT * FROM TipoVivienda where descripcion LIKE '" + (String) descripcion + "%' and tipo = 2";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTV = new TipoVivienda();
                objTV.setIdTipViv(rs.getInt(1));
                objTV.setDescripcion(rs.getString(2));
                objTV.setTipo(rs.getInt(3));
                objTV.setImpAgua(rs.getDouble(4));
                objTV.setImpBP(rs.getDouble(5));
                objTV.setEstado(rs.getString(6));
                ltsTipoVivienda.add(objTV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsTipoVivienda;
    }

    @Override
    public ArrayList buscarTipoViviendaResidencial(Object descripcion) throws SQLException {
        ArrayList<TipoVivienda> ltsTipoVivienda = new ArrayList();
        try {
            String sql = "SELECT * FROM TipoVivienda where descripcion LIKE '" + (String) descripcion + "%' and tipo = 1";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTV = new TipoVivienda();
                objTV.setIdTipViv(rs.getInt(1));
                objTV.setDescripcion(rs.getString(2));
                objTV.setTipo(rs.getInt(3));
                objTV.setImpAgua(rs.getDouble(4));
                objTV.setImpBP(rs.getDouble(5));
                objTV.setEstado(rs.getString(6));
                ltsTipoVivienda.add(objTV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsTipoVivienda;
    }
}

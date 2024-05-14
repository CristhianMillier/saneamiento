package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImp implements LoginDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Login objL;

    public LoginDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objL = (Login) object;
        try {
            String sql = "insert into Login (usuario, contrasena, idEmpleado, estado) values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objL.getUsuario());
            pst.setString(2, objL.getPassword());
            pst.setInt(3, objL.getIdEmpleado());
            pst.setString(4, objL.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objL = (Login) object;
        try {
            String sql = "UPDATE Login SET estado=? where idEmpleado = " + objL.getIdEmpleado();
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
        objL = (Login) object;
        try {
            String sql = "UPDATE Login SET usuario=?, contrasena=?, estado=? where idEmpleado = " + objL.getIdEmpleado();
            pst = con.prepareStatement(sql);
            pst.setString(1, objL.getUsuario());
            pst.setString(2, objL.getPassword());
            pst.setString(3, objL.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Login buscarIdLogin(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Login where idLogin = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objL = new Login();
                objL.setIdLogin(rs.getInt(1));
                objL.setUsuario(rs.getString(2));
                objL.setPassword(rs.getString(3));
                objL.setIdEmpleado(rs.getInt(4));
                objL.setEstado(rs.getString(5));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objL;
    }

    @Override
    public int Logeo(Object user, Object password) throws SQLException {
        int idP = 0;
        try {
            String sql = "SELECT idEmpleado FROM Login "
                    + "where usuario = '" + (String) user + "' and contrasena = '" + (String) password + "' and estado = 'Si'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idP = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return idP;
    }
    
    @Override
    public Login buscarPersonal(Object id) throws SQLException {
        try {
            String sql = "SELECT usuario, contrasena FROM Login where idEmpleado = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objL = new Login();
                objL.setUsuario(rs.getString(1));
                objL.setPassword(rs.getString(2));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objL;
    }
}

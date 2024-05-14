package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ContribuyenteDaoImp implements ContribuyenteDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Contribuyente objC;

    public ContribuyenteDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objC = (Contribuyente) object;
        try {
            String sql = "insert into Contribuyente (nombre, apellido, idTipDoc, nroDoc, domicilio, estado) "
                    + "values (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objC.getNmombre());
            pst.setString(2, objC.getApellido());
            pst.setInt(3, objC.getObjTipDoc().getIdTipDoc());
            pst.setString(4, objC.getNroDoc());
            pst.setString(5, objC.getDomicilio());
            pst.setString(6, objC.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean grabarRazonSocial(Object object) throws SQLException {
        objC = (Contribuyente) object;
        try {
            String sql = "insert into Contribuyente (razonSocial, idTipDoc, nroDoc, domicilio, estado) "
                    + "values (?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objC.getRazonSocial());
            pst.setInt(2, objC.getObjTipDoc().getIdTipDoc());
            pst.setString(3, objC.getNroDoc());
            pst.setString(4, objC.getDomicilio());
            pst.setString(5, objC.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objC = (Contribuyente) object;
        try {
            String sql = "UPDATE Contribuyente SET estado=? where idContribuyente = " + objC.getIdContribuyente();
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
        objC = (Contribuyente) object;
        try {
            String sql = "UPDATE Contribuyente SET nombre=?, apellido=?, idTipDoc=?, nroDoc=?, "
                    + "domicilio=?, estado=? where idContribuyente = " + objC.getIdContribuyente();
            pst = con.prepareStatement(sql);
            pst.setString(1, objC.getNmombre());
            pst.setString(2, objC.getApellido());
            pst.setInt(3, objC.getObjTipDoc().getIdTipDoc());
            pst.setString(4, objC.getNroDoc());
            pst.setString(5, objC.getDomicilio());
            pst.setString(6, objC.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificarRazonSocial(Object object) throws SQLException {
        objC = (Contribuyente) object;
        try {
            String sql = "UPDATE Contribuyente SET razonSocial=?, idTipDoc=?, nroDoc=?, "
                    + "domicilio=?, estado=? where idContribuyente = " + objC.getIdContribuyente();
            pst = con.prepareStatement(sql);
            pst.setString(1, objC.getRazonSocial());
            pst.setInt(2, objC.getObjTipDoc().getIdTipDoc());
            pst.setString(3, objC.getNroDoc());
            pst.setString(4, objC.getDomicilio());
            pst.setString(5, objC.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaContribuyente() throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where razonSocial is null order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }

    @Override
    public void obtenerListaCombContribuyente(JComboBox<Contribuyente> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Contribuyente where estado = 'Si'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                jComboBox.addItem(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Contribuyente buscarIdContribuyente(Object id) throws SQLException {
        objC = null;
        try {
            String sql = "SELECT * FROM Contribuyente where idContribuyente = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objC;
    }

    @Override
    public ArrayList buscarDNIContribuyente(Object dni) throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where nroDoc LIKE '" + (String) dni + "%' and razonSocial is null order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }
    
    @Override
    public ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where nroDoc LIKE '" + (String) dni + "%' and apellido is null and nombre is null order by razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }

    @Override
    public ArrayList buscarApellidoContribuyente(Object apellido) throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where apellido LIKE '" + (String) apellido + "%' and razonSocial is null order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }

    @Override
    public ArrayList buscarNombreContribuyente(Object nombre) throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where nombre LIKE '" + (String) nombre + "%' and razonSocial is null order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }

    @Override
    public ArrayList buscarRazonSocialContribuyente(Object nombre) throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where razonSocial LIKE '" + (String) nombre + "%' and apellido is null and nombre is null order by razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }

    @Override
    public boolean buscarDNI(Object DNI) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Contribuyente where nroDoc= '" + String.valueOf(DNI) + "'";
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
    public boolean buscarNombreApellido(Object nombre, Object apellido) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Contribuyente where nombre = '" + String.valueOf(nombre) + "' and apellido = '" + apellido + "'";
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
    public boolean buscarRazonSocial(Object razonSocial) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Contribuyente where razonSocial = '" + String.valueOf(razonSocial) + "'";
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
    public ArrayList obtenerListaContribuyenteRazonSocial() throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where apellido is null and nombre is null order by razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }

    @Override
    public ArrayList buscarRazonSocialContribuyenteDireccion(Object direccion) throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where domicilio LIKE '" + (String) direccion + "%' and apellido is null and nombre is null order by razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }

    @Override
    public ArrayList buscarPersonaContribuyenteDireccion(Object direccion) throws SQLException {
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            String sql = "SELECT * FROM Contribuyente where domicilio LIKE '" + (String) direccion + "%' and razonSocial is null order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Contribuyente();
                objC.setIdContribuyente(rs.getInt(1));
                objC.setNmombre(rs.getString(2));
                objC.setApellido(rs.getString(3));
                objC.setRazonSocial(rs.getString(4));
                TipDocDao objTP = new TipDocDaoImp(con);
                objC.setObjTipDoc(objTP.buscarIdTipDoc(rs.getInt(5)));
                objC.setNroDoc(rs.getString(6));
                objC.setDomicilio(rs.getString(7));
                objC.setEstado(rs.getString(8));
                ltsContribuyente.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsContribuyente;
    }
}

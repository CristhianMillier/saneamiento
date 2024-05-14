package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViviendaDaoImp implements ViviendaDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Vivienda objV;

    public ViviendaDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objV = (Vivienda) object;
        try {
            String sql = "insert into Vivienda (direcion, nroVivienda, idTipVivienda, idContribuyente, estado, impAgua) "
                    + "values (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objV.getDireccion().trim());
            pst.setString(2, objV.getNroVivienda());
            pst.setInt(3, objV.getObjTipViv().getIdTipViv());
            pst.setInt(4, objV.getObjCont().getIdContribuyente());
            pst.setString(5, objV.getEstado());
            pst.setDouble(6, objV.getImpAgua());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objV = (Vivienda) object;
        try {
            String sql = "UPDATE Vivienda SET estado=? where idVivienda = " + objV.getIdVivienda();
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
        objV = (Vivienda) object;
        try {
            String sql = "UPDATE Vivienda SET direcion=?, nroVivienda=?, idTipVivienda=?, idContribuyente=?, "
                    + " estado=?, impAgua=? where idVivienda = " + objV.getIdVivienda();
            pst = con.prepareStatement(sql);
            pst.setString(1, objV.getDireccion());
            pst.setString(2, objV.getNroVivienda());
            pst.setInt(3, objV.getObjTipViv().getIdTipViv());
            pst.setInt(4, objV.getObjCont().getIdContribuyente());
            pst.setString(5, objV.getEstado());
            pst.setDouble(6, objV.getImpAgua());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaContribuyente() throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            String sql = "select V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "from Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente where C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public ArrayList obtenerListaContribuyenteRazonSocial() throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
           String sql = "select V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "from Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente where "
                    + "C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public Vivienda buscarIdVivienda(Object id) throws SQLException {
        objV = null;
        try {
            String sql = "SELECT * FROM Vivienda where idVivienda = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objV;
    }

    @Override
    public ArrayList buscarDNIContribuyente(Object dni) throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            String sql = "select V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "FROM Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.nroDoc LIKE '" + (String) dni + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            String sql = "SELECT V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "FROM Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.nroDoc LIKE '" + (String) dni + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public ArrayList buscarApellidoContribuyente(Object apellido) throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            String sql = "SELECT V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "FROM Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.apellido LIKE '" + (String) apellido + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public ArrayList buscarNombreContribuyente(Object nombre) throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            String sql = "SELECT V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "FROM Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.nombre LIKE '" + (String) nombre + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public ArrayList buscarRazonSocialContribuyente(Object nombre) throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            String sql = "SELECT V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "FROM Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.razonSocial LIKE '" + (String) nombre + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public boolean buscarContribuyenteDomicilio(Object idContribueynte, Object domicilio, Object nro) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Vivienda where idContribuyente = " + (Integer) idContribueynte + " and direcion = '"
                    + String.valueOf(domicilio) + "' and nroVivienda = '" + String.valueOf(nro) + "'";
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
    public ArrayList buscarDireccionContribuyente(Object direccion) throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            String sql = "SELECT V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "FROM Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where V.direcion LIKE '" + (String) direccion + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public ArrayList buscarDireccionRazonSocialContribuyente(Object direccion) throws SQLException {
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            String sql = "SELECT V.idVivienda, v.direcion, V.nroVivienda, V.idTipVivienda, V.idContribuyente, V.estado, V.impAgua "
                    + "FROM Vivienda V inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where V.direcion LIKE '" + (String) direccion + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objV = new Vivienda();
                objV.setIdVivienda(rs.getInt(1));
                objV.setDireccion(rs.getString(2));
                objV.setNroVivienda(rs.getString(3));
                TipoViviendaDao objTV = new TipoViviendaDaoImp(con);
                objV.setObjTipViv(objTV.buscarIdTipVivienda(rs.getInt(4)));
                ContribuyenteDao objTC = new ContribuyenteDaoImp(con);
                objV.setObjCont(objTC.buscarIdContribuyente(rs.getInt(5)));
                objV.setEstado(rs.getString(6));
                objV.setImpAgua(rs.getDouble(7));
                ltsVivienda.add(objV);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsVivienda;
    }

    @Override
    public boolean buscarDomicilio(Object domicilio, Object nro) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Vivienda where direcion = '" + String.valueOf(domicilio) 
                    + "' and nroVivienda = '" + String.valueOf(nro) + "'";
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
}

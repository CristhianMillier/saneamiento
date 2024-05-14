package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MorososDaoImp implements MorososDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Morosos objM;

    public MorososDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objM = (Morosos) object;
        try {
            String sql = "insert into Morosos (meses, deudaActual, deudaAnterior, deudaTotal, idVivienda) "
                    + "values (?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objM.getMeses());
            pst.setDouble(2, objM.getDeudaAct());
            pst.setDouble(3, objM.getDeudaAnt());
            pst.setDouble(4, objM.getDeudaTotal());
            pst.setDouble(5, objM.getObjVivienda().getIdVivienda());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object idVivienda) throws SQLException {
        try {
            String sql = "DELETE FROM Morosos where idVivienda = " + (Integer) idVivienda;
            pst = con.prepareStatement(sql);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objM = (Morosos) object;
        try {
            String sql = "UPDATE Morosos SET meses=?, deudaActual=?, deudaAnterior=?, deudaTotal=?, "
                    + " idVivienda=? where idMoroso = " + objM.getIdMoroso();
            pst = con.prepareStatement(sql);
            pst.setString(1, objM.getMeses());
            pst.setDouble(2, objM.getDeudaAct());
            pst.setDouble(3, objM.getDeudaAnt());
            pst.setDouble(4, objM.getDeudaTotal());
            pst.setDouble(5, objM.getObjVivienda().getIdVivienda());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaMoroso() throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }
    
    @Override
    public ArrayList obtenerListaContribuyenteRazonSocial() throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }

    @Override
    public Morosos buscarIdMorosos(Object id) throws SQLException {
        objM = null;
        try {
            String sql = "SELECT * FROM Morosos where idMoroso = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objM;
    }

    @Override
    public ArrayList buscarDNIContribuyente(Object dni) throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.nroDoc LIKE '" + (String) dni + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }
    
    @Override
    public ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.nroDoc LIKE '" + (String) dni + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }

    @Override
    public ArrayList buscarApellidoContribuyente(Object apellido) throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.apellido LIKE '" + (String) apellido + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }

    @Override
    public ArrayList buscarNombreContribuyente(Object nombre) throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.nombre LIKE '" + (String) nombre + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }

    @Override
    public ArrayList buscarRazonSocialContribuyente(Object nombre) throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.razonSocial LIKE '" + (String) nombre + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }

    @Override
    public void generarMororos() throws SQLException {
        try {
            String sql = "EXEC GenerarMorosos";
            pst = con.prepareStatement(sql);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList buscarDireccionContribuyente(Object direccion) throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where V.direcion LIKE '" + (String) direccion + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }

    @Override
    public ArrayList buscarDireccionRazonSocialContribuyente(Object direccion) throws SQLException {
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            String sql = "SELECT M.idMoroso, M.meses, M.deudaActual, M.deudaAnterior, M.deudaTotal, M.idVivienda "
                    + "FROM Morosos M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where V.direcion LIKE '" + (String) direccion + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Morosos();
                objM.setIdMoroso(rs.getInt(1));
                objM.setMeses(rs.getString(2));
                objM.setDeudaAct(rs.getDouble(3));
                objM.setDeudaAnt(rs.getDouble(4));
                objM.setDeudaTotal(rs.getDouble(5));
                ViviendaDao objV = new ViviendaDaoImp(con);
                objM.setObjVivienda(objV.buscarIdVivienda(rs.getInt(6)));
                ltsMorosos.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMorosos;
    }
}

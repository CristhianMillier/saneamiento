package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MotivoModfContrDaoImp implements MotivoModfContrDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private MotivoModfContr objMF;

    public MotivoModfContrDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objMF = (MotivoModfContr) object;
        try {
            String sql = "insert into MotivoModfContri (idVivienda, fechaDoc, asunto, tipoDoc, fechaRecp, destinatario, idContribuyenteAnt) "
                    + "values (?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, objMF.getObjV().getIdVivienda());
            pst.setString(2, objMF.getFechaDoc());
            pst.setString(3, objMF.getAsunto());
            pst.setString(4, objMF.getTipoDoc());
            pst.setString(5, objMF.getFechaRec());
            pst.setString(6, objMF.getDestinatario());
            pst.setInt(7, objMF.getObjV().getObjCont().getIdContribuyente());
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
        objMF = (MotivoModfContr) object;
        try {
            String sql = "UPDATE MotivoModfContri SET fechaDoc=?, asunto=?, "
                    + "destinatario=? where idActVivienda = " + objMF.getIdActVivienda();
            pst = con.prepareStatement(sql);
            pst.setString(1, objMF.getFechaDoc());
            pst.setString(2, objMF.getAsunto());
            pst.setString(3, objMF.getDestinatario());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificarPropiedad(Object object) throws SQLException {
        objMF = (MotivoModfContr) object;
        try {
            String sql = "UPDATE Vivienda SET idContribuyente=? where idVivienda = " + objMF.getObjV().getIdVivienda();
            pst = con.prepareStatement(sql);
            pst.setInt(1, objMF.getObjC().getIdContribuyente());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean grabarDocumento(byte[] pdf, Object idMotModf) throws SQLException {
        try {
            String sql = "UPDATE MotivoModfContri set documentoPDF=? "
                    + "where  idActVivienda = " + (Integer) idMotModf;
            pst = con.prepareStatement(sql);
            pst.setBytes(1, pdf);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificarDocumento(byte[] pdf, Object idMotModf) throws SQLException {
        try {
            String sql = "UPDATE MotivoModfContri set documentoPDF=? "
                    + "where  idActVivienda = " + (Integer) idMotModf;
            pst = con.prepareStatement(sql);
            pst.setBytes(1, pdf);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public MotivoModfContr buscarIdMotivoModf(Object idMotModf) throws SQLException {
        try {
            String sql = "select * from MotivoModfContri where idActVivienda = " + (Integer) idMotModf;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objMF;
    }

    @Override
    public int ultimoIdMotivoModf() throws SQLException {
        int id = 0;
        try {
            String sql = "select max(idActVivienda) from MotivoModfContri";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return id;
    }

    @Override
    public ArrayList obtenerListaContribuyente() throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }

    @Override
    public ArrayList obtenerListaContribuyenteRazonSocial() throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }

    @Override
    public ArrayList buscarDNIContribuyente(Object dni) throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente  "
                    + "where C.nroDoc LIKE '" + (String) dni + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }

    @Override
    public ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente  "
                    + "where C.nroDoc LIKE '" + (String) dni + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }

    @Override
    public ArrayList buscarApellidoContribuyente(Object apellido) throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente  "
                    + "where C.apellido LIKE '" + (String) apellido + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }

    @Override
    public ArrayList buscarNombreContribuyente(Object nombre) throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente  "
                    + "where C.nombre LIKE '" + (String) nombre + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }

    @Override
    public ArrayList buscarRazonSocialContribuyente(Object razon) throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where C.razonSocial LIKE '" + (String) razon + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }

    @Override
    public ArrayList buscarDirección(Object direccion) throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where V.direcion LIKE '" + (String) direccion + "%' and C.razonSocial is null order by C.apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }

    @Override
    public ArrayList buscarDirecciónRazonSocial(Object direccion) throws SQLException {
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            String sql = "SELECT M.idActVivienda, M.idVivienda, M.fechaDoc, M.asunto, M.tipoDoc, M.fechaRecp, M.destinatario, M.documentoPDF, M.idContribuyenteAnt "
                    + "FROM MotivoModfContri M inner join Vivienda V on M.idVivienda = V.idVivienda inner join Contribuyente C on V.idContribuyente = C.idContribuyente "
                    + "where V.direcion LIKE '" + (String) direccion + "%' and C.apellido is null and C.nombre is null order by C.razonSocial";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objMF = new MotivoModfContr();
                objMF.setIdActVivienda(rs.getInt(1));
                ViviendaDao objViv = new ViviendaDaoImp(con);
                objMF.setObjV(objViv.buscarIdVivienda(rs.getInt(2)));
                objMF.setFechaDoc(rs.getString(3));
                objMF.setAsunto(rs.getString(4));
                objMF.setTipoDoc(rs.getString(5));
                objMF.setFechaRec(rs.getString(6));
                objMF.setDestinatario(rs.getString(7));
                objMF.setArchivopdf(rs.getBytes(8));
                ContribuyenteDao objC = new ContribuyenteDaoImp(con);
                objMF.setObjC(objC.buscarIdContribuyente(rs.getInt(9)));
                ltsMotivoModfContr.add(objMF);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMotivoModfContr;
    }
}

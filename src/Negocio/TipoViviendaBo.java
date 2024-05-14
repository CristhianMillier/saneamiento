package Negocio;

import Datos.ConexionDaoImp;
import Datos.TipoVivienda;
import Datos.TipoViviendaDao;
import Datos.TipoViviendaDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoViviendaBo {
    public static boolean grabarTipVivienda(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            obj.grabar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    public static boolean modificarTipVivienda(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            obj.modificar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    public static boolean eliminarTipVivienda(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            obj.eliminar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    
    public static ArrayList obtenerComercial() throws Exception{
        Connection con = null;
        ArrayList<TipoVivienda> ltsTipoVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            ltsTipoVivienda = obj.obtenerComercial();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsTipoVivienda;
    }
    
    public static ArrayList obtenerResidencial() throws Exception{
        Connection con = null;
        ArrayList<TipoVivienda> ltsTipoVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            ltsTipoVivienda = obj.obtenerResidencial();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsTipoVivienda;
    }
    
    public static void obtenerComboComercial(JComboBox<TipoVivienda> jComboBox) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            obj.obtenerComboComercial(jComboBox);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    
    public static void obtenerComboResidencial(JComboBox<TipoVivienda> jComboBox) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            obj.obtenerComboResidencial(jComboBox);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    
    public static TipoVivienda buscarIdTipVivienda(Object id) throws Exception{
        Connection con = null;
        TipoVivienda objTP = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            objTP = obj.buscarIdTipVivienda(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objTP;
    }
    
    public static boolean buscarDescripcion(Object descripcion)throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            estado = obj.buscarDescripcion(descripcion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return estado;
    }
    
    public static ArrayList buscarTipoViviendaComercial(Object descripcion) throws Exception{
        Connection con = null;
        ArrayList<TipoVivienda> ltsTipoVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            ltsTipoVivienda = obj.buscarTipoViviendaComercial(descripcion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsTipoVivienda;
    }
    
    public static ArrayList buscarTipoViviendaResidencial(Object descripcion) throws Exception{
        Connection con = null;
        ArrayList<TipoVivienda> ltsTipoVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipoViviendaDao obj = new TipoViviendaDaoImp(con);
            ltsTipoVivienda = obj.buscarTipoViviendaResidencial(descripcion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsTipoVivienda;
    }
    
}

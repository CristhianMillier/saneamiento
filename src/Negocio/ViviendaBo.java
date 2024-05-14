package Negocio;

import Datos.ConexionDaoImp;
import Datos.Vivienda;
import Datos.ViviendaDao;
import Datos.ViviendaDaoImp;
import java.sql.Connection;
import java.util.ArrayList;

public class ViviendaBo {
    public static boolean grabarVivienda(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
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
    public static boolean eliminarVivienda(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
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
    public static boolean modificarVivienda(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
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
    
    public static ArrayList obtenerListaContribuyente() throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.obtenerListaContribuyente();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
    
    public static ArrayList obtenerListaContribuyenteRazonSocial() throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.obtenerListaContribuyenteRazonSocial();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
    
    public static Vivienda buscarIdVivienda(Object id) throws Exception{
        Connection con = null;
        Vivienda objV = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            objV = obj.buscarIdVivienda(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objV;
    }
    
    public static ArrayList buscarDNIContribuyente(Object dni) throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.buscarDNIContribuyente(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
    
    public static ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.buscarDNIContribuyenteRazonSocial(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
            
    public static ArrayList buscarApellidoContribuyente(Object apellido) throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.buscarApellidoContribuyente(apellido);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
    
    public static ArrayList buscarNombreContribuyente(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.buscarNombreContribuyente(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
    
    public static ArrayList buscarRazonSocialContribuyente(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.buscarRazonSocialContribuyente(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
    
    public static boolean buscarContribuyenteDomicilio(Object idContribueynte, Object domicilio, Object nro) throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            estado = obj.buscarContribuyenteDomicilio(idContribueynte, domicilio, nro);
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
    
    public static ArrayList buscarDireccionContribuyente(Object direccion) throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.buscarDireccionContribuyente(direccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
    
    public static ArrayList buscarDireccionRazonSocialContribuyente(Object direccion) throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            ltsVivienda = obj.buscarDireccionRazonSocialContribuyente(direccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsVivienda;
    }
    
    public static boolean buscarDomicilio(Object domicilio, Object nro)throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ViviendaDao obj = new ViviendaDaoImp(con);
            estado = obj.buscarDomicilio(domicilio, nro);
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
}

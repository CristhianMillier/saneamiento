package Negocio;

import Datos.ConexionDaoImp;
import Datos.Morosos;
import Datos.MorososDao;
import Datos.MorososDaoImp;
import java.sql.Connection;
import java.util.ArrayList;

public class MorososBo {
    public static boolean grabarMorosos(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
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
    
    public static boolean modificarMorosos(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
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
    
    public static boolean eliminarMorosos(Object idVivienda)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            obj.eliminar(idVivienda);
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
    
    public static ArrayList obtenerListaMoroso() throws Exception{
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.obtenerListaMoroso();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
    
    public static ArrayList obtenerListaContribuyenteRazonSocial() throws Exception {
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.obtenerListaContribuyenteRazonSocial();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
    
    public static Morosos buscarIdMorosos(Object id) throws Exception{
        Connection con = null;
        Morosos objM = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            objM = obj.buscarIdMorosos(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objM;
    }
    
    public static ArrayList buscarDNIContribuyente(Object dni) throws Exception{
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.buscarDNIContribuyente(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
    
    public static ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws Exception {
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.buscarDNIContribuyenteRazonSocial(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
    
    public static ArrayList buscarApellidoContribuyente(Object apellido) throws Exception{
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.buscarApellidoContribuyente(apellido);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
    
    public static ArrayList buscarNombreContribuyente(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.buscarNombreContribuyente(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
    
    public static ArrayList buscarRazonSocialContribuyente(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.buscarRazonSocialContribuyente(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
    
    public static void generarMororos() throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            obj.generarMororos();
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
    
    public static ArrayList buscarDireccionContribuyente(Object direccion) throws Exception{
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.buscarDireccionContribuyente(direccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
    
    public static ArrayList buscarDireccionRazonSocialContribuyente(Object direccion) throws Exception{
        Connection con = null;
        ArrayList<Morosos> ltsMorosos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MorososDao obj = new MorososDaoImp(con);
            ltsMorosos = obj.buscarDireccionRazonSocialContribuyente(direccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMorosos;
    }
}

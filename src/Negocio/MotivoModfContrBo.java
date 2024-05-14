package Negocio;

import Datos.ConexionDaoImp;
import Datos.MotivoModfContr;
import Datos.MotivoModfContrDao;
import Datos.MotivoModfContrDaoImp;
import java.sql.Connection;
import java.util.ArrayList;


public class MotivoModfContrBo {
    public static boolean grabarMotivoModfContr(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
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

    public static boolean modificarMotivoModfContr(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
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
    
    public static boolean eliminarMotivoModfContr(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
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
    
    public static boolean grabarDocumento(byte[] pdf, Object idMotModf) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            obj.grabarDocumento(pdf, idMotModf);
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
    
    public static boolean modificarDocumento(byte[] pdf, Object idMotModf) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            obj.modificarDocumento(pdf, idMotModf);
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
    
    public static boolean modificarPropiedad(Object object) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            obj.modificarPropiedad(object);
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
    
    public static MotivoModfContr buscarIdMotivoModf(Object idMotModf) throws Exception{
        Connection con = null;
        MotivoModfContr objMC = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            objMC = obj.buscarIdMotivoModf(idMotModf);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objMC;
    }
    
    public static int ultimoIdMotivoModf() throws Exception{
        Connection con = null;
        int id = 0;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            id = obj.ultimoIdMotivoModf();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return id;
    }
    
    public static ArrayList obtenerListaContribuyente() throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.obtenerListaContribuyente();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
    
    public static ArrayList obtenerListaContribuyenteRazonSocial() throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.obtenerListaContribuyenteRazonSocial();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
    
    public static ArrayList buscarDNIContribuyente(Object dni) throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.buscarDNIContribuyente(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
    
    public static ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.buscarDNIContribuyenteRazonSocial(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
    
    public static ArrayList buscarApellidoContribuyente(Object apellido) throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.buscarApellidoContribuyente(apellido);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
    
    public static ArrayList buscarNombreContribuyente(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.buscarNombreContribuyente(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
    
    public static ArrayList buscarRazonSocialContribuyente(Object razon) throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.buscarRazonSocialContribuyente(razon);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
    
    public static ArrayList buscarDirección(Object direccion) throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.buscarDirección(direccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
    
    public static ArrayList buscarDirecciónRazonSocial(Object direccion) throws Exception{
        Connection con = null;
        ArrayList<MotivoModfContr> ltsMotivoModfContr = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MotivoModfContrDao obj = new MotivoModfContrDaoImp(con);
            ltsMotivoModfContr = obj.buscarDirecciónRazonSocial(direccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsMotivoModfContr;
    }
}

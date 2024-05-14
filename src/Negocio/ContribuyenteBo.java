package Negocio;

import Datos.ConexionDaoImp;
import Datos.Contribuyente;
import Datos.ContribuyenteDao;
import Datos.ContribuyenteDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ContribuyenteBo {
    public static boolean grabarContribuyente(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
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
    public static boolean grabarContribuyenteRazonSocial(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            obj.grabarRazonSocial(object);
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
    public static boolean modificarContribuyente(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
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
    public static boolean modificarContribuyenteRazonsocial(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            obj.modificarRazonSocial(object);
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
    public static boolean eliminarContribuyente(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
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
    public static ArrayList obtenerListaContribuyente() throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.obtenerListaContribuyente();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
    
    public static void obtenerListaCombContribuyente(JComboBox<Contribuyente> jComboBox) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            obj.obtenerListaCombContribuyente(jComboBox);
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
    
    public static Contribuyente buscarIdContribuyente(Object id) throws Exception{
        Connection con = null;
        Contribuyente objCon = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            objCon = obj.buscarIdContribuyente(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objCon;
    }
    
    public static ArrayList buscarDNIContribuyente(Object dni) throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.buscarDNIContribuyente(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
    
    public static ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.buscarDNIContribuyenteRazonSocial(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
    
    public static ArrayList buscarApellidoContribuyente(Object apellido) throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.buscarApellidoContribuyente(apellido);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
    
    public static ArrayList buscarNombreContribuyente(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.buscarNombreContribuyente(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
    
    public static ArrayList buscarRazonSocialContribuyente(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.buscarRazonSocialContribuyente(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
    
    public static boolean buscarDNI(Object DNI)throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            estado = obj.buscarDNI(DNI);
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
    
    public static boolean buscarNombreApellido(Object nombre, Object apellido)throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            estado = obj.buscarNombreApellido(nombre, apellido);
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
    
    public static boolean buscarRazonSocial(Object razonSocial) throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            estado = obj.buscarRazonSocial(razonSocial);
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
    
    public static ArrayList obtenerListaContribuyenteRazonSocial() throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.obtenerListaContribuyenteRazonSocial();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
    
    public static ArrayList buscarRazonSocialContribuyenteDireccion(Object direccion) throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.buscarRazonSocialContribuyenteDireccion(direccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
    
    public static ArrayList buscarPersonaContribuyenteDireccion(Object direccion) throws Exception{
        Connection con = null;
        ArrayList<Contribuyente> ltsContribuyente = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ContribuyenteDao obj = new ContribuyenteDaoImp(con);
            ltsContribuyente = obj.buscarPersonaContribuyenteDireccion(direccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsContribuyente;
    }
}

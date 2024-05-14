package Negocio;

import Datos.CajaDao;
import Datos.CajaDaoImp;
import Datos.ConexionDaoImp;
import Datos.ReciboSaniamiento;
import java.sql.Connection;
import java.util.ArrayList;

public class CajaBo {
    public static boolean grabarCaja(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CajaDao obj = new CajaDaoImp(con);
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
    
    public static boolean modificarCaja(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CajaDao obj = new CajaDaoImp(con);
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
    
    public static boolean eliminarCaja(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CajaDao obj = new CajaDaoImp(con);
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
    
    public static ArrayList obtenerListaRecibo(Object idVivienda)throws Exception{
        Connection con = null;
        ArrayList<ReciboSaniamiento> ltsReciboSaniamiento = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CajaDao obj = new CajaDaoImp(con);
            ltsReciboSaniamiento = obj.obtenerListaRecibo(idVivienda);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsReciboSaniamiento;
    }
    
    public static int buscarTicket(Object ticket) throws Exception{
        Connection con = null;
        int idVivienda = 0;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CajaDao obj = new CajaDaoImp(con);
            idVivienda = obj.buscarTicket(ticket);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return idVivienda;
    }
    
    public static double reportMensualSan(Object anio, Object mes) throws Exception{
        Connection con = null;
        double pagoMensualReporte = 0;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CajaDao obj = new CajaDaoImp(con);
            pagoMensualReporte = obj.reportMensualSan(anio, mes);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return pagoMensualReporte;
    }
}

package Negocio;

import Datos.ConexionDaoImp;
import Datos.ReciboSaniamiento;
import Datos.ReciboSaniamientoDao;
import Datos.ReciboSaniamientoDaoImp;
import Datos.Vivienda;
import java.sql.Connection;
import java.util.ArrayList;

public class ReciboSaniamientoBo {

    public static boolean grabarRecibo(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            obj.grabar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean modificarRecibo(Object idReciboSaniamiento) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            obj.modificar(idReciboSaniamiento);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean eliminarRecibo(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            obj.modificar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    public static ArrayList obtenerListaRecibo(Object idVivienda) throws Exception{
        Connection con = null;
        ArrayList<ReciboSaniamiento> ltsReciboSaniamiento = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            ltsReciboSaniamiento = obj.obtenerListaRecibo(idVivienda);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsReciboSaniamiento;
    }
    
    public static double obtenerDeudaAnterior(Object idVivienda) throws Exception{
        Connection con = null;
        double deuda = 0;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            deuda = obj.obtenerDeudaAnterior(idVivienda);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return deuda;
    }
    
    public static ArrayList obtenerDatosImprimir() throws Exception{
        Connection con = null;
        ArrayList<String> ltsDatos = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            ltsDatos = obj.obtenerDatosImprimir();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDatos;
    }
    
    public static boolean buscarRecibosGenerados() throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            estado = obj.buscarRecibosGenerados();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return estado;
    }
    
    public static void generarRecibos() throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            obj.generarRecibos();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    public static int ultimoTicketGenerado() throws Exception{
        Connection con = null;
        int ticket = 0;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            ticket = obj.ultimoTicketGenerado();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ticket;
    }
    
    public static void actualizarTicket(Object ticket, Object idRecibo) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            obj.actualizarTicket(ticket, idRecibo);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    public static ArrayList obtenerRecibosSinTicket() throws Exception{
        Connection con = null;
        ArrayList<ReciboSaniamiento> ltsReciboSaniamiento = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            ltsReciboSaniamiento = obj.obtenerRecibosSinTicket();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsReciboSaniamiento;
    }
    
    public static ArrayList mostrarCorte() throws Exception{
        Connection con = null;
        ArrayList<Vivienda> ltsVivienda = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ReciboSaniamientoDao obj = new ReciboSaniamientoDaoImp(con);
            ltsVivienda = obj.mostrarCorte();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsVivienda;
    }
}

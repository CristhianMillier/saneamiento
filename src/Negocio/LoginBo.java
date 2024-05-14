package Negocio;

import Datos.ConexionDaoImp;
import Datos.Login;
import Datos.LoginDao;
import Datos.LoginDaoImp;
import java.sql.Connection;

public class LoginBo {
    public static boolean grabarLogin(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
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
    public static boolean eliminarLogin(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
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
    public static boolean modificarLogin(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
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
    public static int buscarLogin(Object user, Object password)throws Exception{
        Connection con = null;
        int idP = 0;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
            idP = obj.Logeo(user, password);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return idP;
    }
    public static Login buscarPersonal(Object id)throws Exception{
        Connection con = null;
        Login objL = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
            objL = obj.buscarPersonal(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objL;
    }
}

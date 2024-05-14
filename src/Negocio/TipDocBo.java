package Negocio;

import Datos.TipDoc;
import Datos.TipDocDao;
import Datos.TipDocDaoImp;
import Datos.ConexionDaoImp;
import javax.swing.JComboBox;
import java.sql.Connection;

public class TipDocBo {
    public static void obtenerListaComboTipDoc(JComboBox<TipDoc> jComboBox)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            TipDocDao obj = new TipDocDaoImp(con);
            obj.obtenerListaComboTipDoc(jComboBox);
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
}

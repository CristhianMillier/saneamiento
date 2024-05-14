package Negocio;

import Datos.Cargo;
import Datos.ConexionDaoImp;
import Datos.CargoDao;
import Datos.CargoDaoImp;
import java.sql.Connection;
import javax.swing.JComboBox;

public class CargoBo {
    public static void obtenerListaComboCargo(JComboBox<Cargo> jComboBox)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CargoDao obj = new CargoDaoImp(con);
            obj.obtenerListaComboCargo(jComboBox);
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

package Report;

import Datos.ConexionDaoImp;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReciboReport {
    
    public void verReporte(String mes, int anio, String emision) throws Exception {
        JasperReport repor;
        JasperPrint re;
        JasperViewer view;
        try {
            String path = "src\\Report\\ReportRecibo.jasper";
            repor = (JasperReport) JRLoader.loadObjectFromFile(path);

            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("emision", emision);
            
            re = JasperFillManager.fillReport(repor, parametros, ConexionDaoImp.getConexion());
            view = new JasperViewer(re, false);
            view.setTitle("Recibos del mes de " + mes + " del" + anio);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo.png")));
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException  e) {
            System.out.println(e.getMessage());
        }
    }

}

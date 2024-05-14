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

public class EstadisticaMensualReport {

    public void verReporte(int mes, int anio) throws Exception {
        JasperReport repor;
        JasperPrint re;
        JasperViewer view;
        String[] months = new String[]{"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO",
            "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

        try {
            String path = "src\\Report\\ReportEstaditicoMensual.jasper";
            repor = (JasperReport) JRLoader.loadObjectFromFile(path);

            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("mes", mes);
            parametros.put("anio", anio);

            re = JasperFillManager.fillReport(repor, parametros, ConexionDaoImp.getConexion());
            view = new JasperViewer(re, false);
            view.setTitle("Reporte de Estadístico de Ingresos Mensuales a partir del mes " + months[mes - 1] + " del año " + anio);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo.png")));
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
}

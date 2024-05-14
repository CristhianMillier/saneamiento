package Datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_CuentCorriente extends AbstractTableModel {

    private List<ReciboSaniamiento> listado_ReciboSaniamiento;

    public void setListado_ReciboSaniamiento(List<ReciboSaniamiento> listado_ReciboSaniamiento) {
        this.listado_ReciboSaniamiento = listado_ReciboSaniamiento;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_ReciboSaniamiento != null) {
            cantFilas = this.listado_ReciboSaniamiento.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReciboSaniamiento objRS;
        Object celda = "";
        if (this.listado_ReciboSaniamiento != null) {
            objRS = this.listado_ReciboSaniamiento.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objRS.getAnio();
                    break;
                case 1:
                    celda = objRS.getMes().trim();
                    break;
                case 2:
                    celda = this.convertDate(objRS.getFechaEmision());
                    break;
                case 3:
                    celda = this.convertDate(objRS.getFechaPago());
                    break;
                case 4:
                    celda = objRS.getImpAgua();
                    break;
            }
        }
        return celda;
    }

    @Override
    public String getColumnName(int column) {
        String nombreolumn = "";
        switch (column) {
            case 0:
                nombreolumn = "AÑO";
                break;
            case 1:
                nombreolumn = "MES";
                break;
            case 2:
                nombreolumn = "EMISIÓN";
                break;
            case 3:
                nombreolumn = "PAGO";
                break;
            case 4:
                nombreolumn = "AGUA";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public ReciboSaniamiento getReciboSaniamiento(int fila) {
        ReciboSaniamiento objRS = null;
        if (this.listado_ReciboSaniamiento != null) {
            objRS = this.listado_ReciboSaniamiento.get(fila);
        }
        return objRS;
    }
    
    private String convertDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

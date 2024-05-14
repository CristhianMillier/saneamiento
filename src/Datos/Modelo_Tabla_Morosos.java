package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Morosos extends AbstractTableModel {

    private List<Morosos> listado_Morosos;

    public void setListado_Morosos(List<Morosos> listado_Morosos) {
        this.listado_Morosos = listado_Morosos;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Morosos != null) {
            cantFilas = this.listado_Morosos.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Morosos objM;
        Object celda = "";
        if (this.listado_Morosos != null) {
            objM = this.listado_Morosos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objM.getObjVivienda().getObjCont().toString();
                    break;
                case 1:
                    celda = objM.getObjVivienda().getDireccion() + " " + objM.getObjVivienda().getNroVivienda();
                    break;
                case 2:
                    celda = objM.getMeses();
                    break;
                case 3:
                    celda = objM.getDeudaTotal();
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
                nombreolumn = "CONTRIBUYENTE";
                break;
            case 1:
                nombreolumn = "DOMICILIO";
                break;
            case 2:
                nombreolumn = "MESES";
                break;
            case 3:
                nombreolumn = "DEUDA TOTAL";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Morosos getMorosos(int fila) {
        Morosos objM = null;
        if (this.listado_Morosos != null) {
            objM = this.listado_Morosos.get(fila);
        }
        return objM;
    }
}

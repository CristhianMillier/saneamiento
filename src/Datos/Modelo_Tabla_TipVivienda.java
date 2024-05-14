package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_TipVivienda extends AbstractTableModel {

    private List<TipoVivienda> listado_TipoVivienda;

    public void setListado_TipoVivienda(List<TipoVivienda> listado_TipoVivienda) {
        this.listado_TipoVivienda = listado_TipoVivienda;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_TipoVivienda != null) {
            cantFilas = this.listado_TipoVivienda.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoVivienda objTP;
        Object celda = "";
        if (this.listado_TipoVivienda != null) {
            objTP = this.listado_TipoVivienda.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objTP.getDescripcion();
                    break;
                case 1:
                    if (objTP.getTipo() == 2) {
                        celda = "COMERCIAL";
                    } else {
                        celda = "RESIDENCIAL";
                    }
                    break;
                case 2:
                    celda = objTP.getImpAgua();
                    break;
                case 3:
                    celda = objTP.getImpBP();
                    break;
                case 4:
                    if (objTP.getEstado().equals("Si")) {
                        celda = "ACTIVO";
                    } else{
                        celda = "INACTIVO";
                    }
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
                nombreolumn = "DESCRIPCIÓN";
                break;
            case 1:
                nombreolumn = "TIPO";
                break;
            case 2:
                nombreolumn = "IMP. AGUA";
                break;
            case 3:
                nombreolumn = "IMP. BP";
                break;
            case 4:
                nombreolumn = "ESTADO";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public TipoVivienda getTipoVivienda(int fila) {
        TipoVivienda objTP = null;
        if (this.listado_TipoVivienda != null) {
            objTP = this.listado_TipoVivienda.get(fila);
        }
        return objTP;
    }
}

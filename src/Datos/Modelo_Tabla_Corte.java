package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Corte extends AbstractTableModel {

    private List<Vivienda> listado_Vivienda;

    public void setListado_Vivienda(List<Vivienda> listado_Vivienda) {
        this.listado_Vivienda = listado_Vivienda;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Vivienda != null) {
            cantFilas = this.listado_Vivienda.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vivienda objv;
        Object celda = "";
        if (this.listado_Vivienda != null) {
            objv = this.listado_Vivienda.get(rowIndex);
            switch (columnIndex) { 
                case 0:
                    celda = objv.getObjCont().toString();
                    break;
                case 1:
                    celda = objv.getDireccion() + " " + objv.getNroVivienda();
                    break;
                case 2:
                    celda = objv.getMeses();
                    break;
                case 3:
                    celda = objv.getMesesDebe();
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
                nombreolumn = "MESES SIN PAGAR";
                break;
            case 3:
                nombreolumn = "TOTAL MESES";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Vivienda getVivienda(int fila) {
        Vivienda objV = null;
        if (this.listado_Vivienda != null) {
            objV = this.listado_Vivienda.get(fila);
        }
        return objV;
    }
}

package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Vivienda extends AbstractTableModel {

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
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vivienda objv;
        Object celda = "";
        if (this.listado_Vivienda != null) {
            objv = this.listado_Vivienda.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    if (objv.getObjCont().getRazonSocial() != null) {
                        celda = objv.getObjCont().getRazonSocial();
                    } else {
                        celda = objv.getObjCont().getApellido() + " " + objv.getObjCont().getNmombre();
                    }
                    break;
                case 1:
                    celda = objv.getDireccion() + " " + objv.getNroVivienda();
                    break;
                case 2:
                    if (objv.getObjTipViv().getTipo() == 2) {
                        celda = "COMERCIAL";
                    } else {
                        celda = "RESIDENCIAL";
                    }
                    break;
                case 3:
                    celda = objv.getImpAgua();
                    break;
                case 4:
                    celda = objv.getObjTipViv().getImpBP();
                    break;
                case 5:
                    if (objv.getEstado().equals("Si")) {
                        celda = "ACTIVO";
                    } else {
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
                nombreolumn = "CONTRIBUYENTE";
                break;
            case 1:
                nombreolumn = "DOMICILIO";
                break;
            case 2:
                nombreolumn = "TIP. USER.";
                break;
            case 3:
                nombreolumn = "AGUA";
                break;
            case 4:
                nombreolumn = "BAJA POL.";
                break;
            case 5:
                nombreolumn = "ESTADO";
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

package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Contribuyente extends AbstractTableModel {

    private List<Contribuyente> listado_Contribuyente;

    public void setListado_Contribuyente(List<Contribuyente> listado_Contribuyente) {
        this.listado_Contribuyente = listado_Contribuyente;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Contribuyente != null) {
            cantFilas = this.listado_Contribuyente.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contribuyente objc;
        Object celda = "";
        if (this.listado_Contribuyente != null) {
            objc = this.listado_Contribuyente.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    if (objc.getRazonSocial() != null) {
                        celda = objc.getRazonSocial();
                    } else{
                        celda = objc.getApellido() + " " + objc.getNmombre();
                    }
                    break;
                case 1:
                    celda = objc.getObjTipDoc().getNombre();
                    break;
                case 2:
                    celda = objc.getNroDoc();
                    break;
                case 3:
                    celda = objc.getDomicilio();
                    break;
                case 4:
                    if (objc.getEstado().equals("Si")) {
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
                nombreolumn = "CONTRIBUYENTE";
                break;
            case 1:
                nombreolumn = "TIP. DOC.";
                break;
            case 2:
                nombreolumn = "NRO. DOC.";
                break;
            case 3:
                nombreolumn = "DOMICILIO";
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

    public Contribuyente getContribuyente(int fila) {
        Contribuyente objC = null;
        if (this.listado_Contribuyente != null) {
            objC = this.listado_Contribuyente.get(fila);
        }
        return objC;
    }
}

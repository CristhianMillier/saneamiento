package Datos;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_ModContr extends AbstractTableModel {

    private List<MotivoModfContr> listado_MotivoModfContr;

    public void setListado_MotivoModfContr(List<MotivoModfContr> listado_MotivoModfContr) {
        this.listado_MotivoModfContr = listado_MotivoModfContr;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_MotivoModfContr != null) {
            cantFilas = this.listado_MotivoModfContr.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MotivoModfContr objMC;
        Object celda = null;
        if (this.listado_MotivoModfContr != null) {
            objMC = this.listado_MotivoModfContr.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objMC.getObjV().getObjCont().toString();
                    break;
                case 1:
                    celda = objMC.getObjV().getDireccion() + " " + objMC.getObjV().getNroVivienda();
                    break;
                case 2:
                    celda = objMC.getAsunto();
                    break;
                case 3:
                    if (objMC.getArchivopdf() != null) {
                        celda = agregarBoton(1);
                    } else {
                        celda = agregarBoton(2);
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
                nombreolumn = "ASUNTO";
                break;
            case 3:
                nombreolumn = "DOCUMENTO";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public MotivoModfContr getMotivoModfContr(int fila) {
        MotivoModfContr objMC = null;
        if (this.listado_MotivoModfContr != null) {
            objMC = this.listado_MotivoModfContr.get(fila);
        }
        return objMC;
    }

    private Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

    private JButton agregarBoton(int valor) {
        JButton boton;
        ImageIcon icono = null;
        if (get_Image("/Imagenes/archivo-pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imagenes/archivo-pdf.png"));
        }

        if (valor == 1) {
            boton = new JButton(icono);
        } else {
            boton = new JButton("VACÍO");
        }

        return boton;
    }
}

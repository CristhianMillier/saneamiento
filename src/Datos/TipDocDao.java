package Datos;

import java.sql.SQLException;
import javax.swing.JComboBox;

public interface TipDocDao extends General{
    public void obtenerListaComboTipDoc(JComboBox<TipDoc> jComboBox) throws SQLException;
    public TipDoc buscarIdTipDoc(Object id) throws SQLException;
}

package Datos;

import java.sql.SQLException;
import javax.swing.JComboBox;

public interface CargoDao extends General{
    public void obtenerListaComboCargo(JComboBox<Cargo> jComboBox) throws SQLException;
    public Cargo buscarIdCargo(Object id) throws SQLException;
}

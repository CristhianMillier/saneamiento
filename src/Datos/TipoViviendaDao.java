package Datos;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public interface TipoViviendaDao extends General{
    public ArrayList obtenerComercial() throws SQLException;
    public ArrayList obtenerResidencial() throws SQLException;
    public void obtenerComboComercial(JComboBox<TipoVivienda> jComboBox) throws SQLException;
    public void obtenerComboResidencial(JComboBox<TipoVivienda> jComboBox) throws SQLException;
    public TipoVivienda buscarIdTipVivienda(Object id) throws SQLException;
    public boolean buscarDescripcion(Object descripcion)throws SQLException;
    public ArrayList buscarTipoViviendaComercial(Object descripcion) throws SQLException;
    public ArrayList buscarTipoViviendaResidencial(Object descripcion) throws SQLException;
}

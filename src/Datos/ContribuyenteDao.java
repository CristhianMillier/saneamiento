package Datos;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public interface ContribuyenteDao extends General{
    public boolean grabarRazonSocial(Object object) throws SQLException;
    public boolean modificarRazonSocial(Object object) throws SQLException;
    public ArrayList obtenerListaContribuyente() throws SQLException;
    public ArrayList obtenerListaContribuyenteRazonSocial() throws SQLException;
    public void obtenerListaCombContribuyente(JComboBox<Contribuyente> jComboBox) throws SQLException;
    public Contribuyente buscarIdContribuyente(Object id) throws SQLException;
    public ArrayList buscarDNIContribuyente(Object dni) throws SQLException;
    public ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws SQLException;
    public ArrayList buscarApellidoContribuyente(Object apellido) throws SQLException;
    public ArrayList buscarNombreContribuyente(Object nombre) throws SQLException;
    public ArrayList buscarRazonSocialContribuyente(Object nombre) throws SQLException;
    public ArrayList buscarRazonSocialContribuyenteDireccion(Object direccion) throws SQLException;
    public ArrayList buscarPersonaContribuyenteDireccion(Object direccion) throws SQLException;
    public boolean buscarDNI(Object DNI)throws SQLException;
    public boolean buscarNombreApellido(Object nombre, Object apellido)throws SQLException;
    public boolean buscarRazonSocial(Object razonSocial)throws SQLException;
}

package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ViviendaDao extends General{
    public ArrayList obtenerListaContribuyente() throws SQLException;
    public ArrayList obtenerListaContribuyenteRazonSocial() throws SQLException;
    public Vivienda buscarIdVivienda(Object id) throws SQLException;
    public ArrayList buscarDNIContribuyente(Object dni) throws SQLException;
    public ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws SQLException;
    public ArrayList buscarApellidoContribuyente(Object apellido) throws SQLException;
    public ArrayList buscarNombreContribuyente(Object nombre) throws SQLException;
    public ArrayList buscarRazonSocialContribuyente(Object nombre) throws SQLException;
    public ArrayList buscarDireccionContribuyente(Object direccion) throws SQLException;
    public ArrayList buscarDireccionRazonSocialContribuyente(Object direccion) throws SQLException;
    public boolean buscarContribuyenteDomicilio(Object idContribueynte, Object domicilio, Object nro)throws SQLException;
    public boolean buscarDomicilio(Object domicilio, Object nro)throws SQLException;
}

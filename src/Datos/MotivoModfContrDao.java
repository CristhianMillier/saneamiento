package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MotivoModfContrDao extends General{
    public boolean grabarDocumento(byte[] pdf, Object idMotModf) throws SQLException;
    public boolean modificarDocumento(byte[] pdf, Object idMotModf) throws SQLException;
    public boolean modificarPropiedad(Object object) throws SQLException;
    public MotivoModfContr buscarIdMotivoModf(Object idMotModf) throws SQLException;
    public int ultimoIdMotivoModf() throws SQLException;
    public ArrayList obtenerListaContribuyente() throws SQLException;
    public ArrayList obtenerListaContribuyenteRazonSocial() throws SQLException;
    public ArrayList buscarDNIContribuyente(Object dni) throws SQLException;
    public ArrayList buscarDNIContribuyenteRazonSocial(Object dni) throws SQLException;
    public ArrayList buscarApellidoContribuyente(Object apellido) throws SQLException;
    public ArrayList buscarNombreContribuyente(Object nombre) throws SQLException;
    public ArrayList buscarRazonSocialContribuyente(Object razon) throws SQLException;
    public ArrayList buscarDirección(Object direccion) throws SQLException;
    public ArrayList buscarDirecciónRazonSocial(Object direccion) throws SQLException;
}

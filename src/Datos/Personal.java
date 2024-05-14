package Datos;

public class Personal {

    private int idEmpleado;
    private String nombre;
    private String apellido;
    private TipDoc objTipDoc;
    private String nroDoc;
    private String telefono;
    private Cargo objCargo;
    private String estado;

    public Personal() {
    }

    public Personal(int idEmpleado, String nombre, String apellido, TipDoc objTipDoc, String nroDoc, String telefono, Cargo objCargo, String estado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.objTipDoc = objTipDoc;
        this.nroDoc = nroDoc;
        this.telefono = telefono;
        this.objCargo = objCargo;
        this.estado = estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipDoc getObjTipDoc() {
        return objTipDoc;
    }

    public void setObjTipDoc(TipDoc objTipDoc) {
        this.objTipDoc = objTipDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cargo getObjCargo() {
        return objCargo;
    }

    public void setObjCargo(Cargo objCargo) {
        this.objCargo = objCargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

}

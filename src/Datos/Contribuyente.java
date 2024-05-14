package Datos;

public class Contribuyente {

    private int idContribuyente;
    private String nmombre;
    private String apellido;
    private String razonSocial;
    private TipDoc objTipDoc;
    private String nroDoc;
    private String domicilio;
    private String estado;

    public Contribuyente() {
    }

    public Contribuyente(int idContribuyente, String nmombre, String apellido, String razonSocial, TipDoc objTipDoc, String nroDoc, String domicilio, String estado) {
        this.idContribuyente = idContribuyente;
        this.nmombre = nmombre;
        this.apellido = apellido;
        this.razonSocial = razonSocial;
        this.objTipDoc = objTipDoc;
        this.nroDoc = nroDoc;
        this.domicilio = domicilio;
        this.estado = estado;
    }

    public int getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(int idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public String getNmombre() {
        return nmombre;
    }

    public void setNmombre(String nmombre) {
        this.nmombre = nmombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        if (this.objTipDoc.getNombre().equals("R.U.C.")) {
            return this.razonSocial;
        } else {
            return this.apellido + " " + this.nmombre;
        }
    }

}

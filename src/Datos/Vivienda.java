package Datos;

public class Vivienda {

    private int idVivienda;
    private String direccion;
    private String nroVivienda;
    private TipoVivienda objTipViv;
    private Contribuyente objCont;
    private String estado;
    private int mesesDebe;
    private String meses;
    private double impAgua;

    public Vivienda() {
    }

    public Vivienda(int idVivienda, String direccion, String nroVivienda, TipoVivienda objTipViv, Contribuyente objCont, String estado, double impAgua) {
        this.idVivienda = idVivienda;
        this.direccion = direccion;
        this.nroVivienda = nroVivienda;
        this.objTipViv = objTipViv;
        this.objCont = objCont;
        this.estado = estado;
        this.impAgua = impAgua;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNroVivienda() {
        return nroVivienda;
    }

    public void setNroVivienda(String nroVivienda) {
        this.nroVivienda = nroVivienda;
    }

    public TipoVivienda getObjTipViv() {
        return objTipViv;
    }

    public void setObjTipViv(TipoVivienda objTipViv) {
        this.objTipViv = objTipViv;
    }

    public Contribuyente getObjCont() {
        return objCont;
    }

    public void setObjCont(Contribuyente objCont) {
        this.objCont = objCont;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return direccion + " propietario(a) " + objCont.toString();
    }

    public int getMesesDebe() {
        return mesesDebe;
    }

    public void setMesesDebe(int mesesDebe) {
        this.mesesDebe = mesesDebe;
    }

    public String getMeses() {
        return meses;
    }

    public void setMeses(String meses) {
        this.meses = meses;
    }

    public double getImpAgua() {
        return impAgua;
    }

    public void setImpAgua(double impAgua) {
        this.impAgua = impAgua;
    }
    

}

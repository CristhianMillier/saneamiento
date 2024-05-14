package Datos;

public class TipoVivienda {
    
    private int idTipViv;
    private String descripcion;
    private int tipo;
    private double impAgua;
    private double impBP;
    private String estado;

    public TipoVivienda() {
    }

    public TipoVivienda(int idTipViv, String descripcion, int tipo, double impAgua, double impBP, String estado) {
        this.idTipViv = idTipViv;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.impAgua = impAgua;
        this.impBP = impBP;
        this.estado = estado;
    }

    public int getIdTipViv() {
        return idTipViv;
    }

    public void setIdTipViv(int idTipViv) {
        this.idTipViv = idTipViv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getImpAgua() {
        return impAgua;
    }

    public void setImpAgua(double impAgua) {
        this.impAgua = impAgua;
    }

    public double getImpBP() {
        return impBP;
    }

    public void setImpBP(double impBP) {
        this.impBP = impBP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
}

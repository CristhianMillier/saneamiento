package Datos;

public class Morosos {
    private int idMoroso;
    private String meses;
    private double deudaAct;
    private double deudaAnt;
    private double deudaTotal;
    private Vivienda objVivienda;

    public Morosos() {
    }

    public Morosos(int idMoroso, String meses, double deudaAct, double deudaAnt, double deudaTotal, Vivienda objVivienda) {
        this.idMoroso = idMoroso;
        this.meses = meses;
        this.deudaAct = deudaAct;
        this.deudaAnt = deudaAnt;
        this.deudaTotal = deudaTotal;
        this.objVivienda = objVivienda;
    }

    public int getIdMoroso() {
        return idMoroso;
    }

    public void setIdMoroso(int idMoroso) {
        this.idMoroso = idMoroso;
    }

    public String getMeses() {
        return meses;
    }

    public void setMeses(String meses) {
        this.meses = meses;
    }

    public double getDeudaAct() {
        return deudaAct;
    }

    public void setDeudaAct(double deudaAct) {
        this.deudaAct = deudaAct;
    }

    public double getDeudaAnt() {
        return deudaAnt;
    }

    public void setDeudaAnt(double deudaAnt) {
        this.deudaAnt = deudaAnt;
    }

    public double getDeudaTotal() {
        return deudaTotal;
    }

    public void setDeudaTotal(double deudaTotal) {
        this.deudaTotal = deudaTotal;
    }

    public Vivienda getObjVivienda() {
        return objVivienda;
    }

    public void setObjVivienda(Vivienda objVivienda) {
        this.objVivienda = objVivienda;
    }
    
}

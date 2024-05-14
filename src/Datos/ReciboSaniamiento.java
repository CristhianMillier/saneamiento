package Datos;

public class ReciboSaniamiento {
    private int idRecibo;
    private int anio;
    private String estadoPago;
    private String fechaPagoCaja;
    private String mes;
    private String fechaEmision;
    private String fechaPago;
    private String ticket;
    private Vivienda objVivienda;
    private double impAgua;
    private double imopBP;

    public ReciboSaniamiento() {
    }

    public ReciboSaniamiento(int idRecibo, int anio, String estadoPago, String fechaPagoCaja, String mes, String fechaEmision, String fechaPago, String ticket, Vivienda objVivienda, double impAgua, double imopBP) {
        this.idRecibo = idRecibo;
        this.anio = anio;
        this.estadoPago = estadoPago;
        this.fechaPagoCaja = fechaPagoCaja;
        this.mes = mes;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
        this.ticket = ticket;
        this.objVivienda = objVivienda;
        this.impAgua = impAgua;
        this.imopBP = imopBP;
    }

    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getFechaPagoCaja() {
        return fechaPagoCaja;
    }

    public void setFechaPagoCaja(String fechaPagoCaja) {
        this.fechaPagoCaja = fechaPagoCaja;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Vivienda getObjVivienda() {
        return objVivienda;
    }

    public void setObjVivienda(Vivienda objVivienda) {
        this.objVivienda = objVivienda;
    }

    public double getImpAgua() {
        return impAgua;
    }

    public void setImpAgua(double impAgua) {
        this.impAgua = impAgua;
    }

    public double getImopBP() {
        return imopBP;
    }

    public void setImopBP(double imopBP) {
        this.imopBP = imopBP;
    }
    
}

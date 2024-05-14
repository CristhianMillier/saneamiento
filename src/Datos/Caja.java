package Datos;

public class Caja {
    private int idCaja;
    private String fechaPago;
    private double pago;
    private double descuento;
    private double totalPago;
    private Vivienda objV;

    public Caja() {
    }

    public Caja(int idCaja, String fechaPago, double pago, double descuento, double totalPago, Vivienda objV) {
        this.idCaja = idCaja;
        this.fechaPago = fechaPago;
        this.pago = pago;
        this.descuento = descuento;
        this.totalPago = totalPago;
        this.objV = objV;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public Vivienda getObjV() {
        return objV;
    }

    public void setObjV(Vivienda objV) {
        this.objV = objV;
    }
    
}

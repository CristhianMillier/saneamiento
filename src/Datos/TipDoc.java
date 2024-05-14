package Datos;

public class TipDoc {

    private int idTipDoc;
    private String nombre;
    private String estado;

    public TipDoc() {
    }

    public TipDoc(int idTipDoc, String nombre, String estado) {
        this.idTipDoc = idTipDoc;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdTipDoc() {
        return idTipDoc;
    }

    public void setIdTipDoc(int idTipDoc) {
        this.idTipDoc = idTipDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }

}

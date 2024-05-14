package Datos;

public class Cargo {

    private int idCargo;
    private String nombre;
    private String estado;

    public Cargo() {
    }

    public Cargo(int idCargo, String nombre, String estado) {
        this.idCargo = idCargo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
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

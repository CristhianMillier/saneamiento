package Datos;

public class Login {

    private int idLogin;
    private String usuario;
    private String password;
    private int idEmpleado;
    private String estado;

    public Login() {
    }

    public Login(int idLogin, String usuario, String password, int idEmpleado, String estado) {
        this.idLogin = idLogin;
        this.usuario = usuario;
        this.password = password;
        this.idEmpleado = idEmpleado;
        this.estado = estado;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

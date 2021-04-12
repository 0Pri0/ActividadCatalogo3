package cl.duoc.actividadcatalogo;

public class Usuarios {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private int perfil;
    private boolean cuentaActiva;
    private String password;

    //Constructor sin id
    public Usuarios(String nombre, String apellido, String email, int perfil, boolean cuentaActiva, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.perfil = perfil;
        this.cuentaActiva = cuentaActiva;
        this.password = password;
    }
    //Constructor con id
    public Usuarios(int id, String nombre, String apellido, String email, int perfil, boolean cuentaActiva, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.perfil = perfil;
        this.cuentaActiva = cuentaActiva;
        this.password = password;
    }

    //getters y setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public boolean isCuentaActiva() {
        return cuentaActiva;
    }

    public void setCuentaActiva(boolean cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", perfil=" + perfil +
                ", cuentaActiva=" + cuentaActiva +
                ", password='" + password + '\'' +
                '}';
    }
}

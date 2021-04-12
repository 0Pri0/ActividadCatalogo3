package cl.duoc.actividadcatalogo;

public class Catalogo {

    private int id;
    private int categoria;
    private String nombre;
    private String descripcion;
    private int precio;
    private int imagen;

    //constructor sin parametros

    public Catalogo() {
        categoria =0;
        nombre = "";
        descripcion ="";
        precio =0;
        imagen =0;
    }

    //constructor con parametros

    public Catalogo(int categoria, String nombre, String descripcion, int precio, int imagen ) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    //Constructor para actualizar datos de productos
    public Catalogo(int id, int categoria, String nombre, String descripcion, int precio, int imagen ) {
        this.categoria = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }


    //getters y setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id'" + id + '\'' +
                "categoria'" + categoria +'\'' +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", imagen=" + imagen +
                '}';
    }
}


package pe.com.tatiendo.dao.entity;


public class Producto {
    //Atributos propios
    private Integer idProducto;
    private String nombre;
    private Double precio;
    //Atributos producto de la relacion
    private Categoria idCategoria;
    //Constructor
    public Producto() {
    }
    //Get y Set
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
}

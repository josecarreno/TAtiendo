package pe.com.tatiendo.dao.entity;

import java.util.List;

public class Categoria {
    
    //Atributos propios
    private Integer idCategoria;
    private String nombre;
    //Atributos producto de la relacion
    private List<Producto> productos;
    
    //Constructor
    public Categoria() {
    }
    
    //Get y Set
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
}

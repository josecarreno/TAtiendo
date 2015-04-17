package pe.com.tatiendo.dao.entity;

import java.util.List;

public class Rol {
    
    private Integer idRol;
    private String descripcion;
    private List<Usuario> usuarios;
    private List<Menu> menus;
    //Constructor
    public Rol() {
    }
    //Get y Set
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
    
    
}

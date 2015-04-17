package pe.com.tatiendo.dao.entity;

public class Menu {
    private Integer idMenu;
    private String url;
    private Boolean esJsp;
    private String descripcion;
    private Rol idRol;

    public Menu() {
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getEsJsp() {
        return esJsp;
    }

    public void setEsJsp(Boolean esJsp) {
        this.esJsp = esJsp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }
    
    
}

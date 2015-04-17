package pe.com.tatiendo.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import pe.com.tatiendo.dao.entity.Categoria;
import pe.com.tatiendo.service.CategoriaService;
import pe.com.tatiendo.service.impl.CategoriaServiceImpl;

@WebService
public class CategoriaWs {
    
    @WebMethod
    public String registrar(String nombre){
        String mensaje = "";
        try {
            Categoria categoria = new Categoria();
            categoria.setNombre(nombre);
            CategoriaService categoriaService =
                    CategoriaServiceImpl.obtenerInstancia();
            categoriaService.insertar(categoria);
            mensaje = "Se registro la categoria";
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "Ocurrior un error: " + e.getMessage();
        }
        return mensaje;
    }
    @WebMethod
    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            CategoriaService categoriaService =
                    CategoriaServiceImpl.obtenerInstancia();
            lista = categoriaService.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    

}

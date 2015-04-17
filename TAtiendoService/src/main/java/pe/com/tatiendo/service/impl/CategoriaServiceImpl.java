package pe.com.tatiendo.service.impl;

import java.util.List;
import pe.com.tatiendo.dao.CategoriaDao;
import pe.com.tatiendo.dao.entity.Categoria;
import pe.com.tatiendo.service.CategoriaService;
import pe.com.tatiendo.service.util.ServiceUtil;
import pe.com.tatiendo.util.SystemException;

public class CategoriaServiceImpl implements CategoriaService{

    //Inicio Singleton
    private final static CategoriaServiceImpl CATEGORIA_SERVICE_IMPL;
    private CategoriaDao categoriaDao;
    
    static{
        CATEGORIA_SERVICE_IMPL = new CategoriaServiceImpl();
    }
    
    private CategoriaServiceImpl(){
        //Estoy que obtengo del dao ya sea por JDBC o HIBERNATE
        categoriaDao = (CategoriaDao)ServiceUtil.obtenerDao("Categoria");
    }
    
    public static CategoriaServiceImpl obtenerInstancia(){
        return CATEGORIA_SERVICE_IMPL;
    }
    //Fin Singleton
    
    public void insertar(Categoria e) throws SystemException {
        categoriaDao.insertar(e);
    }

    public void actualizar(Categoria e) throws SystemException {
        categoriaDao.actualizar(e);
    }

    public void eliminar(Integer id) throws SystemException {
        categoriaDao.eliminar(id);
    }

    public Categoria obtener(Integer id) throws SystemException {
        return categoriaDao.obtener(id);
    }

    public List<Categoria> listar() throws SystemException {
        return categoriaDao.listar();
    }
    
}

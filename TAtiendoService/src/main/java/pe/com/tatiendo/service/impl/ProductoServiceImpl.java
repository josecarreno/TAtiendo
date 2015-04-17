package pe.com.tatiendo.service.impl;

import java.util.List;
import pe.com.tatiendo.dao.ProductoDao;
import pe.com.tatiendo.dao.entity.Producto;
import pe.com.tatiendo.service.ProductoService;
import pe.com.tatiendo.service.util.ServiceUtil;
import pe.com.tatiendo.util.SystemException;

public class ProductoServiceImpl implements ProductoService{

    //Inicio Singleton
    private final static ProductoServiceImpl PRODUCTO_SERVICE_IMPL;
    private ProductoDao productoDao = null;
    
    static{
        PRODUCTO_SERVICE_IMPL = new ProductoServiceImpl();
    }
    
    private ProductoServiceImpl(){
        productoDao = (ProductoDao) ServiceUtil.obtenerDao("Producto");
    }
    
    public static ProductoServiceImpl obtenerInstancia(){
        return PRODUCTO_SERVICE_IMPL;
    }
    //Fin Singleton
    
    @Override
    public void insertar(Producto e) throws SystemException {
        productoDao.insertar(e);
    }

    @Override
    public void actualizar(Producto e) throws SystemException {
        productoDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        productoDao.eliminar(id);
    }

    @Override
    public Producto obtener(Integer id) throws SystemException {
        return productoDao.obtener(id);
    }

    @Override
    public List<Producto> listar() throws SystemException {
        return productoDao.listar();
    }
    
}

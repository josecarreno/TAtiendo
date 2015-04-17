package pe.com.tatiendo.service.util;

import pe.com.tatiendo.dao.jdbc.base.EntityDao;
import pe.com.tatiendo.dao.jdbc.impl.CategoriaJdbcDao;
import pe.com.tatiendo.dao.jdbc.impl.ProductoJdbcDao;
import pe.com.tatiendo.dao.jdbc.impl.UsuarioJdbcDao;
import pe.com.tatiendo.util.SystemUtil;


public final class ServiceUtil {
    
    private static final String CATEGORIA = "Categoria";
    private static final String PRODUCTO = "Producto";
    private static final String USUARIO = "Usuario";
    
    private ServiceUtil(){
        
    }
    
    public static EntityDao obtenerDao(String tabla){
        EntityDao entityDao = null;
        //Existira dos tipos JDBC o HIBERNATE
        String tipConexion = "JDBC";
                //SystemUtil.obtenerVariableSistema("tipoConexion");
        if(tabla.equalsIgnoreCase(CATEGORIA)){
            switch(tipConexion){
                case "JDBC":
                    entityDao = CategoriaJdbcDao.obtenerInstancia();
                    break;
            }
        }else if(tabla.equalsIgnoreCase(PRODUCTO)){
            switch(tipConexion){
                case "JDBC":
                    entityDao = ProductoJdbcDao.obtenerInstancia();
                    break;
            }
        }else if(tabla.equalsIgnoreCase(USUARIO)){
            switch(tipConexion){
                case "JDBC":
                    entityDao = UsuarioJdbcDao.obtenerInstancia();
                    break;
            }
        }
        return entityDao;
    }
}

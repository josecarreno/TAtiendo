package pe.com.tatiendo.web.util;

import java.text.MessageFormat;
import java.util.Date;
import pe.com.tatiendo.service.CategoriaService;
import pe.com.tatiendo.service.base.BaseService;
import pe.com.tatiendo.service.impl.CategoriaServiceImpl;
import pe.com.tatiendo.service.impl.ProductoServiceImpl;
import pe.com.tatiendo.service.impl.UsuarioServiceImpl;
import pe.com.tatiendo.util.SystemUtil;

public final class WebUtil {
    
    private WebUtil(){
        
    }
    
    public static String controlarError(Exception excepcion){
        StringBuilder sb = new StringBuilder();
        String idError = SystemUtil.convertirDate(new Date(), "ddMMyyyyhhmmss");
        sb.append(MessageFormat.format("Código de error: {0} \n", idError));
        sb.append(MessageFormat.format("Mensaje del error: {0} \n", 
                excepcion.getMessage()));
        return sb.toString();
    }
    
    public static BaseService obtenerService(String clase){
        BaseService baseService = null;
        if(clase.equalsIgnoreCase("CATEGORIA")){
            baseService = CategoriaServiceImpl.obtenerInstancia();
        }else if(clase.equalsIgnoreCase("PRODUCTO")){
            baseService = ProductoServiceImpl.obtenerInstancia();
        }else if(clase.equalsIgnoreCase("USUARIO")){
            baseService = UsuarioServiceImpl.obtenerInstancia();
        }
        return baseService;
    }
    
}

package pe.com.tatiendo.service;

import pe.com.tatiendo.dao.entity.Usuario;
import pe.com.tatiendo.service.base.BaseService;
import pe.com.tatiendo.util.SystemException;

public interface UsuarioService 
    extends BaseService<Usuario, Integer>{
    
    Usuario validarUsuario(String usuario, String clave) 
            throws SystemException;
}

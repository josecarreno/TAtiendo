package pe.com.tatiendo.dao;

import pe.com.tatiendo.dao.entity.Usuario;
import pe.com.tatiendo.dao.jdbc.base.EntityDao;
import pe.com.tatiendo.util.SystemException;

public interface UsuarioDao extends EntityDao<Usuario, Integer>{
    
    Usuario validarUsuario(String usuario, String clave) throws SystemException;
}

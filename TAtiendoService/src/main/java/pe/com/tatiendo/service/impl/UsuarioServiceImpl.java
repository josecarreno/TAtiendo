package pe.com.tatiendo.service.impl;

import java.util.List;
import javax.print.ServiceUI;
import pe.com.tatiendo.dao.UsuarioDao;
import pe.com.tatiendo.dao.entity.Usuario;
import pe.com.tatiendo.service.UsuarioService;
import pe.com.tatiendo.service.util.ServiceUtil;
import pe.com.tatiendo.util.SystemException;

public class UsuarioServiceImpl implements UsuarioService{

    //Inicio Singleton
    private final static UsuarioServiceImpl USUARIO_SERVICE_IMPL;
    private UsuarioDao usuarioDao = null;
    
    static{
        USUARIO_SERVICE_IMPL = new UsuarioServiceImpl();
    }
    
    private UsuarioServiceImpl(){
        usuarioDao = (UsuarioDao) ServiceUtil.obtenerDao("Usuario");
    }
    
    public static UsuarioServiceImpl obtenerInstancia(){
        return USUARIO_SERVICE_IMPL;
    }
    //Fin Singleton
    
    @Override
    public Usuario validarUsuario(String usuario, String clave) throws SystemException {
        return usuarioDao.validarUsuario(usuario, clave);
    }

    @Override
    public void insertar(Usuario e) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Usuario e) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtener(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

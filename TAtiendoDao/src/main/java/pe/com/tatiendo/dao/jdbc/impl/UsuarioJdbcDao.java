package pe.com.tatiendo.dao.jdbc.impl;

import java.util.ArrayList;
import java.util.List;
import pe.com.tatiendo.dao.UsuarioDao;
import pe.com.tatiendo.dao.entity.Menu;
import pe.com.tatiendo.dao.entity.Rol;
import pe.com.tatiendo.dao.entity.Usuario;
import pe.com.tatiendo.dao.jdbc.base.BaseJdbcDao;
import pe.com.tatiendo.util.SystemException;


public class UsuarioJdbcDao extends BaseJdbcDao implements UsuarioDao {

    private static final UsuarioJdbcDao USUARIO_DAO_IMPL;

    static {
        USUARIO_DAO_IMPL = new UsuarioJdbcDao();
    }

    private UsuarioJdbcDao() {

    }

    public static UsuarioJdbcDao obtenerInstancia() {
        return USUARIO_DAO_IMPL;
    }

    @Override
    public void insertar(Usuario e) throws SystemException {
        throw new UnsupportedOperationException("Metodo no implementado");
    }

    public void actualizar(Usuario e) throws SystemException {
        throw new UnsupportedOperationException("Metodo no implementado");
    }

    public void eliminar(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Metodo no implementado");
    }

    public Usuario obtener(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Metodo no implementado");
    }

    public List<Usuario> listar() throws SystemException {
        throw new UnsupportedOperationException("Metodo no implementado");
    }

    @Override
    public Usuario validarUsuario(String usuario, String clave) throws SystemException {
        Usuario u = null;
        try {
            //1. SQL a Ejecutar
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ");
            sb.append("u.*, r.descripcion, m.idMenu, m.url, m.esJsp, m.descripcion as descripcionMenu ");
            sb.append("FROM ");
            sb.append("usuario u inner join rol r on u.idRol = r.idRol inner join ");
            sb.append("menu m on r.idRol = m.idRol ");
            sb.append("WHERE ");
            sb.append("u.usuario = ? AND u.clave=? ");
            sb.append("ORDER BY ");
            sb.append("m.idMenu ");
            //2. Obtener la conexion
            cn = obtenerConexion();
            //3. Establecer sentencia 
            pr = cn.prepareStatement(sb.toString());
            //4. Establecer los parametros
            pr.setString(1, usuario);
            pr.setString(2, clave);
            //5. Ejecutar sentencia
            rs = pr.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getInt("idMenu"));
                menu.setEsJsp(rs.getBoolean("esJsp"));
                menu.setUrl(rs.getString("url"));
                menu.setDescripcion(rs.getString("descripcionMenu"));
                if (u == null) {
                    u = new Usuario();
                    u.setIdUsuario(rs.getInt("idUsuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setClave(rs.getString("clave"));
                    u.setIdRol(new Rol());
                    u.getIdRol().setIdRol(rs.getInt("idRol"));
                    u.getIdRol().setDescripcion(rs.getString("descripcion"));
                    u.getIdRol().setMenus(new ArrayList<Menu>());
                    u.getIdRol().getMenus().add(menu);
                } else {
                    u.getIdRol().getMenus().add(menu);
                }
            }
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally {
            cerrar(cn, pr, rs);
        }
        return u;
    }

}

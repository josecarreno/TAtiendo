
package pe.com.tatiendo.dao.jdbc.impl;
//PreparedStatement.RETURN_GENERATED_KEYS
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.com.tatiendo.dao.entity.Categoria;
import pe.com.tatiendo.dao.CategoriaDao;
import pe.com.tatiendo.dao.jdbc.base.BaseJdbcDao;
import pe.com.tatiendo.util.SystemException;


public class CategoriaJdbcDao extends BaseJdbcDao implements CategoriaDao{

    //Inicio Singleton
    private static final CategoriaJdbcDao CATEGORIA_JDBC_DAO;
    
    static {
        CATEGORIA_JDBC_DAO = new CategoriaJdbcDao();
    }
    
    
    private CategoriaJdbcDao(){
        
    }
    
    public static CategoriaJdbcDao obtenerInstancia(){
        return CATEGORIA_JDBC_DAO;
    }
    //Fin Singleton
    
    
    
    public void insertar(Categoria e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO CATEGORIA(nombre) VALUES(?)");
            pr = cn.prepareStatement(sb.toString(), 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, e.getNombre().trim().toUpperCase());
            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdCategoria(rs.getInt(1));
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
    }

    public void actualizar(Categoria e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE CATEGORIA SET ");
            sb.append("nombre = ? ");
            sb.append("WHERE ");
            sb.append("idCategoria = ? ");
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getNombre().trim().toUpperCase());
            pr.setInt(2, e.getIdCategoria());
            pr.executeUpdate(); 
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr);                                                                                                              
        }
    }

    public void eliminar(Integer id) throws SystemException {
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM Categoria WHERE idCategoria = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            pr.executeUpdate();
        }catch(Exception ex){
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr);                                                                                                              
        }
    }

    public Categoria obtener(Integer id) throws SystemException {
        Categoria categoria = null;
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Categoria WHERE idCategoria = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while(rs.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombre"));
            }
        }catch(Exception ex){
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
        return categoria;
    }

    public List<Categoria> listar() throws SystemException {
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Categoria ORDER BY nombre");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNombre(rs.getString("nombre"));
                listaCategorias.add(c);
            }
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr, rs);
        }
        return listaCategorias;
    }
    
}

package pe.com.tatiendo.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.com.tatiendo.dao.ProductoDao;
import pe.com.tatiendo.dao.entity.Categoria;
import pe.com.tatiendo.dao.entity.Producto;
import pe.com.tatiendo.dao.jdbc.base.BaseJdbcDao;
import pe.com.tatiendo.util.SystemException;

public class ProductoJdbcDao extends BaseJdbcDao implements ProductoDao{

    //Inicio Singleton
    private static final ProductoJdbcDao PRODUCTO_JDBC_DAO;
    
    static{
        PRODUCTO_JDBC_DAO = new ProductoJdbcDao();
    }
    
    private ProductoJdbcDao(){
        
    }
    
     public static ProductoJdbcDao obtenerInstancia(){
        return PRODUCTO_JDBC_DAO;
    }
    //Fin Singleton

    public void insertar(Producto e) throws SystemException {
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO Producto (nombre, precio, idCategoria) ");
            sb.append("VALUES (?,?,?) ");
            pr = cn.prepareStatement(sb.toString(), 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, e.getNombre().trim().toUpperCase());
            pr.setDouble(2, e.getPrecio());
            pr.setInt(3, e.getIdCategoria().getIdCategoria());
            pr.executeUpdate();
            //Obtener las claves generadas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdProducto(rs.getInt(1));
        } catch(Exception ex){
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
    }

    public void actualizar(Producto e) throws SystemException {
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE Producto SET ");
            sb.append("nombre = ? , precio = ? , idCategoria = ? ");
            sb.append("WHERE ");
            sb.append("idProducto = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getNombre().trim().toUpperCase());
            pr.setDouble(2, e.getPrecio());
            pr.setInt(3, e.getIdCategoria().getIdCategoria());
            pr.setInt(4, e.getIdProducto());
            pr.executeUpdate();
        }catch(Exception ex){
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr);
        }
    }

    public void eliminar(Integer id) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM Producto WHERE idProducto = ? ");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr);
        }
    }

    public Producto obtener(Integer id) throws SystemException {
        Producto p = null;
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT p.*, c.nombre as nombreCategoria FROM ");
            sb.append("Producto p INNER JOIN Categoria c ON ");
            sb.append("p.idCategoria = c.idCategoria ");
            sb.append("WHERE ");
            sb.append("p.idProducto = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while(rs.next()){
                p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setIdCategoria(new Categoria());
                p.getIdCategoria().setIdCategoria(rs.getInt("idCategoria"));
                p.getIdCategoria().setNombre(rs.getString("nombreCategoria"));
            }
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
        return p;
    }

    public List<Producto> listar() throws SystemException {
      List<Producto> lista = new ArrayList<Producto>();
      try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT p.*, c.nombre as nombreCategoria FROM ");
            sb.append("Producto p INNER JOIN Categoria c ON ");
            sb.append("p.idCategoria = c.idCategoria ");
            sb.append("ORDER BY p.nombre ");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setIdCategoria(new Categoria());
                p.getIdCategoria().setIdCategoria(rs.getInt("idCategoria"));
                p.getIdCategoria().setNombre(rs.getString("nombreCategoria"));
                lista.add(p);
            }
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
        return lista;
    }
    
    
    
}

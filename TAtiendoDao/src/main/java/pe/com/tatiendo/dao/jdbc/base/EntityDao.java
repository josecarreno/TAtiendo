package pe.com.tatiendo.dao.jdbc.base;

import java.util.List;
import pe.com.tatiendo.util.SystemException;

/**
 * 
 * @author proyecto
 * @param <E> Representa a que entidad realizo el CRUD
 * @param <J> Representa el tipo de dato de la Clave Primaria de la entidad
 */
public interface EntityDao<E,J> {

    void insertar(E e) throws SystemException;
    void actualizar(E e) throws SystemException;
    void eliminar(J id) throws SystemException;
    E obtener(J id) throws SystemException;
    List<E> listar() throws SystemException;
}

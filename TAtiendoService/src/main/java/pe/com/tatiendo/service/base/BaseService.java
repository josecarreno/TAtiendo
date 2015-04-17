package pe.com.tatiendo.service.base;

import java.util.List;
import pe.com.tatiendo.util.SystemException;

public interface BaseService<E,J> {
    
    void insertar(E e) throws SystemException;
    void actualizar(E e) throws SystemException;
    void eliminar(J id) throws SystemException;
    E obtener(J id) throws SystemException;
    List<E> listar() throws SystemException;
}

package business.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author enrique
 * @param <T>
 * @param <K>
 */
public interface GenericDao<T, K extends Serializable> {

    public T add(T entity);

    public T update(T entity);

    public void delete(T entity);

    public T getById(K key);

    public List<T> getAll();

}

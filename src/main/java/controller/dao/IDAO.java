package controller.dao;

import java.io.Serializable;
import java.util.List;


public interface IDAO<T, Id extends Serializable> {

    void persist(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(Id id);

    T findById(Id id);

    List<T> findAll();

    void deleteAll();
}

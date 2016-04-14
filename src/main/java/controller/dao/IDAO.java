package controller.dao;

import model.client.Client;

import java.io.Serializable;
import java.util.List;


/**
 * Created by ivan on 15.12.15.
 */
public interface IDAO<T,Id extends Serializable> {

    void persist(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(Integer id);

    T findById(Id id);

    List<T> findAll();

    void deleteAll();
}

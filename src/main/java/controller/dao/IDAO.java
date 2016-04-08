package controller.dao;

import model.client.Client;

import java.io.Serializable;
import java.util.List;


/**
 * Created by ivan on 15.12.15.
 */
public interface IDAO<T,Id extends Serializable> {

    public void persist(T entity);

    public void update(T entity);

    public void delete(T entity);

    public void deleteById(Integer id);

    T findById(Id id);

    List<T> findAll();

    void deleteAll();
}

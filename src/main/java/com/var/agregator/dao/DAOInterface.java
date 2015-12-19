package com.var.agregator.dao;

import java.io.Serializable;
import java.util.List;


/**
 * Created by ivan on 15.12.15.
 */
public interface DAOInterface<T,Id extends Integer> {

    public void persist(T entity);

    public void update(T entity);

    public void delete(T entity);

    public T findById(Id id);

    public List<T> findAll();

    public void deleteAll();
}

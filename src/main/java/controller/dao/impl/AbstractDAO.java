package controller.dao.impl;

import controller.dao.IDAO;
import controller.dao.util.DaoUtil;

import java.io.Serializable;

/**
 * Created by ivan on 20.04.16.
 */
public abstract class AbstractDAO<T, Id extends Serializable>  implements IDAO<T,Id> {

    protected DaoUtil<T,Id> daoUtil = new DaoUtil<T, Id>();

    public void persist(T entity) {
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.persist(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void update(T entity) {
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.update(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void deleteById(Id id) {
        daoUtil.openCurrentSessionWithTransaction();
        T entity = findById(id);
        daoUtil.delete(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void delete(T entity) {
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.delete(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

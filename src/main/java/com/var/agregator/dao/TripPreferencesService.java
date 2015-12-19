package com.var.agregator.dao;

import com.var.agregator.dto.client.TripPreferences;

import java.util.List;

/**
 * Created by ivan on 18.12.15.
 */
public class TripPreferencesService implements DAOInterface<TripPreferences,Integer> {

    private DaoUtil<TripPreferences,Integer> daoUtil;

    public TripPreferencesService(){
        daoUtil = new DaoUtil<TripPreferences, Integer>();
    }

    public void persist(TripPreferences entity) {
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.persist(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void update(TripPreferences entity) {
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.update(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public TripPreferences findById(Integer id) {
        daoUtil.openCurrentSession();
        TripPreferences entity = (TripPreferences) daoUtil.getCurrentSession().get(TripPreferences.class, id);
        daoUtil.closeCurrentSession();
        return entity;
    }
//    .
    public void delete(Integer id) {
        daoUtil.openCurrentSessionWithTransaction();
        TripPreferences entity = findById(id);
        daoUtil.delete(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void delete(TripPreferences entity){
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.delete(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public List<TripPreferences> findAll() {
        daoUtil.openCurrentSession();
        List<TripPreferences> entityList = (List<TripPreferences>) daoUtil.getCurrentSession().createQuery("from trip_preferences").list();
        daoUtil.closeCurrentSession();
        if (entityList.isEmpty())
            return null;
        return entityList;
    }

    public void deleteAll() {
        daoUtil.openCurrentSessionWithTransaction();
        List<TripPreferences> entityList = findAll();
        for (TripPreferences entity : entityList) {
            delete(entity);
        }
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

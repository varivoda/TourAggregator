package controller.dao.impl;

import controller.dao.interfaces.DaoTripPreferences;
import controller.dao.DaoUtil;
import model.client.TripPreferences;
import org.hibernate.Query;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 18.12.15.
 */
@Stateless
@LocalBean
public class DaoTripPreferencesImpl implements DaoTripPreferences {

    private DaoUtil<TripPreferences,Integer> daoUtil;

    {
        daoUtil = new DaoUtil<TripPreferences, Integer>();
    }

    public DaoTripPreferencesImpl(){
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

    public List<TripPreferences> findByClientId(Integer clientId){
        daoUtil.openCurrentSession();
        Query query = daoUtil.getCurrentSession().createQuery("from TripPreferences where client.id =:clientIdParam" );
        query.setParameter("clientIdParam", clientId);
        List<TripPreferences> tp = query.list();
        daoUtil.closeCurrentSession();
        if (tp == null || tp.isEmpty()){
            return null;
        }
        return tp;
    }

//    .
    public void deleteById(Integer id) {
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
        List<TripPreferences> entityList = (List<TripPreferences>) daoUtil.getCurrentSession().createQuery("from TripPreferences ").list();
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

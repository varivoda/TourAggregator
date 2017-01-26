package controller.dao.impl;

import controller.dao.TransportationDAO;
import model.tour.Transportation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * DAO for the transportation.
 */
@Stateless
@LocalBean
public class TransportationDAOImpl extends AbstractDAO<Transportation, Integer> implements TransportationDAO {

    public Transportation findById(Integer id) {
        daoUtil.openCurrentSession();
        Transportation transportation = (Transportation) daoUtil.getCurrentSession().get(Transportation.class, id);
        daoUtil.closeCurrentSession();
        return transportation;
    }

    public List<Transportation> findAll() {
        daoUtil.openCurrentSession();
        List<Transportation> transportationList = (List<Transportation>) daoUtil.getCurrentSession().createQuery("from Transportation").list();
        daoUtil.closeCurrentSession();
        return transportationList;
    }

    public void deleteAll() {
        daoUtil.openCurrentSessionWithTransaction();
        List<Transportation> transportationList = (List<Transportation>) daoUtil.getCurrentSession().createQuery("from Transportation").list();
        for (Transportation transportation : transportationList) {
            daoUtil.delete(transportation);
        }
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

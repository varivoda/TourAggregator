package controller.dao.impl;

import controller.dao.TourDAO;
import model.tour.Tour;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 21.04.16.
 */
@Stateless
@LocalBean
public class TourDAOImpl extends AbstractDAO<Tour,Integer> implements TourDAO {

    public TourDAOImpl() {
    }

    public Tour findById(Integer id) {
        daoUtil.openCurrentSession();
        Tour tour = (Tour) daoUtil.getCurrentSession().get(Tour.class, id);
        daoUtil.closeCurrentSession();
        return tour;
    }

    public List<Tour> findAll() {
        daoUtil.openCurrentSession();
        List<Tour> tourList = (List<Tour>) daoUtil.getCurrentSession().createQuery("from Tour").list();
        daoUtil.closeCurrentSession();
        return tourList;
    }

    public void deleteAll() {
        daoUtil.openCurrentSessionWithTransaction();
        List<Tour> tourList = (List<Tour>) daoUtil.getCurrentSession().createQuery("from Tour").list();
        for (Tour tour : tourList) {
            daoUtil.delete(tour);
        }
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

package controller.dao.impl;

import controller.dao.TourDAO;
import model.tour.Tour;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * DAO for the tour entity.
 */
@LocalBean
@Stateless
public class TourDAOImpl extends AbstractDAO<Tour, Integer> implements TourDAO {

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

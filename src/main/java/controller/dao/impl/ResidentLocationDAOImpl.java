package controller.dao.impl;

import controller.dao.ResidentLocationDAO;
import model.tour.ResidentLocation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * DAO for the resident location.
 */
@Stateless
@LocalBean
public class ResidentLocationDAOImpl extends AbstractDAO<ResidentLocation, Integer> implements ResidentLocationDAO {

    public ResidentLocation findById(Integer id) {
        daoUtil.openCurrentSession();
        ResidentLocation residentLocation = (ResidentLocation) daoUtil.getCurrentSession().get(ResidentLocation.class, id);
        daoUtil.closeCurrentSession();
        return residentLocation;
    }


    public List<ResidentLocation> findAll() {
        daoUtil.openCurrentSession();
        List<ResidentLocation> residentLocationsList = (List<ResidentLocation>) daoUtil.getCurrentSession().createQuery("from ResidentLocation ").list();
        daoUtil.closeCurrentSession();
        return residentLocationsList;
    }

    public void deleteAll() {
        daoUtil.openCurrentSessionWithTransaction();
        List<ResidentLocation> entityList = (List<ResidentLocation>) daoUtil.getCurrentSession().createQuery("from ResidentLocation ").list();
        for (ResidentLocation entity : entityList) {
            daoUtil.delete(entity);
        }
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

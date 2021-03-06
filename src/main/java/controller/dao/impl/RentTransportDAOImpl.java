package controller.dao.impl;

import controller.dao.RentTransportDAO;
import model.tour.RentTransport;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * DAO for the rent transport entities.
 */
@Stateless
@LocalBean
public class RentTransportDAOImpl extends AbstractDAO<RentTransport, Integer> implements RentTransportDAO {

    public RentTransportDAOImpl() {
    }

    public RentTransport findById(Integer id) {
        daoUtil.openCurrentSession();
        RentTransport rentTransport = (RentTransport) daoUtil.getCurrentSession().get(RentTransport.class, id);
        daoUtil.closeCurrentSession();
        return rentTransport;
    }

    public List<RentTransport> findAll() {
        daoUtil.openCurrentSession();
        List<RentTransport> rentTransportList = (List<RentTransport>) daoUtil.getCurrentSession().createQuery("from RentTransport").list();
        daoUtil.closeCurrentSession();
        return rentTransportList;
    }

    public void deleteAll() {
        daoUtil.openCurrentSessionWithTransaction();
        List<RentTransport> rentTransporList = (List<RentTransport>) daoUtil.getCurrentSession().createQuery("from RentTransport").list();
        for (RentTransport rentTransport : rentTransporList) {
            daoUtil.delete(rentTransport);
        }
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

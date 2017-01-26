package controller.dao.impl;

import controller.dao.GeneralInformationDAO;
import model.tour.GeneralInformation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * DAO for the general information entities.
 */
@Stateless
@LocalBean
public class GeneralInformationDAOImpl extends AbstractDAO<GeneralInformation, Integer> implements GeneralInformationDAO {

    public GeneralInformation findById(Integer id) {
        daoUtil.openCurrentSession();
        GeneralInformation generalInformation = (GeneralInformation) daoUtil.getCurrentSession().get(GeneralInformation.class, id);
        daoUtil.closeCurrentSession();
        return generalInformation;
    }

    public List<GeneralInformation> findAll() {
        daoUtil.openCurrentSession();
        List<GeneralInformation> generalInformationList = (List<GeneralInformation>) daoUtil.getCurrentSession().createQuery("from GeneralInformation").list();
        daoUtil.closeCurrentSession();
        return generalInformationList;
    }

    public void deleteAll() {
        daoUtil.openCurrentSessionWithTransaction();
        List<GeneralInformation> generalInformationList = (List<GeneralInformation>) daoUtil.getCurrentSession().createQuery("from GeneralInformation").list();
        for (GeneralInformation generalInformation : generalInformationList) {
            daoUtil.delete(generalInformation);
        }
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

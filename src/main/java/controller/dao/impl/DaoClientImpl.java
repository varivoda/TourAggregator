package controller.dao.impl;

import controller.dao.interfaces.DaoClient;
import controller.dao.DaoUtil;
import model.client.Client;
import org.hibernate.Query;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 15.12.15.
 */
@Stateless
@LocalBean
public class DaoClientImpl implements DaoClient {

    private DaoUtil<Client,Integer> daoUtil;

    {
        daoUtil = new DaoUtil<Client, Integer>();
    }

    public DaoClientImpl(){
    }

    public void persist(Client entity) {
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.persist(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void update(Client entity) {
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.update(entity);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public Client findById(Integer id) {
        daoUtil.openCurrentSession();
        Client client = (Client) daoUtil.getCurrentSession().get(Client.class, id);
        daoUtil.closeCurrentSession();
        return client;
    }

    public Client findByEmail(String email){
        daoUtil.openCurrentSession();
        Query query = daoUtil.getCurrentSession().createQuery("from Client where email=:emailParam");
        query.setParameter("emailParam",email);
        List<Client> clients = query.list();
        daoUtil.closeCurrentSession();
        if (clients == null || clients.isEmpty()){
            return null;
        }
        return clients.get(0);
    }

    public void deleteById(Integer id) {
        daoUtil.openCurrentSessionWithTransaction();
        Client client = findById(id);
        daoUtil.delete(client);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public void delete(Client client){
        daoUtil.openCurrentSessionWithTransaction();
        daoUtil.delete(client);
        daoUtil.closeCurrentSessionWithTransaction();
    }

    public List<Client> findAll() {
        daoUtil.openCurrentSession();
        List<Client> clientsList = (List<Client>) daoUtil.getCurrentSession().createQuery("from clients").list();
        daoUtil.closeCurrentSession();
        if (clientsList.isEmpty())
            return null;
        return clientsList;
    }

    public void deleteAll() {
        daoUtil.openCurrentSessionWithTransaction();
        List<Client> entityList = findAll();
        for (Client entity : entityList) {
            delete(entity);
        }
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

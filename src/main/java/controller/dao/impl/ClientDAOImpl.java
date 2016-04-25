package controller.dao.impl;

import controller.dao.ClientDAO;
import controller.dao.util.DaoUtil;
import model.client.Client;
import org.hibernate.Query;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 15.12.15.
 */

@LocalBean
@Stateless
public class ClientDAOImpl implements ClientDAO {

    private DaoUtil<Client,Integer> daoUtil = new DaoUtil<Client, Integer>();

    public ClientDAOImpl(){
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
        List<Client> clients = (List<Client>) query.list();
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
        List<Client> clientsList = (List<Client>) daoUtil.getCurrentSession().createQuery("from Client").list();
        daoUtil.closeCurrentSession();
        return clientsList;
    }

    public void deleteAll() {
        daoUtil.openCurrentSessionWithTransaction();
        List<Client> entityList = (List<Client>) daoUtil.getCurrentSession().createQuery("from Client").list();
        for (Client entity : entityList) {
            daoUtil.delete(entity);
        }
        daoUtil.closeCurrentSessionWithTransaction();
    }
}

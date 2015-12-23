package com.var.agregator.dao;

import com.var.agregator.dto.client.Client;
import org.hibernate.Query;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ivan on 15.12.15.
 */
public class ClientService implements DAOInterface<Client,Integer> {

    private DaoUtil<Client,Integer> daoUtil;

    public ClientService(){
        daoUtil = new DaoUtil<Client, Integer>();
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
//        Query query = daoUtil.getCurrentSession().
//                createQuery("from Client as c left join fetch c.tripPreferences " +
//                        "left join fetch c.tours where c.id=:idParam ");
//        query.setParameter("idParam",id);
//        List<Client> clients = (List<Client>) query.list();
        Client client = (Client) daoUtil.getCurrentSession().get(Client.class, id);
        daoUtil.closeCurrentSession();
//        if (clients == null || clients.isEmpty()){
//            return null;
//        }
//        return clients.get(0);
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

    public void delete(Integer id) {
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

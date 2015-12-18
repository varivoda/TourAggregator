package com.var.agregator.dao;

import com.var.agregator.dto.client.Client;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ivan on 15.12.15.
 */
public class ClientService {

    private static ClientDAO clientDAO;

    static {
        clientDAO = new ClientDAO();
    }

    public ClientService(){
    }
    public static void persist(Client entity) {
        clientDAO.openCurrentSessionWithTransaction();
        clientDAO.persist(entity);
        clientDAO.closeCurrentSessionWithTransaction();
    }

    public static void update(Client entity) {
        clientDAO.openCurrentSessionWithTransaction();
        clientDAO.update(entity);
        clientDAO.closeCurrentSessionWithTransaction();
    }

    public static Client findById(Integer id) {
        clientDAO.openCurrentSession();
        Client client = clientDAO.findById(id);
        clientDAO.closeCurrentSession();
        return client;
    }

    public static Client findByEmail(String email){
        clientDAO.openCurrentSession();
        Query query = clientDAO.getCurrentSession().createQuery("from Client where email=:emailParam");
        query.setParameter("emailParam",email);
        List<Client> clients = query.list();
        clientDAO.closeCurrentSession();
        if (clients == null || clients.isEmpty()){
            return null;
        }
        return clients.get(0);
    }

    public static void delete(Integer id) {
        clientDAO.openCurrentSessionWithTransaction();
        Client client = clientDAO.findById(id);
        clientDAO.delete(client);
        clientDAO.closeCurrentSessionWithTransaction();
    }

    public static List<Client> findAll() {
        clientDAO.openCurrentSession();
        List<Client> clients = clientDAO.findAll();
        clientDAO.closeCurrentSession();
        return clients;
    }

    public static void deleteAll() {
        clientDAO.openCurrentSessionWithTransaction();
        clientDAO.deleteAll();
        clientDAO.closeCurrentSessionWithTransaction();
    }

    public static void delete(Client client){
        clientDAO.openCurrentSessionWithTransaction();
        clientDAO.delete(client);
        clientDAO.closeCurrentSessionWithTransaction();
    }

    public static ClientDAO clientDAO() {
        return clientDAO;
    }
}

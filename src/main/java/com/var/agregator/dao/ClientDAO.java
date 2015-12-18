package com.var.agregator.dao;

import com.var.agregator.dto.client.Client;

import java.util.List;

/**
 * Created by ivan on 15.12.15.
 */
public class ClientDAO extends DAOAbstract<Client, Integer> {

    public ClientDAO(){
    }

    public Client findById(Integer id) {
        Client client = (Client) getCurrentSession().get(Client.class, id);
        return client;
    }

    public List<Client> findAll() {
        List<Client> clientsList = (List<Client>) getCurrentSession().createQuery("from clients").list();
        if (clientsList.isEmpty())
        return null;
        return clientsList;
    }

    public void deleteAll() {
        List<Client> entityList = findAll();
        for (Client entity : entityList) {
            delete(entity);
        }
    }
//    public class ClientDAO implements DAOInterface<Client, Integer> {
//
//        private Session currentSession;
//        private Transaction currentTransaction;
//
//        public Session openCurrentSession() {
//            currentSession = getSessionFactory().openSession();
//            return currentSession;
//        }
//
//        public Session openCurrentSessionWithTransaction() {
//            currentSession = getSessionFactory().openSession();
//            currentTransaction = currentSession.beginTransaction();
//            return currentSession;
//        }
//
//        public void closeCurrentSession() {
//            currentSession.close();
//        }
//
//        public void closeCurrentSessionWithTransaction() {
//            currentTransaction.commit();
//            currentSession.close();
//        }
//
//        public Session getCurrentSession() {
//            return currentSession;
//        }
//
//        public void setCurrentSession(Session currentSession) {
//            this.currentSession = currentSession;
//        }
//
//        public Transaction getCurrentTransaction() {
//            return currentTransaction;
//        }
//
//        public void setCurrentTransaction(Transaction currentTransaction) {
//            this.currentTransaction = currentTransaction;
//        }
//
//        public ClientDAO(){
//        }
//
//        public void persist(Client entity) {
//            getCurrentSession().save(entity);
//        }
//
//        public void update(Client entity) {
//            getCurrentSession().update(entity);
//        }
//
//        public Client findById(Integer id) {
//            Client client = (Client) getCurrentSession().get(Client.class, id);
//            return client;
//        }
//
//        public void delete(Client entity) {
//            getCurrentSession().delete(entity);
//        }
//
//        public List<Client> findAll() {
//            List<Client> books = (List<Client>) getCurrentSession().createQuery("from clients").list();
//            return null;
//        }
//
//        public void deleteAll() {
//            List<Client> entityList = findAll();
//            for (Client entity : entityList) {
//                delete(entity);
//            }
//        }
}

package com.var.agregator.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;

import static com.var.agregator.utils.HibernateUtil.getSessionFactory;

/**
 * Created by ivan on 16.12.15.
 */
public class DaoUtil<T,Id extends Serializable> {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public void persist(T entity) {
        currentSession.save(entity);
    }

    public void update(T entity) {
        currentSession.update(entity);
    }

    public void delete(T entity) {
        currentSession.delete(entity);
    }
}

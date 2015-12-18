package com.var.agregator.utils;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by ivan on 17.11.15.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
//                sessionFactory = new Configuration().configure().buildSessionFactory();
//            Configuration configuration = new Configuration();
//            configuration.configure();
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError("Good morning Ivan!");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

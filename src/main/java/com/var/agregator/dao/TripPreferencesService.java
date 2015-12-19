//package com.var.agregator.dao;
//
//import com.var.agregator.dto.client.TripPreferences;
//import org.hibernate.Query;
//
//import java.util.List;
//
///**
// * Created by ivan on 18.12.15.
// */
//public class TripPreferencesService {
//
//    private static TripPreferencesDAO tripPreferencesDAO;
//
//    static {
//        tripPreferencesDAO = new TripPreferencesDAO();
//    }
//
//    public static void persist(TripPreferences entity) {
//        tripPreferencesDAO.openCurrentSessionWithTransaction();
//        tripPreferencesDAO.persist(entity);
//        tripPreferencesDAO.closeCurrentSessionWithTransaction();
//    }
//
//    public static void update(TripPreferences entity) {
//        tripPreferencesDAO.openCurrentSessionWithTransaction();
//        tripPreferencesDAO.update(entity);
//        tripPreferencesDAO.closeCurrentSessionWithTransaction();
//    }
//
//    public static TripPreferences findById(Integer id) {
//        tripPreferencesDAO.openCurrentSession();
//        TripPreferences tripPreferences = tripPreferencesDAO.findById(id);
//        tripPreferencesDAO.closeCurrentSession();
//        return tripPreferences;
//    }
//
//    public static void delete(Integer id) {
//        tripPreferencesDAO.openCurrentSessionWithTransaction();
//        TripPreferences tripPreferences = tripPreferencesDAO.findById(id);
//        tripPreferencesDAO.delete(tripPreferences);
//        tripPreferencesDAO.closeCurrentSessionWithTransaction();
//    }
//
//    public static List<TripPreferences> findAll() {
//        tripPreferencesDAO.openCurrentSession();
//        List<TripPreferences> tripPreferencesList = tripPreferencesDAO.findAll();
//        tripPreferencesDAO.closeCurrentSession();
//        return tripPreferencesList;
//    }
//
//    public static void deleteAll() {
//        tripPreferencesDAO.openCurrentSessionWithTransaction();
//        tripPreferencesDAO.deleteAll();
//        tripPreferencesDAO.closeCurrentSessionWithTransaction();
//    }
//
//    public static void delete(TripPreferences tripPreferences){
//        tripPreferencesDAO.openCurrentSessionWithTransaction();
//        tripPreferencesDAO.delete(tripPreferences);
//        tripPreferencesDAO.closeCurrentSessionWithTransaction();
//    }
//
//    public static TripPreferencesDAO tripPreferencesDAO() {
//        return tripPreferencesDAO;
//    }
//}

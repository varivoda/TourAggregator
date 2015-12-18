package com.var.agregator.dao;

import com.var.agregator.dto.client.TripPreferences;

import java.util.List;

/**
 * Created by ivan on 16.12.15.
 */
public class TripPreferencesDAO extends DAOAbstract<TripPreferences,Integer>  {

    @Override
    public TripPreferences findById(Integer id) {
        TripPreferences tripPreferences = (TripPreferences) getCurrentSession().get(TripPreferences.class, id);
        return tripPreferences;
    }

    @Override
    public List<TripPreferences> findAll() {
        List<TripPreferences> tripPreferencesList = (List<TripPreferences>) getCurrentSession().createQuery("from trip_preferences").list();
        if (tripPreferencesList.isEmpty())
            return null;
        return tripPreferencesList;
    }

    @Override
    public void deleteAll() {
        List<TripPreferences> tripPreferencesList = findAll();
        for (TripPreferences tripPreferences : tripPreferencesList) {
            delete(tripPreferences);
        }
    }
}

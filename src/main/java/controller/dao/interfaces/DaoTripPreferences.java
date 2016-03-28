package controller.dao.interfaces;

import model.client.TripPreferences;

import java.util.List;

/**
 * Created by ivan on 28.03.16.
 */
public interface DaoTripPreferences extends DaoInterface<TripPreferences, Integer> {

    public List<TripPreferences> findByClientId(Integer clientId);

}

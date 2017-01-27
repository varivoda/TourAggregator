package controller.dao;

import model.client.TripPreferences;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TripPreferencesDAO extends IDAO<TripPreferences, Integer> {

    List<TripPreferences> findByClientId(Integer clientId);

}

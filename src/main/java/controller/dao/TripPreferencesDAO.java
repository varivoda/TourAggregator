package controller.dao;

import model.client.TripPreferences;
import java.util.List;

/**
 * Created by ivan on 28.03.16.
 */
public interface TripPreferencesDAO extends IDAO<TripPreferences, Integer> {

    List<TripPreferences> findByClientId(Integer clientId);

}

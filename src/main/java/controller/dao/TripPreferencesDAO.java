package controller.dao;

import model.client.TripPreferences;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by ivan on 28.03.16.
 */
@Local
public interface TripPreferencesDAO extends IDAO<TripPreferences, Integer> {

    List<TripPreferences> findByClientId(Integer clientId);

}

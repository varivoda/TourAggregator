package TripPreferencesTests;

import controller.dao.impl.TripPreferencesDAOImpl;
import model.client.TripPreferences;
import org.junit.Test;

import java.util.List;

/**
 * Created by ivan on 03.03.16.
 */
public class TripPrefFindByClientIdTest {

    @Test
    public void findByClientId(){
        TripPreferencesDAOImpl tripPreferencesDAOImpl = new TripPreferencesDAOImpl();

        List<TripPreferences> tripPreferences = tripPreferencesDAOImpl.findByClientId(5);

    }

    @Test
    public void findAll(){
        TripPreferencesDAOImpl tripPreferencesDAOImpl = new TripPreferencesDAOImpl();

        List<TripPreferences> tripPreferences = tripPreferencesDAOImpl.findAll();
    }


}

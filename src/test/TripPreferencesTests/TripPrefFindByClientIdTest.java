package TripPreferencesTests;

import controller.dao.impl.DaoTripPreferencesImpl;
import model.client.TripPreferences;
import org.junit.Test;

import java.util.List;

/**
 * Created by ivan on 03.03.16.
 */
public class TripPrefFindByClientIdTest {

    @Test
    public void findByClientId(){
        DaoTripPreferencesImpl daoTripPreferencesImpl = new DaoTripPreferencesImpl();

        List<TripPreferences> tripPreferences = daoTripPreferencesImpl.findByClientId(5);

    }

    @Test
    public void findAll(){
        DaoTripPreferencesImpl daoTripPreferencesImpl = new DaoTripPreferencesImpl();

        List<TripPreferences> tripPreferences = daoTripPreferencesImpl.findAll();
    }


}

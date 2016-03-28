package TripPreferencesTests;

import controller.dao.TripPreferencesService;
import model.client.TripPreferences;
import org.junit.Test;

import java.util.List;

/**
 * Created by ivan on 03.03.16.
 */
public class TripPrefFindByClientIdTest {

    @Test
    public void findByClientId(){
        TripPreferencesService tripPreferencesService = new TripPreferencesService();

        List<TripPreferences> tripPreferences = tripPreferencesService.findByClientId(5);

    }

    @Test
    public void findAll(){
        TripPreferencesService tripPreferencesService = new TripPreferencesService();

        List<TripPreferences> tripPreferences = tripPreferencesService.findAll();
    }


}

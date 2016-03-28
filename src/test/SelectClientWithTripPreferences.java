/**
 * Created by ivan on 22.12.15.
 */
import controller.dao.impl.DaoClientImpl;
import controller.dao.impl.DaoTripPreferencesImpl;
import model.client.Client;
import model.client.TripPreferences;
import org.junit.Test;

public class SelectClientWithTripPreferences {

    @Test
    public void test(){
        DaoClientImpl cs = new DaoClientImpl();
//        Client client = cs.findById(1);
        Client client = cs.findByEmail("varivoda_ivan@mail.ru");

        DaoTripPreferencesImpl tps = new DaoTripPreferencesImpl();
        TripPreferences tp = tps.findById(2);

    }


}

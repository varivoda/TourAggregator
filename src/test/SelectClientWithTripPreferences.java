/**
 * Created by ivan on 22.12.15.
 */
import controller.dao.impl.ClientDAOImpl;
import controller.dao.impl.TripPreferencesDAOImpl;
import model.client.Client;
import model.client.TripPreferences;
import org.junit.Test;

public class SelectClientWithTripPreferences {

    @Test
    public void test(){
        ClientDAOImpl cs = new ClientDAOImpl();
//        Client client = cs.findById(1);
        Client client = cs.findByEmail("varivoda_ivan@mail.ru");

        TripPreferencesDAOImpl tps = new TripPreferencesDAOImpl();
        TripPreferences tp = tps.findById(2);

    }


}

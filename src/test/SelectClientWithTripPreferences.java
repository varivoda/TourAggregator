/**
 * Created by ivan on 22.12.15.
 */
import controller.dao.ClientService;
import controller.dao.TripPreferencesService;
import model.client.Client;
import model.client.TripPreferences;
import org.junit.Test;

public class SelectClientWithTripPreferences {

    @Test
    public void test(){
        ClientService cs = new ClientService();
//        Client client = cs.findById(1);
        Client client = cs.findByEmail("varivoda_ivan@mail.ru");

        TripPreferencesService tps = new TripPreferencesService();
        TripPreferences tp = tps.findById(2);

    }


}

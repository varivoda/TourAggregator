/**
 * Created by ivan on 22.12.15.
 */
import com.var.agregator.dao.ClientService;
import com.var.agregator.dao.TripPreferencesService;
import com.var.agregator.dto.client.Client;
import com.var.agregator.dto.client.TripPreferences;
import org.junit.Test;

public class SelectClientWithTripPreferences {

    @Test
    public void test(){
        ClientService cs = new ClientService();
        Client client = cs.findById(1);

        TripPreferencesService tps = new TripPreferencesService();
        TripPreferences tp = tps.findById(2);

    }


}

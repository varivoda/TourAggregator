import controller.dao.ClientService;
import controller.dao.TripPreferencesService;
import model.client.Client;
import model.client.TripPreferences;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ivan on 16.12.15.
 */
public class CRUDTpirPreferenceTests {

    @Test
    public void InsertUpdateTest(){
        TripPreferences tp = new TripPreferences();
        TripPreferencesService tps = new TripPreferencesService();
        ClientService cs = new ClientService();
        Client client = cs.findById(1);

        Date deaptureDate = null;
        Date arrivalDate = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        String deparetureDateS = "2015-12-31 21:00:00";
        String arrivalDateS = "2016-01-12 12:10:00";
        try {
            deaptureDate = sdf.parse(deparetureDateS);
            arrivalDate = sdf.parse(arrivalDateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // initializing date
        tp.setDepartureDate(deaptureDate);
        tp.setArrivalDate(arrivalDate);

        tp.setBudget(new BigDecimal(100.10));
        tp.setClient(client);
        tp.setTransportKind("Avto");
        tp.setResidentHotelKind("Hotel");
        tp.setTripDocumentType("Visa");
        tp.setTravelersQuantity(4);

        tps.persist(tp);

    }
}

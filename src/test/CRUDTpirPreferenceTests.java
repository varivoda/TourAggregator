import com.var.agregator.dto.client.TripPreferences;
import org.junit.Test;

import java.util.Date;

/**
 * Created by ivan on 16.12.15.
 */
public class CRUDTpirPreferenceTests {

    @Test
    public void InsertUpdateTest(){
        TripPreferences tp = new TripPreferences();
        tp.setDepartureDate(new Date());
    }
}

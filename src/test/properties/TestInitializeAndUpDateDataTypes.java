package properties;

import controller.util.TourContentData;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by ivan on 01.04.16.
 */
public class TestInitializeAndUpDateDataTypes {

    @Test
    public void testInitialize(){
        try {
            Context ctx = new InitialContext();
            TourContentData dt = (TourContentData) ctx.lookup("TourContentData");
            System.out.println();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}

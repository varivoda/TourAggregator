package properties;

import model.ContentDataBean;
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
            ContentDataBean dt = (ContentDataBean) ctx.lookup("ContentDataBean");
            System.out.println();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}

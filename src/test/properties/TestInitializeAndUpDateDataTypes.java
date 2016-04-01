package properties;

import model.DataTypes;
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
            DataTypes dt = (DataTypes) ctx.lookup("DataTypes");
            System.out.println();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}

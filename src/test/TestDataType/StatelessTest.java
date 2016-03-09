package TestDataType;

import com.var.agregator.dto.data.DataTypes;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

/**
 * Created by ivan on 03.03.16.
 */
public class StatelessTest {

    private static EJBContainer ejbContainer;

    @BeforeClass
    public static void startContainer(){
        ejbContainer = EJBContainer.createEJBContainer();
    }

    @Test
    public void test_(){
        DataTypes dt = null;
        try {
            dt = (DataTypes) ejbContainer.getContext().lookup("java:global/TourAgregator/DataTypes");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        assertTrue( dt instanceof DataTypes );
    }
}

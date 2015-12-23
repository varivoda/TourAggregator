/**
 * Created by ivan on 14.12.15.
 */
import com.var.agregator.utils.CategoriesParser;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class TestForCategories {

    @Test
    public void test() {
        Properties property = new Properties();
        Set<String> elements = new HashSet<String>();
        try {
            property.load(new FileInputStream(System.getProperty("user.dir")+"/src/resources/config/initdata.properties"));
            elements = new HashSet<String>(Arrays.asList(property.getProperty("TransportKinds").split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

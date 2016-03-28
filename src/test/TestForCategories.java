/**
 * Created by ivan on 14.12.15.
 */
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
            String userDir = System.getProperty("user.dir");
            property.load(new FileInputStream(System.getProperty("user.dir")+"/src/resources/config/initData.properties"));
            elements = new HashSet<String>(Arrays.asList(property.getProperty("TransportKinds").split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

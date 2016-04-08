package properties;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ivan on 31.03.16.
 */
public class TestLoadPropertyByClassLoader {

    @Test
    public void testClassLoader(){

        try {
            Class cls = Class.forName("model.client.Client");
//            ClassLoader classLoader = cls.getClassLoader();
//            Class cl = Class.forName("java.util.Properties");
//            ClassLoader classLoader = cls.getClassLoader();
            InputStream inputStream = cls.getClassLoader().getResourceAsStream("src/initData.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            System.out.println();
        }
            catch(IOException e){
                e.printStackTrace();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }

//    @Test
    public void testRelPath(){
        try {
//            InputStream inputStream = new FileInputStream("/home/ivan/IdeaProjects/TourAgregator/src/resources/initData.properties");
            InputStream inputStream = new FileInputStream("src/initData.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ejb;

import model.TourContentData;
import org.junit.*;

import java.io.IOException;

/**
 * Created by ivan on 01.04.16.
 */
public class TestContentDataBean {

    private static TourContentData tourContentData;

    @Test
    public void test(){
        try {
            TourContentData.upDate();
            System.out.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public  static void tearDownClass(){
        System.out.println("End of testing");
    }
}

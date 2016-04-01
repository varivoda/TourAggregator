package ejb;

import model.ContentDataBean;
import org.junit.*;

import java.io.IOException;

/**
 * Created by ivan on 01.04.16.
 */
public class TestContentDataBean {

    private static ContentDataBean contentDataBean;

    @BeforeClass
    public static void setUpClass() {
        try {
            contentDataBean = new ContentDataBean();
            System.out.println("Start testing");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        try {
            contentDataBean.upDate();
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

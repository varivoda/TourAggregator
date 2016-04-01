//package ejb;
//
//import controller.gds.sabre.SabrePropertiesBean;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.io.IOException;
//
///**
// * Created by ivan on 01.04.16.
// */
//public class TestSabreSettingsBean {
//
//    private static SabrePropertiesBean sbp;
//
//    @BeforeClass
//    public static void setUpClass(){
//        try {
//            sbp = new SabrePropertiesBean();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void test(){
//        try {
//            sbp.upDate();
//            System.out.println();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String expAccessToken = "Bearer T1RLAQI23iTgRQizcJ6vSXzjAIhRcwFfVxBtaeQ7L/s9R7y50+OqSR53AACg3EQlz9mqf4IEo59XVRNryOBFduBLOWwu4/I9DvP0ZaYrvQxZXRVTGgafeLwsIQLlYKdJuPaUWlCZiECvW14SxLfyepIBiA6t99ff2ewajEmF7mSo/YdZvYYdNSLDNJTWbjOwOnHX6s8JvooKK5Euy3dY60msUMVUFKr+CQzsT1zCui46hhhfZmQPHSGG9AQYWy3X95Q8erzwwgp1W3XN2g**";
//        String expxOriginatingIp = "217.197.2.62";
//        String expFlightsURL = "https://api.test.sabre.com/v2/shop/flights/fares";
//        String expHotelsURL = "";
//        String expCarsURL = "";
//
//        Assert.assertEquals(expAccessToken, sbp.getAccessToken());
//        Assert.assertEquals(expxOriginatingIp, sbp.getxOriginatingIp());
//        Assert.assertEquals(expCarsURL, sbp.getCarsURL());
//        Assert.assertEquals(expHotelsURL, sbp.getHotelsURL());
//        Assert.assertEquals(expFlightsURL, sbp.getFlightsURL());
//    }
//}

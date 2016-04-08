//package testJsonUtil;
//
//import controller.utils.JsonUtil;
//import controller.utils.JsonUtilImpl;
//import controller.utils.RestUtil;
//import controller.utils.RestUtilImpl;
//import org.json.simple.parser.ParseException;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by ivan on 08.03.16.
// */
//public class testJson {
//
////    @Test
//    public void test(){
//        RestUtil restUtil = new RestUtilImpl();
//        JsonUtil jsonUtil = new JsonUtilImpl();
//        String url = "https://api.test.sabre.com/v1/shop/flights";
////        https://api.test.sabre.com/v2/shop/flights/fares
//        Map<String, String> parameters = new HashMap<String, String>();
//
//        parameters.put("origin","JFK");
//        parameters.put("destination","LAX");
//        parameters.put("departuredate","2016-03-25");
//        parameters.put("returndate","2016-03-29");
//        parameters.put("onlineitinerariesonly","N");
//        parameters.put("limit","10");
//        parameters.put("offset","1");
//        parameters.put("eticketsonly","N");
//        parameters.put("sortby","totalfare");
//        parameters.put("order","asc");
//        parameters.put("sortby2","departuretime");
//        parameters.put("order2","asc");
//        parameters.put("pointofsalecountry","US");
//
//        try {
//            String tourJson = restUtil.sendGet(url,parameters);
//            jsonUtil.getJson(tourJson);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void testFairSrevice(){
//
//        RestUtil restUtil = new RestUtilImpl();
//        JsonUtil jsonUtil = new JsonUtilImpl();
//        String url = "https://api.test.sabre.com/v2/shop/flights/fares";
//        Map<String, String> parameters = new HashMap<String, String>();
//
//        parameters.put("origin","JFK");
//        parameters.put("destination","LAX");
//        parameters.put("departuredate","2016-06-01");
//        parameters.put("lengthofstay","6");
//        parameters.put("pointofsalecountry","US");
//
//        try {
//            String tourJson = restUtil.sendGet(url,parameters);
//            jsonUtil.getJson(tourJson);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }
//}

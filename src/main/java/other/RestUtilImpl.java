//package controller.utils;
//
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Map;
//
///**
// * Created by ivan on 09.03.16.
// */
//@Stateless
//@LocalBean
//public class RestUtilImpl implements RestUtil {
//
////    private static final String AUTHORIZATION = "Bearer T1RLAQItZWfLF01dxEAgeQ8N2hWb7fgBLRD5Q8XM8EMyNfYIa"+
////            "QojLYhgAACgH1Ghoq7z97YHty/eJKOCXOEbgi0c7I0G3eFwl/"+
////            "pe0uW4Y2fesTrYuXuvVeHCYOz/FVTOdEEPW3lRk+nS+8M0RkGSy"+
////            "Wqrx+iasIUYvsNwGx5FrbZJHr4sxY1OIy83+ExQonC3DQwGzeubg"+
////            "tEw18tbAoeQQCBOtdyTTbTn20o9vhs+yRa7qkYWrEETWuT4ss84t"+
////            "GP4nrcGg48U5i+gHorLGA**";
//
//
//    public RestUtilImpl() {
//    }
//
//    private static final String AUTHORIZATION ="Bearer T1RLAQIQe1NQs+YfBVQgflI5XSkNXxFOvBDpGhTpczmMjMD027h9TWkHAACgdLUCIDbpZVLAZos5EvnIRa0TkValw/0fMY+DFVWLVowka2PQSNPi7e/tlwTdupydsduYIUbapfZTRKvPDj18Y7xV/UdbVqkQiyDyOdFDJ75biwpZOnO/xRBqwXmgI3+pspxwfVezfGW/D6sdxLo2WslrL0cNf/luws3fo/EOjfKDxOWDOgCo0rlEhm1CclJHJDKNZNEN+Xd/hAMWWwKKQg**";
//
//    private static final String X_ORIGINATING_IP = "217.197.2.62";
//
//    public String sendGet(String url, Map<String, String> parameters) throws IOException {
//        StringBuilder urlBuilder = new StringBuilder();
//        urlBuilder.append(url);
//        urlBuilder.append('?');
//
//        if (parameters != null) {
//            for (Map.Entry<String, String> entry : parameters.entrySet()) {
//                urlBuilder.append(entry.getKey()).append('=').append(entry.getValue()).append('&');
//            }
//        }
//        urlBuilder.delete(urlBuilder.length()-1,urlBuilder.length());
//
//        URL obj = new URL(urlBuilder.toString());
//        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//
//        connection.setRequestMethod("GET");
//        connection.setRequestProperty("Authorization", AUTHORIZATION);
//        connection.setRequestProperty("X-Originating-Ip", X_ORIGINATING_IP);
//
//        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
//        String inputLine;
//        StringBuffer responseBuilder = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            responseBuilder.append(inputLine);
//        }
//        in.close();
//
//        return responseBuilder.toString();
//    }
//
//    public String sentPost(String url, Map<String, String> parameters) {
//        return null;
//    }
//}

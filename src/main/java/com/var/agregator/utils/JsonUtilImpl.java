package com.var.agregator.utils;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ivan on 08.03.16.
 */
public class JsonUtilImpl implements JsonUtil {

    private static final String ACCESS_TOKEN = "T1RLAQItZWfLF01dxEAgeQ8N2hWb7fgBLRD5Q8XM8EMyNfYIa"+
                                                "QojLYhgAACgH1Ghoq7z97YHty/eJKOCXOEbgi0c7I0G3eFwl/"+
                                                "pe0uW4Y2fesTrYuXuvVeHCYOz/FVTOdEEPW3lRk+nS+8M0RkGSy"+
                                                "Wqrx+iasIUYvsNwGx5FrbZJHr4sxY1OIy83+ExQonC3DQwGzeubg"+
                                                "tEw18tbAoeQQCBOtdyTTbTn20o9vhs+yRa7qkYWrEETWuT4ss84t"+
                                                "GP4nrcGg48U5i+gHorLGA**";

    private static final String URL_SABRE_TEST = "https://api.test.sabre.com";
    private static final String URL_AIR_SEARCH = "/v1/shop/flights";
    private static final String TEST_PARAMS = "?origin=JFK&destination=LAX&departuredate=2016-03-25&returndate=2016-03-29"+
                                              "&onlineitinerariesonly=N&limit=10&offset=1&eticketsonly=N&sortby=totalfare"+
                                              "&order=asc&sortby2=departuretime&order2=asc&pointofsalecountry=US";

    private static final String AUTHORIZATION = "Bearer T1RLAQItZWfLF01dxEAgeQ8N2hWb7fgBLRD5Q8XM8EMyNfYIa"+
                                                "QojLYhgAACgH1Ghoq7z97YHty/eJKOCXOEbgi0c7I0G3eFwl/"+
                                                "pe0uW4Y2fesTrYuXuvVeHCYOz/FVTOdEEPW3lRk+nS+8M0RkGSy"+
                                                "Wqrx+iasIUYvsNwGx5FrbZJHr4sxY1OIy83+ExQonC3DQwGzeubg"+
                                                "tEw18tbAoeQQCBOtdyTTbTn20o9vhs+yRa7qkYWrEETWuT4ss84t"+
                                                "GP4nrcGg48U5i+gHorLGA**";

    private static final String X_ORIGINATING_IP = "217.197.2.62";
    public JSONObject getJson(String url) {
        try {
            String tourJson = IOUtils.toString(new URL(url));
            JSONObject tourJsonObject = (JSONObject) JSONValue.parseWithException(tourJson);
            // get the title
            System.out.println(tourJsonObject.get("title"));
            // get the data
            JSONArray genreArray = (JSONArray) tourJsonObject.get("dataset");
            // get the first genre
            JSONObject firstGenre = (JSONObject) genreArray.get(0);
            System.out.println(firstGenre.get("genre_title"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendGet() throws IOException {
        String url = URL_SABRE_TEST+URL_AIR_SEARCH+TEST_PARAMS;
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", AUTHORIZATION);
        connection.setRequestProperty("X-Originating-Ip", X_ORIGINATING_IP);

        int responseCode = connection.getResponseCode();

        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }
}

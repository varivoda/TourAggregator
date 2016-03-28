package controller.utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 * Created by ivan on 08.03.16.
 */
public class JsonUtilImpl implements JsonUtil {


    public JSONObject getJson(String tourJson) throws ParseException {
            JSONObject tourJsonObject = (JSONObject) JSONValue.parseWithException(tourJson);
        return tourJsonObject;
    }


}

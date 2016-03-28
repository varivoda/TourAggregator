package controller.utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Created by ivan on 08.03.16.
 */
public interface JsonUtil {

    public JSONObject getJson(String url) throws ParseException;
}

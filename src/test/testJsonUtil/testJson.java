package testJsonUtil;

import com.var.agregator.utils.JsonUtil;
import com.var.agregator.utils.JsonUtilImpl;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ivan on 08.03.16.
 */
public class testJson {

    @Test
    public void test(){
        JsonUtilImpl jsonUtil = new JsonUtilImpl();
        try {
            jsonUtil.sendGet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

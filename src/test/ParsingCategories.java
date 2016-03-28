/**
 * Created by ivan on 12.12.15.
 */

import controller.utils.CategoriesParser;
import org.junit.Test;
import java.io.IOException;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class ParsingCategories{


    @Test
    public void testingCorrectSet(){
        HashSet<String> correctSet = new HashSet<String>(Arrays.asList("Bar","Barbecue","Bistro"));
        Set<String> expectedSet = null;
        try {
            expectedSet = CategoriesParser.getSet(System.getProperty("user.dir") + "/src/test/testdata/test_restourant_types.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String cur : correctSet) {
            if (!expectedSet.contains(cur)){
                assertEquals(cur,"");
            }
        }
        for (String cur : expectedSet) {
            if (!correctSet.contains(cur)){
                assertEquals(cur,"");
            }
        }
    }

    @Test
    public void testingCorrectSetOtherOrder(){
        HashSet<String> correctSet = new HashSet<String>(Arrays.asList("Barbecue","Bistro","Bar"));
        Set<String> expectedSet = null;
        try {
              expectedSet = CategoriesParser.getSet(System.getProperty("user.dir") + "/src/test/testdata/test_restourant_types.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String cur : correctSet) {
            if (!expectedSet.contains(cur)){
                assertEquals(cur,"");
            }
        }
        for (String cur : expectedSet) {
            if (!correctSet.contains(cur)){
                assertEquals(cur,"");
            }
        }
    }

    @Test
    public void testingCorrectSetHotelKinds(){
        HashSet<String> correctSet = new HashSet<String>(Arrays.asList("Business hotel","Lodge","Motel","Bed and breakfast"));
        Set<String> expectedSet = null;
        try {
            expectedSet = CategoriesParser.getSet(System.getProperty("user.dir") + "/src/test/testdata/test_hotel_kinds.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String cur : correctSet) {
            if (!expectedSet.contains(cur)){
                assertEquals(cur,"");
            }
        }
        for (String cur : expectedSet) {
            if (!correctSet.contains(cur)){
                assertEquals(cur,"");
            }
        }
    }


}

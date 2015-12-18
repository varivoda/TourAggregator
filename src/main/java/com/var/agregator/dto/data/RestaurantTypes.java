package com.var.agregator.dto.data;

import com.var.agregator.utils.CategoriesParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Created by ivan on 23.11.15.
 */
public class RestaurantTypes {

    private static Set<String> elements;

    public static void main(String[] args) {
        upDate();
        for (String s: elements) {
            System.out.println(s);

        }
    }
    static {
        upDate();
    }

    public static boolean upDate(){
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(System.getProperty("user.dir")+"/src/resources/config/initdata.properties"));
            elements = CategoriesParser.getSet(System.getProperty("user.dir") + property.getProperty("dirRestaurantTypes"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Set<String> getElements(){
        return elements;
    }

    public static String[] toAray(){
        return elements.toArray(new String[0]);
    }


}

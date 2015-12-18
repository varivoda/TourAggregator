package com.var.agregator.dto.data;

import com.var.agregator.utils.CategoriesParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by ivan on 23.11.15.
 */
public class HotelKinds {

    private static Set<String> elements;

    static {
        upDate();
    }

    public static boolean upDate(){
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(System.getProperty("user.dir")+"/src/resources/config/initdata.properties"));
            elements = CategoriesParser.getSet(System.getProperty("user.dir" + property.getProperty("dirHotelKinds")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Set<String> getElements(){
        return elements;
    }

    public static String[] toArray(){
        return elements.toArray(new String[0]);
    }
}

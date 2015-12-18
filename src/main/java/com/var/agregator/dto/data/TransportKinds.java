package com.var.agregator.dto.data;

import com.var.agregator.utils.CategoriesParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Created by ivan on 23.11.15.
 */
public class TransportKinds {

    private static Set<String> elements;

    static{
        upDate();
    }

    public static boolean upDate(){
        // Коннект с БД и обновление
        return true;
    }

    public static Set<String> getElements(){
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(System.getProperty("user.dir")+"/src/resources/config/initdata.properties"));
            elements = CategoriesParser.getSet(System.getProperty("user.dir" + property.getProperty("dirTransportKinds")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elements;
    }

    public static String[] toArray(){
        return  elements.toArray(new String[0]);
    }
}

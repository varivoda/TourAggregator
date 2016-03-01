package com.var.agregator.dto.data;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 23.11.15.
 */
public class TransportKinds {

    private static Set<String> elements = new HashSet<String>();

    static{
        elements.add("Plane");
        upDate();
    }

    public static boolean upDate(){
        // Коннект с БД и обновление
        return true;
    }

    public static Set<String> getElements(){
//        Properties property = new Properties();
//        try {
//            property.load(new FileInputStream(System.getProperty("user.dir")+"/src/resources/config/initdata.properties"));
//            elements = CategoriesParser.getSet(System.getProperty("user.dir" + property.getProperty("dirTransportKinds")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return elements;
    }

    public static String[] toArray(){
        return  elements.toArray(new String[0]);
    }
}

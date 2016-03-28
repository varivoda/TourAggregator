//package com.var.agregator.dto.data;
//
//
//import CategoriesParser;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Properties;
//import java.util.Set;
//
///**
// * Created by ivan on 23.11.15.
// */
//public class TransportKinds {
//
//    private static Set<String> elements = new HashSet<String>();
//
//    static{
//        upDate();
//    }
//
//    public static boolean upDate() {
//        Properties property = new Properties();
//        try {
//            property.load(new FileInputStream(System.getProperty("user.dir") + "/src/resources/config/initData.properties"));
//            elements = CategoriesParser.getSet(System.getProperty("user.dir" + property.getProperty("TransportKinds")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    public static Set<String> getElements(){
//        return elements;
//    }
//
//    public static String[] toArray(){
//        return  elements.toArray(new String[0]);
//    }
//}

package controller.utils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 12.12.15.
 */
public class CategoriesParser {

    public static final char separator = ',';

    public static Set<String> getSet(String pathName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(pathName));
        int curChar = 0;
        Set<String> result = new HashSet<String>();
        StringBuilder sb = new StringBuilder();

        while( curChar != -1  ) {
            while ( (curChar = br.read()) != separator && curChar != -1){
                sb.append((char) curChar);
            }
            result.add(sb.toString());
            sb.delete(0, sb.length());
        }
    return result;
    }

}

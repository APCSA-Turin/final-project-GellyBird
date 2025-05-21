package com.example;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Helper methods for the GoogleMaps class
 * Will be used to help with handling search filters
 */
public class Helpers {
        public static JSONArray distanceSort (JSONArray words) {
        for (int i = 0; i < words.length(); i ++) {
            for (int j = i; j < words.length(); j ++) {
                if (Double.compare(words.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lat"),words.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat")) > 0 ) { 
                    Object temp = words.get(i);
                    words.put(i, words.get(j));
                    words.put(j, temp);
                }
            }
           }

        for (int i = 0; i < words.length(); i ++) {
            for (int j = i; j < words.length(); j ++) {
                if (Double.compare(words.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lng"),words.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng")) > 0 ) { 
                    Object temp = words.get(i);
                    words.put(i, words.get(j));
                    words.put(j, temp);
                }
            }
           }
        return words;
    }

}

package com.example;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Helper methods for the GoogleMaps class
 * Will be used to help with handling search filters
 */
public class Helpers {


        // this method needs to be redone entirely, it should compare by subtracting the lat/lng from the lat/lng of the address. AND USE ABSOLUTE VALUE PLEASE
        // Also change GoogleMaps address method to use a seperate "getCoords" so that it's easier to get the coordinates for this.
        // If it's comparing solely based on the number itself, then ofc it's going to list numbers with pos lat/lng first than those with neg, even though the distance is technically longer because the +/- indicates direction
        public static JSONArray distanceSort (JSONArray words) {
        for (int i = 0; i < words.length(); i ++) {
            for (int j = i; j < words.length(); j ++) {
                if (Double.compare(words.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lat"),words.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat")) < 0 ) { 
                    Object temp = words.get(i);
                    words.put(i, words.get(j));
                    words.put(j, temp);
                }
            }
           }

        for (int i = 0; i < words.length(); i ++) {
            for (int j = i; j < words.length(); j ++) {
                if (Double.compare(words.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lng"),words.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng")) < 0 ) { 
                    Object temp = words.get(i);
                    words.put(i, words.get(j));
                    words.put(j, temp);
                }
            }
           }
        return words;
    }

}

package com.example;
import org.json.JSONArray;

/**
 * Helper methods for the GoogleMaps class
 * Will be used to help with handling search filters and general formatting
 */
public class Filters {


        /**
         * Sorts the given list from closest to furthest away.
         * Because lat/lng uses -/+ to indicate direction, The program has to work solely with absolute values or else it will calculate the distance wrong.
         * First sorts by closest latitude and then sorts by closest longitude
         * @param locations
         * @return
         */
        public static JSONArray closestDistanceSort (JSONArray locations) {
            double addressLat = Math.abs(GoogleMaps.getLat());
            double addressLng =  Math.abs(GoogleMaps.getLon());

        for (int i = 0; i < locations.length(); i ++) {
            for (int j = i; j < locations.length(); j ++) {
                if (Double.compare(Math.abs(addressLat - Math.abs(locations.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lat"))),Math.abs(addressLat - Math.abs(locations.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat")))) < 0 ) { 
                    Object temp = locations.get(i);
                    locations.put(i, locations.get(j));
                    locations.put(j, temp);
                }
            }
           }

        for (int i = 0; i < locations.length(); i ++) {
            for (int j = i; j < locations.length(); j ++) {
                if (Double.compare(Math.abs(addressLng - Math.abs(locations.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lng"))),Math.abs(addressLng - Math.abs(locations.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng")))) < 0 ) { 
                    Object temp = locations.get(i);
                    locations.put(i, locations.get(j));
                    locations.put(j, temp);
                }
            }
           }
        return locations;
    }

            /**
         * Sorts the given list from furthest away to closest. 
         * Because lat/lng uses -/+ to indicate direction, The program has to work solely with absolute values or else it will calculate the distance wrong.
         * First sorts by furthest latitude and then sorts by furthest longitude
         * The program sorts by closest --> furthest by default, but this is in case the user would like to sort by furthest first.
         * @param locations
         * @return
         */
        public static JSONArray furthestDistanceSort (JSONArray locations) {
            double addressLat = Math.abs(GoogleMaps.getLat());
            double addressLng =  Math.abs(GoogleMaps.getLon());

        for (int i = 0; i < locations.length(); i ++) {
            for (int j = i; j < locations.length(); j ++) {
                if (Double.compare(Math.abs(addressLat - Math.abs(locations.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lat"))),Math.abs(addressLat - Math.abs(locations.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat")))) > 0 ) { 
                    Object temp = locations.get(i);
                    locations.put(i, locations.get(j));
                    locations.put(j, temp);
                }
            }
           }

        for (int i = 0; i < locations.length(); i ++) {
            for (int j = i; j < locations.length(); j ++) {
                if (Double.compare(Math.abs(addressLng - Math.abs(locations.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lng"))),Math.abs(addressLng - Math.abs(locations.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng")))) > 0 ) { 
                    Object temp = locations.get(i);
                    locations.put(i, locations.get(j));
                    locations.put(j, temp);
                }
            }
           }
        return locations;
    }



}

package com.example;

import org.json.JSONArray;

/**
 * For providing statistical data from each location or the locations overall.
 * To be used in combination with Filters.java and GoogleMaps.java to filter out data
 * 
 * Functionalities to add:
 * Average distance away, distance away of each location,
 * maybed estimate how long it would take to walk to each location/specified location?
 */
public class Stats {

    /**
     * Returns the average #of stars for all stores in the user's area (rating)
     * @param stores
     * @return
     */
    public static double avStars (JSONArray stores) {
        double total = 0.0;
        for (int i = 0; i < stores.length(); i ++) {
           total += stores.getJSONObject(i).getDouble("rating");
        }
        return 0.1 * Math.floor((total/stores.length())*10.0);
    }
}

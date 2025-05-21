package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Just for handling requests/getting data from the Maps API
 * Planning to try and write this to use very few calls, but we'll see if I can manage that.
 */

public class GoogleMaps {
    private static String apiKey = "AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o"; // The Key
    private static String address = "";
    private static double lat = 0.0; // latitude
    private static double lon = 0.0; // longitude
    private static String placesApiLink = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=antique+thrift+vintage&location="+lat+","+lon+"&radius=100.0&key=AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o"; // will update this to include search filters, should be easy. (famous last words)
    private static String geoApiLink = "https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key=AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o";

    // GETTER METHODS
    public static String getApiKey() {return apiKey;} // returns the apiKey if needed
    public static String getApiLink() {return placesApiLink;} // returns the apiLink aka endpoint
    public static double getLat() {return lat;} // returns latitude
    public static double getLon() {return lon;} // returns longitutde

    // SETTER METHODS
    public static void setLat(double newLat) {lat=newLat;} // updates latitude
    public static void setLon(double newLon) {lon=newLon;} // updates longitutde
    public static void setAddress(String newAddress) throws Exception { // used for changing the entire address, formats it for using in a link and then get's the lat/lon using google geocode api
        newAddress = newAddress.replace(' ', '+');
        address = newAddress; 
        geoApiLink = "https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key=AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o";
        String jsonString = getData(geoApiLink);
        JSONObject obj = new JSONObject(jsonString);
        JSONArray results = obj.getJSONArray("results");
        JSONObject resultsObj = results.getJSONObject(0);
        JSONArray navPoints = resultsObj.getJSONArray("navigation_points");
        JSONObject location = navPoints.getJSONObject(0).getJSONObject("location");
        lat = location.getDouble("latitude");
        lon = location.getDouble("longitude");
        System.out.println("NEW ADDRESS: " + address + "\nLatitude: " + lat + "\nLongitude: " + lon);
        placesApiLink = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=antique+thrift+vintage&location="+lat+","+lon+"&radius=100.0&key=AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o";
    }

    // GET DATA FROM JSON (the important part)
    public static String getData(String endpoint) throws Exception {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = buff.readLine()) != null) {
            content.append(inputLine);
        }
        buff.close();
        connection.disconnect();
        return content.toString(); 
    }

    // FIND STORES BASED ON LOCATION
       public static void getStores() throws Exception {
        String jsonString = getData(placesApiLink);
        JSONObject obj = new JSONObject(jsonString);
        System.out.println(geoApiLink);
        JSONArray locations =  new JSONArray((JSONArray)obj.get("results"));
        JSONArray sortedLocations = new JSONArray(Helpers.distanceSort(locations));

         


        System.out.println("There are " + sortedLocations.length() + " stores in your area!");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < sortedLocations.length(); i ++) {
            System.out.println("Store " + (i + 1));
            System.out.println(sortedLocations.getJSONObject(i).getString("name"));
            System.out.println(sortedLocations.getJSONObject(i).getString("formatted_address"));
            System.out.println("---");
        }
    } 
}

package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 * Just for handling requests/getting data from the Maps API
 * Planning to try and write this to use very few calls, but we'll see if I can manage that.
 */

public class GoogleMaps {
    private static String apiKey = "AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o"; // The Key
    private static String address = "";
    private static double lat = 40.72534565744101; // latitude
    private static double lon = -73.94744810669593; // longitude
    private static String placesApiLink = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=antique,thrift,vintage&location="+lat+","+lon+"&key=AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o"; // will update this to include search filters, should be easy. (famous last words)
    private static String geoApiLink = "https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key=AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o";

    // GETTER METHODS
    public static String getApiKey() {return apiKey;} // returns the apiKey if needed
    public static String getApiLink() {return placesApiLink;} // returns the apiLink aka endpoint
    public static double getLat() {return lat;} // returns latitude
    public static double getLon() {return lon;} // returns longitutde

    // SETTER METHODS
    public static void setLat(double newLat) {lat=newLat;} // returns latitude
    public static void setLon(double newLon) {lon=newLon;} // returns longitutde
    public static void setAddress(String newAddress) {
        newAddress.replace(' ', '+');
        address = newAddress; 
    }

    // GET DATA (the important part)
    public static String getData(String endpoint) throws Exception {
        /*endpoint is a url (string) that you get from an API website*/
        URL url = new URL(endpoint);
        /*connect to the URL*/
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        /*creates a GET request to the API.. Asking the server to retrieve information for our program*/
        connection.setRequestMethod("GET");
        /* When you read data from the server, it wil be in bytes, the InputStreamReader will convert it to text. 
        The BufferedReader wraps the text in a buffer so we can read it line by line*/
        BufferedReader buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;//variable to store text, line by line
        /*A string builder is similar to a string object but faster for larger strings, 
        you can concatenate to it and build a larger string. Loop through the buffer 
        (read line by line). Add it to the stringbuilder */
        StringBuilder content = new StringBuilder();
        while ((inputLine = buff.readLine()) != null) {
            content.append(inputLine);
        }
        buff.close(); //close the bufferreader
        connection.disconnect(); //disconnect from server 
        return content.toString(); //return the content as a string
    }
    
}
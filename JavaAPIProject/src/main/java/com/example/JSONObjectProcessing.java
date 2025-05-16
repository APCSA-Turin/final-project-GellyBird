package com.example;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
    
public class JSONObjectProcessing {
public static void main(String[] args) throws Exception {

    
System.out.println(GoogleMaps.getApiLink());
/*this string is just an example, you would be pulling the json data from a server*/
String jsonString = GoogleMaps.getData(GoogleMaps.getApiLink());
//create the JSON object 
JSONObject obj = new JSONObject(jsonString);
//you can get the value of the key by calling the getString(key) method of JSON Object  
JSONArray locations =  new JSONArray((JSONArray)obj.get("results"));

System.out.println("There are " + locations.length() + " stores in your area!");
System.out.println("-------------------------------------------------");
for (int i = 0; i < locations.length(); i ++) {
    System.out.println("Store " + (i + 1));
    System.out.println(locations.getJSONObject(i).getString("name"));
    System.out.println(locations.getJSONObject(i).getString("formatted_address"));
    System.out.println("---");
}
    }
}

package com.example;

import org.json.JSONObject;
    
public class JSONObjectProcessing {
public static void main(String[] args) throws Exception {
/*this string is just an example, you would be pulling the json data from a server*/
String jsonString = GoogleMaps.getData(GoogleMaps.getApiLink());
//create the JSON object 
JSONObject obj = new JSONObject(jsonString);
//you can get the value of the key by calling the getString(key) method of JSON Object
String name = obj.getString("name");          
System.out.println(name);
}
}

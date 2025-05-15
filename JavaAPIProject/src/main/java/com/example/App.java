package com.example;
import org.json.JSONObject;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        double lat = 40.72534565744101 ; // latitude
        double lon = -73.94744810669593; // Longitude
        // for example, 40.72534565744101, -73.94744810669593 

        System.out.println(GoogleMaps.getData("https://maps.googleapis.com/maps/api/place/textsearch/json?query=antique,thrift,vintage&location="+lat+",%"+lon+"&radius=10&&key=AIzaSyCT5Yc5fX2y-0SLDgqKD3jNYnjOSe4nI8o"));
    }
}

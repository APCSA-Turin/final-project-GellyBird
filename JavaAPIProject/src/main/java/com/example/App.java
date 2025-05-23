package com.example;
import java.util.Scanner;

import org.json.JSONArray; 
/**
 * The app :)
 *
 * What needs to be added?:
 * Print statement explaining what the app does, just for now while It's still within terminal.
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an address (or say 'exit' to quit): ");
        String address = scan.nextLine();

        while (!address.toLowerCase().equals("exit")) {
        GoogleMaps.setAddress(address);
        JSONArray locations = GoogleMaps.getStores();

        System.out.print("Sorting Options: \n1) Closest\n2) Furthest\n3) Most Stars\n4) None\n");
        int option = scan.nextInt();

        if (option == 1) {
            locations = Filters.closestDistanceSort(locations);
        } else if (option == 2) {
            locations = Filters.furthestDistanceSort(locations);
        } else if (option == 3) {
            locations = Filters.mostStarsSort(locations);
        }

        System.out.println("There are " + locations.length() + " stores in your area!");
        System.out.println("The average rating is: " + Stats.avStars(locations) + " ⭐");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < locations.length(); i ++) {
            System.out.println("Store " + (i + 1));
            System.out.println(locations.getJSONObject(i).getString("name"));
            System.out.println(locations.getJSONObject(i).getString("formatted_address"));
            System.out.println("---");
        }
        System.out.print("Enter an address (or say 'exit' to quit): ");
        scan.nextLine();
        address = scan.nextLine();
        }
        scan.close();
    }
}
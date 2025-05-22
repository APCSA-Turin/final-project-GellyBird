package com.example;
import java.util.Scanner; 
/**
 * The app :)
 *
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
        GoogleMaps.getStores();

        System.out.print("Enter an address (or say 'exit' to quit): ");
        address = scan.nextLine();
        }
        scan.close();
    }
}
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
        System.out.println("Enter an address: ");
        GoogleMaps.setAddress(scan.nextLine());
        GoogleMaps.getStores();
    }
}
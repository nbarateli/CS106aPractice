package practice22;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class FlightPlanner extends ConsoleProgram {
    private static final String FLIGHTS_FILE = "flights.txt";
    private Map<String, ArrayList<String>> destinations;

    public void run() {
        readFromFile(FLIGHTS_FILE);
        printWelcome();
        printCities();
        getRoundTrip();
    }

    /* Method: printWelcome() */

    /**
     * Prints welcome messages on console.
     */
    private void printWelcome() {
        println("Welcome to Flight Planner!");
    }

    /* Method: printCities() */

    /**
     * Prints the list of all cities.
     */
    private void printCities() {
        println("Here's a list of all the cities in our database:");
        for (String city : destinations.keySet())
            println(" " + city);

    }

    /* Method: getRoundTrip() */

    /**
     * Prompts the user to select starting city, then any other available cities
     * until they come back to the starting city.
     */
    private void getRoundTrip() {
        println("Let's plan a round-trip route!");
        String startingCity = readCity("Enter the starting city: ");
        printDestinations(startingCity);

        String currentCity = readDestination(startingCity);
        String route = startingCity;
        while (!startingCity.equals(currentCity)) {
            printDestinations(currentCity);
            route += " -> " + currentCity;
            currentCity = readDestination(currentCity);
        }

        route += " -> " + currentCity;
        println("The route you've chosen is:\n" + route);
    }

    /* Method: readDestination(currentCity) */

    /**
     * Prompts the user to enter the next city in their route.
     */
    private String readDestination(String currentCity) {
        String destination = readCity("Where do you want to go from " + currentCity + " ? ");
        while (!destinations.get(currentCity).contains(destination)) {
            println("You can't go from " + currentCity + //
                    " to " + destination + " by a direct flight. ");
            printDestinations(currentCity);
            destination = readCity("Where do you want to go from " + currentCity + " ? ");
        }
        return destination;
    }

    /* Method: printDestinations(currentCity) */

    /**
     * Prints out every city where you can go from current city.
     */
    private void printDestinations(String currentCity) {
        println("From " + currentCity + " you can directly fly to:");
        for (String destination : destinations.get(currentCity))
            println(" " + destination);
    }

    /* Method: readCity() */

    /**
     * Prompts the user to enter valid name of the city and returns it when they
     * do.
     */
    private String readCity(String message) {
        String city = readLine(message);
        while (!destinations.containsKey(city))
            city = readLine(city + " was not found in database.\nPlease select another: ");
        return city;
    }

    /* Method: readFromFile(filename) */

    /**
     * Reads flight information from passed file and stores it in database.
     */
    private void readFromFile(String filename) {
        destinations = new HashMap<>();
        try {
            BufferedReader read = new BufferedReader(new FileReader(filename));
            while (true) {
                String line = read.readLine();
                if (line == null)
                    break;

                parseLine(line);
            }
            read.close();
        } catch (Exception e) {

        }
    }

    /* Method: parseLine(line) */

    /**
     * Parses a single line to database.
     */
    private void parseLine(String line) {
        if (line.length() == 0)
            return;
        String city1 = line.substring(0, line.indexOf("->") - 1);
        String city2 = line.substring(line.indexOf("->") + 3);
        if (!destinations.containsKey(city1))
            destinations.put(city1, new ArrayList<String>());

        destinations.get(city1).add(city2);
    }
}

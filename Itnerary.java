
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Itnerary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Travel Itinerary Planner!");

        System.out.print("Enter your destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter your start date (dd/mm/yyyy): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter your end date (dd/mm/yyyy): ");
        String endDate = scanner.nextLine();

        System.out.print("Do you prefer adventure, relaxation, or sightseeing? ");
        String preference = scanner.nextLine();

        System.out.print("Enter your budget (in USD): ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // consume the remaining newline

        // Simulate map generation (replace with actual API call)
        String mapLink = getMapLink(destination);

        // Simulate weather information (replace with actual API call)
        String weatherInfo = getWeatherInfo(destination);

        // Calculate budget details
        double accommodationCost = calculateAccommodationCost(budget);
        double foodCost = calculateFoodCost(budget);
        double activityCost = budget - (accommodationCost + foodCost);

        // Generate travel plan
        generateTravelPlan(destination, startDate, endDate, preference, mapLink, weatherInfo, budget, accommodationCost,
                foodCost, activityCost);
    }

    public static String getMapLink(String destination) {
        // Placeholder for Google Maps API Key
        String apiKey = "AIzaSyAfJs9jH19ojZmdsmP3YXJ4kZ6stlv1Y_Q";

        try {
            String formattedDestination = destination.replace(" ", "%20");
            String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=" + formattedDestination
                    + "&key=" + apiKey;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Assuming you parse the response and extract the map link or coordinates
            return "https://www.google.com/maps/search/?api=1&query=" + formattedDestination;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Unable to get map information.";
    }

    
    public static String getWeatherInfo(String destination) {
        String apiKey = "b454d0f3703f60f0c4c3ccb822a58b12";
    
        try {
            String formattedDestination = destination.replace(" ", "%20");
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + formattedDestination + "&appid=" + apiKey + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
    
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
    
            // Convert response to a string
            String jsonResponse = response.toString();
    
            // Manually extract key fields from the JSON response using basic string operations
            String temp = extractValue(jsonResponse, "\"temp\":", ",");
            String description = extractValue(jsonResponse, "\"description\":\"", "\"");
            String humidity = extractValue(jsonResponse, "\"humidity\":", ",");
            String windSpeed = extractValue(jsonResponse, "\"speed\":", ",");
    
            // Return formatted weather information
            return "Temperature: " + temp + "°C\n" +
                   "Weather: " + description + "\n" +
                   "Humidity: " + humidity + "%\n" +
                   "Wind Speed: " + windSpeed + " m/s";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return "Unable to get weather information.";
    }
    
    // Helper method to extract values between markers
    public static String extractValue(String json, String key, String delimiter) {
        try {
            int startIndex = json.indexOf(key) + key.length();
            int endIndex = json.indexOf(delimiter, startIndex);
            return json.substring(startIndex, endIndex).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    

    public static double calculateAccommodationCost(double budget) {
        // Assuming 40% of the budget goes to accommodation
        return budget * 0.4;
    }

    public static double calculateFoodCost(double budget) {
        // Assuming 30% of the budget goes to food
        return budget * 0.3;
    }

    public static void generateTravelPlan(String destination, String startDate, String endDate, String preference, String mapLink, String weatherInfo, double budget, double accommodationCost, double foodCost, double activityCost) {
        System.out.println("\n--- Travel Itinerary ---");
        System.out.println("Destination: " + destination);
        System.out.println("Travel Dates: " + startDate + " to " + endDate);
        System.out.println("Preference: " + preference);
        System.out.println("Weather Info: " + weatherInfo);
        System.out.println("Map Link: " + mapLink);

        System.out.println("\n--- Budget Breakdown ---");
        System.out.println("Total Budget: $" + budget);
        System.out.println("Accommodation: $" + accommodationCost);
        System.out.println("Food: $" + foodCost);
        System.out.println("Activities: $" + activityCost);

        System.out.println("\nEnjoy your trip to " + destination + "!");
    }
}

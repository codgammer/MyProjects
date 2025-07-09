import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city name:");
        String city = scanner.nextLine();

        WeatherService weatherService = new WeatherService();
        WeatherService.Weather weather = weatherService.getWeather(city);

        if (weather != null) {
            System.out.println("\nWeather details for " + city + ":");
            System.out.println("Temperature: " + weather.getTemperature() + "°C");
            System.out.println("Humidity: " + weather.getHumidity() + "%");
            System.out.println("Conditions: " + weather.getConditions());
            System.out.println(weather.getSuggestions());
        } else {
            System.out.println("Failed to retrieve weather data.");
        }

        scanner.close();
    }
}

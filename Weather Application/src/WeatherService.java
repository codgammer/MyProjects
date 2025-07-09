import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {

    private static final String API_KEY = "b611156bf2774a698fc5a917b66883b5";
    private static final String API_URL = "https://api.weatherbit.io/v2.0/current?city=%s&key=%s";

    public Weather getWeather(String city) {
        try {
            String urlString = String.format(API_URL, city, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            Gson gson = new Gson();
            WeatherResponse response = gson.fromJson(reader, WeatherResponse.class);
            reader.close();

            if (response != null && response.getData() != null && response.getData().length > 0) {
                double temperature = response.getData()[0].getTemp();
                int humidity = response.getData()[0].getRh();
                String conditions = response.getData()[0].getWeather().getDescription();
                return new Weather(temperature, humidity, conditions);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class Weather {
        private double temperature;
        private int humidity;
        private String conditions;

        public Weather(double temperature, int humidity, String conditions) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.conditions = conditions;
        }

        public double getTemperature() {
            return temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public String getConditions() {
            return conditions;
        }

        public String getSuggestions() {
            if (conditions.toLowerCase().contains("rain")) {
                return "Suggestion: Bring an umbrella!";
            } else if (temperature > 30) {
                return "Suggestion: Stay hydrated and wear light clothing!";
            } else if (temperature < 10) {
                return "Suggestion: Wear a jacket to stay warm!";
            } else {
                return "Suggestion: It's a nice day!";
            }
        }
    }
}

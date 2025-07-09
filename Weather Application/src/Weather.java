public class Weather {
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
        if (temperature < 10) {
            return "It's cold! Dress warmly.";
        } else if (temperature > 30) {
            return "It's hot! Stay hydrated.";
        } else {
            return "The weather is pleasant.";
        }
    }
    
}

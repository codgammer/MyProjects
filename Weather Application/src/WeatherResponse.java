import com.google.gson.annotations.SerializedName;

class WeatherResponse {
    @SerializedName("data")
    private WeatherData[] data;

    public WeatherData[] getData() {
        return data;
    }

    public void setData(WeatherData[] data) {
        this.data = data;
    }

    // Nested class to hold the weather data
    public static class WeatherData {
        private double temp;
        private int rh;

        @SerializedName("weather")
        private WeatherCondition weather;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getRh() {
            return rh;
        }

        public void setRh(int rh) {
            this.rh = rh;
        }

        public WeatherCondition getWeather() {
            return weather;
        }

        public void setWeather(WeatherCondition weather) {
            this.weather = weather;
        }
    }

    // Nested class for the weather conditions
    public static class WeatherCondition {
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}

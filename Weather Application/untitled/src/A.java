function getWeather() {
    const city = document.getElementById("cityInput").value;

    // If no city is entered
    if (!city) {
        alert("Please enter a city name.");
        return;
    }

    // Make an API call to fetch weather data
    fetch(`http://localhost:8080/weather?city=${city}`)
        .then(response => response.json())
        .then(data => {
            if (data) {
                document.getElementById("cityName").textContent = data.city;
                document.getElementById("temperature").textContent = `Temperature: ${data.temperature}°C`;
                document.getElementById("humidity").textContent = `Humidity: ${data.humidity}%`;
                document.getElementById("conditions").textContent = `Conditions: ${data.conditions}`;
                document.getElementById("suggestions").textContent = data.suggestions;

                // Set weather image based on conditions
                let imgSrc = "images/sunny.jpg"; // default
                if (data.conditions.toLowerCase().includes("rain")) {
                    imgSrc = "images/rainy.jpg";
                } else if (data.conditions.toLowerCase().includes("cloud")) {
                    imgSrc = "images/cloudy.jpg";
                }
                document.getElementById("weatherImage").src = imgSrc;

                document.getElementById("weatherDetails").classList.remove("hidden");
            } else {
                alert("Failed to retrieve weather data.");
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Error fetching weather data.");
        });
}

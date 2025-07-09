import pandas as pd
import numpy as np
from datetime import datetime, timedelta

# Create a list of dates
today = datetime.today()
dates = [today - timedelta(days=i) for i in range(100)]

# Generate random values for temperature, humidity, water required, and soil moisture
temperature = np.random.uniform(20, 35, 100)
humidity = np.random.uniform(40, 80, 100)
water_required = np.random.uniform(10, 50, 100)
soil_moisture = np.random.uniform(20, 60, 100)

# Generate crop types
crop_types = ['archenut', 'paddy', 'coffee beans']
crops = np.random.choice(crop_types, 100)

# Create a DataFrame
data = {
    'Date': dates,
    'Temperature (°C)': temperature,
    'Humidity (%)': humidity,
    'Water Required (liters)': water_required,
    'Soil Moisture (%)': soil_moisture,
    'Crop Type': crops
}

df = pd.DataFrame(data)

# Save the DataFrame to a CSV file
df.to_csv('crop_data.csv', index=False)

print("Dataset created and saved as 'crop_data.csv'")

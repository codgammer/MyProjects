'''import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
import pickle

# Load the dataset
df = pd.read_csv('water requirements.csv')

# Features and target variable
X = df[['temperature', 'rainfall (mm)', 'Soil Moisture', 'Crop Type']]
y = df['Water Requirement (liters)']

# Convert categorical data to numerical
X = pd.get_dummies(X, columns=['Crop Type'])

# Split the data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train the model
model = RandomForestRegressor()
model.fit(X_train, y_train)

# Save the trained model to a file
with open('model.pkl', 'wb') as file:
    pickle.dump(model, file)'''
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
import pickle

# Load the dataset
print("Loading dataset...")
df = pd.read_csv('water_requirements.csv')
print("Dataset loaded.")

# Features and target variable
print("Preparing features and target variable...")
X = df[['temperature', 'rainfall (mm)', 'Soil Moisture', 'Crop Type']]
y = df['Water Requirement (liters)']
print("Features and target prepared.")

# Convert categorical data to numerical
print("Converting categorical data to numerical...")
X = pd.get_dummies(X, columns=['Crop Type'])
print("Categorical data converted.")

# Split the data
print("Splitting data into training and testing sets...")
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
print("Data split.")

# Train the model
print("Training the model...")
model = RandomForestRegressor()
model.fit(X_train, y_train)
print("Model trained.")

# Save the trained model to a file
print("Saving the model...")
with open('model.pkl', 'wb') as file:
    pickle.dump(model, file)

print("Model saved as model.pkl")


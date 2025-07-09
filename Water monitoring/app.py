from flask import Flask, request, render_template
import pandas as pd
import numpy as np
import pickle

app = Flask(__name__)

# Load the model
with open('model.pkl', 'rb') as file:
    model = pickle.load(file)

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/predict', methods=['POST'])
def predict():
    try:
        # Collect input data from the form
        temperature = float(request.form['temperature'])
        rainfall = float(request.form['rainfall'])
        soil_moisture = float(request.form['soil_moisture'])
        crop_type = request.form['crop_type']

        # Create a DataFrame for the input data
        input_data = pd.DataFrame({
            'temperature': [temperature],
            'rainfall (mm)': [rainfall],
            'Soil Moisture': [soil_moisture],
            'Crop Type': [crop_type]
        })

        # Convert categorical data to numerical
        input_data = pd.get_dummies(input_data, columns=['Crop Type'])

        # Ensure all possible dummy variables are present
        expected_columns = ['temperature', 'rainfall (mm)', 'Soil Moisture',
                            'Crop Type_archenut', 'Crop Type_chilli', 'Crop Type_coffee']
        for col in expected_columns:
            if col not in input_data.columns:
                input_data[col] = 0

        # Align input data with the model's expected input
        input_data = input_data[expected_columns]

        # Make prediction
        prediction = model.predict(input_data)
        output = round(prediction[0], 2)

        return render_template('index.html', prediction_text=f'Water Requirement: {output} liters')

    except Exception as e:
        return render_template('index.html', prediction_text=f'Error: {str(e)}')

if __name__ == "__main__":
    app.run(debug=True)

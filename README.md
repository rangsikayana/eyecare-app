# Eyecare App

## Overview
The Eyecare App is a backend application designed to handle image classification for various eye conditions. It uses a pre-trained Keras model to predict the class of an uploaded image. The application is built using Node.js, Hapi.js, and Flask, and it includes custom error handling and routing.

## To start the project

1. **Copy `.env.example` file and rename it to `.env`**
2. **Fill that `.env` with its values**
3. **Install all dependencies**:
    ```bash
    npm install
    ```

4. **Create a Google Cloud service account and add the Cloud Storage admin role**
5. **Generate a JSON key file from that account**
6. **Put the JSON key file into this project and rename it to `service-key.json`**
7. **To run this project**:
    ```bash
    npm start
    ```


## Project Structure

### `landing-page/index.html`
Contains the HTML for the login and registration forms. It uses Firebase for authentication and Firestore for storing user data.

### `model/Dockerfile`
Defines the Docker image for the application. It typically includes instructions to set up the environment, install dependencies, and run the application

### `model/index.py`
Contains the Flask application for the image classification model. It loads a pre-trained Keras model and provides an endpoint to predict the class of an uploaded image.

### `model/model.json`
Contains the model architecture and weights for the pre-trained Keras model used in the image classification.

### `src/exceptions/ClientError.js`
Defines a custom error class `ClientError` that extends the built-in `Error` class. It includes a `message` and an optional `statusCode` (defaulting to 400).

### `src/exceptions/InputError.js`
Defines a custom error class `InputError` that extends the `ClientError` class. It sets the `name` property to `'InputError'`.

### `src/login/authFunctions.js`
Contains functions for user authentication, including registration and login. It uses Firebase for authentication and Firestore for storing user data.

### `src/login/config.js`
Contains configuration settings for the application, such as database connection details and API keys.

### `src/login/firebase.js`
Initializes and exports the Firebase app, including Firestore and authentication services.

### `src/login/firebaseconfig.js`
Contains the Firebase configuration settings, such as API key, auth domain, and project ID.

### `src/login/serviceAccountKey.json`
Contains the service account key for Google Cloud, used for authentication and accessing Google Cloud services.

### `src/server/handler.js`
Handles the core logic for processing requests and responses. This file typically includes functions to handle different routes and business logic.

### `src/server/routes.js`
Defines the routes for the application. It maps endpoints to their corresponding handler functions.

### `src/server/server.js`
Sets up the Hapi server, applies middleware, and starts the server. It typically includes the following:
- Importing necessary modules
- Setting up middleware (e.g., CORS)
- Defining routes
- Starting the server

### `src/services/firestoreFunctions.js`
Contains utility functions for interacting with Firestore, such as fetching and updating data.

### `src/services/getData.js`
Provides functions to retrieve data from various sources, including databases and external APIs.

### `src/services/inferenceService.js`
Handles the logic for making predictions using the machine learning model, including data preprocessing and calling the model.

### `src/services/loadModel.js`
Responsible for loading the machine learning model from storage into the application.

### `src/services/storeData.js`
Includes functions to store data in Firestore, handling both insertion and updates of records.

### `.dockerignore`
Specifies files and directories that should be ignored by Docker when building the Docker image. This typically includes dependencies, environment files, and other files not needed in the Docker image.

### `.env`
Contains environment variables used by the application. This file should not be committed to version control as it may contain sensitive information such as API keys and database connection details.

### `.gcloudignore`
Specifies files and directories that should be ignored when deploying to Google Cloud using the `gcloud` command. 

### `.gitignore`
Specifies files and directories that should be ignored by Git. This typically includes dependencies, build artifacts, and environment files.

### `app.yaml`
Configuration file for deploying the application to Google App Engine. It includes settings such as the runtime environment, instance class, and environment variables.

### `package-lock.json`
Automatically generated file that records the exact versions of dependencies installed in the `node_modules` directory. This ensures that the same versions are installed if the project is reinstalled.

### `package.json`
Contains metadata about the project, including its name, version, dependencies, and scripts. It is used by npm to manage the project's dependencies and scripts.

## Example Usage

### Predicting Eye Conditions
To predict the class of an uploaded image, send a POST request to the `/predict` endpoint with the image file.

```bash
curl -X POST -F 'file=@path_to_your_image.jpg' http://localhost:3000/predict
```

### Error Handling
The application uses custom error classes (`ClientError` and `InputError`) to handle different types of errors gracefully.

## Dependencies
- Node.js
- Hapi.js
- TensorFlow.js
- Keras
- Prisma
- Firebase
- Flask
- Docker

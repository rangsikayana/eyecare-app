# Eyecare App

## Overview
The Eyecare App is a backend application designed to handle image classification for various eye conditions. It uses a pre-trained Keras model to predict the class of an uploaded image. The application is built using Node.js, Express, and Flask, and it includes custom error handling and routing.

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

8. **Run a migration**:
    ```bash
    npx prisma migrate dev --name init
    ```

9. **Run a seeder**:
    ```bash
    npx prisma db seed
    ```

## Project Structure

### `src/exceptions/ClientError.js`
Defines a custom error class `ClientError` that extends the built-in `Error` class. It includes a `message` and an optional `statusCode` (defaulting to 400).

### `src/exceptions/InputError.js`
Defines a custom error class `InputError` that extends the `ClientError` class. It sets the `name` property to `'InputError'`.

### `src/handler.js`
Handles the core logic for processing requests and responses. This file typically includes functions to handle different routes and business logic.

### `src/routes.js`
Defines the routes for the application. It maps endpoints to their corresponding handler functions.

### `src/server.js`
Sets up the Express server, applies middleware, and starts the server. It typically includes the following:
- Importing necessary modules
- Setting up middleware (e.g., body-parser, CORS)
- Defining routes
- Starting the server

### `landing-page/index.html`
Contains the HTML for the login and registration forms. It uses Firebase for authentication and Firestore for storing user data.

### `model/index.py`
Contains the Flask application for the image classification model. It loads a pre-trained Keras model and provides an endpoint to predict the class of an uploaded image.

### `Dockerfile`
Defines the Docker image for the application. It typically includes instructions to set up the environment, install dependencies, and run the application.

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
- Express
- TensorFlow.js
- Keras
- Prisma
- Firebase
- Flask
- Docker

Branch ini digunakan untuk backend-site, dari aplikasi EyeCare-App.

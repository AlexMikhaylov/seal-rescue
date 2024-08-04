# Seal Rescue Project

This project aims to create a comprehensive database and support system for seal rehabilitation and rescue centers worldwide. It includes a backend built with Spring Boot and Kotlin and a frontend built with Angular.

## Project Structure

- **backend/**: Contains the Spring Boot application code.
    - **src/main/kotlin/**: Kotlin source files.
    - **src/main/resources/**: Configuration files and static resources.
    - **build.gradle.kts**: Gradle build configuration for the backend.
    - **docker-compose.yml**: Docker Compose file for setting up the PostgreSQL database.
- **frontend/**: Contains the Angular application code.
    - **src/**: Angular source files.
    - **angular.json**: Angular project configuration.
    - **package.json**: Node.js dependencies.

## Getting Started

### Backend

1. Ensure your docker is running
2. **Build and Run**:
    ```sh
    cd backend
   ./gradlew bootRun
    ```
Flyway will automatically handle the database migrations       


### Frontend

1. **Install Dependencies**:
    ```sh
    cd frontend
    npm install
    ```

2. **Run the Application**:
    ```sh
    ng serve
    ```

For more details, please check the individual README files in the backend and frontend directories.
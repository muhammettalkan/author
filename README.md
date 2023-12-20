
# Author-Work Management App

### Purpose of the App
This application is designed to manage and track authors and their works. It provides functionalities to add, retrieve, and manage information about authors and their literary or artistic works.

### Technology Stack
- Java: Version 17
- Spring Boot: Version 3.2.0, including:
Spring Data JPA, Spring Web, Liquibase, MySQL Driver.
- MySQL
- Maven: For project build and dependency management.

## How to Run the Application
1. Clone the Repository: Clone the project repository to your local machine.
2. Database Configuration:
Create a database schema (e.g., author_work_db) using a MySQL.
Configure the database connection settings (URL, username, password) in the application.yml file.
3. Prerequisites:
Ensure you have Maven installed.
Java 17 or higher should be installed on your system.
4. Running the Application:
Navigate to the project directory.
Run the application using the command: mvn spring-boot:run.
5. Accessing the Application:
Once the application is running, access it via http://localhost:8080.
You can also use API tools like Postman to interact with the endpoints.

### Endpoints
Author Endpoints
- GET /api/authors/find: Requires a query parameter, name (String), to search for an author by name.

Work Endpoints
- GET /api/works: Requires a query parameter, author_id (String), to search for works by author.

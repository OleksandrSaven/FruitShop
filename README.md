# Fruit shop (backend part + UI)
## Intro

This is the "Fruit shop" application based on Spring Boot, which allows you to manage fruits. The application includes the following features:

 - Add fruit to cart.
 - Delete fruit from cart.
 - Change quantity.

## Technologies used
 - Spring Boot: This project is based on the Spring Boot framework, which simplest the setup and development of Java application.
 - Spring Data JPA: It's allow the simplest database access and management.
 - Database: The project uses a relation database MySQL to store data.

## How to use
To start this project, you'll need to follow these general steps. Keep in mind that the specific instruction may vary based on the project's structure and you environment.
 
- **Clone the Repository**:

Clone the project's repository from a version control system.

- **Database configuration**

Application use Local database. Check the project's configuration files (src/main/resources/application.properties) to configure your database connection settings. Ensure you have a MySql database set up and that you provide the correct credentials.

- **Build the project**

Open a terminal in the project's root directory and run the following command to build the project using Maven:
<pre>
nvm clean install
</pre>

- **Start the Application**

You can start the application directly by running the following command:
<pre>
java -jar target/ittest-0.0.1-SNAPSHOT.jar
</pre>

## Additional
You can watch the video demonstration of how the app works by following [link](https://www.loom.com/share/e72690db2844418cb64c658e2226e39e?sid=a4815c16-6a48-4324-a304-72e819b87f4d)

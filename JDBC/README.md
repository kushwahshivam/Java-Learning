# JDBC (Java Database Connectivity)

### Overview
JDBC is an API that enables Java applications to interact with databases. It allows you to connect to a database, execute SQL queries, and process the results.

### Basic Concepts
- **Driver**: A set of classes that implement the JDBC interfaces for a specific database.
- **Connection**: Represents a connection to the database.
- **Statement**: Used to execute SQL queries.
- **ResultSet**: A table of data representing the results of a query.

### Example
Here’s a simple example of using JDBC to connect to a MySQL database and retrieve data:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String user = "yourusername";
        String password = "yourpassword";

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM yourtable");

            // Process results
            while (resultSet.next()) {
                System.out.println("Column1: " + resultSet.getString("column1"));
                // Add more columns as needed
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
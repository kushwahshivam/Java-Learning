import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java program start... ");

        // Database credentials
        String url = "jdbc:mysql://localhost:3306/classicmodels"; // Replace with your database URL
        String username = "root"; // Replace with your database username
        String password = ""; // Replace with your database password
        String sqlQuery = "SELECT * FROM orders limit 5"; // Replace with your SQL query

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            conn = DriverManager.getConnection(url, username, password);

            // 3. Create Statement
            ps = conn.prepareStatement(sqlQuery);

            // 4. Execute SQL Statement (Select Query)
            rs = ps.executeQuery();

            // 5. Process ResultSet
            while (rs.next()) {
                // Process the result set
                System.out.print("Order Number: " + rs.getInt("orderNumber"));
                System.out.print(", Order Date: " + rs.getDate("orderDate"));
                System.out.println(", Status: " + rs.getString("status"));
                // Add more columns as needed
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Error.");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources.");
                e.printStackTrace();
            }
        }

        System.out.println("Java program end...");
    }
}


// java -cp .:/home/hardik/Downloads/mysql-connector-j-9.0.0/mysql-connector-j-9.0.0.jar Main
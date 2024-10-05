import java.sql.*;
import java.io.*;
import java.util.Properties;

public class InsertImgInDB {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Properties properties = new Properties();

        // Load database properties
        try (InputStream input = new FileInputStream("database.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            System.out.println("Unable to load database properties file.");
            ex.printStackTrace();
            return;
        }

        String dbURL = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(dbURL, username, password);

            // SQL INSERT statement
            String sql = "INSERT INTO books (isbn, image) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Set the ISBN
            pstmt.setString(1, "978-3-16-148410-1");

            // Set the image (path to the image file)
            File image = new File("Book_001.jpg");
            FileInputStream fis = new FileInputStream(image);
            pstmt.setBinaryStream(2, fis, (int) image.length());

            // Execute the insert statement
            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("A book image was inserted successfully.");
            }

            // Close resources
            fis.close();
            pstmt.close();
            conn.close();

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include the connector in the classpath.");
            e.printStackTrace();
        }
    }
}


// add jar in path and compile as below 

//   1) javac -cp .:mysql-connector-j-9.0.0.jar InsertImgInDB.java
//   2) java -cp .:mysql-connector-j-9.0.0.jar InsertImgInDB
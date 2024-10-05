import java.sql.*;
import java.io.*;
import java.util.Properties;

public class RetrieveImgFromDB {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
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

            // SQL SELECT statement
            String sql = "SELECT image FROM books WHERE isbn = ?";
            pstmt = conn.prepareStatement(sql);

            // Set the ISBN
            pstmt.setString(1, "978-3-16-148410-1");

            // Execute the query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Get the image as a binary stream
                InputStream inputStream = rs.getBinaryStream("image");
                FileOutputStream outputStream = new FileOutputStream("Retrieved_Book_001.jpg");

                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                System.out.println("Image retrieved and saved as Retrieved_Book_001.jpg");
            }

            // Close resources
            rs.close();
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

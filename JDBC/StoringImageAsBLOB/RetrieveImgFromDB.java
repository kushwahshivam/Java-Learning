import java.sql.*;
import java.io.*;

public class RetrieveImgFromDB {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:3306/test_db_02";
        String username = "root";
        String password = "123456";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(dbURL, username, password);

            // SQL SELECT statement
            String sql = "SELECT image FROM books WHERE isbn = ?";
            pstmt = conn.prepareStatement(sql);

            // Set the ISBN to fetch the specific image
            pstmt.setString(1, "978-3-16-148410-1");

            // Execute the select statement
            rs = pstmt.executeQuery();

            // Check if image exists
            if (rs.next()) {
                // Get the image as a binary stream
                InputStream is = rs.getBinaryStream("image");
                FileOutputStream fos = new FileOutputStream("Retrieved_Book_001.jpg");

                // Write the image to file
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

                fos.close();
                is.close();

                System.out.println("Image retrieved and saved as Retrieved_Book_001.jpg.");
            } else {
                System.out.println("No image found for the specified ISBN.");
            }

            // Close resources
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

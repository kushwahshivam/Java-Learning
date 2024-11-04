import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        // Using try-with-resources to handle multiple resources
        try (
            FileOutputStream fileOutputStream = new FileOutputStream("abc.txt");
            FileInputStream input = new FileInputStream("abc.txt")
        ) {
            // ----------------------------- Code to write data into file ----------------------------- //
            String msg = "Writting the data in the file next can be read now ! ";
            byte[] byteArray = msg.getBytes();  // Converting string into byte array
            fileOutputStream.write(byteArray);  // Writing data into file
            System.out.println("------------ Data written into file --------------");
            System.out.println(msg);

            // Ensure the output stream is flushed before reading
            fileOutputStream.flush();

            // ----------------------------- Code to read data from file ----------------------------- //
            // Creating DataInputStream instance
            DataInputStream inst = new DataInputStream(input);
            int data = input.available();  // Returns an estimate of the number of bytes that can be read
            byte[] byteArray2 = new byte[data];  // Creating a byte array of available size
            inst.readFully(byteArray2);  // Read the entire byte array

            String str = new String(byteArray2);  // Passing byte array into String constructor
            System.out.println("------------ Data read from file as --------------");
            System.out.println(str);  // Display file data
        } catch (IOException exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }
    }
}

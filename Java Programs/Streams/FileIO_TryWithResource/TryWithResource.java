import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) {
        // Using try-with-resources
        try (FileOutputStream fileOutputStream = new FileOutputStream("abc.txt")) {
            String msg = "Welcome to Try With Resource !!";
            byte byteArray[] = msg.getBytes(); // converting string into byte array
            fileOutputStream.write(byteArray);
            System.out.println("Message written to file successfully!");
        } catch (IOException exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }
    }
}



/***
 * Suppressed Exceptions
 * If a try block throws an exception and one or more exceptions are thrown by
 * the try-with-resources, the exceptions thrown by try-with-resources are
 * suppressed. In other words, we can say, exceptions which are thrown by
 * try-with-resources are suppressed exceptions.
 * 
 * You can get these exceptions by using the getSuppress() method of Throwable
 * class.
 * 
 * Java added a new constructor and two new methods in Throwable class to deal
 * with suppressed exceptions.
 */

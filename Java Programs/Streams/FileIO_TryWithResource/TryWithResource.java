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

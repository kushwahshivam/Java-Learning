import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputToFile02 {

    public static void main(String[] args) {
        // Define the name of the file to write to
        String filename = "inputFromConsole.txt";
        
        // Use try-with-resources to automatically close resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));   // when FileWriter(filename,true) is set then it append's else it overrides existing
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Enter lines of text (type 'exit' to finish):");
            
            // Loop to read input lines from the console
            while (true) {
                // Read a line of input
                String inputLine = scanner.nextLine();
                
                // Check if the user wants to exit
                if (inputLine.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if the user types 'exit'
                }
                
                // Write the input line to the file
                writer.write(inputLine);
                writer.newLine(); // Add a new line in the file
            }
            
            System.out.println("Input written to " + filename);
        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

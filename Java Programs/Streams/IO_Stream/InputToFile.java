import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InputToFile {

    public static void main(String[] args) {
        // Check if there are any command-line arguments
        if (args.length == 0) {
            System.out.println("No input provided. Please provide arguments.");
            return;
        }

        // Create a file to write the output
        String filename = "inputFromConsole.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Iterate through the command-line arguments
            for (String arg : args) {
                writer.write(arg);
                writer.newLine(); // Write each argument on a new line
            }
            System.out.println("Input written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}


/*
 # Way 1 : java InputToFile this are the inputs from the console 6  <-- This writes each word with new line
 # Way 2 : java InputToFile "this are the inputs from the console 6 "  <-- This in single line and inverted commas are removed
*/
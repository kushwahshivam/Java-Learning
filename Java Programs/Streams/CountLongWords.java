import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Stream01
 */
public class CountLongWords {
    
    // Declare words as a static variable so it can be accessed in main
    private static List<String> words;

    static {
        String content;
        try {
            // Read the file into a string
            content = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
            // Split the content into words; non-letters are delimiters.
            words = List.of(content.split("\\PL+"));
        } catch (IOException e) {
            e.printStackTrace();
            // If reading the file fails, initialize words to an empty list
            words = List.of();
        }
    }

    public static void main(String[] args) {
        long count = 0;
        // Count the number of words
        for (String w : words) {
            if(w.length()>5)count++;
        }
        
        // Print the total word count
        System.out.println("Total word count : " + count);

        count = words.stream().filter(w -> w.length()>5).count();
        System.out.println("Total word count : " +count);

        // using parallelStream() to filtering and counting in parallel
        count = words.parallelStream().filter(w -> w.length()>5).count();
        System.out.println("Total word count : " + count);
    }
}

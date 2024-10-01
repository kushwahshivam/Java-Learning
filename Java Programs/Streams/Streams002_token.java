import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams002_token {
    public static void main(String[] args) {
        Path path = Path.of("alice.txt");

        try {
            // Read the file contents into a String
            String contents = Files.readString(path, StandardCharsets.UTF_8);

            // Create a Scanner to tokenize the contents
            try (Scanner scanner = new Scanner(contents)) {
                // Use Stream to process the tokens
                Stream<String> words = scanner.tokens()
                    .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase()) // Clean and normalize
                    .filter(word -> !word.isEmpty()); // Remove empty tokens

                // Count the occurrences of each word
                Map<String, Long> wordCounts = words
                    .collect(Collectors.groupingBy(word -> word, HashMap::new, Collectors.counting()));

                // Print the word counts
                wordCounts.forEach((word, count) -> System.out.println(word + ": " + count));
                System.out.println(contents);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




/**
# What is token()?
The token() method is not a standalone method; rather, it refers to the tokens() method provided by the Scanner class. This method returns a stream of tokens (words) from the input. The tokens are determined based on the default delimiter (whitespace) or a custom delimiter that you can specify.

# Usage of tokens()

- Tokenization:

The primary purpose of the tokens() method is to break up the input into individual pieces (tokens) based on defined delimiters. By default, whitespace (spaces, tabs, line breaks) serves as a delimiter.

- Stream Processing:

The method returns a Stream<String>, allowing you to process the tokens using Java Streams, which provides powerful functionalities like filtering, mapping, and collecting.
 */
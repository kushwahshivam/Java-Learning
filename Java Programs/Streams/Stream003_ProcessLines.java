import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Stream003_ProcessLines {
    public static void main(String[] args) {
        Path path = Paths.get("alice.txt");

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            // Process lines here
            lines.forEach(line -> {
                // You can perform any processing on each line
                System.out.println(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

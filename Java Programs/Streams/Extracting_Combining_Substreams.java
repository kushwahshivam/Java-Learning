import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.stream.Stream;

public class Extracting_Combining_Substreams {
    public static void main(String[] args) {
        Stream<Double> randoms = Stream.generate(Math::random).limit(10);
        randoms.forEach(System.out::println);
    }
}

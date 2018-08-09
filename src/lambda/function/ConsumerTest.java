package lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerTest {

    public static void main(String args[]) {
        List<String> array = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");

        Consumer<String> c1 = s -> System.out.print(s.toUpperCase());
        Consumer<String> c2 = s -> System.out.print(s.toLowerCase());
        Consumer<String> c3 = String::toLowerCase;

        array.stream()
                .peek(c1)
                .collect(Collectors.toList());

        System.out.println();

        array.forEach(c1);

        System.out.println();

        array.forEach(c1.andThen(c2));

        System.out.println();

        array.forEach(c3.andThen(System.out::print));

    }
}

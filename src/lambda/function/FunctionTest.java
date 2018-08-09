package lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String arg[]) {
        List<String> array = Arrays.asList("1", "2", "3", "4", "5");

        Function<String, Boolean> f = s -> Integer.valueOf(s) % 2 == 0;

        array.forEach(s -> System.out.println(s + " is even number ? " + f.apply(s)));

        Function<String, String> farm = s -> s.equals("seed") ? "wheat" : null;
        Function<String, String> mill = s -> s.equals("wheat") ? "flour" : null;
        Function<String, String> bakery = s -> s.equals("flour") ? "bread" : null;

        Function<String, String> factory1 = farm.andThen(mill.andThen(bakery));
        Function<String, String> factory2 = bakery.compose(mill.compose(farm));

        System.out.println(factory1.apply("seed"));

        System.out.println(factory2.apply("seed"));


    }
}

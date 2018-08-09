package lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

public class BoxingTest {

    public static void main(String arg[]) {
        List<String> strArray = Arrays.asList("123", "456", "789");

        // T ---> ToXXXFunction ---> XXX
        int[] intArray = strArray.stream().mapToInt(Integer::valueOf).toArray();
        long[] longArray = Arrays.stream(intArray).mapToLong(Long::valueOf).toArray();
        double[] doubleArray = Arrays.stream(longArray).mapToDouble(Double::valueOf).toArray();

        System.out.println(Arrays.toString(doubleArray));

        // XXX ---> XXXFunction<T> ---> T
        IntFunction<Long> intf = value -> (long) value;
        LongFunction<Double> longf = value -> (double) value;
        DoubleFunction<String> doublef = String::valueOf;

        System.out.println(doublef.apply(longf.apply(intf.apply(123))));

    }
}

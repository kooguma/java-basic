package lambda.example.chapter1;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Chapter1 {

    //1.predicate
    public static List<Integer> predicateBigger(List<Integer> array, int value) {
        return array.stream()
                .filter(i -> i > value)
                .collect(Collectors.toList());
    }

    //2.predicate negate
    public static List<Integer> predicateSmaller(List<Integer> array, int value) {
        return array.stream()
                .filter(((Predicate<Integer>) i -> i > value).negate().and(i -> i != value))
                .collect(Collectors.toList());
    }

    //3.predicate and
    public static List<Integer> predicateBiggerAndSmaller(List<Integer> array, int low, int height) {
        return array.stream()
                .filter(((Predicate<Integer>) i -> i > low).and(i -> i < height))
                .collect(Collectors.toList());
    }

    //4.predicate or
    public static List<Integer> predicateBiggerOrSmaller(List<Integer> array, int low, int height) {
        return array.stream()
                .filter(((Predicate<Integer>) i -> i < low).or(i -> i > height))
                .collect(Collectors.toList());
    }

    //5.Consumer
    public static void consumerToUpperThenToLower(List<String> array) {
        array.forEach(((Consumer<String>) s -> System.out.print(s.toUpperCase())).andThen(s -> System.out.print(s.toLowerCase())));
    }

    //6.Function andThen
    public static String functionAndThen(String seed) {
        Function<String, String> farm = s -> s.equals("seed") ? "wheat" : null;
        Function<String, String> mill = s -> s.equals("wheat") ? "flour" : null;
        Function<String, String> bakery = s -> s.equals("flour") ? "bread" : null;
        Function<String, String> factory = farm.andThen(mill.andThen(bakery));
        return factory.apply(seed);
    }

    //7.Function compose
    public static String functionCompose(String seed) {
        Function<String, String> farm = s -> s.equals("seed") ? "wheat" : null;
        Function<String, String> mill = s -> s.equals("wheat") ? "flour" : null;
        Function<String, String> bakery = s -> s.equals("flour") ? "bread" : null;
        Function<String, String> factory = bakery.compose(mill.compose(farm));
        return factory.apply(seed);
    }

    //8.Supplier 工厂方法
    public static String supplier(Supplier<String> supplier) {
        return supplier.get();
    }

    //9.UnaryOperator 一元运算符
    public static List<Integer> unaryOperator(List<Integer> array) {
        final UnaryOperator<Integer> uop = i -> i + 1;
        return array.stream()
                .map(uop)
                .collect(Collectors.toList());
    }

    //10.BinaryOperator 二元运算符
    public static List<Integer> binaryOperator(List<Integer> array) {
        final BinaryOperator<Integer> bop = (i1, i2) -> i1 * i2;
        return array.stream()
                .map(i -> bop.apply(i, i))
                .collect(Collectors.toList());
    }


    //11.T ---> ToXXXFunction ---> XXX
    public static double[] toXXXFunction(List<String> strArray) {
        return strArray.stream()
                .mapToInt(Integer::valueOf)
                .mapToLong(Long::valueOf)
                .mapToDouble(Double::valueOf)
                .toArray();
    }

    //12.XXX ---> XXXFunction<T> ---> T
    public static String XXXFunction(int value) {
        IntFunction<Long> intf = v -> (long) v;
        LongFunction<Double> longf = v -> (double) v;
        DoubleFunction<String> doublef = String::valueOf;
        return doublef.apply(longf.apply(intf.apply(value)));
    }
}

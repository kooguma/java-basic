package lambda.example.chapter1;

import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Chapter1 {

    //1.predicate
    public static Integer[] predicateBigger(List<Integer> array, int value) {
        return (Integer[]) array.stream()
                .filter(i -> i > value)
                .toArray();
    }

    //2.predicate negate
    public static Integer[] predicateSmaller(List<Integer> array, int value) {
        return (Integer[]) array.stream()
                .filter(((Predicate<Integer>) i -> i > value).negate())
                .toArray();
    }

    //3.predicate and
    public static Integer[] predicateBiggerAndSmaller(List<Integer> array, int low, int height) {
        return (Integer[]) array.stream()
                .filter(((Predicate<Integer>) i -> i > low).and(i -> i < height))
                .toArray();
    }

    //4.predicate or
    public static Integer[] predicateBiggerOrSmaller(List<Integer> array, int low, int height) {
        return (Integer[]) array.stream()
                .filter(((Predicate<Integer>) i -> i < low).or(i -> i > height))
                .toArray();
    }

    //5.Consumer
    public static void consumerToUpperThenToLower(List<String> array) {
        array.forEach(((Consumer<String>) s -> System.out.println(s.toUpperCase())).andThen(s -> System.out.println(s.toLowerCase())));
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
    public static Integer[] unaryOperator(List<Integer> array) {
        final UnaryOperator<Integer> uop = i -> i + 1;
        return (Integer[]) array.stream()
                .map(uop)
                .toArray();
    }

    //10.BinaryOperator 二元运算符
    public static Integer[] binaryOperator(List<Integer> array) {
        final BinaryOperator<Integer> bop = (i1, i2) -> i1 * i2;
        return (Integer[]) array.stream()
                .map(i -> bop.apply(i, i))
                .toArray();
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

package lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String arg[]) {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> p1 = i -> i > 3;

        Predicate<Integer> p2 = i -> i < 8;

        Predicate<Integer> p3 = p1.negate().and(i -> i != 3);

        Predicate<Integer> p4 = p2.negate().and(i -> i != 8);

        System.out.println("numbers bigger than 3 : " + Arrays.toString(array.stream().filter(p1).toArray()));

        System.out.println("numbers smaller than 3 : " + Arrays.toString(array.stream().filter(p3).toArray()));

        System.out.println("numbers smaller than 8 : " + Arrays.toString(array.stream().filter(p2).toArray()));

        System.out.println("numbers bigger than 8 : " + Arrays.toString(array.stream().filter(p4).toArray()));

        System.out.println("numbers bigger than 3 and smaller than 8 :" + Arrays.toString(array.stream().filter(p1.and(p2)).toArray()));

        System.out.println("numbers smaller than 3 or bigger than 8 :" + Arrays.toString(array.stream().filter(p3.or(p4)).toArray()));


    }
}

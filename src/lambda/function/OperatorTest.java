package lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class OperatorTest {


    public static void main(String arg[]) {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //一元运算符
        UnaryOperator<Integer> uop = i -> i + 1;
        array.forEach(i -> System.out.print(uop.apply(i) + " "));

        System.out.println();

        //二元运算符
        BinaryOperator<Integer> bop = (i1, i2) -> i1 * i2;
        array.forEach(i -> System.out.print(bop.apply(i, i) + " "));

        BinaryOperator<Integer> maxOp = BinaryOperator.maxBy(Integer::compareTo);

        System.out.println();

        System.out.println(maxOp.apply(1, 2));

        BinaryOperator<Integer> minOp = BinaryOperator.minBy(Integer::compareTo);

        System.out.println(minOp.apply(2, 1));


    }
}

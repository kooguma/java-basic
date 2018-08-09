package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class StreamTest {

    public static void main(String arg[]) {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum1 = array.stream().reduce((i1, i2) -> i1 + i2).get();
        int sum2 = array.stream().reduce(1, (i1, i2) -> i1 + i2);
        //BinaryOperator 并行执行时多个部分结果的合并方式
        int sum3 = array.stream().reduce(1, (i1, i2) -> i1 + i2, (i1, i2) -> i1 + i2);

        System.out.println("array sum1 : " + sum1);
        System.out.println("array sum2 : " + sum2);
        System.out.println("array sum3 : " + sum3);

    }

}

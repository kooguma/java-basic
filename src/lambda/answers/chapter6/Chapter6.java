package lambda.answers.chapter6;

import lambda.demo.Album;
import lambda.demo.Track;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chapter6 {

    //顺需求平方和
    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(i -> i * i).sum();
    }

    //并行求平方和
    public static int parallelSumOfSquares(IntStream range) {
        return range.parallel().map(i -> i * i).sum();
    }

    //把列表中的数字相乘，然后再将所得结果乘以5，该实现有一个缺陷
    public static int buggyMultiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> x * acc);
    }

    public static int multiplyThrough(List<Integer> numbers) {
        return 5 * numbers.parallelStream()
                .reduce(1, (acc, x) -> x * acc);
    }

    public static int slowSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    /**
     *  性能好：
     *  ArrayList、数组或IntStream.range，这些数据结构支持随机读取，也就是说它们能轻而易举地被任意分解
     *
     *  性能差：
     *  有些数据结构难于分解，比如，可能要花O(N)的时间复杂度来分解问题。LinkedList，Streams.iterate BufferedReader.lines
     *
     */


    public static int serialSlowSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public static int intermediateSumOfSquares(List<Integer> arrayListOfNumbers) {
        return arrayListOfNumbers.stream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }


    public static int serialIntermediateSumOfSquares(List<Integer> arrayListOfNumbers) {
        return arrayListOfNumbers.stream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public static int fastSumOfSquares(List<Integer> arrayListOfNumbers) {
        return arrayListOfNumbers.parallelStream()
                .mapToInt(x -> x * x)
                .sum();
    }

    public static int serialFastSumOfSquares(List<Integer> arrayListOfNumbers) {
        return arrayListOfNumbers.stream()
                .mapToInt(x -> x * x)
                .sum();
    }
}

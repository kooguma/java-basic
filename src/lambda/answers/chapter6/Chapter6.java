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


    //并行化计算专辑曲目长度
    public int parallerlArraySum(List<Album> albums) {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    //使用蒙特卡洛模拟法并行化模拟投骰子事件
    public Map<Integer, Double> paralleDiceRolls(int N) {
        final double fraction = 1.0 / N;
        return IntStream.range(0, N)
                .parallel()
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side, Collectors.summingDouble(n -> fraction)));
    }

    private static IntFunction<Integer> twoDiceThrows() {
        return i -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int firstThrow = random.nextInt(1, 7);
            int secondThrow = random.nextInt(1, 7);
            return firstThrow + secondThrow;
        };
    }

    //并行求和 fork join
    private int addIntegers(List<Integer> values) {
        return values.parallelStream()
                .mapToInt(i -> i)
                .sum();
    }

    //使用并行化数组操作初始化数组
    public double[] paralleInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    public double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum); // 并行操作，将数组的元素相加
        int start = n - 1;
        return IntStream.range(start, sums.length)
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n;
                })
                .toArray();
    }

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

    public static int mutiplyThrough(List<Integer> numbers) {
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

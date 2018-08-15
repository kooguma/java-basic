package lambda.example.chapter6;

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
    public static int parallelArraySum(List<Album> albums) {
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

    //串行求和
    public static int sequentialAddIntegers(List<Integer> values) {
        return values.stream()
                .mapToInt(i -> i)
                .sum();
    }

    //并行求和 fork join
    public static int parallelAddIntegers(List<Integer> values) {
        return values.parallelStream()
                .mapToInt(i -> i)
                .sum();
    }

    //使用串行化数组操作初始化数组
    public static double[] sequentialInitialize(int size) {
        double[] values = new double[size];
        Arrays.setAll(values, i -> i);
        return values;
    }

    //使用并行化数组操作初始化数组
    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    //简单计算滑动平均数
    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum); // 并行操作，将数组的元素相加 1,3,6,10,15,21,28,36,45,55
        int start = n - 1;
        return IntStream.range(start, sums.length)
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n;
                })
                .toArray();
    }
}

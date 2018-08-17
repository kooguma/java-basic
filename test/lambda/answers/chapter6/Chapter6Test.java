package lambda.answers.chapter6;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lambda.answers.chapter6.Chapter6.*;

public class Chapter6Test {

    private List<Integer> arrayListOfNumbers = IntStream.range(1, 100).boxed().collect(Collectors.toCollection(ArrayList::new));

    private List<Integer> linkedListOfNumbers = IntStream.range(1, 100).boxed().collect(Collectors.toCollection(LinkedList::new));


    //1ms
    @Test
    public void sequentialSumOfSquaresTest() {
        int actual = sequentialSumOfSquares(IntStream.range(0, 1000));
        Assert.assertEquals(332833500, actual);
    }

    //78ms
    @Test
    public void parallelSumOfSquaresTest() {
        int actual = parallelSumOfSquares(IntStream.range(0, 1000));
        Assert.assertEquals(332833500, actual);
    }

    //3ms
    @Test
    public void slowSumOfSquaresTest() {
        int actual = slowSumOfSquares(IntStream.range(0, 1000));
        Assert.assertEquals(332833500, actual);
    }


    @Test
    public void serialSlowSumOfSquaresTest() {
        serialSlowSumOfSquares(linkedListOfNumbers);
    }

    @Test
    public void intermediateSumOfSquaresTest() {
        intermediateSumOfSquares(arrayListOfNumbers);
    }

    @Test
    public void serialIntermediateSumOfSquaresTest() {
        serialIntermediateSumOfSquares(arrayListOfNumbers);
    }

    @Test
    public void fastSumOfSquaresTest() {
        fastSumOfSquares(arrayListOfNumbers);
    }

    @Test
    public void serialFastSumOfSquaresTest() {
        serialFastSumOfSquares(arrayListOfNumbers);
    }
}

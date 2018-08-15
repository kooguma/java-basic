package lambda.example.chapter6;

import lambda.demo.SampleData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lambda.example.chapter6.Chapter6.*;

public class Chapter6Test {

    private List<Integer> intArray;

    @Before
    public void setup() {
        intArray = IntStream.range(0, 100000).boxed().collect(Collectors.toList());
    }

    @Test
    public void parallelArraySumTest() {
        int actual = parallelArraySum(SampleData.getThreeAlbums());
        Assert.assertEquals(1089, actual);
    }

    @Test
    public void sequentialAddIntegersTest() {
        int actual = sequentialAddIntegers(intArray);
        Assert.assertEquals(704982704,actual);
    }

    //比串行快8-10倍
    @Test
    public void parallelAddIntegersTest() {
        int actual = parallelAddIntegers(intArray);
        Assert.assertEquals(704982704,actual);
    }

    @Test
    public void sequentialInitializeTest(){
        sequentialInitialize(100000);
    }

    //速度跟 size 有关
    @Test
    public void parallelInitializeTest(){
        parallelInitialize(100000);
    }


    @Test
    public void simpleMovingAverageTest(){
        double[] values = new double[]{1d,2d,3d,4d,5d,6d,7d,8d,9d,10d};
        double[] actual = simpleMovingAverage(values,3);
        Assert.assertArrayEquals(new double[]{2d,3d,4d,5d,6d,7d,8d,9d},actual,0);
    }
}
